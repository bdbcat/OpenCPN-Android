/*
 * Copyright (C) 2012 OpenIntents.org
 * Copyright (C) 2014-2016 George Venios
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

package bms.myfilemanager.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

import bms.myfilemanager.FileManagerApplication;
import bms.myfilemanager.R;
import bms.myfilemanager.activity.FileManagerActivity;
import bms.myfilemanager.fragment.SimpleFileListFragment;
import bms.myfilemanager.misc.FileHolder;
import bms.myfilemanager.misc.MimeTypes;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import static android.graphics.Bitmap.Config.ARGB_8888;
import static android.view.View.MeasureSpec.EXACTLY;
import static android.view.View.MeasureSpec.makeMeasureSpec;
import static bms.myfilemanager.AnimationConstants.ANIM_START_DELAY;
import static java.lang.Math.abs;

public abstract class Utils {
    private Utils() {
    }

    /**
     * @param root      Folder to start search from.
     * @param filter    The FilenameFilter to use for matching.
     * @param mimeTypes Initialized MimeTypes instance.
     * @param context   A context.
     * @param recursive Whether to recursively follow the paths.
     * @param maxLevel  How many levels below the current we're allowed to recurse.
     * @return A list of FileHolders found in root and matching filter.
     */
    public static List<FileHolder> searchIn(File root, FilenameFilter filter, MimeTypes mimeTypes,
                                            Context context, boolean recursive, int maxLevel) {
        ArrayList<FileHolder> result = new ArrayList<>(10);

        File[] filteredFiles = root.listFiles(filter);
        if (filteredFiles != null) {
            for (File f : filteredFiles) {
                String mimeType = mimeTypes.getMimeType(f.getName());

                result.add(new FileHolder(f, mimeType, getIconForFile(context, mimeType, f)));
            }
        }

        File[] files = root.listFiles();
        if (files != null) {
            if (recursive && (maxLevel-- != 0)) {
                for (File f : files) {
                    // Prevent trying to search invalid folders
                    if (f.isDirectory() && f.canRead()) {
                        result.addAll(searchIn(f, filter, mimeTypes, context, true, maxLevel));
                    }
                }
            }
        }

        return result;
    }

    public static List<FileHolder> searchIn(File root, final String query, MimeTypes mimeTypes,
                                            Context context) {
        return searchIn(root, newFilter(query), mimeTypes, context, false, 0);
    }

    public static FilenameFilter newFilter(final String query) {
        return new FilenameFilter() {
            @Override
            public boolean accept(File dir, String filename) {
                return query != null && filename.toLowerCase().contains(query.toLowerCase());
            }
        };
    }

    public static String getLastPathSegment(String path) {
        String[] segments = path.split("/");

        if (segments.length > 0)
            return segments[segments.length - 1];
        else
            return "";
    }

    /**
     * Launch the home activity.
     *
     * @param act The currently displayed activity.
     */
    public static void showHome(Activity act) {
        Intent intent = new Intent(act, FileManagerActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        act.startActivity(intent);
    }

    /**
     * Creates a home screen shortcut.
     *
     * @param fileHolder The {@link File} to create the shortcut to.
     */
    public static void createShortcut(FileHolder fileHolder, Context context) {
        Intent shortcutIntent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        shortcutIntent.putExtra("duplicate", false);
        shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, fileHolder.getName());
        try {
            shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON,
                    bitmapFrom(context.getResources().getDisplayMetrics(),
                            fileHolder.getBestIcon()));
        } catch (Exception ex) {
            Logger.log(ex);
            Parcelable icon = Intent.ShortcutIconResource.fromContext(
                    context.getApplicationContext(), R.mipmap.ic_launcher);
            shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, icon);
        } finally {
            Intent onClickIntent = new Intent(Intent.ACTION_VIEW);
            if (fileHolder.getFile().isDirectory())
                onClickIntent.setData(Uri.fromFile(fileHolder.getFile()));
            else
                onClickIntent.setDataAndType(Uri.fromFile(fileHolder.getFile()), fileHolder.getMimeType());
            onClickIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);

            shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, onClickIntent);
            context.sendBroadcast(shortcutIntent);
        }
    }

    private static Bitmap bitmapFrom(DisplayMetrics metrics, Drawable drawable) {
        Bitmap result = Bitmap.createBitmap(
                metrics,
                drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(),
                ARGB_8888);
        Canvas c = new Canvas(result);
        drawable.draw(c);
        return result;
    }

    /**
     * Creates an activity picker to send a file.
     *
     * @param fHolder A {@link FileHolder} containing the {@link File} to send.
     * @param context {@link Context} in which to create the picker.
     */
    public static void sendFile(FileHolder fHolder, Context context) {
        String filename = fHolder.getName();

        Intent i = new Intent();
        i.setAction(Intent.ACTION_SEND);
        i.setType(fHolder.getMimeType());
        i.putExtra(Intent.EXTRA_SUBJECT, filename);
        i.putExtra(Intent.EXTRA_STREAM, FileUtils.getUri(fHolder));

        i = Intent.createChooser(i, context.getString(R.string.send_chooser_title));

        try {
            context.startActivity(i);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(context, R.string.send_not_available, Toast.LENGTH_SHORT).show();
        }
    }

    public static Drawable getIconForFile(Context c, String mimeType, File f) {
        if (f.isDirectory()) {
            return getFolderIcon(c);
        } else {
            MimeTypes mimeTypes = ((FileManagerApplication) c.getApplicationContext()).getMimeTypes();
            return mimeTypes.getIcon(c, mimeType);
        }
    }

    public static Drawable getSdCardIcon(Context c) {
        return c.getDrawable(R.drawable.ic_item_sdcard);
    }

    private static Drawable getFolderIcon(Context c) {
        return c.getDrawable(R.drawable.ic_item_folder);
    }

    /**
     * Get the directory index where two files are intersected last.
     * Effectively the last common directory in two files' paths. <br/>
     * This method seems kind of silly, if anyone has a more elegant solution, please lmk.
     */
    public static int lastCommonDirectoryIndex(File file1, File file2) {
        String[] parts1 = file1.getAbsolutePath().split("/");
        String[] parts2 = file2.getAbsolutePath().split("/");
        int index = 0;

        for (String part1 : parts1) {
            if (parts2.length <= index) {
                // Reached the end of the second input.
                // The first input was fully contained in it.
                if (index > 0)
                    // If the index has been incremented, it is now
                    // outside the second path's bounds.
                    index--;
                // If it was 0, it meant that the second input was just the root.
                break;
            } else if (!part1.equals(parts2[index])) {
                // Found a difference between the two paths.
                // Last common directory was the previous one.
                index--;
                break;
            } else if (!parts1[parts1.length - 1].equals(part1)) {
                // The end of the first path has not been reached.
                index++;
            }
        }

        return index;
    }

    /**
     * @param file1
     * @param file2
     * @return 1 if file1 is above file2, -1 otherwise. 0 on errors
     */
    public static int getNavigationDirection(File file1, File file2) {
        if (file1 == null || file2 == null
                || file1.getAbsolutePath().equals("") || file2.getAbsolutePath().equals("")
                || file1.getAbsolutePath().equals(file2.getAbsolutePath()))
            return 0;

        int result = -1;
        if (file2.getAbsolutePath().startsWith(file1.getAbsolutePath())) {
            result = 1;
        }
        return result;
    }

    public static boolean getItemChecked(AbsListView listView, int position) {
        return listView.getCheckedItemPositions().get(position);
    }

    public static boolean isAPK(String mimeType) {
        return "application/vnd.android.package-archive".equals(mimeType);
    }

    public static boolean isImage(String mimeType) {
        String type = mimeType.split("/")[0];
        return "image".equals(type);
    }

    public static void scrollToPosition(final AbsListView listView, final SimpleFileListFragment.ScrollPosition pos, boolean immediate) {
        if (listView instanceof ListView) {
            listView.setSelectionFromTop(pos.index, pos.top);
        } else {
            listView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Being unable to scroll to exact pixel without ListView
                    // (or without having a god-awful animation forced)
                    // we just scroll to the closest item
                    int index = pos.index;
                    listView.setSelection(index);
                    View firstChild = listView.getChildAt(0);

                    if (firstChild != null
                            && abs(pos.top) > firstChild.getHeight() / 2) {
                        listView.setSelection(index + 1);
                    }
                }
            }, immediate ? 0 : ANIM_START_DELAY);
        }
    }

    /**
     * @param initialDirPath The directory on which the app was launched.
     * @param currentDirPath The current directory's absolute path.
     * @return Whether the back button should exit the app.
     */
    public static boolean backWillExit(String initialDirPath, String currentDirPath) {
        // Count tree depths
        String[] dir = currentDirPath.split("/");
        int dirTreeDepth = dir.length;

        String[] init = initialDirPath.split("/");
        int initTreeDepth = init.length;

        //noinspection SimplifiableIfStatement
        if (dirTreeDepth > initTreeDepth) {
            return false;
        } else {
            return currentDirPath.equals(initialDirPath) || currentDirPath.equals("/");
        }
    }

    public static int measureExactly(int pixels) {
        return makeMeasureSpec(pixels, EXACTLY);
    }

    @Nullable
    public static View getLastChild(ViewGroup group) {
        return getChildAtFromEnd(group, 0);
    }

    @Nullable
    public static View getChildAtFromEnd(ViewGroup group, int i) {
        int childCount = group.getChildCount();
        if (childCount == 0) {
            return null;
        }

        return group.getChildAt(childCount - (i + 1));
    }
}
