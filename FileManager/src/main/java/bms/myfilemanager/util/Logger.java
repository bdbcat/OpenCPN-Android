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

package bms.myfilemanager.util;

import android.util.Log;

import bms.myfilemanager.BuildConfig;

/**
 * @author George Venios
 */
public class Logger {
    private static final boolean LOG_ENABLED = BuildConfig.DEBUG;

    private static final String TAG_DEFAULT = "DIR_Default";
    public static final String TAG_OBSERVER = "DIR_FileObserver";
    public static final String TAG_DIRSCANNER = "DIR_DirectoryScanner";
    public static final String TAG_THUMBLOADER = "DIR_ThumbnailLoader";
    public static final String TAG_MEDIASCANNER = "DIR_MediaScanner";
    public static final String TAG_PATHBAR = "DIR_PathBar";
    public static final String TAG_ANIMATION = "DIR_Animation";

    private Logger(){}

    public static void log(Throwable t) {
        if (LOG_ENABLED) {
            t.printStackTrace();
        }
    }

    public static void log(String msg) {
        logV(TAG_DEFAULT, msg);
    }

    public static void log(int priority, String msg) {
        log(priority, TAG_DEFAULT, msg);
    }

    public static void logV(String tag, String msg) {
        log(Log.VERBOSE, tag, msg);
    }

    public static void log(int priority, String tag, String msg) {
        if (LOG_ENABLED) {
            Log.println(priority, tag, msg);
        }
    }
}
