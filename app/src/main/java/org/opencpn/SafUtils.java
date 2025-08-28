package org.opencpn;

import androidx.annotation.Nullable;
import androidx.documentfile.provider.DocumentFile;
import android.content.Context;
import android.net.Uri;
import android.content.SharedPreferences;

public class SafUtils {

    /**
     * Recursively finds a directory within a DocumentFile tree.
     *
     * @param context          The application context.
     * @param currentDirectory The DocumentFile of the current directory to search.
     * @param pathSegments     A list of directory names representing the remaining path.
     * @return The DocumentFile of the target directory, or null if not found.
     */
    private static DocumentFile findDirectory(Context context, DocumentFile currentDirectory, String[] pathSegments, int index) {
        if (currentDirectory == null || !currentDirectory.isDirectory()) {
            return null;
        }

        if (index >= pathSegments.length) {
            return currentDirectory; // We've found the target directory.
        }

        String targetName = pathSegments[index];
        DocumentFile found = currentDirectory.findFile(targetName);

        if (found != null && found.isDirectory()) {
            // Found the next segment; recurse deeper.
            return findDirectory(context, found, pathSegments, index + 1);
        }

        return null; // The path segment was not found or is not a directory.
    }


    /**
     * Finds the DocumentFile for a specific sub-path from a persisted tree URI.
     *
     * @param context The application context.
     * @param treeUri The persisted Uri for the root directory (e.g., "Documents").
     * @param path    The relative path to the target directory (e.g., "test/x/y").
     * @return The DocumentFile of the target directory, or null if not found.
     */
    public static DocumentFile findParentDirectoryFromPath(Context context, Uri treeUri, String path) {
        DocumentFile documentsRoot = DocumentFile.fromTreeUri(context, treeUri);
        if (documentsRoot == null || !documentsRoot.isDirectory()) {
            return null;
        }

        String[] pathSegments = path.split("/");
        return findDirectory(context, documentsRoot, pathSegments, 0);
    }

 //   import android.content.Context;
//import android.content.SharedPreferences;
//import android.net.Uri;
//import androidx.annotation.Nullable;



        private static final String PREFS_NAME = "OCPN_PERSISTED_PERMISSION";
        private static final String KEY_DOCUMENTS_TREE_URI = "filestorageuri";

    //SharedPreferences preferences = getSharedPreferences("OCPN_PERSISTED_PERMISSION", Context.MODE_PRIVATE);
    //String sUri = preferences.getString("filestorageuri", "");

    /**
         * Saves a Uri to SharedPreferences as a string.
         * This should be called after a user has granted permission via ACTION_OPEN_DOCUMENT_TREE.
         *
         * @param context The application context.
         * @param treeUri The Uri of the directory tree to persist.
         */
        public static void savePersistedTreeUri(Context context, Uri treeUri) {
            SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString(KEY_DOCUMENTS_TREE_URI, treeUri.toString());
            editor.apply();
        }

        /**
         * Retrieves the persisted Uri from SharedPreferences.
         *
         * @param context The application context.
         * @return The persisted Uri, or null if not found.
         */
        @Nullable
        public static Uri getPersistedTreeUri(Context context) {
            SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
            String uriString = prefs.getString(KEY_DOCUMENTS_TREE_URI, null);
            if (uriString != null) {
                return Uri.parse(uriString);
            }
            return null;
        }
}

