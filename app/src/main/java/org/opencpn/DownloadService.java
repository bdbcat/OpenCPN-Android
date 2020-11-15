package org.opencpn;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.ConnectivityManager;
import android.app.IntentService;
import android.os.ResultReceiver;
import java.io.BufferedInputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import java.io.IOException;
import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import android.preference.PreferenceManager;
import android.content.SharedPreferences;

import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;

import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import org.opencpn.MySSLSocketFactory;
import org.opencpn.opencpn.R;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class DownloadService extends IntentService {
    public static final int UPDATE_PROGRESS = 8344;
    public static final int DOWNLOAD_DONE = 8345;
    public DownloadService() {
        super("DownloadService");
//        Log.i("OpenCPN", "DownloadService ctor ");
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        String urlToDownload = intent.getStringExtra("url");
        String fileDestination = intent.getStringExtra("file");
        boolean bUseDocFile = intent.getBooleanExtra("useDocFile", false);

        Uri fURI = Uri.parse(fileDestination);
        String file = "";
        try{
            file = fURI.getPath();
        }catch (Exception e) {
        }

        ResultReceiver receiver = (ResultReceiver) intent.getParcelableExtra("receiver");
        Log.i("OpenCPN", "onHandleIntent " + fileDestination + " " + file );

        OutputStream outputStream = null;

        if(bUseDocFile){
            Log.i("OpenCPN", "onHandleIntent : using DocumentFile interface for: " + file );

            File destFile = new File(file);
            DocumentFile dfile = getDocumentFile(destFile, false, true);

            if(null == dfile)
                Log.i("OpenCPN", "onHandleIntent : dfile is NULL" );


            try{
                outputStream = getContentResolver().openOutputStream(dfile.getUri());
            }
            catch(Exception e){
                Log.i("OpenCPN", "onHandleIntent exceptionA: " + file);
            }


        }
        else{
            try{
                outputStream = new FileOutputStream(file);
            }
            catch(Exception e){
                Log.i("OpenCPN", "onHandleIntent exceptionB: " + file);
            }
        }






        long total = 0;
        int fileLength = -1;
        InputStream input = null;

        if(null != outputStream){
        try {
            URL url = new URL(urlToDownload);
            if (android.os.Build.VERSION.SDK_INT <= android.os.Build.VERSION_CODES.KITKAT) {
                Log.i("OpenCPN", "Protocol(): " + url.getProtocol());

                if(url.getProtocol().equalsIgnoreCase("https")){

                    SSLContext context = null;

                    // Set up a new TrustManager to handle unrecognized certificate from storageshare.de
                    if( urlToDownload.indexOf("storageshare.de") != -1 ) {                  // o-charts cloud server
                        CertificateFactory cf = null;
                        try {
                            cf = CertificateFactory.getInstance("X.509");
                        } catch (Exception e) {
                            Log.i("OpenCPN", "Download Service Exception CFA ");
                            e.printStackTrace();
                        }

                        Certificate ca = null;
                        if (cf != null) {
                            InputStream caInput = getApplicationContext().getResources().openRawResource(R.raw.your_storageshare_de_crt);


                            try {
                                ca = cf.generateCertificate(caInput);
                                System.out.println("ca=" + ((X509Certificate) ca).getSubjectDN());
                            } catch (Exception e) {
                                Log.i("OpenCPN", "Download Service Exception CFB ");
                                e.printStackTrace();
                            } finally {
                                caInput.close();
                            }
                        }

                        // Create a KeyStore containing our trusted CAs
                        KeyStore keyStore = null;
                        try {
                            String keyStoreType = KeyStore.getDefaultType();
                            keyStore = KeyStore.getInstance(keyStoreType);
                            keyStore.load(null, null);
                            keyStore.setCertificateEntry("ca", ca);
                        } catch (Exception e) {
                            Log.i("OpenCPN", "Download Service Exception CFC ");
                            e.printStackTrace();
                        }

                        // Create a TrustManager that trusts the CAs in our KeyStore
                        TrustManagerFactory tmf = null;
                        try {
                            String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();

                            tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
                            tmf.init(keyStore);
                        } catch (Exception e) {
                            Log.i("OpenCPN", "Download Service Exception CFD ");
                            e.printStackTrace();
                        }


                        // Create an SSLContext that uses our TrustManager
                        try {
                            context = SSLContext.getInstance("TLS");
                            context.init(null, tmf.getTrustManagers(), null);
                        } catch (Exception e) {
                            Log.i("OpenCPN", "Download Service Exception CFE ");
                            e.printStackTrace();
                        }
                    }
                    else{
                        try {
                            context = SSLContext.getInstance("TLS");
                            context.init(null, null, null);
                        } catch (Exception e) {
                            Log.i("OpenCPN", "Download Service Exception CFF ");
                            e.printStackTrace();
                        }
                    }


                    HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

                    // Force a TLSv1.2 connection
                    MySSLSocketFactory myFact = new MySSLSocketFactory(context.getSocketFactory());
                    connection.setSSLSocketFactory(myFact);

                    connection.connect();
                    fileLength = connection.getContentLength();
                    input = new BufferedInputStream(connection.getInputStream());

                }
                else{
                    Log.i("OpenCPN", "URL is http:");
                    URLConnection connection = url.openConnection();
                    connection.connect();

                    int code =((HttpURLConnection)connection).getResponseCode();
                    Log.i("OpenCPN", "response code: " + Integer.toString(code));

                    if (code/100 == 3) {
                         String loc = connection.getHeaderField("Location");
                         Log.i("OpenCPN", "Redirect: " + loc);

                         URL urlRedirect = new URL(loc);

                         connection = urlRedirect.openConnection();
                         connection.connect();

                         int codeRedirect =((HttpURLConnection)connection).getResponseCode();
                         Log.i("OpenCPN", "response code on redirect: " + Integer.toString(codeRedirect));

                    }
                    fileLength = connection.getContentLength();
                    input = new BufferedInputStream(connection.getInputStream());
                }

            }
            else{
                Log.i("OpenCPN", "DownloadService: later than KitKat");

                URLConnection connection = url.openConnection();
                connection.connect();

                int code =((HttpURLConnection)connection).getResponseCode();
                Log.i("OpenCPN", "response code: " + Integer.toString(code));

                if (code/100 == 3) {
                     String loc = connection.getHeaderField("Location");
                     Log.i("OpenCPN", "Redirect: " + loc);

                     URL urlRedirect = new URL(loc);

                     connection = urlRedirect.openConnection();
                     connection.connect();

                     int codeRedirect =((HttpURLConnection)connection).getResponseCode();
                     Log.i("OpenCPN", "response code on redirect: " + Integer.toString(codeRedirect));

                }


                // this will be useful so that you can show a typical 0-100% progress bar
                fileLength = connection.getContentLength();

                // download the file from stream
                input = new BufferedInputStream(connection.getInputStream());
            }


            byte data[] = new byte[1024];
            int count;
            while ((count = input.read(data)) != -1) {
                total += count;
                // publishing the progress....
                Bundle resultData = new Bundle();

                int progress = (int) (total * 100 / fileLength);
                resultData.putInt("progress" , progress);
                resultData.putInt("sofar" , (int)total);
                resultData.putInt("filelength" , fileLength);

//                Log.i("OpenCPN", "RECEIVER SEND " + total + " " + fileLength + " " + progress);
                receiver.send(UPDATE_PROGRESS, resultData);
                outputStream.write(data, 0, count);
            }

            outputStream.flush();
            outputStream.close();
            input.close();
        } catch (IOException e) {
            Log.i("OpenCPN", "Download Service Exception A ");
            e.printStackTrace();
        }
        }

        Bundle resultData = new Bundle();
        resultData.putInt("progress" ,100);
        resultData.putInt("sofar" , (int)total);
        resultData.putInt("filelength" , fileLength);
        receiver.send(DOWNLOAD_DONE, resultData);
    }

    /**
        * Get a list of external SD card paths. (Kitkat or higher.)
        *
        * @return A list of external SD card paths.
        */
       private String[] getExtSdCardPaths() {
           List<String> paths = new ArrayList<String>();



               for (File file : this.getExternalFilesDirs("external")) {
                   if (file != null && !file.equals(this.getExternalFilesDir("external"))) {
                       int index = file.getAbsolutePath().lastIndexOf("/Android/data");
                       if (index < 0) {
                           //Log.w(Application.TAG, "Unexpected external file dir: " + file.getAbsolutePath());
                       } else {
                           String path = file.getAbsolutePath().substring(0, index);
                           try {
                               path = new File(path).getCanonicalPath();
                           } catch (IOException e) {
                               // Keep non-canonical path.
                           }
                           paths.add(path);
                       }
                   }
               }

           return paths.toArray(new String[paths.size()]);
       }


    public String getExtSdCardFolder(final File file) {
        String[] extSdPaths = getExtSdCardPaths();
        try {
            for (int i = 0; i < extSdPaths.length; i++) {
                if (file.getCanonicalPath().startsWith(extSdPaths[i])) {
                   return extSdPaths[i];
                }
           }
        }
        catch (IOException e) {
           return null;
        }

        return null;
   }

    public DocumentFile getDocumentFile(final File file, final boolean isDirectory, boolean bCreate) {
        String baseFolder = getExtSdCardFolder(file);

        if (baseFolder == null) {
            return null;
        }

        String relativePath = null;
        try {
            String fullPath = file.getCanonicalPath();
            if(fullPath.length() > baseFolder.length())
                relativePath = fullPath.substring(baseFolder.length() + 1);
            else
            relativePath = "";
            }
        catch (IOException e) {
            return null;
        }

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String sUri = preferences.getString("SDURI", "");
        if(sUri.isEmpty())
            return null;

        Uri ltreeUri = Uri.parse(sUri);

        if (ltreeUri == null) {
            return null;
        }


        // start with root of SD card and then parse through document tree.
        DocumentFile document = DocumentFile.fromTreeUri(this, ltreeUri);

        if(relativePath.isEmpty())
            return document;

        try {
            String[] parts = relativePath.split("\\/");
            for (int i = 0; i < parts.length; i++) {
                DocumentFile nextDocument = document.findFile(parts[i]);

                if (nextDocument == null) {
                    if(!bCreate)
                        return null;
                    if ((i < parts.length - 1) || isDirectory) {
                        nextDocument = document.createDirectory(parts[i]);
                    } else {
                        nextDocument = document.createFile("image", parts[i]);
                    }
                }
                document = nextDocument;
                }
            }catch(Exception e){
                int yyp = 0;
            }

        return document;
        }



}































