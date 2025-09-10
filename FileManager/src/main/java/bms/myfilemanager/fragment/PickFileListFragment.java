/*
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

package bms.myfilemanager.fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ViewFlipper;

import bms.myfilemanager.IntentConstants;
import bms.myfilemanager.R;
import bms.myfilemanager.misc.FileHolder;
import bms.myfilemanager.provider.FileManagerProvider;
import bms.myfilemanager.view.widget.PickBar;
import bms.myfilemanager.view.widget.PickBar.OnPickRequestedListener;

import java.io.File;

public class PickFileListFragment extends SimpleFileListFragment {
	private PickBar mPickBar;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
		return inflater.inflate(R.layout.fragment_filelist_pick, null);
	}


    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.removeItem(R.id.menu_bookmark);
    }

    @Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		ViewFlipper modeSelector = (ViewFlipper) view.findViewById(R.id.modeSelector);
		
		// Folder init
		if(getArguments().getBoolean(IntentConstants.EXTRA_DIRECTORIES_ONLY)){
			modeSelector.setDisplayedChild(0);
			
			Button button = (Button) view.findViewById(R.id.button);
			button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					pickFileOrFolder(new File(getPath()), false);
				}
			});
			if(getArguments().containsKey(IntentConstants.EXTRA_BUTTON_TEXT)){
				button.setText(getArguments().getString(IntentConstants.EXTRA_BUTTON_TEXT));
			}
		}
		// Files init
		else {
			modeSelector.setDisplayedChild(1);
			
			mPickBar = (PickBar) view.findViewById(R.id.pickBar);
			mPickBar.setButtonText(getArguments().getString(IntentConstants.EXTRA_BUTTON_TEXT));
			 
			mPickBar.setText(getFilename());
			// TODO make file visible, i.e. scroll to item 
			
			mPickBar.setOnPickRequestedListener(new OnPickRequestedListener() {
				@Override
				public void pickRequested(String filename) {
					if(filename.trim().length() == 0) {
						Toast.makeText(getActivity(), R.string.choose_filename, Toast.LENGTH_SHORT).show();
						return;
					}

					// Pick
					pickFileOrFolder(new File(getPath() + (getPath().endsWith("/") ? "" : "/") + filename),
							getArguments().getBoolean(IntentConstants.EXTRA_IS_GET_CONTENT_INITIATED, false));
				}
			});
			
		}			
	}

	@Override
	public void onListItemClick(AbsListView l, View v, int position, long id) {
		FileHolder item = (FileHolder) mAdapter.getItem(position);
		
		if(item.getFile().isFile())
			mPickBar.setText(item.getName());
		else
			super.onListItemClick(l, v, position, id);
	}
	
	/**
	 * Act upon picking. 
	 * @param selection A {@link File} representing the user's selection.
	 * @param getContentInitiated Whether the fragment was called through a GET_CONTENT intent on
     *                            the IntentFilterActivity. We have to know this so that result
     *                            is correctly formatted.
	 */
	private void pickFileOrFolder(File selection, boolean getContentInitiated){
		Intent intent = new Intent();
		intent.putExtras(getArguments());

        PreferenceFragment.setDefaultPickFilePath(getActivity(), selection.getParent() != null
                ?  selection.getParent() : "/");
		
		if(getContentInitiated)
			intent.setData(Uri.parse(FileManagerProvider.FILE_PROVIDER_PREFIX + selection));
		else
			intent.setData(Uri.fromFile(selection));
		getActivity().setResult(Activity.RESULT_OK, intent);
		getActivity().finish();
	}
}