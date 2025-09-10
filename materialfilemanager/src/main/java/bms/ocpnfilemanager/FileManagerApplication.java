/*
 * Copyright (C) 2014-2016 George Venios
 * Copyright (C) 2012 OpenIntents.org
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

package bms.ocpnfilemanager;

import android.animation.Animator;
import android.app.Application;
import android.view.ViewConfiguration;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import bms.ocpnfilemanager.misc.MimeTypes;
import bms.ocpnfilemanager.util.CopyHelper;
import bms.ocpnfilemanager.view.AnimatorSynchroniser;

import java.lang.reflect.Field;

import static bms.ocpnfilemanager.misc.ThumbnailHelper.imageDecoder;

public class FileManagerApplication extends Application {
    private CopyHelper mCopyHelper;
    private MimeTypes mMimeTypes;

    @Override
    public void onCreate() {
        super.onCreate();

        mCopyHelper = new CopyHelper();
        mMimeTypes = MimeTypes.newInstance(this);

        // Force-enable the action overflow
        try {
            ViewConfiguration config = ViewConfiguration.get(this);
            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if (menuKeyField != null) {
                menuKeyField.setAccessible(true);
                menuKeyField.setBoolean(config, false);
            }
        } catch (NoSuchFieldException | IllegalAccessException ex) {
            // Ignore
        }

        // UIL
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .diskCacheSize(10240000) // 10MB
                .imageDecoder(imageDecoder(getApplicationContext()))
                .build();
        ImageLoader.getInstance().init(config);
    }

    public CopyHelper getCopyHelper() {
        return mCopyHelper;
    }

    public MimeTypes getMimeTypes() {
        return mMimeTypes;
    }

    // Static for easier access
    private static AnimatorSynchroniser mAnimSync = new AnimatorSynchroniser();

    public static void enqueueAnimator(Animator animator) {
        mAnimSync.addWaitingAnimation(animator);
    }
}