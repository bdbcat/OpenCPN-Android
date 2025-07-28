/*
    Copyright (c) 2012-2013, BogDan Vatra <bogdan@kde.org>
    Contact: http://www.qt-project.org/legal

    Redistribution and use in source and binary forms, with or without
    modification, are permitted provided that the following conditions
    are met:

    1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
    2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.

    THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
    IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
    OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
    IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
    INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
    NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
    DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
    THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
    (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
    THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.opencpn;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.Environment;

import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import dalvik.system.DexClassLoader;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceScreen;
import android.preference.PreferenceGroup;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceActivity;
import android.preference.ListPreference;
import android.preference.PreferenceManager;
import android.preference.PreferenceCategory;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import org.json.JSONException;
import org.json.JSONObject;
import android.text.format.Time;
import ar.com.daidalos.afiledialog.*;
import android.os.Message;
import android.os.Handler;

import static java.util.TimeZone.getTimeZone;

import org.opencpn.opencpn.R;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

//@ANDROID-11
import android.app.Fragment;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import javax.net.ssl.HttpsURLConnection;
//@ANDROID-11


public class OCPNGRIBDownloadPrefActivity extends PreferenceActivity {

    public final static int MESSAGE_DOWNLOADGRIB_OK = 21;
    public final static int RESULT_DOWNLOAD_OK = RESULT_FIRST_USER + 1;

    // Request codes for activities atarted from this activity
    public final static int GRIB_REQUEST_BASE = 2257;
    private final static int OCPN_DOWNLOAD_SINGLE_GRIB_REQUEST_CODE = GRIB_REQUEST_BASE + 1;
    private final static int OCPN_DOWNLOAD_SINGLE_FILE_REQUEST_CODE = GRIB_REQUEST_BASE + 2;
    private final static int OCPN_DOWNLOAD_COMBINE_GRIB_REQUEST_CODE = GRIB_REQUEST_BASE + 3;

    //public static final int DIALOG_DOWNLOAD_PROGRESS = 0;
    private static final int RESULT_OK = 0;
    private static final int ERROR_NO_INTERNET = 1;
    //public static final int ERROR_NO_CONNECTION = 2;
    private static final int ERROR_EXCEPTION = 3;
    private static final int META_FILE_NOT_FOUND = 4;
    private static final int META_FILE_NOT_READABLE = 5;
    private static final int META_FILE_PARSE_ERROR = 6;
    private static final int RESULT_SERVER_MESSAGE = 6;

    //public static final int WARNING_PARTIAL = 4;
    //public static final int ERROR_NO_RESOLVE = 5;

    //public OnDownloadButtonSelectedListener mListener;
    public SharedPreferences.OnSharedPreferenceChangeListener m_listener;

    public ListPreference mGRIB_modelPreference;
    public ListPreference mGRIB_TimestepPreference;
    public ListPreference mGRIB_DaysPreference;

    public CheckBoxPreference mGRIB_WavesPreference;

    public PreferenceCategory prefCatSea;
    public PreferenceCategory prefCatWaves;
    public PreferenceCategory prefCatGeneral;

    public PreferenceCategory prefCatTimeStep;

    public JSONObject  m_grib_PrefsJSON;

    public taskHandler m_taskHandler;

    private boolean m_downloadOK;

    private String m_xyMetaFile;
    private String m_xygrib_url;
    private String  m_xymodel;
    private int m_xyhours;
    private long m_grib_length;

    private Context m_context;

    private ProgressDialog mProgressDialog;
    boolean m_ProgressDo = false;

    private class XmlPullParserHandler {
        String text;
        StringBuilder builder = new StringBuilder();

        public String parse(InputStream is) {

            try {

                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                factory.setNamespaceAware(true);
                XmlPullParser parser = factory.newPullParser();

                parser.setInput(is, null);

                int eventType = parser.getEventType();

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    String tagname = parser.getName();
                    switch (eventType) {

                        case XmlPullParser.TEXT:
                            text = parser.getText();
                            break;

                        case XmlPullParser.END_TAG:
                            if (tagname.equalsIgnoreCase("status")) {
                                builder.append("TAG1 = " + text);
                            } else if (tagname.equalsIgnoreCase("message")) {
                                builder.append("\nTAG2 = " + text);
                            }
                            break;

                        default:
                            break;
                    }
                    eventType = parser.next();
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }

            return builder.toString();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        m_context = this;
     //   Log.i("DEBUGGER_TAG", "SettingsFragment display!");

        //OCPNSettingsActivity act1 = (OCPNSettingsActivity)getActivity();

        setContentView(R.layout.grib_download_activity_layout);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.grib_download_settings);


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        String settings = "";

        if (preferences != null) {
            settings = preferences.getString("GRIB_PREFS_JSON", "{}");

            try {
                m_grib_PrefsJSON  = new JSONObject( settings );
            } catch (JSONException e) {
                System.out.println(e);

                try{
                    m_grib_PrefsJSON  = new JSONObject("{}");
                } catch(JSONException e1) {
                    System.out.println(e1);
                }
            }
        }


        m_downloadOK = false;

        //  Set up inital values of "Summaries" fields

        // Be careful here, the values in preferences may be invalid....
        mGRIB_modelPreference = (ListPreference)getPreferenceScreen().findPreference("GRIB_prefs_model");
        if(null != mGRIB_modelPreference){
            if(null != mGRIB_modelPreference.getEntry()){
                mGRIB_modelPreference.setSummary(mGRIB_modelPreference.getEntry().toString());
            }
        }

        mGRIB_TimestepPreference = (ListPreference)getPreferenceScreen().findPreference("GRIB_prefs_timestep");
        if(null != mGRIB_TimestepPreference){
            String ts = getResources().getString(R.string.ocpn_grib_download_summary_timestep);
            String pts = mGRIB_TimestepPreference.getEntry().toString();
            mGRIB_TimestepPreference.setSummary(ts + " ... " + pts);
        }

        mGRIB_DaysPreference = (ListPreference)getPreferenceScreen().findPreference("GRIB_prefs_days");
        if(null != mGRIB_DaysPreference){
            String ts = getResources().getString(R.string.ocpn_grib_download_summary_days);
            String pts = mGRIB_DaysPreference.getEntry().toString();
            mGRIB_DaysPreference.setSummary(ts + " ... " + pts);
        }


        PreferenceScreen screen = getPreferenceScreen();
        prefCatSea= (PreferenceCategory)findPreference("GRIB_prefcat_sea");
        prefCatWaves= (PreferenceCategory)screen.findPreference("GRIB_prefcat_waves");
        prefCatGeneral= (PreferenceCategory)screen.findPreference("GRIB_prefcat_general");
        prefCatTimeStep= (PreferenceCategory)screen.findPreference("GRIB_prefcat_timestep");



        if(null != mGRIB_modelPreference){
            PreparePreferenceScreen();
        }


        //  Set up a handler to catch messages from async tasks
            m_taskHandler = new taskHandler();

          // Set up a listener for key changes

         m_listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
           public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {

             // listener implementation

             // Set new summary, when a preference value changes
             if (key.equals("GRIB_prefs_timestep")) {
                 if(null != mGRIB_TimestepPreference){
                     String ts = "Set the time interval between forecasts";
                     String pts = mGRIB_TimestepPreference.getEntry().toString();
                     mGRIB_TimestepPreference.setSummary(ts + " ... " + pts);
                 }
              }

             if (key.equals("GRIB_prefs_days")) {
                 if(null != mGRIB_DaysPreference){
                     String ts = "Set the number of days in forecast";
                     String pts = mGRIB_DaysPreference.getEntry().toString();
                     mGRIB_DaysPreference.setSummary(ts + " ... " + pts);
                 }
             }

             if (key.equals("GRIB_prefs_model")) {
                 if(null != mGRIB_modelPreference){
                     mGRIB_modelPreference.setSummary(mGRIB_modelPreference.getEntry().toString());
                     PreparePreferenceScreen();
                 }
             }
         }
         };

         getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(m_listener);



         Button button_download = (Button)findViewById(R.id.DownloadPrefButton);
         button_download.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Log.i("OpenCPN", "DownloadPrefActivity button_download");

               onDownloadButtonClick();
           }
         });


    }


    private
    void PreparePreferenceScreen(){
        PreferenceScreen screen = getPreferenceScreen();
        String model = mGRIB_modelPreference.getEntry().toString();
        if(model.contains("GFS")){
            screen.addPreference(prefCatTimeStep);
            screen.addPreference(prefCatGeneral);
            screen.addPreference(prefCatSea);
            screen.addPreference(prefCatWaves);
        }
        else if(model.contains("ECMWF")){
            screen.removePreference(prefCatSea);
            screen.removePreference(prefCatWaves);
            screen.removePreference(prefCatGeneral);
            screen.removePreference(prefCatTimeStep);
        }
        else if(model.contains("Arpege")){
            screen.addPreference(prefCatSea);
            screen.removePreference(prefCatWaves);
            screen.addPreference(prefCatGeneral);
            screen.addPreference(prefCatTimeStep);
        }
        else if(model.contains("Arome")){
            screen.addPreference(prefCatSea);
            screen.removePreference(prefCatWaves);
            screen.addPreference(prefCatGeneral);
            screen.addPreference(prefCatTimeStep);
        }
    }

    public class taskHandler extends Handler {
    @Override
            public void handleMessage(Message msg) {

                switch (msg.what) {
                    case OCPNGRIBDownloadPrefActivity.MESSAGE_DOWNLOADGRIB_OK:
                    Log.i("OpenCPN", "DownloadPrefActivity Download OK message");

                    m_downloadOK = true;
                    finish();       // On OK download, pop back immediately.
                    break;


                    default:
                        break;
                }
            }
    }


    private PreferenceGroup getParent(Preference preference)
    {
        return getParent(getPreferenceScreen(), preference);
    }

    private PreferenceGroup getParent(PreferenceGroup root, Preference preference)
    {
        for (int i = 0; i < root.getPreferenceCount(); i++)
        {
            Preference p = root.getPreference(i);
            if (p == preference)
                return root;
            if (PreferenceGroup.class.isInstance(p))
            {
                PreferenceGroup parent = getParent((PreferenceGroup)p, preference);
                if (parent != null)
                    return parent;
            }
        }
        return null;
    }



    @Override
    public void finish() {
        Log.i("OpenCPN", "GRIB Download Activity finish");

        String json = "{}";
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        try {
            m_grib_PrefsJSON.put("model", preferences.getString("GRIB_prefs_model", "?"));
            m_grib_PrefsJSON.put("days", preferences.getString("GRIB_prefs_days", "?"));
            m_grib_PrefsJSON.put("time_step", preferences.getString("GRIB_prefs_timestep", "?"));
            m_grib_PrefsJSON.put("grib_file", preferences.getString("GRIB_dest_file", "?"));

            json = m_grib_PrefsJSON.toString(2);

        } catch (JSONException e) {
            System.out.println(e);
            json = "{}";
        }


        Editor editor = preferences.edit();
        editor.putString("GRIB_PREFS_JSON", json);
        editor.apply();

        Bundle b = new Bundle();
        b.putString("GRIB_JSON", json);
        Intent i = new Intent();
        i.putExtras(b);
        if(m_downloadOK)
            setResult(OCPNGRIBDownloadPrefActivity.RESULT_DOWNLOAD_OK, i);
        else
            setResult(RESULT_OK, i);


        super.finish();
    }








    private String downloadECMWFDirect(){


        //  Get some parameters from the Preferences.
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        String model = preferences.getString("GRIB_prefs_model", "GFS100");
        int days = Integer.parseInt(preferences.getString("GRIB_prefs_days", "2"));
        if (days > 6) days = 6;

        Time tn = new Time(Time.getCurrentTimezone());
        tn.setToNow();
        String formattedTime = tn.format("%Y%m%d_%H%M%S");

        int lat_min = 0;
        int lat_max = 1;
        int lon_min = 0;
        int lon_max = 1;
        String serverBase = "";

        //  Get some parameters from the JSON
        if(null != m_grib_PrefsJSON) {

            try {
                if (m_grib_PrefsJSON.has("latMin")) {
                    lat_min = m_grib_PrefsJSON.getInt("latMin");
                }
                if (m_grib_PrefsJSON.has("latMax")) {
                    lat_max = m_grib_PrefsJSON.getInt("latMax");
                }
                if (m_grib_PrefsJSON.has("lonMin")) {
                    lon_min = m_grib_PrefsJSON.getInt("lonMin");
                }
                if (m_grib_PrefsJSON.has("lonMax")) {
                    lon_max = m_grib_PrefsJSON.getInt("lonMax");
                }

            } catch (JSONException e) {
                lat_min = 0;
                lat_max = 1;
                lon_min = 0;
                lon_max = 1;
                System.out.println(e);
            }
        }

        Time tm = new Time(Time.getCurrentTimezone());
        tm.setToNow();
        tm.switchTimezone("UTC");
        String startDate = tm.format("%Y%m%d");
        int tHours = tm.hour;

        // Adjust the time span request to conform to server requirements
        // 24, 72, or 999 (max)
        int treqHours = 24;
        if (days > 3)
            treqHours = 999;
        else if (days > 1)
            treqHours = 72;

        // decode the model name
        String model_decode;
        model_decode = "ecmwf0p25";

        // craft the url
        String gurl = "https://grib.bosun.io/grib?model=";
        gurl += model_decode;
        gurl += "&latmin=";
        gurl += Integer.toString(lat_min);
        gurl += "&latmax=";
        gurl += Integer.toString(lat_max);
        gurl += "&lonmin=";
        gurl += Integer.toString(lon_min);
        gurl += "&lonmax=";
        gurl += Integer.toString(lon_max);
        gurl += "&length=";
        gurl += Integer.toString(treqHours);

        // Make the destination file name
        String tdest_file = ("gribs/ocpn_") + model_decode;
        tdest_file += "_" + Integer.toString(days * 24);
        tdest_file += "_" + formattedTime + ".grb2";


        // File will end up in public downloads directory.
        File trootDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File tdFile = new File(trootDir.getAbsolutePath() , tdest_file);
        String dest_file = tdFile.getAbsolutePath();

        Log.i("OpenCPN", "dest_file: " + dest_file);

        // persist the target file name
        Editor editor = preferences.edit();
        editor.putString("GRIB_dest_file", dest_file);
        editor.apply();


        //  Calculate estimate block size
        double nBlock = (lat_max - lat_min) * (lon_max - lon_min);
        double factor = 1.0;
        if(model.equals("GFS25"))
            factor = 16;;
        if(model.equals("GFS50"))
            factor = 4;

        nBlock *= factor;
        int nParam = 0;
        nBlock *= nParam;
        int niBlock = (int)nBlock;

        String bmsg = String.format("%d\n", niBlock);
        Log.i("OpenCPN", "nBlock: " + bmsg);


        Intent intent = new Intent(this, downloadGRIBSingle.class);
        intent.putExtra("URL",gurl);
        intent.putExtra("GRIB_dest_file",dest_file);
        intent.putExtra("niBlock",niBlock);
        startActivityForResult(intent, OCPN_DOWNLOAD_SINGLE_GRIB_REQUEST_CODE );

        return "OK";
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("GRIB", "onActivityResult");
        // Check which request we're responding to
        if (requestCode == OCPN_DOWNLOAD_SINGLE_GRIB_REQUEST_CODE) {
            if (resultCode == RESULT_OK)
                m_downloadOK = true;
            finish();
        }
    }

            private String downloadXyGribDirect() {
        //  Get some parameters from the Preferences.
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        Time tn = new Time(Time.getCurrentTimezone());
        tn.setToNow();
        String formattedTime = tn.format("%Y%m%d_%H%M%S");

        // Craft a url to start the GRIB file preparation
        // the resulting XML file download contains tha actual GRIB download link
        // Server's base address
        String urlStr = "http://grbsrv.opengribs.org/getmygribs2.php?";

        int lat_min = 0;
        int lat_max = 1;
        int lon_min = 0;
        int lon_max = 1;

        //  Get some parameters from the JSON
        if(null != m_grib_PrefsJSON) {

            try {
                if (m_grib_PrefsJSON.has("latMin")) {
                    lat_min = m_grib_PrefsJSON.getInt("latMin");
                }
                if (m_grib_PrefsJSON.has("latMax")) {
                    lat_max = m_grib_PrefsJSON.getInt("latMax");
                }
                if (m_grib_PrefsJSON.has("lonMin")) {
                    lon_min = m_grib_PrefsJSON.getInt("lonMin");
                }
                if (m_grib_PrefsJSON.has("lonMax")) {
                    lon_max = m_grib_PrefsJSON.getInt("lonMax");
                }

            } catch (JSONException e) {
                lat_min = 0;
                lat_max = 1;
                lon_min = 0;
                lon_max = 1;
                System.out.println(e);
            }
        }

        // Bounding box
        urlStr += "la1=";
        urlStr += Integer.toString(lat_min);
        urlStr += "&la2=";
        urlStr += Integer.toString(lat_max);
        urlStr += "&lo1=";
        urlStr += Integer.toString(lon_min);
        urlStr += "&lo2=";
        urlStr += Integer.toString(lon_max);

        // Atmospheric Model & resolution reference
        String model = preferences.getString("GRIB_prefs_model", "GFS100");
        urlStr += "&model=";

        String model_decode = "arpege_eu_p10_";     // Arpege_HD
        if (model.contentEquals("ARPEGE"))
            model_decode = "arpege_p50_";
        else if (model.contentEquals("GFS100"))
            model_decode = "gfs_1p0_";
        else if (model.contentEquals("GFS50"))
            model_decode = "gfs_p50_";
        else if (model.contentEquals("GFS25"))
            model_decode = "gfs_p25_";
        else if (model.contentEquals("AROME"))
            model_decode = "arome_p025_";


        m_xymodel = model_decode;
        urlStr += model_decode;

        // Interval
        int time_step = Integer.parseInt(preferences.getString("GRIB_prefs_timestep", "3"));
        int time_step_adj = time_step;

        if (model.contentEquals("ARPEGE")){
            if (time_step == 1) time_step_adj = 3;
            if (time_step == 24) time_step_adj = 12;
        }
        else if (model.contentEquals("ARPEGE-HD")){
            if (time_step == 1) time_step_adj = 3;
            if (time_step == 24) time_step_adj = 12;
        }
        else if (model.contentEquals("GFS100")){
            if (time_step == 1) time_step_adj = 3;
            if (time_step == 24) time_step_adj = 12;
        }
        else if (model.contentEquals("GFS50")){
            if (time_step == 1) time_step_adj = 3;
            if (time_step == 24) time_step_adj = 12;
        }
        else if (model.contentEquals("GFS25")){
            if (time_step == 1) time_step_adj = 3;
            if (time_step == 24) time_step_adj = 12;
        }
        else if (model.contentEquals("AROME")){
            if (time_step == 1) time_step_adj = 3;
            if (time_step == 24) time_step_adj = 12;
        }

        urlStr += "&intv=";
        urlStr += Integer.toString(time_step_adj);

        // Length in days
        int days = Integer.parseInt(preferences.getString("GRIB_prefs_days", "2"));
        int days_adj = days;
        if (model.contentEquals("ARPEGE")){
            if (days > 4)
                days_adj = 4;
        }
        else if (model.contentEquals("ARPEGE-HD")){
            if (days > 4)
                days_adj = 4;
        }
        else if (model.contentEquals("GFS100")){
            if (days > 10)
                days_adj = 10;
        }
        else if (model.contentEquals("GFS50")){
            if (days > 10)
                days_adj = 10;
        }
        else if (model.contentEquals("GFS25")){
            if (days > 10)
                days_adj = 10;
        }
        else if (model.contentEquals("AROME")){
            if (days > 2)
                days_adj = 2;
        }

        m_xyhours = days_adj * 24;

        urlStr += "&days=";
        urlStr += Integer.toString(days_adj);

        // Selected run
        urlStr += "&cyc=last";

        // Atmospheric data fields
        urlStr += "&par=";
        boolean bWind = preferences.getBoolean("GRIB_prefb_wind", true);
        if (bWind)
            urlStr += "W;";

        boolean bPressure = preferences.getBoolean("GRIB_prefb_pressure", true);
        if (bPressure)
            urlStr += "P;";

        boolean bGust = preferences.getBoolean("GRIB_prefb_windgust", false);
        if (bGust)
            urlStr += "G;";

        boolean bRain = preferences.getBoolean("GRIB_prefb_rainfall", false);
        if (bRain)
            urlStr += "R;";

        boolean bCloud = preferences.getBoolean("GRIB_prefb_cloudcover", false);
        if (bCloud)
            urlStr += "C;";

        boolean bAirTemp = preferences.getBoolean("GRIB_prefb_airtemp", false);
        if (bAirTemp)
            urlStr += "T;";

        boolean bCape = preferences.getBoolean("GRIB_prefb_CAPE", false);
        if (bCape)
            urlStr += "c;";

        boolean benableWave = true;
        if (model.equals("ARPEGE"))
            benableWave = false;
        if (model.equals("ARPEGE-HD"))
            benableWave = false;
        if (model.equals("AROME"))
            benableWave = false;

        boolean bWave = preferences.getBoolean("GRIB_prefb_waves", false);
        if (benableWave && bWave ) {
            String mdl_str = "&wmdl=ww3_p50_";
            String params = "s;";
            params += "h;d;p;";

            urlStr += mdl_str;
            urlStr += "&wpar=";
            urlStr += params;
        }
        else
            urlStr += "&wmdl=none";


        // Make the destination file name
        String tdest_file = ("gribs/ocpn_xygrib_");
        tdest_file += formattedTime + ".xml";

        // File will end up in public downloads directory.
        File trootDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File tdFile = new File(trootDir.getAbsolutePath() , tdest_file);
        String dest_file = tdFile.getAbsolutePath();
        m_xyMetaFile = dest_file;

        Log.i("OpenCPN", "xyGRIB metatdata: " + dest_file);

        m_ProgressDo = false;
        DownloadSingleFile(urlStr, dest_file, "NO", "STAGE_META");

        //Intent intent = new Intent(this, DownloadFileSingleActivity.class);
        //intent.putExtra("URL",urlStr);
        //intent.putExtra("dest_file",dest_file);
        //intent.putExtra("progress_hide",(boolean)true);
        //startActivityForResult(intent, OCPN_DOWNLOAD_SINGLE_FILE_REQUEST_CODE );

        return "OK";
    }

    public void onDownloadButtonClick(){

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String model = preferences.getString("GRIB_prefs_model", "GFS100");

        if(model.startsWith("GFS", 0)){
            downloadXyGribDirect();
        }
        else if(model.contains("ECMWF")) {
            downloadECMWFDirect();
        }
        else if(model.contains("ARPEGE")){
            downloadXyGribDirect();
        }
        else if(model.contains("AROME")){
            downloadXyGribDirect();
        }
    }



    private void ShowTextDialog(final String message){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage(message);
        builder1.setCancelable(true);
        builder1.setNeutralButton("OK",
        new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                // This action will dismiss the entire activity
                //Log.i("OpenCPN", "ShowTextDialog Button OK");
                //Message message = Message.obtain (m_taskHandler, OCPNGRIBDownloadPrefActivity.MESSAGE_DOWNLOADGRIB_OK);
                //message.sendToTarget();

                dialog.cancel();
            }
        });
   /*
   builder1.setNegativeButton("No",
   new DialogInterface.OnClickListener() {
   public void onClick(DialogInterface dialog, int id) {
   dialog.cancel();
   }
   });
   */
        if (!isFinishing()) {
            AlertDialog alert11 = builder1.create();
            alert11.show();
        }
   }

    void DownloadGRIBFile(String url, long length) {
        // Ready to download the target GRIB file
        // Make the destination file name
        Time tn = new Time(Time.getCurrentTimezone());
        tn.setToNow();
        String formattedTime = tn.format("%Y%m%d_%H%M%S");

        String tdest_file = ("gribs/ocpn_") + m_xymodel;
        tdest_file += "_" + Integer.toString(m_xyhours);
        tdest_file += "_" + formattedTime + ".grb2";

        // File will end up in public downloads directory.
        File trootDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File tdFile = new File(trootDir.getAbsolutePath() , tdest_file);
        String dest_file = tdFile.getAbsolutePath();

        //Log.i("OpenCPN", "dest_file: " + dest_file);

        // persist the target file name
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        Editor editor = preferences.edit();
        editor.putString("GRIB_dest_file", dest_file);
        editor.apply();

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage(getResources().getString(R.string.DOWNLOADING_FILE));
        mProgressDialog.setIndeterminate(false);
        mProgressDialog.setMax(100);
        mProgressDialog.setProgress(0);
        //mProgressDialog.setIndeterminate(true);
        mProgressDialog.setCancelable(true);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        if (!isFinishing()) {
            mProgressDialog.show();
            m_ProgressDo = true;
        }

        DownloadSingleFile(url, dest_file, "YES", "STAGE_GRB2");

    }


    private int ParseXYMetadata(String matafile){

        File metaFile = new File(matafile);

        if (metaFile.exists()) {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream((metaFile));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return META_FILE_NOT_FOUND;
            }

            String metaString = "";
            try {
                byte[] bytes = new byte[8192];
                // reads 8192 bytes at a time, if end of the file, returns -1
                fis.read(bytes);

                metaString = new String(bytes, StandardCharsets.UTF_8);

                fis.close();

            } catch (IOException e) {
                e.printStackTrace();
                return META_FILE_NOT_READABLE;
            }

            metaFile.delete();

            String status = "";
            String message = "";
            String grib_url = "";
            long grib_length;

            JSONObject metaJSON = null;
            try {
                metaJSON = new JSONObject(metaString);
                if (metaJSON.has("status")) {
                    status = metaJSON.getString("status");
                }
                if (metaJSON.has("message")) {
                    message = metaJSON.getString("message");
                }
                if (metaJSON.has("url")) {
                    grib_url = metaJSON.getString("url");
                }


                if (status.equals("false")) {
                    if (message.isEmpty())
                        ShowTextDialog(getResources().getString(R.string.ocpn_GRIB_download_dialog_DOWN_FAIL));
                    else {
                        ShowTextDialog(message);
                        return RESULT_SERVER_MESSAGE;
                    }
                } else {
                    m_xygrib_url = metaJSON.getJSONObject("message").getString("url");
                    String l = metaJSON.getJSONObject("message").getString("size");
                    m_grib_length = Long.parseLong(l);
                    return RESULT_OK;
                }
            } catch (JSONException e) {
                return META_FILE_PARSE_ERROR;
            }
        }
        else
            return META_FILE_NOT_FOUND;

        return META_FILE_NOT_FOUND;
    }

    @SuppressLint("HandlerLeak")
    Handler handler = new android.os.Handler() {
        @Override
        public void handleMessage(Message msg) {
            String stage = msg.getData().getString("stage");

            if (stage.equals("STAGE_META")) {
                String filePath = msg.getData().getString("file");
                int status = msg.getData().getInt("result");
                if (status != RESULT_OK) {
                    String msg_meta_file_error = "GRIB metadata download failed.\n Status code: " + Integer.toString(status);
                    ShowTextDialog(msg_meta_file_error);
                } else {
                    // Read and parse the metadata
                    int metaParseResult = ParseXYMetadata(filePath);
                    if (metaParseResult != RESULT_OK) {
                        if (metaParseResult != RESULT_SERVER_MESSAGE) {
                            String msg_meta_file_error = "GRIB metadata download failed.\n Status code: " + Integer.toString(metaParseResult);
                            ShowTextDialog(msg_meta_file_error);
                        }
                    } else {
                        DownloadGRIBFile(m_xygrib_url, m_grib_length);
                    }
                }
            } else if (stage.equals("STAGE_GRB2")) {
                int status = msg.getData().getInt("result");
                if (status != RESULT_OK) {
                    String msg_grib_file_error = "GRIB file download failed.\n Status code: " + Integer.toString(status);
                    ShowTextDialog(msg_grib_file_error);
                }
                else {
                    m_downloadOK = true;
                    //String msg_grib_file_ok = "GRIB file download OK";
                    //ShowTextDialog(msg_grib_file_ok);
                    finish();       // Pops out of activity, back to charts.
                }
            }
        }
    };

   private int DownloadSingleFile(String targetURL,
                                  String destination,
                                  String doProgress,
                                  String gribStage){
       if(!haveNetworkConnection()){
            return ERROR_NO_INTERNET;
       }
       else{
           //executing the asynctask
           new DownloadSingleFileAsync().execute(targetURL,
                   destination,
                   doProgress,
                   gribStage);
           return 0;
       }
   }

    //An async file downloader

    class DownloadSingleFileAsync extends AsyncTask<String, Integer, String> {
        private int  m_result;
        private String m_destination;
        private String m_stage;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }


        @Override
        protected String doInBackground(String... parms) {

            m_destination = parms[1];
            m_stage = parms[3];

            downloadSingleFile(parms[0], parms[1], parms[2], parms[3]);
            return "OK";
        }

        protected void downloadSingleFile(String url,
                                          String dest,
                                          String doProgess,
                                          String gribStage) {
            long lengthOfFile = 0;

            HttpsURLConnection c;
            InputStream in;

            try {
                URL u = new URL(url);

                if (u.getProtocol().equalsIgnoreCase("https")) {
                    Log.d("OpenCPN", "OpenCPN DSFA URL is https");


                    //connecting to url
                    c = (HttpsURLConnection) u.openConnection();
                    c.setRequestProperty("Accept-Encoding", "identity");
                    c.setRequestMethod("GET");
                    c.setDoOutput(true);
                    c.connect();

                    in = c.getInputStream();

                    //lgc = c.getContent().toString().length();
                    lengthOfFile = c.getContentLength();
                } else {
                    Log.d("OpenCPN", "DFSA URL is http");

                    //connecting to url
                    HttpURLConnection c1 = (HttpURLConnection) u.openConnection();
                    c1.setRequestProperty("Accept-Encoding", "identity");
                    c1.setRequestMethod("GET");
                    c1.setDoOutput(true);
                    c1.connect();

                    int http_status = c1.getResponseCode();
                    String statusMsg = String.format("DFSA Status: %d\n", http_status);
                    Log.i("OpenCPN", statusMsg);

                    if (http_status / 100 == 3) {
                        String loc = c1.getHeaderField("Location");
                        Log.i("OpenCPN", "Redirect: " + loc);

                        URL urlRedirect = new URL(loc);

                        c = (HttpsURLConnection) urlRedirect.openConnection();
                        c.setRequestProperty("Accept-Encoding", "identity");
                        c.setRequestMethod("GET");
                        c.setDoOutput(true);
                        c.connect();

                        int codeRedirect = c.getResponseCode();
                        Log.i("OpenCPN", "response code on redirect: " + Integer.toString(codeRedirect));

                        in = c.getInputStream();
                        lengthOfFile = c.getContentLength();

                    } else {
                        in = c1.getInputStream();
                        lengthOfFile = c1.getContentLength();
                    }

                }

            } catch (Exception e) {
                Log.d("OpenCPN DSFA ExcA1", e.getMessage());

                Log.i("OpenCPN", "DSFA ERROR_NO_CONNECTION");
                m_result = ERROR_EXCEPTION;
                return;
            }


            try {
                //mProgressDialog.setMax((int)lengthOfFile);

                //this is where the file will be seen after the download
                File nFile = new File(dest);
                File nDir = nFile.getParentFile();
                if (null != nDir)
                    nDir.mkdirs();
                nFile.createNewFile();

                FileOutputStream f = new FileOutputStream(nFile);

                //here’s the download code
                byte[] buffer = new byte[1024];
                int len1 = 0;
                long total = 0;

                while ((len1 = in.read(buffer)) > 0) {
                    total += len1;

                    if (m_ProgressDo) {
                        if (lengthOfFile > 0) {
                            mProgressDialog.setIndeterminate(false);
                            long prog = ((total * 100) / lengthOfFile);
                            publishProgress((int) prog);
                        }
                    }

                    f.write(buffer, 0, len1);
                }
                f.close();
                m_result = RESULT_OK;


            } catch (Exception e) {
                Log.d("OpenCPN DFSA ExceptionB", e.getMessage());
                m_result = ERROR_EXCEPTION;
            }
            return;
        }


        protected void onProgressUpdate(Integer... progress) {
            if (!isFinishing()) {
                mProgressDialog.setMessage(getResources().getString(R.string.DOWNLOADING_FILE));
                mProgressDialog.setProgress(progress[0]);
            }
        }

        @Override
        protected void onPostExecute(String unused) {
            Log.i("OpenCPN", "DSFA onPostExecute");

            if (!isFinishing()) {
                if (m_ProgressDo)
                    mProgressDialog.hide();
            }

            //  Send a message to caller handler
            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putString("file", m_destination);
            bundle.putInt("result", m_result);
            bundle.putString("stage", m_stage);
            message.setData(bundle);
            handler.sendMessage(message); // pass handler object from activity
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

