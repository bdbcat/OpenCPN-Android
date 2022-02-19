package org.opencpn;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.BufferedOutputStream;
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
import java.io.IOException;
import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import android.preference.PreferenceManager;
import android.content.SharedPreferences;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.xz.XZCompressorInputStream;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnzipService extends IntentService {
    public static final int UNZIP_DONE = 8349;
    public static final int UNZIP_FILE = 8350;
    public static final int TOPDIR = 8351;

    String topDir = "";

    private ResultReceiver m_receiver;

    public UnzipService() {
        super("UnzipService");
        Log.i("OpenCPN", "UnzipService ctor ");
    }
    @Override
    protected void onHandleIntent(Intent intent) {

        Bundle extras = intent.getExtras();

        String fileSource = intent.getStringExtra("sourceZip");
        String fileDestination = intent.getStringExtra("targetDir");
        int nStrip = extras.getInt("nStrip", 0);
        int nRemoveZip = extras.getInt("removeZip", 0);
        m_receiver = (ResultReceiver) intent.getParcelableExtra("receiver");

        Log.i("OpenCPN", "UnzipService: onHandleIntent " + fileSource + "  " + fileDestination );

        if(fileSource.endsWith(".tar.xz")){
            unpackTARXZ(fileSource, fileDestination, nStrip);
        }
        else {
            boolean bResult = unzip(fileSource, fileDestination, nStrip);
        }

        if(nRemoveZip > 0){
            Log.i("OpenCPN", "UnzipService: onHandleIntent RemoveZIP" +  fileSource);
 //           Uri ltreeUri = Uri.parse("");

 //           SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
 //           String sUri = preferences.getString("SDURI", "");
 //           if(!sUri.isEmpty())
 //               ltreeUri = Uri.parse(sUri);

            //  Is zip file on an SDCard?

            File zipFile = new File(fileSource);
            if(zipFile.exists()) {
                if (android.os.Build.VERSION.SDK_INT > android.os.Build.VERSION_CODES.KITKAT) {
                    String sdRoot = getExtSdCardFolder(zipFile);

                    if (null != sdRoot) {
                        DocumentFile zipDocument = getDocumentFile(zipFile, false, false);
                        Log.i("OpenCPN", "UnzipService: onHandleIntent RemoveZIPAPlus " + zipDocument.getName());
                        zipDocument.delete();
                    } else {
                        zipFile.delete();
                    }

                } else {
                    zipFile.delete();
                }
            }

        }

        Bundle topdirData = new Bundle();
        topdirData.putString("topDir", topDir);
        m_receiver.send(TOPDIR, topdirData);

        Bundle resultData = new Bundle();
        m_receiver.send(UNZIP_DONE, resultData);
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


        public boolean unzip(String inputFile, String _targetLocation, int nStrip) {


                byte[] buffer = new byte[8192];
                Uri ltreeUri = Uri.parse("");


                FileInputStream inputStream = null;

                try{
                    inputStream = new FileInputStream(inputFile);

                }
                catch (Exception e) {
                    e.printStackTrace();
                    Log.i("OpenCPN", "UnzipService:unzip  Input Stream Exception");
                    return false;
                }


                String baseFolder = "";

                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
                String sUri = preferences.getString("SDURI", "");
                if(!sUri.isEmpty())
                    ltreeUri = Uri.parse(sUri);

                DocumentFile installDocument = null;

                //  Is the target directory on an SDCard?
                boolean bisSD = false;
                File targetFile = new File(_targetLocation);
                if (android.os.Build.VERSION.SDK_INT > android.os.Build.VERSION_CODES.KITKAT) {
                    String sdRoot = getExtSdCardFolder(targetFile);

                    if (null != sdRoot) {
                       if(!ltreeUri.toString().isEmpty())
                            installDocument = DocumentFile.fromTreeUri(this, ltreeUri);

                       Log.i("OpenCPN", "UnzipService:unzip  bisSD true");

                       if(null == installDocument)
                           Log.i("OpenCPN", "UnzipService:unzip  installDocument null");


                       bisSD = true;
                    }
                    else{
                        Log.i("OpenCPN", "UnzipService:unzip  sdRoot null");
                    }

                }


                try {
                    ZipInputStream zin = new ZipInputStream(inputStream);
                    ZipEntry ze = null;

                    while ((ze = zin.getNextEntry()) != null) {

                        //Log.i("OpenCPN", "ZIP Entry: " + ze.getName());

                        //create dir if required while unzipping
                        if (ze.isDirectory()) {
                            if(topDir.length() == 0)            // Save the top level directory
                                topDir = ze.getName();

                            File dir = new File( _targetLocation,  ze.getName());

                            // Test for Zip Path Traversal Vulnerability
                            // https://support.google.com/faqs/answer/9294009

                            String canonicalPath = dir.getCanonicalPath();
                            if (!canonicalPath.startsWith(_targetLocation)) {
                                throw new SecurityException("Zip Path Traversal Vulnerability detected");
                            }

                            Log.i("OpenCPN", "ZIP Entry Dir: " + _targetLocation + File.separator + ze.getName());

                            if(bisSD) {
                                installDocument = getDocumentFile(dir, true, true);
                                if(null == installDocument)
                                    Log.i("OpenCPN", "UnzipService:unzip  installDocument(2) null");
                            }
                            else {
                                if (!dir.exists()) {
                                    dir.mkdirs();
                                }
                            }
                        } else {
                            int size;
                            File testFile = new File( _targetLocation,  ze.getName());

                            String canonicalPath = testFile.getCanonicalPath();
                            if (!canonicalPath.startsWith(_targetLocation)) {
                                throw new SecurityException("Zip Path Traversal Vulnerability detected");
                            }

                            String fileName = ze.getName();

                            Log.i("OpenCPN", "ZIP Entry File: " + _targetLocation + File.separator + fileName);


                            FileOutputStream outStream = null;

                            if(nStrip > 0){
                                String[] parts = ze.getName().split("\\/");
                                if(parts.length > 1){
                                fileName = "";
                                    for (int i = 1; i < parts.length; i++) {
                                        fileName += parts[i];
                                        if(i < (parts.length - 1)){
                                            fileName += File.separator;
                                        }
                                    }
                                }

                               Log.i("OpenCPN", "stripFile: " + _targetLocation + File.separator + fileName);
                            }

                            if(bisSD) {

                                //  Very recursively slow...
                                File zef = new File(_targetLocation + File.separator + fileName);
                                DocumentFile dfile = getDocumentFile(zef, false, true);

                                if(null == dfile)
                                    Log.i("OpenCPN", "UnzipService:unzip  dfile null");

                                //  Faster
                                //File zefs = new File(ze.getName());
                                //DocumentFile dfile = installDocument.createFile("image",zefs.getName());

                                OutputStream os = getContentResolver().openOutputStream(dfile.getUri());
                                outStream = (FileOutputStream) os;


                            }
                            else{
                                File zef = new File(_targetLocation + File.separator + fileName);
                                File zefDir = zef.getParentFile();

                                try{
                                    if (!zefDir.exists()) {
                                        zefDir.mkdirs();
                                    }
                                }catch(Exception e){
                                    Log.i("OpenCPN", "UnzipService:unzip  Zip ExceptionC");
                                }



                                try{
                                    outStream = new FileOutputStream(_targetLocation + File.separator + fileName);
                                }catch(Exception e){
                                    Log.i("OpenCPN", "UnzipService:unzip  Zip ExceptionA: " + _targetLocation + File.separator + fileName);
                                }
                            }


                            try{
                                BufferedOutputStream bufferOut = new BufferedOutputStream(outStream, buffer.length);

                                while ((size = zin.read(buffer, 0, buffer.length)) != -1) {
                                    bufferOut.write(buffer, 0, size);
                                }


                                bufferOut.flush();
                                bufferOut.close();
                            }catch(Exception e){
                                Log.i("OpenCPN", "UnzipService:unzip  Zip ExceptionB");
                            }

                            if(m_receiver != null) {
                                Bundle resultData = new Bundle();
                                resultData.putString("lastFile", fileName);
                                m_receiver.send(UNZIP_FILE, resultData);
                            }

                            zin.closeEntry();

                        }
                    }
                    zin.close();
                } catch (Exception e) {
                    Log.i("OpenCPN", "UnzipService:unzip  Zip Exception");
                    return false;
                }

                // All done, no error
                return true;
            }



    public boolean unpackTARXZ(String inputFile, String _targetLocation, int nStrip) {

        int BUFFER_SIZE = 8192;
        byte[] buffer = new byte[BUFFER_SIZE];

        Uri ltreeUri = Uri.parse("");
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String sUri = preferences.getString("SDURI", "");
        if(!sUri.isEmpty())
            ltreeUri = Uri.parse(sUri);

        //  Is the target directory on an SDCard?
        DocumentFile installDocument = null;

        boolean bisSD = false;
        File targetFile = new File(_targetLocation);
        if (android.os.Build.VERSION.SDK_INT > android.os.Build.VERSION_CODES.KITKAT) {
            String sdRoot = getExtSdCardFolder(targetFile);

            if (null != sdRoot) {
                if(!ltreeUri.toString().isEmpty())
                    installDocument = DocumentFile.fromTreeUri(this, ltreeUri);

                Log.i("OpenCPN", "UnzipService:unzip  bisSD true");

                if(null == installDocument)
                    Log.i("OpenCPN", "UnzipService:unzip  installDocument null");


                bisSD = true;
            }
            else{
                Log.i("OpenCPN", "UnzipService:unzip  sdRoot null");
            }

        }


        try {
            InputStream  inputStream = new FileInputStream(inputFile);

            InputStream bi = new BufferedInputStream(inputStream);
            XZCompressorInputStream xzIn = new XZCompressorInputStream(bi);
            TarArchiveInputStream tarIn = new TarArchiveInputStream(xzIn);
            TarArchiveEntry entry;

            while ((entry = (TarArchiveEntry) tarIn.getNextEntry()) != null) {
                String name = entry.getName();
                /** If the entry is a directory, create the directory. **/
                if (entry.isDirectory()) {
                    File f = new File(entry.getName());
                    boolean created = f.mkdir();
                    if (!created) {
                        System.out.printf("Unable to create directory '%s', during extraction of archive contents.\n",
                                f.getAbsolutePath());
                    }
                } else {
                    FileOutputStream outStream = null;

                    if(bisSD) {

                        //  Very recursively slow...
                        File zef = new File(_targetLocation + File.separator + name);
                        DocumentFile dfile = getDocumentFile(zef, false, true);

                        if(null == dfile)
                            Log.i("OpenCPN", "UnzipService:unzip  dfile null");

                        //  Faster
                        //File zefs = new File(ze.getName());
                        //DocumentFile dfile = installDocument.createFile("image",zefs.getName());

                        OutputStream os = getContentResolver().openOutputStream(dfile.getUri());
                        outStream = (FileOutputStream) os;


                    }
                    else{
                        File zef = new File(_targetLocation + File.separator + name);
                        File zefDir = zef.getParentFile();

                        try{
                            if (!zefDir.exists()) {
                                zefDir.mkdirs();
                            }
                        }catch(Exception e){
                            Log.i("OpenCPN", "UnzipService:unzip  Zip ExceptionC");
                        }



                        try{
                            outStream = new FileOutputStream(_targetLocation + File.separator + name);
                        }catch(Exception e){
                            Log.i("OpenCPN", "UnzipService:unzip  Zip ExceptionA: " + _targetLocation + File.separator + name);
                        }
                    }


                    try{
                        int count;
                        BufferedOutputStream bufferOut = new BufferedOutputStream(outStream, BUFFER_SIZE);

                        while ((count = tarIn.read(buffer, 0, BUFFER_SIZE)) != -1) {
                            bufferOut.write(buffer, 0, count);
                        }


                        bufferOut.flush();
                        bufferOut.close();
                    }catch(Exception e){
                        Log.i("OpenCPN", "UnzipService:unzip  Zip ExceptionB");
                    }

                }
            }

            System.out.println("Untar completed successfully!");
        }catch (Exception e) {
            System.out.println("Untar EXCEPTION");
        }

        return true;
    }
}































