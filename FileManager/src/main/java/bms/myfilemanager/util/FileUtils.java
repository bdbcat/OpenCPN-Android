/* 
 * Copyright (C) 2007-2008 OpenIntents.org
 * Copyright (C) 2017 George Venios
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

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.format.Formatter;
import android.widget.Toast;

import bms.myfilemanager.R;
import bms.myfilemanager.misc.FileHolder;

import java.io.File;
import java.util.List;

import static android.content.Intent.ACTION_VIEW;
import static bms.myfilemanager.provider.FileManagerProvider.FILE_PROVIDER_PREFIX;

/**
 * @version 2009-07-03
 *
 * @author Peli
 *
 */
public class FileUtils {
	private static final int X_OK = 1;
	public static final String NOMEDIA_FILE_NAME = ".nomedia";

	/**
	 * Gets the extension of a file name, like ".png" or ".jpg".
	 *
	 * @param path The file path or name
	 * @return Extension including the dot("."); "" if there is no extension;
	 *         null if uri was null.
	 */
	public static String getExtension(String path) {
        String ext = "";
        String name = new File(path).getName();

        int i = name.lastIndexOf('.');

        if (i > 0 &&  i < name.length() - 1) {
            ext = name.substring(i).toLowerCase();
        }
        return ext;
	}

    public static Uri getUri(Uri uri) {
        String filePath = uri.getSchemeSpecificPart();
        return getUri(filePath);
    }

    public static Uri getUri(FileHolder fileHolder) {
        return getUri(fileHolder.getFile().getAbsolutePath());
    }

    private static Uri getUri(String filePath) {
        if (filePath.startsWith("//")) {
            filePath = filePath.substring(2);
        }
        return Uri.parse(FILE_PROVIDER_PREFIX).buildUpon()
                .appendPath(filePath)
                .build();
    }

	/**
	 * Convert Uri into File.
	 * @param uri Uri to convert.
	 * @return The file pointed to by the uri.
	 */
	public static File getFile(Uri uri) {
		if (uri != null) {
			String filepath = uri.getPath();
			if (filepath != null) {
				return new File(filepath);
			}
		}
		return null;
	}

	/**
	 * Returns the path only (without file name).
	 * @param file The file whose path to get.
	 * @return The first directory up from file. If file.isdirectory returns the file.
	 */
	public static File getPathWithoutFilename(File file) {
		 if (file != null) {
			 if (file.isDirectory()) {
				 // no file to be split off. Return everything
				 return file;
			 } else {
				 String filename = file.getName();
				 String filepath = file.getAbsolutePath();

				 // Construct path without file name.
				 String pathWithoutName = filepath.substring(0, filepath.length() - filename.length());
				 if (pathWithoutName.endsWith("/")) {
					 pathWithoutName = pathWithoutName.substring(0, pathWithoutName.length() - 1);
				 }
				 return new File(pathWithoutName);
			 }
		 }
		 return null;
	}

	public static String formatSize(Context context, long sizeInBytes) {
		return Formatter.formatFileSize(context, sizeInBytes);
	}

	public static long folderSize(File directory) {
		long length = 0;
		File[] files = directory.listFiles();
		if(files != null)
			for (File file : files)
				if (file.isFile())
					length += file.length();
				else
					length += folderSize(file);
		return length;
	}

    /**
     * @param f File which needs to be checked.
     * @return True if the file is a zip archive.
     */
    public static boolean checkIfZipArchive(File f){
        // Hacky but fast enough
        return f.isFile() && FileUtils.getExtension(f.getAbsolutePath()).equals(".zip");
    }

    /**
     * Recursively count all files in the <code>file</code>'s subtree.
     * @param file The root of the tree to count.
     */
    public static int getFileCount(File file){
        int fileCount = 0;
        if (!file.isDirectory()){
            fileCount++;
        } else {
            if(file.list() != null) {
                for (File f : file.listFiles()) {
                    fileCount += getFileCount(f);
                }
            }
        }

        return fileCount;
    }

    public static int getFileCount(List<FileHolder> list) {
        int fileCount = 0;
        for (FileHolder fh : list) {
            fileCount += FileUtils.getFileCount(fh.getFile());
        }

        return fileCount;
    }

	/**
	 * Native helper method, returns whether the current process has execute privilages.
	 * @param file File
	 * @return returns TRUE if the current process has execute privilages.
	 */
	public static boolean canExecute(File file) {
		return file.canExecute();
	}

	/**
	 * @param path The path that the file is supposed to be in.
	 * @param fileName Desired file name. This name will be modified to create a unique file if necessary.
	 * @return A file name that is guaranteed to not exist yet. MAY RETURN NULL!
	 */
	public static File createUniqueCopyName(Context context, File path, String fileName) {
		// Does that file exist?
		File file = new File(path, fileName);

		if (!file.exists()) {
			// Nope - we can take that.
			return file;
		}

		// Split file's name and extension to fix internationalization issue #307
		String extension = getExtension(file.getPath());
        int extStart = fileName.lastIndexOf(extension);
		if (extStart > 0) {
			fileName = fileName.substring(0, extStart);
		}

		// Try a simple "copy of".
		file = new File(path, context.getString(R.string.copied_file_name, fileName).concat(extension));

		if (!file.exists()) {
			// Nope - we can take that.
			return file;
		}

		int copyIndex = 2;

		// Well, we gotta find a unique name at some point.
		while (copyIndex < 500) {
			file = new File(path, context.getString(R.string.copied_file_name_2, copyIndex, fileName).concat(extension));

			if (!file.exists()) {
				// Nope - we can take that.
				return file;
			}

			copyIndex++;
		}

		// I GIVE UP.
		return null;
	}

	/**
	 * Attempts to open a file for viewing.
	 *
	 * @param fileholder The holder of the file to open.
	 */
	public static void openFile(FileHolder fileholder, Context c) {
        Intent intent = getViewIntentFor(fileholder, c);
        launchFileIntent(intent, c);
	}

    public static Intent getViewIntentFor(FileHolder fileholder, Context c) {
        Intent intent = new Intent(ACTION_VIEW);
        Uri data = getUri(fileholder);
        String type = fileholder.getMimeType();

        intent.setDataAndType(data, type);
        return intent;
    }

    private static void launchFileIntent(Intent intent, Context c) {
		intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        try {
            List<ResolveInfo> activities = c.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
            if (activities.size() == 0 || onlyActivityIsOurs(c, activities)) {
                Toast.makeText(c.getApplicationContext(), R.string.application_not_available, Toast.LENGTH_SHORT).show();
            } else {
                c.startActivity(intent);
            }
        } catch (ActivityNotFoundException | SecurityException e) {
            Toast.makeText(c.getApplicationContext(), R.string.application_not_available, Toast.LENGTH_SHORT).show();
        }
	}

	public static boolean isValidDirectory(@NonNull File file) {
		return file.exists() && file.isDirectory();
	}

    public static boolean isResolverActivity(ResolveInfo resolveInfo) {
        // Please kill me..
        return "android".equals(resolveInfo.activityInfo.packageName)
                && "com.android.internal.app.ResolverActivity".equals(resolveInfo.activityInfo.name);
    }

    private static boolean onlyActivityIsOurs(Context c, List<ResolveInfo> activities) {
        String dirPackage = c.getApplicationInfo().packageName;
        String resolvedPackage = activities.get(0).activityInfo.packageName;

        return activities.size() == 1 && dirPackage.equals(resolvedPackage);
    }

    public static String getNameWithoutExtension(File f) {
        String fileName = f.getName();
        String extension = getExtension(fileName);
        return fileName.substring(0, fileName.length() - extension.length());
	}

    public static void deleteDirectory(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory())
            for (File child : fileOrDirectory.listFiles())
                deleteDirectory(child);

        fileOrDirectory.delete();
    }

    public static String getFileName(File file) {
        if (file.getAbsolutePath().equals("/")) {
            return "/";
        } else {
            return file.getName();
        }
    }
}
