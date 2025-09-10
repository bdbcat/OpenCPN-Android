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

package bms.myfilemanager.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

import bms.myfilemanager.IntentConstants;
import bms.myfilemanager.R;
import bms.myfilemanager.fragment.FileListFragment;
import bms.myfilemanager.misc.FileHolder;
import bms.myfilemanager.util.MediaScannerUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SingleDeleteDialog extends DialogFragment {
	private FileHolder mFileHolder;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mFileHolder = getArguments().getParcelable(IntentConstants.EXTRA_DIALOG_FILE_HOLDER);
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setTitle(getString(R.string.really_delete, mFileHolder.getName()))
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        new RecursiveDeleteTask().execute(mFileHolder.getFile());
                    }
                })
                .setNegativeButton(R.string.no, null)
                .create();
        dialog.setIcon(R.drawable.ic_dialog_delete);
        return dialog;
	}
	
	private class RecursiveDeleteTask extends AsyncTask<File, Void, Void> {
		/**
		 * If 0 some failed, if 1 all succeeded. 
		 */
		private int mResult = 1;
		private ProgressDialog dialog = new ProgressDialog(getActivity());

		/**
		 * Recursively delete a file or directory and all of its children.
		 * 
		 * @return 0 if successful, error value otherwise.
		 */
		private int recursiveDelete(File file) {
			File[] files = file.listFiles();
			if (files != null && files.length != 0) {
                // If it's a directory delete all children.
                for (File childFile : files) {
                    if (childFile.isDirectory()) {
                        mResult *= recursiveDelete(childFile);
                    } else {
                        mResult *= childFile.delete() ? 1 : 0;
                    }
                }
            }
				
            // And then delete parent. -- or just delete the file.
            mResult *= file.delete() ? 1 : 0;

            return mResult;
		}
		
		@Override
		protected void onPreExecute() {		
			dialog.setMessage(getActivity().getString(R.string.deleting));
			dialog.setIndeterminate(true);
			dialog.show();
		}
		
		@Override
		protected Void doInBackground(File... params) {
            File tbd = params[0];
            boolean isDir = tbd.isDirectory();
            List<String> paths = new ArrayList<String>();
            if (isDir) {
                MediaScannerUtils.getPathsOfFolder(paths, tbd);
            }

			recursiveDelete(tbd);

            if (isDir) {
                MediaScannerUtils.informPathsDeleted(getTargetFragment()
                        .getActivity().getApplicationContext(), paths);
            } else {
                MediaScannerUtils.informFileDeleted(getTargetFragment()
                        .getActivity().getApplicationContext(), tbd);
            }
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			Toast.makeText(dialog.getContext(), mResult == 0 ? R.string.delete_failure : R.string.delete_success, Toast.LENGTH_LONG).show();
            FileListFragment.refresh(getTargetFragment().getActivity(), mFileHolder.getFile().getParentFile());
            dialog.dismiss();
		}
	}
}