package org.opencpn;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileInputStream;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.ConnectivityManager;

import org.opencpn.opencpn.R;

public class downloadGRIBSingle extends Activity {

    //initialize our progress dialog/bar
    private ProgressDialog mProgressDialog;
    public static final int RESULT_OK = 0;
    public static final int DIALOG_DOWNLOAD_PROGRESS = 0;
    public static final int ERROR_NO_INTERNET = 1;
    public static final int ERROR_NO_CONNECTION = 2;
    public static final int ERROR_EXCEPTION = 3;
    public static final int WARNING_PARTIAL = 4;
    public static final int ERROR_NO_RESOLVE = 5;

    public int m_result = RESULT_OK;
    public String targetURL;

    public boolean mDialogShown = false;
    public Context m_context;

    public long targetLength;
    public boolean m_progressHide;

    //initialize root directory
    File rootDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

    //defining file name and url
    public String fileName = "";
    public String fileURL = "";
    public String destinationFileName = "";
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setting some display
        //   setContentView(R.layout.main);
        //   TextView tv = new TextView(this);
        //   tv.setText("Android Download File With Progress Bar");

        Bundle extras = getIntent().getExtras();
        destinationFileName = extras.getString("GRIB_dest_file");
        Log.d("OpenCPN", "GRIB destinationFileName: " + destinationFileName);
//        fileURL = extras.getString("URL");
        targetURL = extras.getString("URL");
        targetLength = extras.getLong("gribLength");
        m_progressHide = extras.getBoolean("progress_hide");

        m_context = this;

        if(!haveNetworkConnection()){
            Intent i = getIntent(); //get the intent that called this activity
            setResult(ERROR_NO_INTERNET, i);
            finish();
        }
        else{
            //executing the asynctask
            Log.i("OpenCPN", " GRIB new DFA");
            new DownloadSingleFileAsync().execute(targetURL);
        }
    }

    //this is our download file asynctask
    class DownloadSingleFileAsync extends AsyncTask<String, Integer, String> {

        @Override
        protected void onPreExecute() {
            Log.i("OpenCPN", "GRIB onPreExecute");

            super.onPreExecute();
            mProgressDialog = new ProgressDialog(m_context);
            mProgressDialog.setMessage(getResources().getString(R.string.PREPARING_GRIB));
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.setMax(100);
            mProgressDialog.setProgress(0);
            mProgressDialog.setCancelable(true);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

            if (!m_progressHide)
                mProgressDialog.show();

            mDialogShown = true;
        }


        @Override
        protected String doInBackground(String...  url) {

           downloadSingleGRIB(url[0], destinationFileName);
           return "OK";
        }

        protected String downloadSingleGRIB(String url, String dest) {
                long lengthOfFile = 0;

                HttpsURLConnection c;
                InputStream in;

                try {
                    URL u = new URL(url);

                    if(u.getProtocol().equalsIgnoreCase("https")){
                        Log.d("OpenCPN", "OpenCPN Grib URL is https");


                        //connecting to url
                        c = (HttpsURLConnection)u.openConnection();
                        c.setRequestProperty("Accept-Encoding", "identity");
                        c.setRequestMethod("GET");
                        c.setDoOutput(true);
                        c.connect();

                        in = c.getInputStream();

                        //lgc = c.getContent().toString().length();
                        lengthOfFile = c.getContentLength();
                    }
                    else{
                        Log.d("OpenCPN", "OpenCPN Grib URL is http");

                        //connecting to url
                        HttpURLConnection c1 = (HttpURLConnection)u.openConnection();
                        c1.setRequestProperty("Accept-Encoding", "identity");
                        c1.setRequestMethod("GET");
                        c1.setDoOutput(true);
                        c1.connect();

                        int http_status = c1.getResponseCode();
                        String statusMsg = String.format("GRIB Status: %d\n", http_status);
                        Log.i("OpenCPN", statusMsg);

                        if (http_status/100 == 3) {
                            String loc = c1.getHeaderField("Location");
                            Log.i("OpenCPN", "Redirect: " + loc);

                            URL urlRedirect = new URL(loc);

                            c = (HttpsURLConnection)urlRedirect.openConnection();
                            c.setRequestProperty("Accept-Encoding", "identity");
                            c.setRequestMethod("GET");
                            c.setDoOutput(true);
                            c.connect();

                            int codeRedirect = c.getResponseCode();
                            Log.i("OpenCPN", "response code on redirect: " + Integer.toString(codeRedirect));

                            in = c.getInputStream();

                        }
                        else{
                            in = c1.getInputStream();

                        }
                    }

                }

                catch (Exception e) {
                    Log.d("OpenCPN Grib ExceptionA1", e.getMessage());

                        Log.i("OpenCPN", "GRIB ERROR_NO_CONNECTION");
                        if(e.getMessage().contains("resolve"))
                            m_result = ERROR_NO_RESOLVE;
                        else
                            m_result = ERROR_NO_CONNECTION;
                        return null;
                }



                try{
                    //mProgressDialog.setMax((int)lengthOfFile);

                    //this is where the file will be seen after the download
                    File nFile = new File(dest);
                    File nDir = nFile.getParentFile();
                    if(null != nDir)
                        nDir.mkdirs();
                    nFile.createNewFile();

                    FileOutputStream f = new FileOutputStream(nFile);

                    //here’s the download code
                    byte[] buffer = new byte[1024];
                    int len1 = 0;
                    long total = 0;

                    while ((len1 = in.read(buffer)) > 0) {
                         total += len1;

                        if (!m_progressHide) {

                            if (lengthOfFile > 0) {
                                long prog = ((total * 100) / lengthOfFile);
                                publishProgress((int) prog);

                                //publishProgress((int) total);
                                //String bmsg = String.format("%d / %d    %d \n", total, lengthOfFile,   prog);
                                //Log.i("OpenCPN", "GRIB Pub: " + bmsg);
                            } else if (targetLength > 0) {
                                long prog = ((total * 100) / targetLength);
                                publishProgress((int) prog);
                            }
                        }

                        f.write(buffer, 0, len1);
                    }

                    f.close();
                    m_result = RESULT_OK;
                } catch (Exception e) {
                    Log.d("OpenCPN GRIB ExceptionB", e.getMessage());
                    m_result = ERROR_EXCEPTION;

                }



            return "OK";
        }


        protected void onProgressUpdate(Integer... progress) {
//            String msg = String.format("%d\n", progress[0]);
//             Log.d("OpenCPN GRIB Progress",msg);
            mProgressDialog.setMessage(getResources().getString(R.string.DOWNLOADING_FILE));
            mProgressDialog.setProgress(progress[0]);
        }

        @Override
        protected void onPostExecute(String unused) {
            Log.i("OpenCPN", "GRIB onPostExecute");

            //dismiss the dialog after the file was downloaded
            if(mDialogShown){
                try{
                    dismissDialog(DIALOG_DOWNLOAD_PROGRESS);
                }
                catch(IllegalArgumentException exception){
                    Log.d("OpenCPN", "GRIB dialog illegal arg exception");
                }
            }


            Bundle b = new Bundle();
            Intent i = getIntent(); //gets the intent that called this intent
            setResult(m_result, i);

            finish();
        }
    }



    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }
}
