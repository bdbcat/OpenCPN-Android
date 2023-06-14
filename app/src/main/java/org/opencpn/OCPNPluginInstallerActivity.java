
package org.opencpn;

import android.content.ComponentName;
import android.content.pm.ApplicationInfo;
import android.app.Activity;
import android.os.Bundle;
import org.opencpn.opencpn.R;
import android.content.Intent;
import android.app.PendingIntent;
import android.app.AlarmManager;
import android.content.Context;
import android.app.ActivityManager;
import android.os.Handler;
import android.util.Log;
import android.net.Uri ;

import androidx.core.content.IntentCompat;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.List;
import org.qtproject.qt5.android.bindings.QtActivity;

public class OCPNPluginInstallerActivity extends Activity {

        public void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);

            Log.i("OpenCPN", "OCPNPluginInstallerActivity onCreate");

            // Get intent, action and MIME type
            Intent intent = getIntent();
            String action = intent.getAction();
            String type = intent.getType();

            if (Intent.ACTION_SEND.equals(action) && type != null) {
                if ("text/plain".equals(type)) {
                    Log.i("OpenCPN", "OCPNPluginInstallerActivity Got text/plain");

                    // Check the URI
                    Uri uri = (Uri) getIntent().getExtras().get(Intent.EXTRA_STREAM);
                    if(null == uri){
                        Log.i("OpenCPN", "OCPNPluginInstallerActivity ERROR: Got null file uri.");
                        finish();
                    }

                    handleSendText(intent); // Handle uri being sent
                }
            }

            boolean bRestart = true;

            // Want to avoid restarting OCPN now?
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                bRestart = extras.getBoolean("RestartFlag", true);
            }

            Log.i("OpenCPN", "OCPNPluginInstallerActivity mStartActivity: ");

            if(bRestart){
                Log.i("OpenCPN", "OCPNPluginInstallerActivity mStartActivity: bRestart True");

                Intent intentToBeNewRoot = new Intent(this, org.qtproject.qt5.android.bindings.QtActivity.class);
                ComponentName cn = intentToBeNewRoot.getComponent();

                Intent mainIntent = Intent.makeRestartActivityTask(cn);

                int mPendingIntentId = 123456;

                PendingIntent mPendingIntent = PendingIntent.getActivity(getApplicationContext(), mPendingIntentId, mainIntent,
                        PendingIntent.FLAG_CANCEL_CURRENT + PendingIntent.FLAG_IMMUTABLE);
                AlarmManager mgr = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 1000, mPendingIntent);

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        System.exit(0);
                    }
                }, 500);
            }

            finish();
        }

        void handleSendText(Intent intent) {
            Uri uri = (Uri) intent.getExtras().get(Intent.EXTRA_STREAM);
            if(null == uri){
                finish();
            }

            String sharedFile = uri.toString();

            if (sharedFile != null) {
                Log.i("OpenCPN", "OCPNPluginInstallerActivity Got uri: " + sharedFile);



                // Name and extension of the shared file
                String fileName = new File(uri.getPath()).getName();


                //  Open the file as an input stream
                InputStream inputStream = null;
                try{
                    inputStream = getApplicationContext().getContentResolver().openInputStream(uri);

                    String length = String.valueOf(inputStream.available());
                    Log.i("OpenCPN", "OCPNPluginInstallerActivity: inputStream available(): " + length);
                }
                catch (Exception e) {
                    e.printStackTrace();
                    Log.i("OpenCPN", "OCPNPluginInstallerActivity:  Input Stream Exception");
                }

                // Create the destination directory
                String stagingPath = getFilesDir().getPath() + File.separator + "staging";


/*
                //  Maybe the app has been migrated to SDCard...
                ApplicationInfo ai = getApplicationInfo();
                if((ai.flags & ApplicationInfo.FLAG_EXTERNAL_STORAGE) ==  ApplicationInfo.FLAG_EXTERNAL_STORAGE){
                    Log.i("OpenCPN", "OCPNPluginInstallerActivity:  OCPN is on EXTERNAL_STORAGE");
                    File[] fx = getExternalFilesDirs(null);
                    if(fx.length > 1){
                        stagingPath = fx[1].getPath() + File.separator + "staging";
                    }
                }
*/

                Log.i("OpenCPN", "OCPNPluginInstallerActivity:  Staging directory: " + stagingPath);

                File stagingDirFile = new File(stagingPath);
                if (!stagingDirFile.exists()){
                    Log.i("OpenCPN", "OCPNPluginInstallerActivity:  Making Staging directory: " + stagingPath);
                    if( !stagingDirFile.mkdirs()){
                        Log.i("OpenCPN", "OCPNPluginInstallerActivity:  Could not make Staging directory: " + stagingPath);
                    }
                }

                // Create the output stream

                Log.i("OpenCPN", "OCPNPluginInstallerActivity:  Destination file: " + stagingPath + File.separator + fileName);

                File destinationFile = new File(stagingPath + File.separator + fileName);

                OutputStream outputStream = null;
                try{
                    destinationFile.createNewFile();
                    outputStream = new FileOutputStream(destinationFile);
                }
                catch (Exception e) {
                    e.printStackTrace();
                    Log.i("OpenCPN", "OCPNPluginInstallerActivity:  Output Stream Exception");
                }

                if(null != outputStream){
                    //  Copy the file to staging directory
                    try {
                        copyFile(inputStream, outputStream);
                        inputStream.close();
                        outputStream.close();
                        Log.i("OpenCPN", "OCPNPluginInstallerActivity: copyFile OK");
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                        Log.i("OpenCPN", "OCPNPluginInstallerActivity: copyFile Exception");
                    }
                }

            }

        }

        static private void copyFile(InputStream inputStream, OutputStream outputStream)
            throws IOException
        {
            byte[] buffer = new byte[1024];

            int count;
            while ((count = inputStream.read(buffer)) > 0)
                outputStream.write(buffer, 0, count);
        }

        @Override
        public void finish() {
            Log.i("OpenCPN", "OCPNPluginInstallerActivity finish " + this);

//            Bundle b = new Bundle();
//            b.putString("SettingsString", m_newSettings);
            Intent i = new Intent();
//            i.putExtras(b);
            setResult(RESULT_OK, i);

            super.finish();
        }


}

