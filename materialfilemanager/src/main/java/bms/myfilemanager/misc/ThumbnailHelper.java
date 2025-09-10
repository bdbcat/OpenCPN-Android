/*
 * Copyright (C) 2014 George Venios
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package bms.myfilemanager.misc;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.decode.ImageDecodingInfo;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import bms.myfilemanager.util.FileUtils;
import bms.myfilemanager.util.Logger;
import bms.myfilemanager.util.Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static android.content.pm.PackageManager.MATCH_DEFAULT_ONLY;
import static android.graphics.Bitmap.Config.ARGB_8888;
import static android.graphics.Shader.TileMode.CLAMP;
import static android.net.Uri.decode;
import static android.os.Build.VERSION.SDK_INT;
import static com.nostra13.universalimageloader.core.ImageLoader.getInstance;
import static com.nostra13.universalimageloader.core.assist.ImageScaleType.EXACTLY;
import static bms.myfilemanager.util.FileUtils.getViewIntentFor;

public class ThumbnailHelper {
    private static final int FADE_IN_DURATION = 400;

    private static ImageDecoder sDecoder = null;
    private static DisplayImageOptions.Builder sDefaultImageOptionsBuilder;

    public static void requestIcon(FileHolder holder, ImageView imageView) {
        Uri uri = Uri.fromFile(holder.getFile());
        DisplayImageOptions options = defaultOptionsBuilder()
                .extraForDownloader(holder)
                .build();

        getInstance().displayImage(decode(uri.toString()), imageView, options);
    }

    /**
     * Unfortunately getting the default is not straightforward..
     * See https://groups.google.com/forum/#!topic/android-developers/UkfP70MtjGA
     */
    private static Drawable getAssociatedAppIconDrawable(FileHolder holder, Context context) {
        PackageManager pm = context.getPackageManager();
        Intent intent = getViewIntentFor(holder, context);
        Drawable icon = null;

        // Contrary to queryIntentActivities documentation, the first item IS NOT the same
        // as the one returned by resolveActivity.
        ResolveInfo resolveInfo = pm.resolveActivity(intent, MATCH_DEFAULT_ONLY);
        if (!FileUtils.isResolverActivity(resolveInfo)) {
            icon = resolveInfo.loadIcon(pm);
        } else if (!holder.getMimeType().equals("*/*")) {
            final List<ResolveInfo> lri = pm.queryIntentActivities(intent,
                    MATCH_DEFAULT_ONLY);
            if (lri != null && lri.size() > 0) {
                // Again, contrary to documentation, best match is actually the last item.
                icon = lri.get(lri.size()-1).loadIcon(pm);
            }
        }

        return icon;
    }

    private static final Drawable getApkIconDrawable(FileHolder holder, Context context) {
        PackageManager pm = context.getPackageManager();
        String path = holder.getFile().getPath();
        PackageInfo pInfo = pm.getPackageArchiveInfo(path,
                PackageManager.GET_ACTIVITIES);
        if (pInfo != null) {
            ApplicationInfo aInfo = pInfo.applicationInfo;

            // Bug in SDK versions >= 8. See here:
            // http://code.google.com/p/android/issues/detail?id=9151
            if (SDK_INT >= 8) {
                aInfo.sourceDir = path;
                aInfo.publicSourceDir = path;
            }

            return aInfo.loadIcon(pm);
        }

        return null;
    }

    public static ImageDecoder imageDecoder(final Context context) {
        if (sDecoder == null) {
            sDecoder = new ImageDecoder() {
                private BaseImageDecoder internal = new BaseImageDecoder(false);

                @Override
                public Bitmap decode(ImageDecodingInfo idi) throws IOException {
                    FileHolder holder = (FileHolder) idi.getExtraForDownloader();
                    Bitmap bitmap = null;

                    if (!holder.getFile().isDirectory()) {
                        if (Utils.isImage(holder.getMimeType())) {
                            try {
                                ImageDecodingInfo info = new ImageDecodingInfo(
                                        idi.getImageKey(), idi.getImageUri(),
                                        idi.getOriginalImageUri(), idi.getTargetSize(),
                                        ViewScaleType.CROP,
                                        idi.getDownloader(), defaultOptionsBuilder().build()
                                );
                                Bitmap bmp = internal.decode(info);

                                // Make bmp round
                                int targetHeight = idi.getTargetSize().getHeight();
                                int targetWidth = idi.getTargetSize().getWidth();
                                int radius = targetWidth/2;
                                bitmap = Bitmap.createBitmap(targetWidth, targetHeight, ARGB_8888);
                                BitmapShader shader = new BitmapShader(bmp, CLAMP, CLAMP);
                                Canvas canvas = new Canvas(bitmap);
                                Paint paint = new Paint();
                                paint.setAntiAlias(true);
                                paint.setShader(shader);
                                canvas.drawCircle(radius, radius, radius, paint);

                                bmp.recycle();
                            } catch (FileNotFoundException ex) {
                                Logger.log(ex);
                                return null;
                                // Fail silently.
                            }
                        } else if (Utils.isAPK(holder.getMimeType())) {
                            Drawable drawable = getApkIconDrawable(holder, context);
                            if (drawable != null) {
                                bitmap = ((BitmapDrawable) drawable).getBitmap();
                            }
                        } else {
                            Drawable drawable = getAssociatedAppIconDrawable(holder, context);
                            if (drawable != null) {
                                bitmap = ((BitmapDrawable) drawable).getBitmap();
                            }
                        }
                    }

                    return bitmap;
                }
            };
        }

        return sDecoder;
    }

    private static DisplayImageOptions.Builder defaultOptionsBuilder() {
        if (sDefaultImageOptionsBuilder == null) {
            sDefaultImageOptionsBuilder = new DisplayImageOptions.Builder()
                    .displayer(new FadeInBitmapDisplayer(FADE_IN_DURATION, true, true, false))
                    .cacheInMemory(true)
                    .cacheOnDisk(false)
                    .delayBeforeLoading(125)
                    .imageScaleType(EXACTLY);
        }

        return sDefaultImageOptionsBuilder;
    }

    private static String getPackageNameFromInfo(ResolveInfo ri) {
        if (ri.resolvePackageName == null) {
            if (ri.activityInfo != null) {
                return ri.activityInfo.packageName;
            } else if (ri.serviceInfo.packageName != null) {
                return ri.serviceInfo.packageName;
            } else {
                return ri.providerInfo.packageName;
            }
        } else {
            return ri.resolvePackageName;
        }
    }
}
