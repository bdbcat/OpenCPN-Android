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
package org.qtproject.qt5.android.bindings;

import com.arieslabs.assetbridge.Assetbridge;
import org.opencpn.opencpn.BuildConfig;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.lang.annotation.Native;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.nio.file.Files;
import java.text.DateFormat;
import java.util.Date;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipEntry;
import java.io.BufferedOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;
import java.util.concurrent.Semaphore;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Iterator;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.UriPermission;
import android.location.Location;
import android.media.MediaDrm;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Parcelable;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.provider.DocumentsContract;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import java.util.Locale ;
import java.util.HashMap;
import java.util.Map;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.SecretKey;
import javax.crypto.Cipher;
import javax.crypto.BadPaddingException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.net.ssl.HttpsURLConnection;

import java.security.InvalidKeyException;
import java.security.spec.InvalidKeySpecException;
import java.security.NoSuchAlgorithmException;
import android.net.Uri;

import java.io.UnsupportedEncodingException;
import android.os.CountDownTimer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStreamWriter;

//import com.google.android.gms.common.GoogleApiAvailability;

//import org.kde.necessitas.ministro.IMinistro;
//import org.kde.necessitas.ministro.IMinistroCallback;

//import android.app.DialogFragment;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.DialogFragment;

import androidx.fragment.app.FragmentManager;
import androidx.core.content.ContextCompat;

import android.os.SystemClock;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Environment;
import android.app.Activity;
import android.app.ProgressDialog;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.DialogInterface.OnCancelListener;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.content.BroadcastReceiver;
import android.database.Cursor;
import android.content.IntentFilter;
import android.app.PendingIntent;
import android.net.ConnectivityManager;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.*;

import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.DisplayMetrics;
import android.view.Surface;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.webkit.WebView;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.Display;
import android.view.MenuInflater;
import android.view.InputDevice;
import android.view.LayoutInflater ;

import dalvik.system.DexClassLoader;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.provider.Settings;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.Preference;
import android.preference.PreferenceFragment;

import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.compressors.CompressorStreamFactory;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.compress.compressors.xz.XZCompressorInputStream;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.AsyncTask;
import android.os.Message;
import android.os.Handler;
import androidx.core.content.FileProvider;

import android.widget.TextView;
import android.graphics.Color;
import android.text.style.ForegroundColorSpan;
import android.text.SpannableString;
import android.view.SubMenu;


import org.opencpn.MySSLSocketFactory;
import org.opencpn.opencpn.R;

//ANDROID-11
import android.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.ActionMode;
import android.view.ActionMode.Callback;
//ANDROID-11

import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.MulticastLock;
import java.util.concurrent.atomic.AtomicReference;

import android.bluetooth.BluetoothAdapter;

import org.opencpn.GPSServer;
import org.opencpn.OCPNNativeLib;

import org.qtproject.qt5.android.QtNative;
import org.qtproject.qt5.android.QtActivityDelegate;

import android.bluetooth.BluetoothDevice;
import org.opencpn.BTScanHelper;
import app.akexorcist.bluetotohspp.library.BluetoothSPP;
import app.akexorcist.bluetotohspp.library.BluetoothState;
import app.akexorcist.bluetotohspp.library.BluetoothSPP.OnDataReceivedListener;

import org.opencpn.SpinnerNavItem;
import org.opencpn.TitleNavigationAdapter;
import org.opencpn.WebViewActivity;

import ar.com.daidalos.afiledialog.*;

import org.opencpn.UsbSerialHelper;

import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.List;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import android.os.ResultReceiver;

import org.opencpn.DownloadService;
import org.opencpn.OCPNResultReceiver;
import org.opencpn.OCPNResultReceiver.Receiver;
import androidx.documentfile.provider.DocumentFile;
import org.opencpn.UnzipService;

import com.caverock.androidsvg.SVG;
import com.github.anrwatchdog.ANRError;
import com.github.anrwatchdog.ANRWatchDog;
//import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.location.sample.locationupdatesforegroundservice.LocationUpdatesService;

import android.graphics.Bitmap;

import androidx.documentfile.provider.DocumentFile;
import android.provider.OpenableColumns;
import android.provider.MediaStore;
import android.os.ParcelFileDescriptor;
import android.content.res.AssetManager;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TimeZone;
import android.text.format.Time;

import org.opencpn.ColorPickerDialog;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.Manifest;

import static android.app.ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND;
import static android.app.ActivityManager.RunningAppProcessInfo.IMPORTANCE_VISIBLE;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
import static android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION;
import static android.content.Intent.FLAG_GRANT_WRITE_URI_PERMISSION;
import static android.util.Base64.DEFAULT;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.opencpn.GPSServer.GPS_STOPSERVICE;
import static org.qtproject.qt5.android.QtNative.getContext;

import android.media.MediaDrm;


public class QtActivity extends FragmentActivity implements ActionBar.OnNavigationListener, Receiver {
    private final static int MINISTRO_INSTALL_REQUEST_CODE = 0xf3ee; // request code used to know when Ministro instalation is finished
    private final static int OCPN_SETTINGS_REQUEST_CODE = 0xf3ef; // request code used to know when OCPNsettings dialog activity is done
    private final static int OCPN_GOOGLEMAPS_REQUEST_CODE = 0xf3ed; // request code used to know when GoogleMaps activity is done
    private final static int OCPN_GRIB_REQUEST_CODE = 0xf3ec; // request code used to know when OCPNGRIB activity is done

    private static final int MINISTRO_API_LEVEL = 4; // Ministro api level (check IMinistro.aidl file)
    private static final int NECESSITAS_API_LEVEL = 2; // Necessitas api level used by platform plugin
    private static final int QT_VERSION = 0x050100; // This app requires at least Qt version 5.1.0

    private final static int OCPN_FILECHOOSER_REQUEST_CODE = 0x5555;
    private final static int OCPN_AFILECHOOSER_REQUEST_CODE = 0x5556;
    private final static int OCPN_ARBITRARY_REQUEST_CODE = 0x5557;
    private final static int OCPN_SAF_DIALOG_A_REQUEST_CODE = 0x5558;
    private final static int OCPN_SAF_DIALOG_DL_REQUEST_CODE = 0x5559;
    private final static int OCPN_SAF_DIALOG_MIGRATE_REQUEST_CODE = 0x5560;

    private final static int OCPN_ACTION_FOLLOW = 0x1000;
    private final static int OCPN_ACTION_ROUTE = 0x1001;
    private final static int OCPN_ACTION_RMD = 0x1002;
    private final static int OCPN_ACTION_SETTINGS_BASIC = 0x1003;
    private final static int OCPN_ACTION_SETTINGS_EXPERT = 0x1004;
    private final static int OCPN_ACTION_TRACK_TOGGLE = 0x1005;
    private final static int OCPN_ACTION_MOB = 0x1006;
    private final static int OCPN_ACTION_TIDES_TOGGLE = 0x1007;
    private final static int OCPN_ACTION_CURRENTS_TOGGLE = 0x1008;
    private final static int OCPN_ACTION_ENCTEXT_TOGGLE = 0x1009;
    private final static int OCPN_ACTION_TRACK_ON = 0x100a;
    private final static int OCPN_ACTION_TRACK_OFF = 0x100b;
    private final static int OCPN_ACTION_ENCSOUNDINGS_TOGGLE = 0x100c;
    private final static int OCPN_ACTION_ENCLIGHTS_TOGGLE = 0x100d;

    private final static int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;
    private final static int MY_PERMISSIONS_REQUEST_WRITE_STORAGE = 2;

    //  Definitions found in OCPN "chart1.h"
    private final static int ID_CMD_APPLY_SETTINGS = 300;
    private final static int ID_CMD_NULL_REFRESH = 301;
    private final static int ID_CMD_TRIGGER_RESIZE = 302;
    private final static int ID_CMD_SETVP = 303;
    private final static int ID_CMD_POST_JSON_TO_PLUGINS = 304;
    private final static int ID_CMD_SET_LOCALE = 305;
    private final static int ID_CMD_SOUND_FINISHED = 306;
    
    private final static int CHART_TYPE_CM93COMP = 7;       // must line up with OCPN types
    private final static int CHART_FAMILY_RASTER = 1;
    private final static int CHART_FAMILY_VECTOR = 2;

    private static final String ERROR_CODE_KEY = "error.code";
    private static final String ERROR_MESSAGE_KEY = "error.message";
    private static final String DEX_PATH_KEY = "dex.path";
    private static final String LIB_PATH_KEY = "lib.path";
    private static final String LOADER_CLASS_NAME_KEY = "loader.class.name";
    private static final String NATIVE_LIBRARIES_KEY = "native.libraries";
    private static final String ENVIRONMENT_VARIABLES_KEY = "environment.variables";
    private static final String APPLICATION_PARAMETERS_KEY = "application.parameters";
    private static final String BUNDLED_LIBRARIES_KEY = "bundled.libraries";
    private static final String BUNDLED_IN_LIB_RESOURCE_ID_KEY = "android.app.bundled_in_lib_resource_id";
    private static final String BUNDLED_IN_ASSETS_RESOURCE_ID_KEY = "android.app.bundled_in_assets_resource_id";
    private static final String MAIN_LIBRARY_KEY = "main.library";
    private static final String STATIC_INIT_CLASSES_KEY = "static.init.classes";
    private static final String NECESSITAS_API_LEVEL_KEY = "necessitas.api.level";

    /// Ministro server parameter keys
    private static final String REQUIRED_MODULES_KEY = "required.modules";
    private static final String APPLICATION_TITLE_KEY = "application.title";
    private static final String MINIMUM_MINISTRO_API_KEY = "minimum.ministro.api";
    private static final String MINIMUM_QT_VERSION_KEY = "minimum.qt.version";
    private static final String SOURCES_KEY = "sources";               // needs MINISTRO_API_LEVEL >=3 !!!
    // Use this key to specify any 3rd party sources urls
    // Ministro will download these repositories into their
    // own folders, check http://community.kde.org/Necessitas/Ministro
    // for more details.

    private static final String REPOSITORY_KEY = "repository";         // use this key to overwrite the default ministro repsitory
    private static final String ANDROID_THEMES_KEY = "android.themes"; // themes that your application uses

    public View parentLayout;

    public String APPLICATION_PARAMETERS = null; // use this variable to pass any parameters to your application,
    // the parameters must not contain any white spaces
    // and must be separated with "\t"
    // e.g "-param1\t-param2=value2\t-param3\tvalue3"

    public String ENVIRONMENT_VARIABLES = "QT_USE_ANDROID_NATIVE_STYLE=1\tQT_USE_ANDROID_NATIVE_DIALOGS=1\t";
    // use this variable to add any environment variables to your application.
    // the env vars must be separated with "\t"
    // e.g. "ENV_VAR1=1\tENV_VAR2=2\t"
    // Currently the following vars are used by the android plugin:
    // * QT_USE_ANDROID_NATIVE_STYLE - 1 to use the android widget style if available.
    // * QT_USE_ANDROID_NATIVE_DIALOGS -1 to use the android native dialogs.

    public String[] QT_ANDROID_THEMES = null;     // A list with all themes that your application want to use.
    // The name of the theme must be the same with any theme from
    // http://developer.android.com/reference/android/R.style.html
    // The most used themes are:
    //  * "Theme" - (fallback) check http://developer.android.com/reference/android/R.style.html#Theme
    //  * "Theme_Black" - check http://developer.android.com/reference/android/R.style.html#Theme_Black
    //  * "Theme_Light" - (default for API <=10) check http://developer.android.com/reference/android/R.style.html#Theme_Light
    //  * "Theme_Holo" - check http://developer.android.com/reference/android/R.style.html#Theme_Holo
    //  * "Theme_Holo_Light" - (default for API 11-13) check http://developer.android.com/reference/android/R.style.html#Theme_Holo_Light
    //  * "Theme_DeviceDefault" - check http://developer.android.com/reference/android/R.style.html#Theme_DeviceDefault
    //  * "Theme_DeviceDefault_Light" - (default for API 14+) check http://developer.android.com/reference/android/R.style.html#Theme_DeviceDefault_Light

    public String QT_ANDROID_DEFAULT_THEME = null; // sets the default theme.

    private static Activity m_activity = null;

    private static final int INCOMPATIBLE_MINISTRO_VERSION = 1; // Incompatible Ministro version. Ministro needs to be upgraded.
    private static final int BUFFER_SIZE = 1024 * 1024;

    private ActivityInfo m_activityInfo = null; // activity info object, used to access the libs and the strings
    private DexClassLoader m_classLoader = null; // loader object
    private String[] m_sources = {"https://download.qt-project.org/ministro/android/qt5/qt-5.2"}; // Make sure you are using ONLY secure locations
    private String m_repository = "default"; // Overwrites the default Ministro repository
    // Possible values:
    // * default - Ministro default repository set with "Ministro configuration tool".
    // By default the stable version is used. Only this or stable repositories should
    // be used in production.
    // * stable - stable repository, only this and default repositories should be used
    // in production.
    // * testing - testing repository, DO NOT use this repository in production,
    // this repository is used to push a new release, and should be used to test your application.
    // * unstable - unstable repository, DO NOT use this repository in production,
    // this repository is used to push Qt snapshots.
    private String[] m_qtLibs = null; // required qt libs

    private String CHANNEL_ID = "CHANNEL_ID";
    // Builder for notification events
    NotificationCompat.Builder mNotificationBuilder;
    private int FGBG_notificationID = 0;
    NotificationManager m_notificationManager;

    private String m_filesDir = "";
    public FragmentManager fm;

    private DownloadManager m_dm;
    private long m_enqueue;

    private static ActivityManager activityManager;

    private Semaphore mutexD = new Semaphore(0);

    private Float lastX;
    private Float lastY;

    private Boolean m_activityARBComplete = false;
    private String m_activityArbResult;
    private String m_arbResultStringName;           // name of string result expected

    private Boolean m_GPSServiceStarted = false;
    private GPSServer m_GPSServer;
    private boolean m_gpsOn =false;

    public ProgressDialog ringProgressDialog;
    public boolean m_hasGPS;
    private boolean m_backButtonEnable = true;
    private boolean m_optionsItemActionEnable = true;

    private BTScanHelper scanHelper;
    private Boolean m_ScanHelperStarted = false;
    private BluetoothSPP m_BTSPP;
    private Boolean m_BTServiceCreated = false;
    private String m_BTStat;
    private Boolean m_FileChooserDone = false;
    private String m_filechooserString;

    private Boolean m_ColorDialogDone = false;
    private String m_ColorDialogString;

    private String m_downloadRet = "";
    private String m_yesno = "";
    private boolean m_trackContinuous = false;
    private boolean m_bNeworUpdateInstall;

    public OCPNResultReceiver mReceiver;

    OCPNNativeLib nativeLib;

    private String m_GRIBReturn;

    private UsbSerialHelper uSerialHelper;

    // action bar
    private ActionBar actionBar;
    private boolean optionsMenuEnabled = true;

    // Title navigation Spinner data
    private ArrayList<SpinnerNavItem> navSpinner;
    private SpinnerNavItem spinnerItemRaster;
    private SpinnerNavItem spinnerItemVector;
    private SpinnerNavItem spinnerItemcm93;

    // Navigation adapter
    private TitleNavigationAdapter adapter;

    // Menu item used to indicate "RouteCreate" is active
    MenuItem itemRouteAnnunciator;
    MenuItem itemRouteMenuItem;
    private boolean m_showRouteAnnunciator = false;

    MenuItem itemFollowInActive;
    MenuItem itemFollowActive;
    MenuItem itemFollowActiveGreen;
    MenuItem itemFollowActiveBlue;
    private int m_nFollowState = 0;

    MenuItem itemTrackInActive;
    MenuItem itemTrackActive;
    private boolean m_isTrackActive = false;

    private static AudioManager audioManager;
    private MediaPlayer mediaPlayer; // The media player to play the sounds, even in background

    BroadcastReceiver downloadBCReceiver = null;

    private double m_gminitialLat;
    private double m_gminitialLon;
    private double m_gminitialZoom;

    private boolean m_fullScreen;
    private String m_scannedSerial = "";

    public MyDocSpinnerDialog myDocSpinnerInstance;

    private String g_postResult = "";
    private boolean g_postActive = false;
    PostTask g_postTask;
    private boolean m_inExit = false;
    private boolean m_GPSPermissionRequested = false;
    private String m_nativeLibraryDir;

    private String m_unzipLastFile = "";
    private String unzipTopDir = "";

    // Used in checking for runtime permissions.
    private static final int REQUEST_PERMISSIONS_REQUEST_CODE = 34;

    // The BroadcastReceiver used to listen from broadcasts from the service.
    private MyReceiver myReceiver;

     // Tracks the bound state of the service.
    private boolean mBound = false;

    // Tracks the bound state of the GPS service.
    private boolean mGPSBound = false;
    private Intent GPSServiceIntent;

    int m_Orientation = 1;

    private String m_systemName;
    private static String OCPNuniqueID = null;
    private static final String PREF_UNIQUE_ID = "PREF_UNIQUE_ID";

    private static String m_UUID = null;
    private static String m_OCPNUUID = null;
    private static String m_OCPNWVID = null;
    private static String m_selID = null;
    ConnectivityManager connectivityManager = null;
    WifiManager wifi = null;
    MulticastLock m_multicastlock = null;

    private boolean m_gpsServerActionPending = false;
    private int m_gpsServerPendingParm = 0;

    /** Defines callbacks for service binding, passed to bindService() */

    private ServiceConnection GPSconnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            GPSServer.LocalBinder binder = (GPSServer.LocalBinder) service;
            m_GPSServer = binder.getService();
            mGPSBound = true;
            m_GPSServiceStarted = true;

            if (m_gpsServerActionPending) {
                m_GPSServer.doService(m_gpsServerPendingParm);
                m_gpsServerActionPending = false;
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mGPSBound = false;
            m_GPSServiceStarted = false;
        }
    };

    private void quickStopGpsService(){

        // A short method to allow quick stopping of GPS service
        // Unbind from the GPS service
        if (mGPSBound) {
            getApplicationContext().unbindService(GPSconnection);
            mGPSBound = false;
        }

        if (m_GPSServiceStarted)
            m_GPSServer.doService(GPS_STOPSERVICE);

    }

    public String getOChartsSystemName(){
        return m_systemName;
    }

    private String getUUID( Context context){
        final String androidId = Settings.Secure.getString(
                context.getContentResolver(), Settings.Secure.ANDROID_ID);
        if(androidId.isEmpty())
            return "";

        final UUID uuid;
        try{
            uuid = UUID.nameUUIDFromBytes(androidId.getBytes("utf8"));
        } catch (UnsupportedEncodingException e) {
           throw new RuntimeException(e);
        }

        return uuid.toString();
    }

    private String getSystemName( String sID){
        String name = android.os.Build.DEVICE;
        if(name.length() > 11)
            name = name.substring(0, 10);

        // Get a hash of the supplied string
        int uuidHash = -(sID.hashCode());
        // And take the mod(10000) result
        int val = Math.abs(uuidHash) % 10000;
        name += String.valueOf(val);

        Pattern replace = Pattern.compile("[-_/()~#%&*{}:;?|<>!$^+=@ ]");
        Matcher matcher2 = replace.matcher(name);
        name = matcher2.replaceAll("0");

        name = name.toLowerCase(Locale.ROOT);
        return name;

    }

    public String getOCPNuniqueID() {
        if (OCPNuniqueID == null) {
            SharedPreferences sharedPrefs = getSharedPreferences( PREF_UNIQUE_ID, Context.MODE_PRIVATE);
            OCPNuniqueID = sharedPrefs.getString(PREF_UNIQUE_ID, null);
            if (OCPNuniqueID == null) {
                OCPNuniqueID = UUID.randomUUID().toString();
                SharedPreferences.Editor editor = sharedPrefs.edit();
                editor.putString(PREF_UNIQUE_ID, OCPNuniqueID);
                editor.commit();
            }
        }    return OCPNuniqueID;
    }


    public String getOCPNWVID() {
        String rv = "";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            MediaDrm mediaDrm;

            final UUID WIDEVINE_UUID = UUID.fromString("edef8ba9-79d6-4ace-a3c8-27dcd51d21ed");
            try {
                mediaDrm = new MediaDrm(WIDEVINE_UUID);
            } catch (Exception e) {
                return rv;
            }

            byte[] deviceUniqueIdArray = mediaDrm.getPropertyByteArray("deviceUniqueId");
            StringBuilder sb = new StringBuilder();
            for (byte b : deviceUniqueIdArray) {
                sb.append(String.format("%02X", b));
            }
            //System.out.println(sb.toString());
            //String encodedWidevineId = Base64.encodeToString(deviceUniqueIdArray, DEFAULT).trim();
            return sb.toString();
        }
        else
          return rv;
    }

        // Monitors the state of the connection to the service.
    //BroadcastReceiver which receives broadcasted Intents
    private final BroadcastReceiver mLocaleChangeReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i("OpenCPN", "mLocaleChangeReceiver");

            final String action = intent.getAction();
            Log.i("OpenCPN", "onLocaleChange: " + action);
            String language = getCurrentAndroidLocale().getLanguage();
            Log.i("OpenCPN", "  new language is: " + language);

            setAppLocale(getCurrentAndroidLocale());
        }
    };

    public Locale getCurrentAndroidLocale() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
//            return getResources().getConfiguration().getLocales().get(0);
//        }
//        else
        {
            //noinspection deprecation
            return getResources().getConfiguration().locale;
        }
    }

    public void setAppLocale(Locale newLocale) {
        String lang = newLocale.getLanguage();
        String country = newLocale.getCountry();

        String toSet = lang;
        if (!country.isEmpty())
            toSet += "_" + country;

//        Log.i("OpenCPN", "  setAppLocale new language ID is: " + toSet);

//        nativeLib.invokeCmdEventCmdString( ID_CMD_SET_LOCALE, toSet);

    }


    public String getAndroidLocaleString() {
        Locale locale = getCurrentAndroidLocale();
        if (null != locale) {
            String lang = locale.getLanguage();
            String country = locale.getCountry();

            String ret = lang;
            if (!country.isEmpty())
                ret += "_" + country;

            Log.i("OpenCPN", "  getAndroidLocaleString language ID is: " + ret);

            return ret;
        } else
            return "en_US";

    }

    @SuppressWarnings("deprecation")
    @SuppressLint("NewApi")
    public static void lockActivityOrientation(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        int rotation = display.getRotation();
        int height;
        int width;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB_MR2) {
            height = display.getHeight();
            width = display.getWidth();
        } else {
            Point size = new Point();
            display.getSize(size);
            height = size.y;
            width = size.x;
        }
        switch (rotation) {
            case Surface.ROTATION_90:
                if (width > height)
                    activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                else
                    activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);
                break;
            case Surface.ROTATION_180:
                if (height > width)
                    activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);
                else
                    activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
                break;
            case Surface.ROTATION_270:
                if (width > height)
                    activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
                else
                    activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                break;
            default:
                if (height > width)
                    activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                else
                    activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }

    public String DisableRotation() {
        lockActivityOrientation(this);

        return "OK";
    }

    public String EnableRotation() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

        return "OK";
    }

    public String getScreenOrientation(){
        Configuration c = getResources().getConfiguration();
        int orient = c.orientation;
        return String.valueOf(orient);
    }

    public QtActivity() {
        if (Build.VERSION.SDK_INT <= 10) {
            QT_ANDROID_THEMES = new String[]{"Theme_Light"};
            QT_ANDROID_DEFAULT_THEME = "Theme_Light";
        } else if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT <= 13) {
            QT_ANDROID_THEMES = new String[]{"Theme_Holo_Light"};
            QT_ANDROID_DEFAULT_THEME = "Theme_Holo_Light";
        } else {
            QT_ANDROID_THEMES = new String[]{"Theme_DeviceDefault_Light"};
            QT_ANDROID_DEFAULT_THEME = "Theme_DeviceDefault_Light";
        }
        m_activity = QtActivity.this;


    }

    public String getAndroidTZOffsetMinutes() {
        Time time = new Time();
        time.setToNow();

        TimeZone tz = TimeZone.getDefault();
        int offsetMilli = tz.getOffset(time.toMillis(true));
        int offsetMins = offsetMilli / 60000;
        String rv = Integer.toString(offsetMins);
        Log.i("OpenCPN", "  offsetMilli is: " + Integer.toString(offsetMilli) + " offsetmins: " + rv);
        return rv;
    }

    public String getAndroidVersionCode() {
        try {
            PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            String rv = Integer.toString(pInfo.versionCode);
            return rv;
        } catch (NameNotFoundException e) {
            return "0";
        }
    }

    public String getAndroidVersionName() {
        try {
            PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            String rv = pInfo.versionName;
            return rv;
        } catch (NameNotFoundException e) {
            return "0";
        }
    }


    public String buildSVGIcon(String inFile, String outFile, int width, int height) {

//        Log.i("OpenCPN", inFile + " " + outFile);

        int rwidth = width;
        int rheight = height;

        // Read an SVG file
        File file = new File(inFile);
        SVG svg = null;
        if (file.exists()) {
            FileInputStream inStream = null;
            try {
                inStream = new FileInputStream(inFile);
            } catch (Exception e) {
                e.printStackTrace();
                Log.i("OpenCPN", "buildSVGIcon Read Stream Exception");
            }

            //SVG  svg = SVG.getFromAsset(getContext().getAssets(), inFile);
            try {
                svg = SVG.getFromInputStream(inStream);
            } catch (Exception e) {
                e.printStackTrace();
                Log.i("OpenCPN", "buildSVGIcon SVG Parse ExceptionA");
            }

            //  Inkscape SVG Documents must be saved in "optimized SVG" format, with viewbox enabled....
            // https://code.google.com/archive/p/androidsvg/wikis/FAQ.wiki#My_SVG_won%27t_scale_to_fit_the_canvas_or_my_ImageView
            try {

                if ((width < 0) || (height < 0)) {
                    rwidth = Math.round(svg.getDocumentWidth());
                    rheight = Math.round(svg.getDocumentHeight());
                    //String report = String.valueOf( rwidth ) + "  " + String.valueOf( rheight );
                    //Log.i("OpenCPN", "buildSVGIcon document size:" + report);

                }

                svg.setDocumentWidth(rwidth);
                svg.setDocumentHeight(rheight);
            } catch (Exception e) {
                e.printStackTrace();
                Log.i("OpenCPN", "buildSVGIcon SVG Parse ExceptionB");
            }

            // Create a canvas to draw onto
            if (svg.getDocumentWidth() != -1) {
                Bitmap newBM = Bitmap.createBitmap(rwidth, rheight, Bitmap.Config.ARGB_8888);
                Canvas bmcanvas = new Canvas(newBM);

                // Clear background to white
                //bmcanvas.drawRGB(255, 255, 255);

                // Render our document onto our canvas
                try {
                    svg.renderToCanvas(bmcanvas);
                } catch (Exception e) {
                    Log.i("OpenCPN", "buildSVGIcon SVG Render ExceptionA");
                    return "NOK";
                }

                //  Write the file out
                FileOutputStream out = null;
                try {
                    out = new FileOutputStream(outFile);
                    newBM.compress(Bitmap.CompressFormat.PNG, 100, out);

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (out != null) {
                            out.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            Log.i("OpenCPN", "FileNotFound: " + inFile);
            return "FileNotFound";
        }

        return "OK";
    }


    public String enableOptionsMenu(int bEnable) {
        Log.i("OpenCPN", "enableOptionsMenu " + bEnable);

        if (bEnable == 1)
            optionsMenuEnabled = true;
        else
            optionsMenuEnabled = false;

        // Can only mess with the UI view if this method is executed from the main UI thread.
        //  Otherwise, provokes a "CalledFromWrongThreadException"
        //  But, for some reason, this code don't work...
/*
        if(Looper.getMainLooper().getThread() == Thread.currentThread())
            invalidateOptionsMenu();
*/
        // So, do this:
        runOnUiThread(new Runnable() {
            public void run() {
                invalidateOptionsMenu();
            }
        });

        return "OK";
    }

    public String showDisclaimerDialog(String title, String message) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        // set title
        alertDialogBuilder.setTitle(title);

        // set dialog message
        alertDialogBuilder
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, close
                        // current activity
                        QtActivity.this.finish();
                    }
                })
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

        return ("OK");

    }

    public String disclaimerDialog(final String title, final String message) {

        final QtActivityDelegate delegate = QtNative.activityDelegate();

        if (null != delegate) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    showDisclaimerDialog(title, message);

                }
            });
        }

        String ret = "OK";
        return ret;
    }

    public String showSimpleOKDialog(String title, String message) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        // set title
        alertDialogBuilder.setTitle(title);

        // set dialog message
        alertDialogBuilder
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

        return ("OK");

    }

    public String simpleOKDialog(final String title, final String message) {

        final QtActivityDelegate delegate = QtNative.activityDelegate();

        if (null != delegate) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    showSimpleOKDialog(title, message);

                }
            });
        }

        String ret = "OK";
        return ret;
    }

    public String simpleYesNoDialog(final String title, final String message) {

        final QtActivityDelegate delegate = QtNative.activityDelegate();

        if (null != delegate) {

            mutexD = new Semaphore(0);


            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(m_activity);

                    // set title
                    alertDialogBuilder.setTitle(title);

                    // set dialog message
                    alertDialogBuilder
                            .setMessage(message)
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    m_yesno = "YES";
                                    mutexD.release();
                                    dialog.cancel();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    m_yesno = "NO";
                                    mutexD.release();
                                    dialog.cancel();
                                }
                            });

                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    // show it
                    alertDialog.show();

                }

            });

            // One way to wait for the runnable to be done...
            try {
                Log.i("OpenCPN", "Waiting for MutexD....");
                mutexD.acquire();            // Cannot get mutex until runnable above exits.
                Log.i("OpenCPN", "Got MutexD");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        Log.i("OpenCPN", "YesNo returned: " + m_yesno);

        return m_yesno;
    }

    public String installPlaystoreHelp() {

        final String helpPackageName = "org.opencpn.opencpnusermanual";
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + helpPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + helpPackageName)));
        }
        return "OK";
    }

    public String showHTMLAlertDialog(String title, String htmlString) {

        WebView wv = new WebView(getApplicationContext());

        wv.getSettings().setLoadWithOverviewMode(true);
        wv.getSettings().setUseWideViewPort(true);
        wv.getSettings().setMinimumFontSize(50);
        wv.loadData(htmlString, "text/html; charset=UTF-8", null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this, AlertDialog.THEME_HOLO_LIGHT);

        // set title
        alertDialogBuilder.setTitle(title);

        // set dialog message
        alertDialogBuilder
                .setView(wv)
                .setCancelable(false)
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });

        //                     alertDialogBuilder.setPositiveButton("Cancel",new DialogInterface.OnClickListener() {
        //                             public void onClick(DialogInterface dialog,int id) {
        // if this button is clicked, close
        // current activity
        //                                     QtActivity.this.finish();
        //                             }
        //                       });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();


        // show it
        alertDialog.show();

        return ("OK");

    }

    public String displayHTMLAlertDialog(final String title, final String htmlString) {
        //Log.i("OpenCPN", "displayHTMLAlertDialog" + htmlString);

        final QtActivityDelegate delegate = QtNative.activityDelegate();

        if (null != delegate) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    showHTMLAlertDialog(title, htmlString);

                }
            });
        }

        String ret = "OK";
        return ret;
    }


    private String m_settingsReturn;

    public static class MyDocSpinnerDialog extends DialogFragment {

        ProgressDialog _dialog;

        public MyDocSpinnerDialog() {
            // use empty constructors. If something is needed use onCreate's
        }

        @Override
        public Dialog onCreateDialog(final Bundle savedInstanceState) {

            _dialog = new ProgressDialog(getActivity());
            this.setStyle(STYLE_NO_TITLE, getTheme()); // You can use styles or inflate a view
            _dialog.setMessage("Please stand by while OpenCPN installs the User Manual"); // set your messages if not inflated from XML

            _dialog.setCancelable(false);

            return _dialog;
        }

        public void setMyMessage(String message) {
            if (null != _dialog) {
                _dialog.setMessage(message);
            }
        }
    }


    public String launchHelpBook() {
        Log.i("OpenCPN", "launchHelpBook");
        if (isHelpAvailable().equals("YES")) {
            Log.i("OpenCPN", "Help is available");
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("org.opencpn.opencpnusermanual");
            startActivity(launchIntent);

            return "OK";
        } else
            return "NO";
    }


    public String isHelpAvailable() {

        boolean bVal = false;
        List<PackageInfo> packList = getPackageManager().getInstalledPackages(0);
        for (int i = 0; i < packList.size(); i++) {
            PackageInfo packInfo = packList.get(i);
            if ((packInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
                String appName = packInfo.applicationInfo.loadLabel(getPackageManager()).toString();
                if (appName.equals("OpenCPN User Manual")) {
                    //if(packInfo.versionCode >= 18){
                    bVal = true;
                    break;
                    //}
                }
                //Log.i("OpenCPN", appName);
            }
        }
        if (bVal)
            return "YES";
        else
            return "NO";
    }

    public String launchWebView(String url) {
        Log.i("OpenCPN", "launchWebView: " + url);

        Intent intent = new Intent(this, WebViewActivity.class);

        Bundle b = new Bundle();
        b.putString(WebViewActivity.SELECTED_URL, url);
        intent.putExtras(b);

        startActivity(intent);
        return "OK";
    }

    public String launchBrowser(String url) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        return "OK";
    }

    private Toast mTimedToast;
    private CountDownTimer mtoastCountDown;
    private boolean ToastTimerRunning = false;

    public String showTimedToast(final String text, final int toastDurationInMilliSeconds) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                // Set the toast
                mTimedToast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG);

                // Set the countdown to display the toast
                ToastTimerRunning = true;
                mtoastCountDown = new CountDownTimer(toastDurationInMilliSeconds, 1000 /*Tick duration*/) {
                    public void onTick(long millisUntilFinished) {
                        if (!isFinishing())
                            mTimedToast.show();
                    }

                    public void onFinish() {
                        mTimedToast.cancel();
                        ToastTimerRunning = false;
                    }
                };

                // Show the toast and starts the countdown
                if (!isFinishing())
                    mTimedToast.show();
                mtoastCountDown.start();

            }
        });


        return "OK";
    }

    public String cancelTimedToast() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                if (mTimedToast.getView().isShown()) {
                    mtoastCountDown.cancel();
                    mTimedToast.cancel();
                }
            }
        });


        return "OK";
    }

    public String showToast(final String text) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                // Set the toast
                mTimedToast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG);
                mTimedToast.show();

            }
        });


        return "OK";
    }


    public String startActivityWithIntent(String target_package, String activity, String extra_name_in, String extra_data_in, String extra_data_out_name) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setComponent(new ComponentName(target_package, target_package + "." + activity));
        Log.i("OpenCPN", "startActivityWithIntent: " + target_package + ", " + target_package + "." + activity);

        Bundle b = new Bundle();
        b.putString(extra_name_in, extra_data_in);
        intent.putExtras(b);

        m_activityARBComplete = false;      // Mark the activity as incomplete
        m_arbResultStringName = extra_data_out_name;

        startActivityForResult(intent, OCPN_ARBITRARY_REQUEST_CODE);

        return "OK";
    }

    public String getArbActivityStatus() {
        if (m_activityARBComplete)
            return "COMPLETE";
        else
            return "INCOMPLETE";
    }

    public String getArbActivityResult() {
        return m_activityArbResult;
    }

    private void toggleFullscreen() {
        m_fullScreen = !m_fullScreen;
        setFullscreen(m_fullScreen);
        nativeLib.notifyFullscreenChange(m_fullScreen);
    }

    public void setFullscreen(final boolean bfull) {

        final QtActivityDelegate delegate = QtNative.activityDelegate();

        if (null != delegate) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    delegate.setFullScreen(bfull);

                    if (bfull) {
                        int flags = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

                        getWindow().getDecorView().setSystemUiVisibility(flags);
                    }

                }
            });
        }
    }

    public String setFullscreen(final int bfull) {
        setFullscreen(bfull != 0);
        m_fullScreen = (bfull != 0);
        return "OK";
    }


    public String getFullscreen() {
        if (m_fullScreen)
            return "YES";
        else
            return "NO";
    }

    public String setTrackContinuous(final int btrack) {
        m_trackContinuous = (btrack != 0);
        return "OK";
    }

    public String terminateApp() {
        Log.i("OpenCPN", "terminateApp");
        finish();
        return "";
    }

    public String makeToast(String msg) {
        //Toast.makeText(getApplicationContext(), msg,Toast.LENGTH_LONG).show();

        return "OK";
    }

    public String isDirWritable(String dir) {
        File fn = new File(dir);
        if (fn.canWrite())
            return "YES";
        else
            return "NO";
    }

    public String invokeGoogleMaps() {
        Log.i("DEBUGGER_TAG", "invokeGoogleMaps");


        Intent intent = new Intent(QtActivity.this, org.opencpn.OCPNMapsActivity.class);

        String s = nativeLib.getVPCorners();
        if (s.isEmpty()) {
            Log.i("DEBUGGER_TAG", "invokeGoogleMaps..Error, empty VPCorners");
            return "66";
        }

        String v = nativeLib.getVPS();
        Log.i("DEBUGGER_TAG", "initialPositionString" + v);

        StringTokenizer tkz = new StringTokenizer(v, ";");

        String initialLat = "";
        String initialLon = "";
        String initialZoom = "";

        if (tkz.hasMoreTokens()) {
            initialLat = tkz.nextToken();
            initialLon = tkz.nextToken();
            initialZoom = tkz.nextToken();
        }

        m_gminitialZoom = Double.parseDouble(initialZoom);

        intent.putExtra("VP_CORNERS", s);
        intent.putExtra("VPS", v);

        int height = this.getWindow().getDecorView().getHeight();
        int width = this.getWindow().getDecorView().getWidth();
        intent.putExtra("WIDTH", width);
        intent.putExtra("HEIGHT", height);

        startActivityForResult(intent, OCPN_GOOGLEMAPS_REQUEST_CODE);

        int pss = 55;
        String ret;
        ret = String.format("%d", pss);
        return ret;
    }

    public String doGRIBActivity(String json) {
        Log.i("OpenCPN", "doGRIBActivity");
//        Log.i("DEBUGGER_TAG", json);


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("GRIB_PREFS_JSON", json);
        editor.apply();

        Intent intent = new Intent(QtActivity.this, org.opencpn.OCPNGRIBActivity.class);
        startActivityForResult(intent, OCPN_GRIB_REQUEST_CODE);

        int pss = 666;
        String ret;
        ret = String.format("%d", pss);
        return ret;

    }

    private String getAllFilesResult;
    private String getAllFilesFilespec;

    public void traverse(File dir) {
        if (dir.exists()) {
            File[] files = dir.listFiles();
            for (int i = 0; i < files.length; ++i) {
                File file = files[i];
                if (file.isDirectory()) {
                    traverse(file);
                } else {
                    if (file.getName().matches(getAllFilesFilespec)) {

                        //Log.i("OpenCPN", "traverse:File: " + file.getAbsolutePath());
                        getAllFilesResult += file.getAbsolutePath() + ";";
                    }
                }
            }
        }
    }

    public String getAllFilesWithFilespec(String dir, String filespec) {
        getAllFilesResult = "";

        int dot_pos = filespec.lastIndexOf(".");
        if ((dot_pos < filespec.length() - 1) && (dot_pos >= 0)) {
            try {
                getAllFilesFilespec = "(.*)[.]" + filespec.substring(dot_pos + 1) + "$";
                Log.i("OpenCPN", "getAllFilesWithFilespec " + getAllFilesFilespec);

                File dirt = new File(dir);
                traverse(dirt);
            } catch (Exception e) {
                Log.i("OpenCPN", "getAllFilesWithFilespec exception");
                e.printStackTrace();
            }
        }

        return getAllFilesResult;
    }


    public String doAndroidSettings(String settings) {
        if (null != uSerialHelper)
            m_scannedSerial = scanSerialPorts(UsbSerialHelper.NOSCAN);      // No scan, just report latest results.

        m_settingsReturn = new String();

        Intent intent = new Intent(QtActivity.this, org.opencpn.OCPNSettingsActivity.class);
        intent.putExtra("SETTINGS_STRING", settings);
        intent.putExtra("DETECTEDSERIALPORTS_STRING", m_scannedSerial);
        Log.i("OpenCPN", "doAndroidSettings settings" + settings);
        Log.i("OpenCPN", "doAndroidSettings m_scannedSerial" + m_scannedSerial);

        startActivityForResult(intent, OCPN_SETTINGS_REQUEST_CODE);

        int pss = 55;
        String ret;
        ret = String.format("%d", pss);
        return ret;
    }


    public String checkAndroidSettings() {
        return m_settingsReturn;
    }


    public String Executer(String command) {

        Log.i("OpenCPN", "Executor process launched as: [" + command + "]");

        StringBuffer output = new StringBuffer();

        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            Log.i("OpenCPN", "Executer wait done");
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            Log.i("OpenCPN", "Executer exception");
            e.printStackTrace();
        }
        String response = output.toString();
        return response;

    }

    public String xcreateProc(String cmd) {
        Log.i("OpenCPN", "createProc");

        String cmdExec = cmd;
        if (Build.VERSION.SDK_INT > 28) {
            File cmdFile = new File(cmd);
            cmdExec = m_nativeLibraryDir + "/lib" + cmdFile.getName() + ".so";
        }

        File file = new File(cmdExec);
        if(!file.exists())
            Log.i("OpenCPN", "createProc cmd executable does not exist: " + cmdExec);
        else {
            Log.i("OpenCPN", "Setting executable on: " + cmdExec);
            file.setExecutable(true);
        }

        long pid = 0;
        try {
            Process process = Runtime.getRuntime().exec(cmdExec);

            Log.i("OpenCPN", "Process launched as: {" + cmdExec + "}");

            Log.i("OpenCPN", "Process ClassName: " + process.getClass().getName());

            if (process.getClass().getName().equals("java.lang.UNIXProcess")) {
                /* get the PID on unix/linux systems */
                Log.i("OpenCPN", "Fetching PID...");
                try {
                    Field f = process.getClass().getDeclaredField("pid");
                    f.setAccessible(true);
                    pid = f.getLong(process);
                } catch (Throwable e) {
                }
            } else {
                pid = 1;
                Log.i("OpenCPN", "Process:  unknown Class name");
            }

        } catch (Exception e) {
            Log.i("OpenCPN", "createProc exception: " + e.getMessage());
            e.printStackTrace();
        }

        String ret = String.valueOf(pid);
        Log.i("OpenCPN", "Process PID: " + ret);
        return ret;
    }

    public String createProc(String cmd, String arg1, String arg2, String libPath) {
        Log.i("OpenCPN", "createProc");
        Log.i("OpenCPN", "cmd: " + cmd);
        Log.i("OpenCPN", "arg1: " + arg1);
        Log.i("OpenCPN", "arg2: " + arg2);
        Log.i("OpenCPN", "libPath: " + libPath);
        String libraryPath = getContext().getApplicationInfo().dataDir + "/lib";
        Log.i("OpenCPN", "libraryPath: " + libraryPath);

        String cmdExec = cmd;
        if (Build.VERSION.SDK_INT > 28) {
            File cmdFile = new File(cmd);
            cmdExec = m_nativeLibraryDir + "/lib" + cmdFile.getName() + ".so";
        }

        File file = new File(cmdExec);
        if(!file.exists())
            Log.i("OpenCPN", "createProc cmd executable does not exist: " + cmdExec);
        else {
            Log.i("OpenCPN", "Setting executable on: " + cmdExec);
            file.setExecutable(true);
        }

        long pid = 0;
        try {
            ProcessBuilder pb = new ProcessBuilder(cmdExec, arg1, arg2);

            Map<String, String> env = pb.environment();
            env.put("LD_LIBRARY_PATH", libPath);

            //env.remove("OTHERVAR");
            //env.put("VAR2", env.get("VAR1") + "suffix");

            //pb.directory(new File("myDir"));
            //File log = new File("log");
            //pb.redirectErrorStream(true);
            //pb.redirectOutput(Redirect.appendTo(log));

            Log.i("OpenCPN", "Process launched as: [" + cmd + "]");

            Process process = pb.start();
            Log.i("OpenCPN", "Process ClassName: " + process.getClass().getName());

            if (process.getClass().getName().equals("java.lang.UNIXProcess")) {
                /* get the PID on unix/linux systems */
                Log.i("OpenCPN", "Fetching PID...");
                try {
                    Field f = process.getClass().getDeclaredField("pid");
                    f.setAccessible(true);
                    pid = f.getLong(process);
                } catch (Throwable e) {
                }
            } else {
                pid = 1;
                Log.i("OpenCPN", "Process:  unknown Class name");
            }


        } catch (Exception e) {
            Log.i("OpenCPN", "createProcB exception: " + e.getMessage());
            e.printStackTrace();
        }

        String ret = String.valueOf(pid);
        Log.i("OpenCPN", "Process PID: " + ret);
        return ret;

    }

    public String createProc(String cmd, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String libPath) {
        Log.i("OpenCPN", "createProc");
        Log.i("OpenCPN", "cmd: " + cmd);
        Log.i("OpenCPN", "arg1: " + arg1);
        Log.i("OpenCPN", "arg2: " + arg2);
        Log.i("OpenCPN", "arg3: " + arg3);
        Log.i("OpenCPN", "arg4: " + arg4);
        Log.i("OpenCPN", "arg5: " + arg5);
        Log.i("OpenCPN", "arg6: " + arg6);
        Log.i("OpenCPN", "libPath: " + libPath);
        String libraryPath = getContext().getApplicationInfo().dataDir + "/lib";
        Log.i("OpenCPN", "libraryPath: " + libraryPath);

        String cmdExec = cmd;

        if (Build.VERSION.SDK_INT > 28) {
            File cmdFile = new File(cmd);
            cmdExec = m_nativeLibraryDir + "/lib" + cmdFile.getName() + ".so";
        }

        File file = new File(cmdExec);
        if(!file.exists())
            Log.i("OpenCPN", "createProc cmd executable does not exist: " + cmdExec);
        else {
            Log.i("OpenCPN", "Setting executable on: " + cmdExec);
            file.setExecutable(true);
        }

        long pid = 0;
        try {
//            ProcessBuilder pb = new ProcessBuilder(cmdExec, arg1, arg2, arg3, arg4, arg5, "df9f5b06-4715-3f6e-85c4-90514d0935a3;xxxx; : A7600-F Lenovo A7600-F");
            ProcessBuilder pb = new ProcessBuilder(cmdExec, arg1, arg2, arg3, arg4, arg5, arg6);

            Map<String, String> env = pb.environment();
            env.put("LD_LIBRARY_PATH", libPath);

            Log.i("OpenCPN", "Process launched as: [" + cmd + "]");

            Process process = pb.start();
            Log.i("OpenCPN", "Process ClassName: " + process.getClass().getName());

            if (process.getClass().getName().equals("java.lang.UNIXProcess")) {
                /* get the PID on unix/linux systems */
                Log.i("OpenCPN", "Fetching PID...");
                try {
                    Field f = process.getClass().getDeclaredField("pid");
                    f.setAccessible(true);
                    pid = f.getLong(process);
                } catch (Throwable e) {
                }
            } else {
                pid = 1;
                Log.i("OpenCPN", "Process:  unknown Class name");
            }


        } catch (Exception e) {
            Log.i("OpenCPN", "createProc6 exception: " + e.getMessage());
            e.printStackTrace();
        }

        String ret = String.valueOf(pid);
        Log.i("OpenCPN", "Process PID: " + ret);
        return ret;
    }


    public String createProcSync(String cmd, String arg1, String arg2, String libPath) {
        Log.i("OpenCPN", "createProc");
        Log.i("OpenCPN", "cmd: " + cmd);
        Log.i("OpenCPN", "arg1: " + arg1);
        Log.i("OpenCPN", "arg2: " + arg2);
        Log.i("OpenCPN", "libPath: " + libPath);

        String cmdExec = cmd;
        if (Build.VERSION.SDK_INT > 28) {
            File cmdFile = new File(cmd);
            cmdExec = m_nativeLibraryDir + "/lib" + cmdFile.getName() + ".so";
        }

        File file = new File(cmdExec);
        if(!file.exists())
            Log.i("OpenCPN", "createProcSync cmd executable does not exist: " + cmdExec);
        else {
            Log.i("OpenCPN", "Setting executable on: " + cmdExec);
            file.setExecutable(true);
        }


        long pid = 0;
        try {
            ProcessBuilder pb = new ProcessBuilder(cmdExec, arg1, arg2);

            Map<String, String> env = pb.environment();
            env.put("LD_LIBRARY_PATH", libPath);

            //env.remove("OTHERVAR");
            //env.put("VAR2", env.get("VAR1") + "suffix");

            //pb.directory(new File("myDir"));
            //File log = new File("log");
            //pb.redirectErrorStream(true);
            //pb.redirectOutput(Redirect.appendTo(log));

            Log.i("OpenCPN", "Process launched as: [" + cmd + "]");
            Process process = pb.start();

            // Reads stdout.
            // NOTE: You can write to stdin of the command using
            //       process.getOutputStream().
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            int read;
            char[] buffer = new char[4096];
            StringBuffer output = new StringBuffer();
            while ((read = reader.read(buffer)) > 0) {
                output.append(buffer, 0, read);
            }
            reader.close();
            String result = output.toString();
            Log.i("OpenCPN", "createProcSync stdout output:\n " + result);


            BufferedReader ereader = new BufferedReader(
                    new InputStreamReader(process.getErrorStream()));
            int eread;
            char[] ebuffer = new char[4096];
            StringBuffer eoutput = new StringBuffer();
            while ((eread = ereader.read(ebuffer)) > 0) {
                eoutput.append(ebuffer, 0, eread);
            }
            ereader.close();

            String eresult = eoutput.toString();
            Log.i("OpenCPN", "createProcSync stderr output:\n " + eresult);


            Log.i("OpenCPN", "\ncreateProcSync Process ClassName: " + process.getClass().getName());

            if (process.getClass().getName().equals("java.lang.UNIXProcess")) {
                /* get the PID on unix/linux systems */
                Log.i("OpenCPN", "Fetching PID...");
                try {
                    Field f = process.getClass().getDeclaredField("pid");
                    f.setAccessible(true);
                    pid = f.getLong(process);
                } catch (Throwable e) {
                }
            } else {
                pid = 1;
                Log.i("OpenCPN", "Process:  unknown Class name");
            }

            process.waitFor();

        } catch (Exception e) {
            Log.i("OpenCPN", "createProcSync exception: " + e.getMessage());
            e.printStackTrace();
        }

        String ret = String.valueOf(pid);
        Log.i("OpenCPN", "createProcSync Process PID: " + ret);
        return ret;

    }


    public String createProcSync4(String cmd, String arg1, String arg2, String arg3, String arg4, String libPath) {
        Log.i("OpenCPN", "createProcSync4");
        Log.i("OpenCPN", "cmd: " + cmd);
        Log.i("OpenCPN", "arg1: " + arg1);
        Log.i("OpenCPN", "arg2: " + arg2);
        Log.i("OpenCPN", "arg3: " + arg3);
        Log.i("OpenCPN", "arg4: " + arg4);
        Log.i("OpenCPN", "libPath: " + libPath);


        String cmdExec = cmd;
        if (Build.VERSION.SDK_INT > 28) {
            File cmdFile = new File(cmd);
            cmdExec = m_nativeLibraryDir + "/lib" + cmdFile.getName() + ".so";
        }

        File file = new File(cmdExec);
        if(!file.exists())
            Log.i("OpenCPN", "createProcSync4 cmd executable does not exist: " + cmdExec);
        else {
            Log.i("OpenCPN", "Setting executable on: " + cmdExec);
            file.setExecutable(true);
        }

        long pid = 0;
        try {
            ProcessBuilder pb = new ProcessBuilder( cmdExec, arg1, arg2, arg3, arg4);

            Map<String, String> env = pb.environment();
            env.put("LD_LIBRARY_PATH", libPath);


            Log.i("OpenCPN", "Process launched as: [" + cmdExec + "]");

            Process process = pb.start();

            // Reads stdout.
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            int read;
            char[] buffer = new char[4096];
            StringBuffer output = new StringBuffer();
            while ((read = reader.read(buffer)) > 0) {
                output.append(buffer, 0, read);
            }
            reader.close();

            String result = output.toString();
            Log.i("OpenCPN", "createProcSync4 cmd output: " + result);

            Log.i("OpenCPN", "Process ClassName: " + process.getClass().getName());

            if (process.getClass().getName().equals("java.lang.UNIXProcess")) {
                /* get the PID on unix/linux systems */
                Log.i("OpenCPN", "Fetching PID...");
                try {
                    Field f = process.getClass().getDeclaredField("pid");
                    f.setAccessible(true);
                    pid = f.getLong(process);
                } catch (Throwable e) {
                }
            } else {
                pid = 1;
                Log.i("OpenCPN", "Process:  unknown Class name");
            }

            process.waitFor();

        } catch (Exception e) {
            Log.i("OpenCPN", "createProcSync4 exception: " + e.getMessage());
            e.printStackTrace();
        }

        String ret = String.valueOf(pid);
        Log.i("OpenCPN", "Process PID: " + ret);
        return ret;

    }


    public String createProcSync5stdout(String cmd, String arg1, String arg2, String arg3, String arg4, String arg5) {

        String cmdExec = cmd;
        if (Build.VERSION.SDK_INT > 28) {
            File cmdFile = new File(cmd);
            cmdExec = m_nativeLibraryDir + "/lib" + cmdFile.getName() +".so";
        }

        File file = new File(cmdExec);
        if(!file.exists())
            Log.i("OpenCPN", "createProcSync5 cmd executable does not exist: " + cmdExec);
        else {
            Log.i("OpenCPN", "Setting executable on: " + cmdExec);
            file.setExecutable(true);
        }

        long pid = 0;
        String result="";
        try {
            ProcessBuilder pb = new ProcessBuilder(cmdExec, arg1, arg2, arg3, arg4, arg5);

            //Log.i("OpenCPN", "Process launched as: [" + cmdExec + "]");

            Process process = pb.start();

            // Reads stdout.
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            int read;
            char[] buffer = new char[4096];
            StringBuffer output = new StringBuffer();
            while ((read = reader.read(buffer)) > 0) {
                output.append(buffer, 0, read);
            }
            reader.close();

            result = output.toString();
            //Log.i("OpenCPN", "createProcSync4stdout cmd output: " + result);

             process.waitFor();

        } catch (Exception e) {
            Log.i("OpenCPN", "createProcSync5stdout exception: " + e.getMessage());

            e.printStackTrace();
        }

        return result;

    }


    public String callFromCpp() {
        Log.i("OpenCPN", "callFromCpp");

        String res = "";
        ///String res = Executer("/data/user/0/org.opencpn.opencpn/oeserverda");
        //String res = Executer("/data/user/0/org.opencpn.opencpn/oeserverda -h");
        //String res = Executer("pwd");
        //String res = Executer("ls -l /data/user/0/org.opencpn.opencpn/lib/*");
        Log.i("OpenCPN", "Process launched");
        Log.i("OpenCPN", "result: " + res);
        return res;
    }


    public String callFromCpp(int pid) {
        //Log.i("DEBUGGER_TAG", "callFromCpp");


        MemoryInfo mi = new MemoryInfo();
        int pids[] = new int[1];
        pids[0] = pid;

        android.os.Debug.MemoryInfo[] memoryInfoArray = activityManager.getProcessMemoryInfo(pids);
        int pss = memoryInfoArray[0].getTotalPss();

        String ret;
        ret = String.format("%d", pss);
        return ret;


    }

    public String getMemInfo(int pid) {
//        Log.i("DEBUGGER_TAG", "getMemInfo");
        int pids[] = new int[1];
        pids[0] = pid;

        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        android.os.Debug.MemoryInfo[] memoryInfoArray = activityManager.getProcessMemoryInfo(pids);
        int pss = memoryInfoArray[0].getTotalPss();

        String ret;
        ret = String.format("%d", pss);
        return ret;
    }


    public native String getJniString();

    public native int test();

    public String getDisplayMetrics() {
        //Log.i("DEBUGGER_TAG", "getDisplayDPI");

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int statusBarHeight = 0;

        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = getResources().getDimensionPixelSize(resourceId);
        }


        int actionBarHeight = 0;
        ActionBar actionBar = getActionBar();
        if (actionBar.isShowing())
            actionBarHeight = actionBar.getHeight();

//            float getTextSize() //pixels
        int width = 600;
        int height = 400;

        Display display = getWindowManager().getDefaultDisplay();


        if (Build.VERSION.SDK_INT >= 13) {

            if (Build.VERSION.SDK_INT >= 17) {
                //Log.i("DEBUGGER_TAG", "VERSION.SDK_INT >= 17");
                width = dm.widthPixels;
                height = dm.heightPixels;
            } else {

                switch (Build.VERSION.SDK_INT) {

                    case 16:
                        //Log.i("DEBUGGER_TAG", "VERSION.SDK_INT == 16");
                        width = dm.widthPixels;
                        height = dm.heightPixels;
                        break;

                    case 15:
                    case 14:
                        Point outPoint = new Point();
                        display.getRealSize(outPoint);
                        if (outPoint != null) {
                            width = outPoint.x;
                            height = outPoint.y;
                        }
                        break;

                    default:
                        width = dm.widthPixels;
                        height = dm.heightPixels;
                        break;

                }
            }
        } else {
            //Log.i("DEBUGGER_TAG", "VERSION.SDK_INT < 13");
            width = display.getWidth();
            height = display.getHeight();
        }


//  In FullScreen immersive mode, height needs a fixup...
        if (m_fullScreen) {
            Point outPoint = new Point();
            display.getRealSize(outPoint);
            if (outPoint != null) {
                width = outPoint.x;
                height = outPoint.y;
            }
            height += statusBarHeight;
        }


        float tsize = new Button(this).getTextSize();       // in pixels

        String ret;

        ret = String.format("%f;%f;%d;%d;%d;%d;%d;%d;%d;%d;%f", dm.xdpi, dm.density, dm.densityDpi,
                width, height - statusBarHeight,
                width, height,
                dm.widthPixels, dm.heightPixels, actionBarHeight, tsize);

        //Log.i("DEBUGGER_TAG", ret);


        return ret;
    }

    public String getDeviceInfo() {
        String s = "Device Info:";
        s += "\n OS Version: " + System.getProperty("os.version") + "(" + Build.VERSION.INCREMENTAL + ")";
        s += "\n OS API Level: " + Build.VERSION.RELEASE + "{" + Build.VERSION.SDK_INT + "}";
        s += "\n OS SDK_INT:" + Build.VERSION.SDK_INT;
        s += "\n Device: " + Build.DEVICE;
        s += "\n Model (and Product): " + Build.MODEL + " (" + Build.PRODUCT + ")";
        s += "\n" + getPackageName();
        s += "\n UUID:" + getUUID(this);
        s += "\n systemName:" + m_systemName;
        s += "\n OCPNRUID:" + getOCPNuniqueID();
        s += "\n OCPNWVID:" +  getOCPNWVID();
        s += "\n SELID:" +  m_selID;
        s += "\n VERSION_CODE:" +  String.valueOf(BuildConfig.VERSION_CODE);
        Log.i("OpenCPN", s);

        return s;
    }


    public String GetLegacyServerdCreds() {

        /*
        These are the interesting offsets in the file
        1.  GUID:           0x48f08
        2.  gsysNames:      0x48f34
        3.  deviceString:   0x4907c
        4.  version string  0x4e020

         */
        String result = ";;";

        int offsetGUID =    0x48f08;
        int offsetsysName = 0x48f34;
        int offsetDevice =  0x4907c;
        int offsetVersion = 0x4e020;

        // Check to see if this result has been found and persisted once before.
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String key = "LegacyoeServerdcreds";
        String LegacyoeserverdCreds = sharedPref.getString(key, null);

        Log.i("OpenCPN", "Creds0: " + LegacyoeserverdCreds);

        if(LegacyoeserverdCreds != null) {
            if (LegacyoeserverdCreds.length() > 4)
                return LegacyoeserverdCreds;
        }


        if(true){

            // Copy the file to private data area
            File sourceFile = new File(getApplicationInfo().dataDir + "/" + "oeaserverda" );
            if(sourceFile.exists() && sourceFile.canRead()) {
                File destinationFile = new File(m_filesDir + "/" + "oeaserverda");

                if (!destinationFile.exists()) {
                    File parentDirectory = destinationFile.getParentFile();
                    if (!parentDirectory.exists())
                        parentDirectory.mkdirs();
                }

                try {
                    InputStream inputStream = new FileInputStream(sourceFile.getAbsolutePath());
                    OutputStream outputStream = new FileOutputStream(m_filesDir + "/" + "oeaserverda");
                    copyFile(inputStream, outputStream);
                    inputStream.close();
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.i("OpenCPN", "GetLegacyServerdCreds ExceptionA");
                }

            }

            // Read the copied file, extracting some values
            File targetFile = new File(m_filesDir + "/" + "oeaserverda");
            if(targetFile.exists()){

                try {
                    InputStream inputStreamTarget = new FileInputStream(targetFile.getAbsolutePath());

                    // Catch the three strings
                    long skipped = inputStreamTarget.skip(offsetGUID);
                    if(skipped == offsetGUID){
                        byte[] buffer = new byte[24000];
                        inputStreamTarget.read( buffer);
                        String uuid = new String(buffer, 0, 36);

                        Log.i("OpenCPN", "Creds01: " + uuid);

                        int i = offsetsysName - offsetGUID;
                        int i0 = 0;
                        String sysName = "";
                        while ((buffer[i] != 0) && (i0 < 32)){
                            sysName += (char)buffer[i];
                            i++;
                            i0++;
                        }

                        Log.i("OpenCPN", "Creds02: " + sysName);

                        i = offsetDevice - offsetGUID;
                        i0 = 0;
                        String device = "";
                        while ((buffer[i] != 0) && (i0 < 32)){
                            device += (char)buffer[i];
                            i++;
                            i0++;
                        }
                        Log.i("OpenCPN", "Creds03: " + device);


                        // Check the version string
                        i = offsetVersion - offsetGUID;
                        i0 = 0;
                        String version = "";
                        while ((buffer[i] != 0) && (i0 < 4)){
                            version += (char)buffer[i];
                            i++;
                            i0++;
                        }

                        Log.i("OpenCPN", "Creds04: " + version);

                        if(version.startsWith("1.10")) {
                            result = uuid + ";" + sysName + ";" + device;

                            Log.i("OpenCPN", "Creds1: " + result);

                            // A good result, so persist it across app starts
                            SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putString(key, result);
                            editor.apply();
                        }
                        Log.i("OpenCPN", "Creds2: " + result);

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    Log.i("OpenCPN", "GetLegacyServerdCreds ExceptionB");
                }
            }
        }

        Log.i("OpenCPN", "Creds3: " + result);

        return result;
    }



    public String showBusyCircle() {
        //if(!m_fullScreen)

        {

            mutexC = new Semaphore(0);

            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if (null == ringProgressDialog) {
                        Log.i("OpenCPN", "ShowBusyBuild");
                        ringProgressDialog = new ProgressDialog(QtActivity.this, R.style.MyTheme);
                        ringProgressDialog.setCancelable(false);
                        ringProgressDialog.setProgressStyle(android.R.style.Widget_ProgressBar_Small);

                        Drawable myIcon = getResources().getDrawable(R.drawable.progressbar_custom);
                        ringProgressDialog.setIndeterminateDrawable(myIcon);

                        //  THIS IS IMPORTANT...Keeps the busy spinner from surfacing the hidden navigation buttons.
                        ringProgressDialog.getWindow().setFlags(LayoutParams.FLAG_NOT_FOCUSABLE,
                                LayoutParams.FLAG_NOT_FOCUSABLE);
                    }

                    ringProgressDialog.show();

                    mutexC.release();

                }
            });
        }

        // One way to wait for the runnable to be done...
        try {
            //mutexC.acquire();            // Cannot get mutex until runnable above exits.
            mutexC.tryAcquire( 500, MILLISECONDS);            // Cannot get mutex until runnable above exits.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        String ret = "";
        return ret;
    }

    public String hideBusyCircle() {

        //if (null == ringProgressDialog) {
        //    return "";
        //}

        mutexC = new Semaphore(0);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                if (null != ringProgressDialog) {
                    //if(ringProgressDialog.isShowing ())
                    {
                        Log.i("OpenCPN", "ShowBusyDismiss");
                        ringProgressDialog.dismiss();
                    }
                }

                mutexC.release();
            }
        });

        // One way to wait for the runnable to be done...
        try {
            //mutexC.acquire();            // Cannot get mutex until runnable above exits.
            mutexC.tryAcquire( 500, MILLISECONDS);            // Cannot get mutex until runnable above exits.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String ret = "";
        return ret;
    }


    public String setRouteAnnunciator(final int viz) {
        //Log.i("DEBUGGER_TAG", "setRouteAnnunciator");

        m_showRouteAnnunciator = (viz != 0);

//    if( null != itemRouteAnnunciator)
        {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {

//                    itemRouteAnnunciator.setVisible(viz != 0);
                    QtActivity.this.invalidateOptionsMenu();

                }
            });

            return "OK";
        }
//     else
//        return "NO";
    }

    private boolean m_showAction = false;

    public String setFollowIconState(final int state) {
        m_nFollowState = state;


        runOnUiThread(new Runnable() {
            @Override
            public void run() {


                QtActivity.this.invalidateOptionsMenu();

            }
        });

        // testing playSound("/data/data/org.opencpn.opencpn/files/sounds/2bells.wav");

        m_showAction = (state != 0);

        return "OK";
    }

    public String setTrackIconState(final int isActive) {
        m_isTrackActive = (isActive != 0);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {


                QtActivity.this.invalidateOptionsMenu();

            }
        });

        return "OK";
    }


    public String setBackButtonState(final int isActive) {
        Log.i("OpenCPN", "setBackButtonState" + isActive);
        m_backButtonEnable = (isActive != 0);
        return "OK";
    }


    public String enableOptionItemAction(final int enable) {
        Log.i("OpenCPN", "enableOptionItemAction" + enable);
        m_optionsItemActionEnable = (enable != 0);

        return "OK";
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void registerNetworkCallback()
    {
        if(connectivityManager == null)
            return;
        try {

            connectivityManager.registerDefaultNetworkCallback(new ConnectivityManager.NetworkCallback() {
                @Override
                public void onAvailable(Network network) {
                    enableMulticast( 1 );
                    Log.e("OpenCPN", "The default network is now: " + network);
                }

                @Override
                public void onLost(Network network) {
                    Log.e("OpenCPN", "The application no longer has a default network. The last default network was " + network);
                }

                @Override
                public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                    //Log.e("OpenCPN", "The default network changed capabilities: " + networkCapabilities);
                }

                @Override
                public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
                    //Log.e("OpenCPN", "The default network changed link properties: " + linkProperties);
                }
            });
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public String enableMulticast( final int param) {
        if (wifi != null) {
            Log.e("OpenCPN", "Create multicastLock");

            m_multicastlock = wifi.createMulticastLock("mylock");
            m_multicastlock.setReferenceCounted(true);
            m_multicastlock.acquire();
        }
        return "OK";
    }


    public String lastCallOnInit( final int param) {
        // Do all those things necessary after app initialization, and make ready to run

        enableMulticast( 1 );

        return "OK";
    }

    public String queryGPSServer(final int parm) {
        Log.i("OpenCPN", "queryGPSServer");

        if (GPSServer.GPS_PROVIDER_AVAILABLE == parm) {
            String ret_string = "NO";
            if (m_hasGPS)
                ret_string = "YES";

            Log.i("OpenCPN", "Available: " + ret_string);

            return ret_string;
        }

        if (parm == GPSServer.GPS_ON) {
            if (Build.VERSION.SDK_INT >= 23) {
                Log.i("OpenCPN", "Checking GPS permissions");

                if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                    // Permission is not already granted
                    // No explanation needed, we can request the permission.
                    if (!m_GPSPermissionRequested) {
                        requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
                        m_GPSPermissionRequested = true;
                        Log.i("OpenCPN", "Requesting GPS permissions");

                    }

                    return "PENDING";

                    // MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION is an
                    // app-defined int constant. The callback method gets the
                    // result of the request.

                } else {
                    // Permission has already been granted
                    Log.i("OpenCPN", "GPS permissions already granted");
                }
            }

            if (!m_GPSServiceStarted) {
                Log.i("OpenCPN", "Starting GPS Server");
                Intent intent = new Intent(this, GPSServer.class);
                startService(intent);
                m_gpsServerActionPending = true;
                m_gpsServerPendingParm = parm;
                getApplicationContext().bindService(intent, GPSconnection, Context.BIND_AUTO_CREATE);
            }

            m_gpsOn = true;

        }
        if (parm == GPSServer.GPS_OFF) {
            m_gpsOn = false;
        }

        if (m_GPSServiceStarted){
            Log.i("OpenCPN", "Invoking GPS Server.doService");
            return m_GPSServer.doService(parm);
        }
        else{
            Log.i("OpenCPN", "GPS Server.doService pending...");
            return "PENDING";
        }
    }

    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        Log.i("OpenCPN", "onRequestPermissionsResult");
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (!m_GPSServiceStarted) {
                        Log.i("OpenCPN", "Starting GPS Server in onRequestPermissionsResult");
                        Intent intent = new Intent(this, GPSServer.class);
                        startService(intent);
                        m_gpsServerActionPending = true;
                        m_gpsServerPendingParm = GPSServer.GPS_ON;
                        getApplicationContext().bindService(intent, GPSconnection, Context.BIND_AUTO_CREATE);
                   }
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Log.i("OpenCPN", "GPS permission denied in onRequestPermissionsResult");
                }
                return;
            }
            // other 'case' lines to check for other
            // permissions this app might request
            case MY_PERMISSIONS_REQUEST_WRITE_STORAGE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // task you need to do.
                    Log.i("OpenCPN", "MY_PERMISSIONS_REQUEST_WRITE_STORAGE permission granted");

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Log.i("OpenCPN", "MY_PERMISSIONS_REQUEST_WRITE_STORAGE permission denied");
                }
                return;
            }

        }
    }


    public String hasBluetooth(final int parm) {
        String ret = "Yes";
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            ret = "No";
        }

        return ret;
    }

    public boolean isBluetoothPermissionOK() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if ((ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_DENIED) ||
                    (ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_SCAN) == PackageManager.PERMISSION_DENIED)) {
                return FALSE;
            }
        }
        return TRUE;
    }

    public String startBlueToothScan(final int parm) {
        Log.i("DEBUGGER_TAG", "startBlueToothScan");

        if (!isBluetoothPermissionOK()){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                ActivityCompat.requestPermissions( this,
                        new String[]{Manifest.permission.BLUETOOTH_CONNECT,
                                     Manifest.permission.BLUETOOTH_SCAN},
                        2);


            }
            return "OK";
        }

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                if (!m_ScanHelperStarted) {
                    scanHelper = new BTScanHelper(QtActivity.this);
                    m_ScanHelperStarted = true;
                }

                scanHelper.doDiscovery();

            }
        });


        return ("OK");

    }

    public String stopBlueToothScan(final int parm) {
//        Log.i("DEBUGGER_TAG", "stopBlueToothScan");
        if (!isBluetoothPermissionOK())
            return "NOK";

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                if (m_ScanHelperStarted) {
                    scanHelper.doDiscovery();
                    scanHelper.stopDiscovery();
                }


            }
        });


        return ("OK");

    }

    public String getBlueToothScanResults(final int parm) {
        String ret_str = "";

        if (!isBluetoothPermissionOK())
            return ret_str;

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                if (!m_ScanHelperStarted) {
                    scanHelper = new BTScanHelper(QtActivity.this);
                    m_ScanHelperStarted = true;
                }


            }
        });

        if (m_ScanHelperStarted)
            ret_str = scanHelper.getDiscoveredDevices();
        ;

//        Log.i("DEBUGGER_TAG", "results");
//        Log.i("DEBUGGER_TAG", ret_str);

        return ret_str;


    }


    public String startBTService(final String address) {
        Log.i("DEBUGGER_TAG", "startBTService");
        Log.i("DEBUGGER_TAG", address);
        m_BTStat = "Unknown";

        if(m_BTServiceCreated && m_BTSPP.isServiceAvailable() && (m_BTSPP.getServiceState() == BluetoothState.STATE_CONNECTED) ){
            return "OK";
        }

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

///
                if (!m_BTServiceCreated) {
//                    Log.i("DEBUGGER_TAG", "Bluetooth createBTService");
                    m_BTSPP = new BluetoothSPP(getApplicationContext());

                    if (!m_BTSPP.isBluetoothAvailable() || !m_BTSPP.isBluetoothEnabled()) {
                        //                           Toast.makeText(getApplicationContext()
                        //                                           , "Bluetooth is not available"
                        //                                           , Toast.LENGTH_SHORT).show();
                    } else {
                        m_BTSPP.setupService();
                        m_BTServiceCreated = true;
                    }
                }


                m_BTSPP.setOnDataReceivedListener(new OnDataReceivedListener() {
                    public void onDataReceived(byte[] data, String message) {
//                        Log.i("DEBUGGER_TAG", message);
                        // Do something when data incoming
                        nativeLib.processBTNMEA(message);

                    }
                });

                if (m_BTSPP.isServiceAvailable()) {
//                    Log.i("DEBUGGER_TAG", "Bluetooth startService");
                    m_BTSPP.startService(BluetoothState.DEVICE_OTHER);

//                    Log.i("DEBUGGER_TAG", "Bluetooth connectA");
//                    m_BTSPP.connect(address);
                    m_BTSPP.resetAutoConnect();
                    m_BTSPP.autoConnectAddress(address);

                }

                if (!m_BTSPP.isBluetoothEnabled())
                    m_BTStat = "NOK.BTNotEnabled";
                else if (!m_BTSPP.isServiceAvailable())
                    m_BTStat = "NOK.ServiceNotAvailable";
                else
                    m_BTStat = "OK";


            }
        });


        Log.i("DEBUGGER_TAG", "startBTService return: " + m_BTStat);
        return m_BTStat;
    }


    public String stopBTService(final int parm) {
        Log.i("DEBUGGER_TAG", "stopBTService");
        String ret_str = "";

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                if (m_BTServiceCreated) {
                    Log.i("DEBUGGER_TAG", "Bluetooth stopService");
                    m_BTSPP.stopService();
                }


            }
        });

        ret_str = "OK";
        return ret_str;
    }

    public String sendBTMessage(final String message) {
        Log.i("DEBUGGER_TAG", "sendBTMessage: " + message);


        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                if (m_BTServiceCreated) {
                    m_BTSPP.send(message, false);
                }


                if (!m_BTSPP.isBluetoothEnabled())
                    m_BTStat = "NOK.BTNotEnabled";
                else if (!m_BTSPP.isServiceAvailable())
                    m_BTStat = "NOK.ServiceNotAvailable";
                else
                    m_BTStat = "OK";


            }
        });


        return m_BTStat;
    }


    public String scanSerialPorts(final int parm) {

        String ret_str = "";
        if (null != uSerialHelper) {
            ret_str = uSerialHelper.scanSerialPorts(parm);
        }

        m_scannedSerial = ret_str;
        return ret_str;
    }


    public String startSerialPort(final String name, final String baudRate) {

        String ret_str = "";
        if (null != uSerialHelper) {
            ret_str = uSerialHelper.startUSBSerialPort(name, Integer.parseInt(baudRate));
        }

        return ret_str;
    }

    public String stopSerialPort(final String name) {

        String ret_str = "";
        if (null != uSerialHelper) {
            ret_str = uSerialHelper.stopUSBSerialPort(name);
        }

        return ret_str;
    }

    public String writeSerialPort(final String name, final String message){
        if(uSerialHelper == null)
            return "NOK";
        return uSerialHelper.writeUSBSerialPort(name, message);

    }

    private Semaphore mutex = new Semaphore(0);
    private Semaphore mutexC = new Semaphore(0);
    private Query m_query = new Query();


    public String downloadFileDM(final String url, final String destination) {
        m_downloadRet = "";
        Log.i("OpenCPN", url);
        Log.i("OpenCPN", destination);

/*
        //  Delete any existing file of the same name.
        Uri fURI = Uri.parse(destination);
        try{
            File f = new File(fURI.getPath());
            if(f.exists())
                f.delete();
       }catch (Exception e) {
       }
*/
        if (downloadBCReceiver == null) {
            downloadBCReceiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    String action = intent.getAction();
                    Log.i("OpenCPN", "onReceive: " + action);

                    if (DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(action)) {
                        long downloadId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, 0);

                        m_query = new Query();
                        m_query.setFilterById(m_enqueue);
                        Cursor c = m_dm.query(m_query);


                        if (c.moveToFirst()) {
                            String uriString = c.getString(c.getColumnIndex(DownloadManager.COLUMN_URI));

                            int columnIndex = c.getColumnIndex(DownloadManager.COLUMN_STATUS);
                            if (DownloadManager.STATUS_SUCCESSFUL == c.getInt(columnIndex)) {
                                Log.i("OpenCPN", "Download successful " + downloadId + m_enqueue);
                                String totalBytes = c.getString(c.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));
                                Log.i("OpenCPN", "totalBytes: " + totalBytes);

                            }

                            nativeLib.setDownloadStatus(c.getInt(columnIndex), uriString);


                        }
                        c.close();
                    }
                }
            };
        }

        registerReceiver(downloadBCReceiver, new IntentFilter(
                DownloadManager.ACTION_DOWNLOAD_COMPLETE));


        mutex = new Semaphore(0);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                m_dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);

                Request request = new Request(Uri.parse(url));
                request.setDestinationUri(Uri.parse(destination));

                Log.i("OpenCPN", "enqueue");
                m_downloadRet = "PENDING";
                try {
                    m_enqueue = m_dm.enqueue(request);
                    String result = "OK;" + String.valueOf(m_enqueue);
                    Log.i("OpenCPN", result);
                    m_downloadRet = result;
                } catch (Exception e) {
                    m_downloadRet = "NOK";
                    Log.i("OpenCPN", "exception: " + e.getMessage());
                }


                mutex.release();


            }
        });

        // One way to wait for the runnable to be done...
        try {
            mutex.acquire();            // Cannot get mutex until runnable above exits.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Log.i("OpenCPN", "m_downloadRet " + m_downloadRet);
        return m_downloadRet;
    }

    public String getDownloadStatusDM(final int ID) {
        Log.i("OpenCPN", "getDownloadStatus " + String.valueOf(ID));

        String ret = "NOSTAT";
        if (m_dm != null) {

            m_query.setFilterById(ID);
            Cursor c = m_dm.query(m_query);

            if (c.moveToFirst()) {
                int columnIndex = c.getColumnIndex(DownloadManager.COLUMN_STATUS);
                int stat = c.getInt(columnIndex);
                String sstat = String.valueOf(stat);

                String sofarBytes = c.getString(c.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));
                String totalBytes = c.getString(c.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));

                ret = sstat + ";" + sofarBytes + ";" + totalBytes;

            }
            c.close();

        }

        Log.i("OpenCPN", ret);
        return ret;
    }


    public String cancelDownload(final int ID) {
        Log.i("OpenCPN", "cancelDownload " + String.valueOf(ID));
        if (m_dm != null) {
            m_dm.remove(ID);
        }

        return "OK";
    }


    public String doHttpPostSync(final String turl, final String encodedData) {

        Log.i("OpenCPN", "POST parms: " + encodedData);

        HttpURLConnection urlc = null;
        OutputStreamWriter out = null;
        DataOutputStream dataout = null;
        BufferedReader in = null;
        String result = "";

        try {
            URL url = new URL(turl);
            urlc = (HttpURLConnection) url.openConnection();
            urlc.setRequestMethod("POST");
            urlc.setDoOutput(true);
            urlc.setDoInput(true);
            urlc.setUseCaches(false);
            urlc.setAllowUserInteraction(false);
            //urlc.setRequestProperty(HEADER_USER_AGENT, HEADER_USER_AGENT_VALUE);
            urlc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            dataout = new DataOutputStream(urlc.getOutputStream());

            // perform POST operation
            dataout.writeBytes(encodedData);

            int responseCode = urlc.getResponseCode();
            Log.i("OpenCPN", "Response code: " + Integer.toString(responseCode));

            in = new BufferedReader(new InputStreamReader(urlc.getInputStream()), 8096);
            String response;
            // write html to System.out for debug
            while ((response = in.readLine()) != null) {
                Log.i("OpenCPN", response);
                result += response;
            }

            in.close();
            urlc.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
            result = "NOK";
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    result = "NOK";
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    result = "NOK";
                }
            }
        }

        return result;
    }


    class PostTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... arg0) {

            g_postActive = true;
            //Log.i("OpenCPN", "POST url: " + arg0[0]);
            //Log.i("OpenCPN", "POST parms: " + arg0[1]);

            OutputStreamWriter out = null;
            DataOutputStream dataout = null;
            BufferedReader in = null;
            String result = "";

            int timeout = 4950;
            try {
                timeout = Integer.parseInt(arg0[2]);
            } catch (NumberFormatException nfe) {
                // Handle parse error.
                nfe.printStackTrace();
                Log.i("OpenCPN", "Timeout value parse exception");
            }

            try {
                URL url = new URL(arg0[0]);

                // On older devices, we need to explicitly enable TLS v1.2 on https connections

                if((url.getProtocol().equalsIgnoreCase("https")) &&
                    (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT < 22) ){

                    HttpsURLConnection surl = (HttpsURLConnection) url.openConnection();

                    // Force a TLSv1.2 connection
                    MySSLSocketFactory myFact = new MySSLSocketFactory(surl.getSSLSocketFactory());
                    surl.setSSLSocketFactory(myFact);

                    surl.setRequestMethod("POST");
                    surl.setDoOutput(true);
                    surl.setDoInput(true);
                    surl.setUseCaches(false);
                    surl.setAllowUserInteraction(false);
                    //surl.setRequestProperty(HEADER_USER_AGENT, HEADER_USER_AGENT_VALUE);
                    surl.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    surl.setConnectTimeout(timeout);
                    surl.setReadTimeout(timeout);

                    dataout = new DataOutputStream(surl.getOutputStream());

                    // perform POST operation
                    //Log.i("OpenCPN", "doin it...");

                    dataout.writeBytes(arg0[1]);

                    int responseCode = surl.getResponseCode();
                    Log.i("OpenCPN", "AsyncTask HTTPPOST Response code: " + Integer.toString(responseCode));

                    in = new BufferedReader(new InputStreamReader(surl.getInputStream()), 8096);
                    String response;
                    // write html to System.out for debug
                    while ((response = in.readLine()) != null) {
                        //Log.i("OpenCPN", response);
                        result += response;
                    }

                    in.close();
                    surl.disconnect();

                }
                else {
                    HttpURLConnection urlc = null;
                    urlc = (HttpURLConnection) url.openConnection();
                    urlc.setRequestMethod("POST");
                    urlc.setDoOutput(true);
                    urlc.setDoInput(true);
                    urlc.setUseCaches(false);
                    urlc.setAllowUserInteraction(false);
                    //urlc.setRequestProperty(HEADER_USER_AGENT, HEADER_USER_AGENT_VALUE);
                    urlc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    urlc.setConnectTimeout(timeout);
                    urlc.setReadTimeout(timeout);

                    dataout = new DataOutputStream(urlc.getOutputStream());

                    // perform POST operation
                    //Log.i("OpenCPN", "doin it...");

                    dataout.writeBytes(arg0[1]);

                    int responseCode = urlc.getResponseCode();
                    Log.i("OpenCPN", "AsyncTask HTTPPOST Response code: " + Integer.toString(responseCode));

                    in = new BufferedReader(new InputStreamReader(urlc.getInputStream()), 8096);
                    String response;
                    // write html to System.out for debug
                    while ((response = in.readLine()) != null) {
                        //Log.i("OpenCPN", response);
                        result += response;
                    }

                    in.close();
                    urlc.disconnect();
                }

            } catch (IOException e) {
                e.printStackTrace();
                Log.i("OpenCPN", "AsyncTask IOException 1", e);
                result = "NOK";
            } finally {
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        Log.i("OpenCPN", "AsyncTask IOException 2", e);
                        result = "NOK";
                    }
                }
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        Log.i("OpenCPN", "Exception 3", e);
                        result = "NOK";
                    }
                }
            }

            //Log.i("OpenCPN", "async result: " + result);

            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);

            g_postResult = result;
            g_postActive = false;
        }
    }


    public String doHttpPostAsync(final String url, final String encodedData, final String timeoutMsec) {
        //Log.i("OpenCPN", "doHttpPostAsync start ");
        // Clear the data
        g_postActive = false;
        g_postResult = "";

        new PostTask().execute(url, encodedData, "20000");

        return "OK";
    }

    public String checkPostAsync() {
        if (g_postActive)
            return "ACTIVE";
        else
            return g_postResult;
    }


    /*
        public String doHttpPostX( final String url, final String parameters ){

            // Creating an instance of HttpClient.

              HttpClient httpclient = new DefaultHttpClient();
              try {

                   // Creating an instance of HttpPost.
                   HttpPost httpost = new HttpPost( url );

               // Extract the parameters
               // Adding all form parameters in a List of type NameValuePair
                    //Log.i("OpenCPN", "POST parms: " + parameters);
                    List<NameValuePair> nvps = new ArrayList<NameValuePair>();

                    StringTokenizer tkz = new StringTokenizer(parameters, ";");

                    while(tkz.hasMoreTokens()){
                        String p0 = tkz.nextToken();
                        String p1 = tkz.nextToken();
                        //Log.i("OpenCPN", "parms: " + p0 + "  " + p1);
                        nvps.add(new BasicNameValuePair(p0, p1));
                    }


                    try{
                        httpost.setEntity(new UrlEncodedFormEntity(nvps));
                    }catch(Exception e) {
                        e.printStackTrace();
                    }


               // Executing the request.
                    HttpResponse response = httpclient.execute(httpost);

                    //Log.i("OpenCPN", "POST Response Status line :" + response.getStatusLine());

                    try {
                        // Do the needful with entity.
                        HttpEntity entity = response.getEntity();

                        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

                        StringBuffer result = new StringBuffer();
                        String line = "";
                        while ((line = rd.readLine()) != null) {
                            //Log.i("OpenCPN", line);
                            result.append(line);
                        }

                     }catch(Exception e) {
                         e.printStackTrace();
                     }
               }catch(Exception e) {
                   e.printStackTrace();
               }

               return "OK";
           }


    */

    public String validateWriteLocation( final String destination, final String dummy, final int chainCode, final int dummyInt) {

        Uri fURI = Uri.parse(destination);
        String destPath = "";
        try {
            destPath = fURI.getPath();
        } catch (Exception e) {
        }

        Log.i("OpenCPN", "validateWriteLocation parsed destination: " + destPath);

        // We validate write access to the destination directory
        File dest = new File(destPath);
        File destDir = dest.getParentFile();

        DocumentFile dir = null;

        //  Is destination on an SDCard?
        String sdRoot = "";
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {

            sdRoot = getExtSdCardFolder(dest);
            if (null != sdRoot) {
                if (null != sdRoot) {
                    if (Build.VERSION.SDK_INT >= 30) {      // Android 11 does not need permission to write on private dir
                        File xfiles[] = getExternalFilesDirs( null );
                        if (xfiles.length > 1){
                            String sdHome = "";
                            try {
                                sdHome = xfiles[1].getCanonicalPath();
                            } catch (Exception e) {
                            }

                            if(destPath.startsWith(sdHome)){
                                return "OK";
                            }
                        }
                    }

/*
                    DocumentFile pickedDir = null;
                    List<UriPermission> permissions = getContentResolver().getPersistedUriPermissions();
                    if (permissions != null && permissions.size() > 0) {
                        for (int i = 0; i < permissions.size(); i++) {
                            Uri test = permissions.get(i).getUri();
                             //String permissionTreeId = DocumentsContract.getTreeDocumentId(permissions.get(i).getUri());
                            //String uriTreeId = DocumentsContract.getTreeDocumentId(fURI);
                            pickedDir = DocumentFile.fromTreeUri(this, permissions.get(i).getUri());
                        }

                        //DocumentFile file = pickedDir.createFile("text/plain", "try2.txt");
                    }
*/
                    dir = getDocumentFile(destDir, true, false);

                    if (null == dir) {
                        Log.i("OpenCPN", "validateWriteLocation Needs to startSAF OCPN_SAF_DIALOG_DL_REQUEST_CODE");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                startSAFDialog(OCPN_SAF_DIALOG_DL_REQUEST_CODE);
                            }
                        });

                        return "Pending";

                    }
                }
            }
        }

        return "OK";
    }


    public String downloadFile(final String url, final String destination) {

        Log.i("OpenCPN", "downloadFile " + url + " to " + destination);

        m_downloadURL = url;
        m_downloadStatus = 1;       //STATUS_PENDING
        m_downloadTotal = 0;

        Uri fURI = Uri.parse(destination);
        String destPath = "";
        try {
            destPath = fURI.getPath();
        } catch (Exception e) {
        }

        Log.i("OpenCPN", "downloadFile parsed destination: " + destPath);

        // We validate write access to the destination directory
        File dest = new File(destPath);
        File destDir = dest.getParentFile();

        DocumentFile dir = null;
        boolean buseDocFile = false;

        //  Is destination on an SDCard?
        String sdRoot = "";
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {

            sdRoot = getExtSdCardFolder(dest);
            if (null != sdRoot) {
                Log.i("OpenCPN", "downloadFile destination on SDCard");

                if (Build.VERSION.SDK_INT >= 30) {      // Android 11 does not need permission to write on private dir
                    File xfiles[] = getExternalFilesDirs(null);
                    if (xfiles.length > 1) {
                        String sdHome = "";
                        try {
                            sdHome = xfiles[1].getCanonicalPath();
                        } catch (Exception e) {
                        }

                        if (destPath.startsWith(sdHome))
                            buseDocFile = false;
                    }
                }

                else {
                    buseDocFile = true;
                }
            }
        }

        Log.i("OpenCPN", "downloadFile writeable OK, starting service intent...");


        Intent intent = new Intent(this, DownloadService.class);
        intent.putExtra("url", url);
        intent.putExtra("file", destination);
        intent.putExtra("receiver", mReceiver);
        intent.putExtra("useDocFile", buseDocFile);

        startService(intent);

        //Log.i("OpenCPN", "RET OK");
        return "OK;77";
    }


    public String getDownloadStatus(final int ID) {

        String ret = "NOSTAT";

        String sstat = String.valueOf(m_downloadStatus);
        ret = sstat + ";" + m_downloadTotal + ";" + m_downloadFilelength;

        Log.i("OpenCPN", "getDownloadStatus " + String.valueOf(ID) + " " + ret);
        return ret;
    }

    private int m_downloadTotal;
    private int m_downloadFilelength;
    private int m_downloadStatus;
    private String m_downloadURL;


    @Override
    public void onReceiveResult(int resultCode, Bundle resultData) {
        //super.onReceiveResult(resultCode, resultData);
        if (resultCode == DownloadService.UPDATE_PROGRESS) {

            int progress = resultData.getInt("progress");

            m_downloadTotal = resultData.getInt("sofar");
            m_downloadFilelength = resultData.getInt("filelength");
            m_downloadStatus = 2;           // STATUS_RUNNING

//            Log.i("OpenCPN", "UPDATE_PROGRESS " + m_downloadTotal + " " + m_downloadFilelength + " " + progress);

            //mProgressDialog.setProgress(progress);
            //if (progress == 100) {
            //    mProgressDialog.dismiss();

            nativeLib.setDownloadStatus(m_downloadStatus, m_downloadURL);

        }
        if (resultCode == DownloadService.DOWNLOAD_DONE) {
            m_downloadTotal = resultData.getInt("sofar");
            m_downloadFilelength = resultData.getInt("filelength");
            m_downloadStatus = 8;           // STATUS_SUCCESSFUL
            if (0 == m_downloadTotal)
                m_downloadStatus = 16;      // STATUS_ERROR

            nativeLib.setDownloadStatus(m_downloadStatus, m_downloadURL);
            Log.i("OpenCPN", "DOWNLOAD_DONE " + m_downloadStatus + " " + m_downloadTotal + " " + m_downloadTotal + " " + m_downloadFilelength);
        }

        if (resultCode == UnzipService.UNZIP_DONE) {
            Log.i("OpenCPN", "UNZIP_DONE ");
            m_unzipDone = true;
        }

        if (resultCode == UnzipService.UNZIP_FILE) {
            Log.i("OpenCPN", "UNZIP_FILE ");
            String lastFile = resultData.getString("lastFile");
            m_unzipLastFile = lastFile;
            Log.i("OpenCPN", "UNZIP_FILE: " + m_unzipLastFile);
        }

        if (resultCode == UnzipService.TOPDIR) {
            unzipTopDir = resultData.getString("topDir");
        }


    }

    private boolean m_unzipDone;

    public String unzipFile(final String source, final String destination, String nStrip, String bRemoveZip) {

        Log.i("OpenCPN", "unzipFile " + source + " to " + destination);

        Intent intent = new Intent(this, UnzipService.class);
        intent.putExtra("sourceZip", source);
        intent.putExtra("targetDir", destination);
        intent.putExtra("receiver", mReceiver);
        intent.putExtra("nStrip", Integer.parseInt(nStrip));
        intent.putExtra("removeZip", Integer.parseInt(bRemoveZip));
        m_unzipDone = false;

        startService(intent);
        return "OK;78";

    }

    public String getUnzipStatus(String dummy) {
        if (m_unzipDone)
            return "UNZIPDONE " + unzipTopDir;
        else
            return m_unzipLastFile;
    }



    public String isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        // test for connection
        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable()
                && cm.getActiveNetworkInfo().isConnected()) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public String getGMAPILicense() {
        String ret = "";

/*        GoogleApiAvailability av = GoogleApiAvailability.getInstance();
        if(av != null)
            ret = av.getOpenSourceSoftwareLicenseInfo (this);
*/
        return ret;
    }


     /**
     * Play the given file, invoking onSoundDone when completed.
     * the next from the list
     *
     * @param fileName: the file name to start playing from it
     * @param sound: String representation of a opaque pointer handled
     *        to onSoundDone()
     */
    public String playSound(final String fileName, final String sound) {
        Log.i("DEBUGGER_TAG", "playSound " + fileName);
        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        }

        if (mediaPlayer != null) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        mediaPlayer.reset();
                        mediaPlayer.setDataSource(fileName);
                        mediaPlayer.prepare();
                        mediaPlayer.setOnCompletionListener(
                                new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        BigInteger soundcb = new BigInteger( sound, 16);
                                        long ptr = soundcb.longValue();
                                        nativeLib.onSoundDone(ptr);
                                    }
                                }
                        );
                        //Log.i("DEBUGGER_TAG", "playSoundStart");
                        mediaPlayer.start();
                    } catch (Exception e) {
                        // TODO: Remove this error checking before publishing
                    }
                }});

        }
        return "OK";
    }


    public String FileChooserDialog(final String initialDir, final String Title, final String Suggestion, final String wildcard) {
        Log.i("OpenCPN", "FileChooserDialog");
        Log.i("OpenCPN", initialDir);
        Log.i("OpenCPN", Suggestion);

        m_FileChooserDone = false;

        boolean buseDialog = true;
        if (!buseDialog) {
            Intent intent = new Intent(this, FileChooserActivity.class);

            File target = new File(initialDir);
            if(target.canWrite())
                intent.putExtra(FileChooserActivity.INPUT_START_FOLDER, initialDir);
            else
                intent.putExtra(FileChooserActivity.INPUT_START_FOLDER, getExternalFilesDir( null ).getPath() );

            intent.putExtra(FileChooserActivity.INPUT_FOLDER_MODE, false);
            intent.putExtra(FileChooserActivity.INPUT_SHOW_FULL_PATH_IN_TITLE, true);
            intent.putExtra(FileChooserActivity.INPUT_TITLE_STRING, Title);


            //  Creating a file?
            if (!Suggestion.isEmpty()) {
                //Log.i("OpenCPN", "FileChooserDialog Creating");
                intent.putExtra(FileChooserActivity.INPUT_CAN_CREATE_FILES, true);
            }

            this.startActivityForResult(intent, OCPN_AFILECHOOSER_REQUEST_CODE);
            return "OK";

        }

        //Log.i("DEBUGGER_TAG", "FileChooserDialog create and show " + initialDir);

        Thread thread = new Thread() {
            @Override
            public void run() {

                // Block this thread for 20 msec.
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                }

// After sleep finishes blocking, create a Runnable to run on the UI Thread.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String startDir = initialDir;

                        File target = new File(initialDir);
                        if(!target.canWrite())
                            startDir = getExternalFilesDir( null ).getPath();

                        FileChooserDialog dialog = new FileChooserDialog(m_activity, startDir);

                        dialog.setShowFullPath(true);
                        dialog.setTitle(Title);

                        //  Creating a file?
                        if (!Suggestion.isEmpty()) {
                            Log.i("OpenCPN", "FileChooserDialog CanCreate");
                            dialog.setCanCreateFiles(true);
                        }

                        dialog.addListener(new FileChooserDialog.OnFileSelectedListener() {
                            public void onFileSelected(Dialog source, File file) {
                                source.hide();
                                //Toast toast = Toast.makeText(source.getContext(), "File selected: " + file.getName(), Toast.LENGTH_LONG);
                                //toast.show();
                                Log.i("OpenCPN", "FileChooserDialog selected: " + file.getName());

                                m_filechooserString = "file:" + file.getPath();
                                m_FileChooserDone = true;

                            }

                            public void onFileSelected(Dialog source, File folder, String name) {
                                source.hide();
                                //Toast toast = Toast.makeText(source.getContext(), "File created: " + folder.getName() + "/" + name, Toast.LENGTH_LONG);
                                //toast.show();
                                Log.i("OpenCPN", "Listener: FileChooserDialog created: " + folder.getName() + "/" + name);

                                m_filechooserString = "file:" + folder.getPath() + "/" + name;

                                final File newFile = new File(folder.getPath() + File.separator + name);
                                if (!folder.canWrite()) {
                                    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
                                        Log.i("OpenCPN", "FileChooserDialog listener needs SAF dialog");

                                        //  Is this on an SDCard?
                                        String sdRoot = getExtSdCardFolder(folder);
                                        if (null != sdRoot) {
                                            Log.i("OpenCPN", "FileChooserDialog listener found sdCard");

                                            // This will NOT create the file
                                            DocumentFile f = getDocumentFile(folder, true, false);
                                            if (null == f) {
                                                startSAFDialog(OCPN_SAF_DIALOG_A_REQUEST_CODE);
                                                return;
                                            }
                                        }
                                    }
                                }

                                m_FileChooserDone = true;

                            }
                        });

                        dialog.setOnCancelListener(new OnCancelListener() {
                            public void onCancel(DialogInterface dialog) {
                                Log.i("OpenCPN", "FileChooserDialog Cancel");
                                m_filechooserString = "cancel:";
                                m_FileChooserDone = true;
                            }
                        });


                        dialog.setCanCreateFiles(true);
                        dialog.show();

                        //Log.i("DEBUGGER_TAG", "FileChooserDialog Back from show");

                    }
                });
            }
        };

        // Don't forget to start the thread.
        thread.start();

        //Log.i("DEBUGGER_TAG", "FileChooserDialog Returning");

        return "OK";
    }

    public String doColorPickerDialog(final int initialColor) {
        m_ColorDialogDone = false;


        Log.i("OpenCPN", "ColorPicker create and show " + initialColor);

        Thread thread = new Thread() {
            @Override
            public void run() {

                // Block this thread for 20 msec.
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                }

// After sleep finishes blocking, create a Runnable to run on the UI Thread.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        final ColorPickerDialog dialog = new ColorPickerDialog(m_activity, initialColor) {

                            @Override
                            public void onOK(int selectedColor) {
                                String strI = String.valueOf(selectedColor);
                                Log.i("DEBUGGER_TAG", "Activity on OK button Color: " + strI);
                                m_ColorDialogString = "color:" + strI;
                                m_ColorDialogDone = true;

                                // do something
                            }

                            @Override
                            public void onCancel() {
                                Log.i("DEBUGGER_TAG", "Activity on Cancel Color: ");
                                m_ColorDialogString = "cancel:";
                                m_ColorDialogDone = true;
                                // do something
                            }
                        };


//                        dialog.setTitle( Title );


                        dialog.show();

                        Log.i("DEBUGGER_TAG", "ColorPickerDialog Back from show");

                    }
                });
            }
        };

        // Don't forget to start the thread.
        thread.start();

        Log.i("DEBUGGER_TAG", "ColorPickerDialog Returning");

        return "OK";
    }

    public String isColorPickerDialogFinished() {
        Log.i("DEBUGGER_TAG", "poll");

        if (m_ColorDialogDone) {
            Log.i("DEBUGGER_TAG", "done");
            return m_ColorDialogString;
        } else {
            return "no";
        }
    }


    public String DirChooserDialog(final String initialDir, final String Title, final int addFile, final int spare) {
        m_FileChooserDone = false;

        // Take this chance to prebuild the SDCard "Charts" directory, if not already present.
        if (Build.VERSION.SDK_INT >= 30) {
            File[] files = getExternalFilesDirs(null);
            if(files.length > 1) {
                if (files[1] != null) {
                    String sdCharts = files[1].getPath() + "/Charts";
                    File sdChartsFile = new File(sdCharts);
                    if (!sdChartsFile.exists()) {
                        try {
                            sdChartsFile.mkdir();
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }

        boolean buseDialog = (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP);        //false;
        if (!buseDialog) {
            //Intent intent = new Intent(this, FileChooserActivity.class);
            //intent.putExtra(FileChooserActivity.INPUT_START_FOLDER, initialDir);
            //intent.putExtra(FileChooserActivity.INPUT_FOLDER_MODE, true);

            //this.startActivityForResult(intent, OCPN_AFILECHOOSER_REQUEST_CODE);
            //return "OK";

            Log.i("OpenCPN", "DirChooserDialog start activity: " + initialDir);

            Bundle b = new Bundle();
            File target = new File(initialDir);
            if(target.canWrite())
                b.putString(FileChooserActivity.INPUT_START_FOLDER, initialDir);
            else
                b.putString(FileChooserActivity.INPUT_START_FOLDER, getExternalFilesDir( null ).getPath() );

            b.putBoolean(FileChooserActivity.INPUT_FOLDER_MODE, true);
            b.putBoolean(FileChooserActivity.INPUT_CAN_CREATE_FILES, true);

            Intent intent = new Intent(this, FileChooserActivity.class);
            intent.putExtras(b);
            startActivityForResult(intent, OCPN_AFILECHOOSER_REQUEST_CODE);
            return "OK";


        }

        Log.i("OpenCPN", "DirChooserDialog create and show " + initialDir);

        Thread thread = new Thread() {
            @Override
            public void run() {

                // Block this thread for 20 msec.
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                }

// After sleep finishes blocking, create a Runnable to run on the UI Thread.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        final FileChooserDialog dialog = new FileChooserDialog(m_activity, initialDir);

                        dialog.setShowFullPath(true);
                        dialog.setFolderMode(true);
                        dialog.setCanCreateFiles(addFile > 0);


                        dialog.setTitle(Title);

                        dialog.addListener(new FileChooserDialog.OnFileSelectedListener() {
                            public void onFileSelected(Dialog source, File file) {
                                source.hide();
                                //Toast toast = Toast.makeText(source.getContext(), "File selected: " + file.getName(), Toast.LENGTH_LONG);
                                //toast.show();

                                //Log.i("OpenCPN", "Activity onFileSelectedA: " + file.getPath());
                                m_filechooserString = "file:" + file.getPath();
                                m_FileChooserDone = true;

                            }

                            public void onFileSelected(Dialog source, File folder, String name) {
                                //Log.i("OpenCPN", "Activity onFileSelectedB: " + folder.getPath() +  File.separator + name);

                                File newFolder = new File(folder.getPath() + File.separator + name);
                                boolean success = true;
                                if (!newFolder.exists())
                                    success = newFolder.mkdirs();

                                if (!success) {
                                    Toast toast = Toast.makeText(source.getContext(), "Could not create file in: " + folder.getPath(), Toast.LENGTH_LONG);
                                    toast.show();
                                }

                                dialog.loadFolder(folder.getPath());
                            }

                        });

                        dialog.setOnCancelListener(new OnCancelListener() {
                            public void onCancel(DialogInterface dialog) {
                                Log.i("OpenCPN", "DirChooserDialog Cancel");
                                m_filechooserString = "cancel:";
                                m_FileChooserDone = true;
                            }
                        });


                        dialog.show();

                    }
                });
            }
        };

        // Don't forget to start the thread.
        thread.start();

        //Log.i("DEBUGGER_TAG", "DirChooserDialog Returning");

        return "OK";
    }

    public String isFileChooserFinished() {
        if (m_FileChooserDone) {
            Log.i("OpenCPN", "isFileChooserFinished:  returning " + m_filechooserString);
            return m_filechooserString;
        } else {
            return "no";
        }
    }

    // ActionBar Spinner navigation to select chart display type

    //  Thread safe version, callable from another thread
    public String configureNavSpinnerTS(final int flag, final int sel) {
        Thread thread = new Thread() {
            @Override
            public void run() {

                // Block this thread for 20 msec.
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                }

                // After sleep finished blocking, create a Runnable to run on the UI Thread.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        configureNavSpinner(flag, sel);
                    }
                });
            }
        };

        // Don't forget to start the thread.
        thread.start();

        return "OK";
    }


    public String configureNavSpinner(int flag, int sel) {

        navSpinner.clear();
        int nbits = 0;
        int n93 = -1;
        int nraster = -1;
        int nvector = -1;

        if ((flag & 1) == 1) {
            nraster = nbits;
            navSpinner.add(spinnerItemRaster);
            nbits++;
        }
        if ((flag & 2) == 2) {
            nvector = nbits;
            navSpinner.add(spinnerItemVector);
            nbits++;
        }
        if ((flag & 4) == 4) {
            n93 = nbits;
            navSpinner.add(spinnerItemcm93);
            nbits++;
        }


        // Select the proper item as directed
        int to_sel = 0;
        if (sel == 1)
            to_sel = nraster;
        else if (sel == 2)
            to_sel = nvector;
        else if (sel == 4)
            to_sel = n93;

        // Any bits set?
        if (nbits > 1) {
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
            actionBar.setSelectedNavigationItem(to_sel);
        } else
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);

        return "OK";
    }

    public String getSystemDirs() {
        String result = "";


//       String extFiles = getExternalFilesDir(null).getPath();   // Provisional

        //  Maybe the app has been migrated to SDCard...
        ApplicationInfo ai = getApplicationInfo();
        if ((ai.flags & ApplicationInfo.FLAG_EXTERNAL_STORAGE) == ApplicationInfo.FLAG_EXTERNAL_STORAGE) {
            //Log.i("OpenCPN", "External");
            result = "EXTAPP;";
//           File[] fx = getExternalFilesDirs(null);
//           if(fx.length > 1){
//               extFiles = fx[1].getPath();
//           }
        } else {
            //Log.i("OpenCPN", "Internal");
            result = "INTAPP;";
        }

        String extFiles = m_filesDir;

        // Find the external cache directory
        String cacheDir = "";

        File cache = getExternalCacheDir();
        if (null == cache) {
            File fc = new File(m_filesDir);
            cacheDir = fc.getParent() + "/cache";
        } else {
            cacheDir = cache.getAbsolutePath();
        }

        //  Verify the ExternalStorage Directory
        String sxsd = "";
        File xsd = Environment.getExternalStorageDirectory();
        if (null == xsd) {
            sxsd = getFilesDir().getPath();
        } else {
            sxsd = xsd.getPath();
        }


        result = result.concat(getFilesDir().getPath() + ";");
        result = result.concat(getCacheDir().getPath() + ";");
        result = result.concat(extFiles + ";");
        result = result.concat(cacheDir + ";");
        result = result.concat(sxsd + ";");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            File[] fxd = getApplicationContext().getExternalFilesDirs(null);
            result = result.concat(fxd[0] + ";");
            if (fxd.length > 1)
                result = result.concat(fxd[1] + ";");
            else
                result = result.concat("???" + ";");
        }
        else {
            result = result.concat("???0" + ";");
            result = result.concat("???1" + ";");
        }


        File downloadDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        result = result.concat(downloadDir.getAbsolutePath() + ";");

        Log.i("OpenCPN", "getSystemDirs  result: " + result);

        return result;
    }

    public String getIpAddress() {
        ConnectivityManager connectivity = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return getDeviceIpAddress(connectivity);
    }

    public static String getDeviceIpAddress(@NonNull ConnectivityManager connectivityManager) {
        LinkProperties linkProperties = connectivityManager.getLinkProperties(connectivityManager.getActiveNetwork());
        InetAddress inetAddress;
        for(LinkAddress linkAddress : linkProperties.getLinkAddresses()) {
            inetAddress = linkAddress.getAddress();
            if (inetAddress instanceof Inet4Address
                    && !inetAddress.isLoopbackAddress()
                    && inetAddress.isSiteLocalAddress()) {
                return inetAddress.getHostAddress();
            }
        }
        return "0";
    }


    //  ActionBar drop-down spinner navigation
    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        // Action to be taken after selecting a spinner item from action bar

        //Log.i("DEBUGGER_TAG", "onNavigationItemSelected");
        String aa;
        aa = String.format("%d", itemPosition);
        //Log.i("DEBUGGER_TAG", aa);

        SpinnerNavItem item = navSpinner.get(itemPosition);
        if (item.getTitle().equalsIgnoreCase("cm93")) {
            nativeLib.selectChartDisplay(CHART_TYPE_CM93COMP, -1);
            return true;
        } else if (item.getTitle().equalsIgnoreCase("raster")) {
            nativeLib.selectChartDisplay(-1, CHART_FAMILY_RASTER);
            //Log.i("DEBUGGER_TAG", "onNavigationItemSelectedA");
            return true;
        } else if (item.getTitle().equalsIgnoreCase("vector")) {
            nativeLib.selectChartDisplay(-1, CHART_FAMILY_VECTOR);
            return true;
        }


        return false;
    }

    private void relocateOCPNPlugins() {
        // We need to relocate the PlugIns that have been included as "assets"

        // Reason:  PlugIns can only load from the apps dataDir, which is like:
        //          "/data/data/org.opencpn.opencpn"
        //          This is due to some policy in the system loader....
        //
        //           There is no need to relocate any data files needed by the PlugIns
        //           since they will have been added as assets and moved to the file system
        //           by assetbridge elsewhere.
        //
        //          Since this method runs on every restart, it may be used to condition manually installed
        //          PlugIns as well.  Just somehow install the PlugIn .so file into ".../files/plugins" dir,
        //          and it will be moved to the proper load location on restart.

        Log.i("OpenCPN", "relocateOCPNPlugins");

        //  Detect 64 bits:
        boolean b64;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Log.i("OpenCPN", "relocateOCPNPlugins for " + Build.SUPPORTED_ABIS[0]);
            b64 = TextUtils.join(", ", Build.SUPPORTED_ABIS).contains("64") ? TRUE : FALSE;
        } else {
            b64 = FALSE;
        }


        if(b64)
            Log.i("OpenCPN", "relocateOCPNPlugins64");
        else
            Log.i("OpenCPN", "relocateOCPNPlugins32");

/*
       // On Moto G
       // This produces "/data/data/org.opencpn.opencpn/files"
       //  Which is where the app files would be with default load
       String iDir = getFilesDir().getPath();
       String ssd = iDir + "/plugins";


       //  Maybe the app has been migrated to SDCard...
       sApplicationInfo ai = getApplicationInfo();
       if((ai.flags & ApplicationInfo.FLAG_EXTERNAL_STORAGE) ==  ApplicationInfo.FLAG_EXTERNAL_STORAGE){
           Log.i("OpenCPN", "relocateOCPNPlugins:  OCPN is on EXTERNAL_STORAGE");
           File[] fx = getExternalFilesDirs(null);
           if(fx.length > 1){
               ssd = fx[1].getPath() + File.separator + "plugins";
           }
       }
*/
        File fd = new File(m_filesDir);
        String ssd = fd.getPath() + File.separator + "plugins";

        File sourceDir = new File(ssd);

        // The PlugIn .so files are always relocated to here, which looks like:
        // "/data/data/org.opencpn.opencpn"
        String finalDestination = getApplicationInfo().dataDir;

        File[] dirs = sourceDir.listFiles();
        if (dirs != null) {
            for (int j = 0; j < dirs.length; j++) {
                File sfile = dirs[j];
                Log.i("OpenCPN", "relocateOCPNPlugins considering: " + sfile.getName());

                // As a special case, if present we capture and relocate "libgnustl_shared.so", 32 Bit,  to support some legacy plugins.
                //  We store it in "finalDestination", and plugins can access it by specifying a LD_LIBRARY environment directory
                if(sfile.isFile() && sfile.getAbsolutePath().endsWith("libgnustl_shared.so")){
                    try {
                        File destinationFile = new File(finalDestination + "/" + "libgnustl_shared.so");
                        if(!destinationFile.exists()) {
                            File parentDirectory = destinationFile.getParentFile();
                            if (!parentDirectory.exists())
                                parentDirectory.mkdirs();

                            InputStream inputStream = new FileInputStream(sfile.getAbsolutePath());
                            OutputStream outputStream = new FileOutputStream(finalDestination + "/" + "libgnustl_shared.so");
                            copyFile(inputStream, outputStream);
                            inputStream.close();
                            outputStream.close();
                            Log.i("OpenCPN", "relocateOCPNPlugins copyFile libgnustl_shared.so OK");
                        }
                        else {
                            Log.i("OpenCPN", "relocateOCPNPlugins libgnustl_shared.so already in place");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.i("OpenCPN", "relocateOCPNPlugins copyFile libgnustl_shared.so Exception");
                    }
                }

                if (sfile.isFile() && !sfile.getAbsolutePath().endsWith(".so")) {     // Don't relocate legacy plugins on upgrade

                    String source = sfile.getAbsolutePath();
                    String soName = "NOTSET";
                    if (source.endsWith("so64") || source.endsWith("so32")) {
                        if (b64) {
                            if (source.endsWith("so64"))
                                soName = sfile.getName().replace("so64", "so");
                        } else {
                            if (source.endsWith("so32"))
                                soName = sfile.getName().replace("so32", "so");
                        }
                    } else {        // Any binary executables, or any other files not ending with "soxx"?
                        soName = sfile.getName();          // if so, copy directly
                    }

                    if (soName.equals("NOTSET"))
                        continue;                         // skip everything else

                    String dest = finalDestination + "/" + soName;

                    if (soName.contains("o-chart")){
                        dest = finalDestination + "/manPlug/" + soName;
                    }
                    try {
                        InputStream inputStream = new FileInputStream(source);
                        OutputStream outputStream = new FileOutputStream(dest);
                        copyFile(inputStream, outputStream);
                        inputStream.close();
                        outputStream.close();
                        Log.i("OpenCPN", "relocateOCPNPlugins copyFile OK: " + source + " to " + dest);

                        if (!dest.endsWith(".so")) {
                            Log.i("OpenCPN", "relocateOCPNPlugins setting executable on: " + dest);
                            File file = new File(dest);
                            file.setExecutable(true);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.i("OpenCPN", "relocateOCPNPlugins copyFile Exception");
                    }
                }
            }
        }

        // A special case:
        // In OA 5.2.2/61, Squiddio was ported to a managed plugin.
        //  So, on app upgrade, we need to remove the unmanaged (system-type) Squiddio plugin
        //   in order that the managed version can be loaded without CommonName conflist.
        if(BuildConfig.VERSION_CODE >= 61) {
            File squiddio_unmanaged = new File(finalDestination + "/libsquiddio_pi.so");
            if (squiddio_unmanaged.exists())
                squiddio_unmanaged.delete();
        }

    }

    /**
     * Get a list of external SD card paths. (Kitkat or higher.)
     *
     * @return A list of external SD card paths.
     */
    private String[] getExtSdCardPaths() {
        List<String> paths = new ArrayList<String>();


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
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
        }

        return paths.toArray(new String[paths.size()]);
    }

    String processStagingFilesString() {
        boolean br = processStagingFiles();
        if(br)
            return "YES";
        else
            return "NO";
    }

    boolean processStagingFiles() {
        Log.i("OpenCPN", "processStagingFiles starts...");


        // Is there anything in the "staging" directory?
        String stagingPath = getFilesDir().getPath() + File.separator + "staging";

/*
       //  The destination after unzipping
       String finalDestination = getFilesDir().getAbsolutePath() + File.separator;

       //  Maybe the app has been migrated to SDCard...
       ApplicationInfo ai = getApplicationInfo();
       if((ai.flags & ApplicationInfo.FLAG_EXTERNAL_STORAGE) ==  ApplicationInfo.FLAG_EXTERNAL_STORAGE){
           Log.i("OpenCPN", "processStagingFiles:  OCPN is on EXTERNAL_STORAGE");
           File[] fx = getExternalFilesDirs(null);
           if(fx.length > 1){
               stagingPath = fx[1].getPath() + File.separator + "staging";
               finalDestination = fx[1].getAbsolutePath() + File.separator;
           }
       }
*/
        String finalDestination = m_filesDir + File.separator;
        Log.i("OpenCPN", "   Staging directory:: " + stagingPath);
        Log.i("OpenCPN", "   Destination directory:: " + finalDestination);
        boolean b_processed = false;

        File stageDir = new File(stagingPath);
        if (stageDir.exists()) {
            if (stageDir.isDirectory()) {
                Log.i("OpenCPN", "Staging directory exists at: " + stagingPath);

                File[] files = stageDir.listFiles();

                if (files != null) {
                    for (int j = 0; j < files.length; j++) {
                        File sfile = files[j];

                        if (sfile.isFile()) {
                            Log.i("OpenCPN", "Processing staged file: " + sfile.getName());

                            String source = sfile.getAbsolutePath();
                            if (source.toUpperCase().endsWith("ZIP")) {
                                Log.i("OpenCPN", "Processing staged ZIP file: " + sfile.getName());
                                long len = sfile.length();
                                // We unzip the file into the app "files" directory.
                                //  May be on SDCard for migrated apps.

                                // For normal plugin zip packages, that will put the plugin .so and helper files
                                // into "files/plugins/", from whence they will be relocated to the data directory for runtime.


                                unzip(sfile.getAbsolutePath(), finalDestination);
                                b_processed = true;
                            }
                            //  Finished, so delete the staged file
                            sfile.delete();
                        }
                    }
                }
            }
        }

        if(b_processed) {
            Log.i("OpenCPN", "processStagingFiles processed some content.");
            return true;
        }
        else{
            Log.i("OpenCPN", "processStagingFiles found no new content.");
            return false;
        }

    }

    public void unzip(String _zipFile, String _targetLocation) {
        Log.i("OpenCPN", "ZIP unzipping " + _zipFile + " to " + _targetLocation);
        File f=new File(_zipFile);
        Log.i("OpenCPN", "ZIP file length of " + _zipFile + " is " + Long.toString(f.length()));

        ZipEntry ze = null;

        try {
            FileInputStream fin = new FileInputStream(_zipFile);
            ZipInputStream zin = new ZipInputStream(fin);
            while ((ze = zin.getNextEntry()) != null) {

                Log.i("OpenCPN", "ZIP Entry: " + ze.getName());

                //create dir if required while unzipping
                if (ze.isDirectory()) {
                    Log.i("OpenCPN", "Unzip dir: " + ze.getName());
                    File dir = new File(ze.getName());
                    if (!dir.exists()) {
                        dir.mkdirs();
                    }

                } else {
                    int size;
                    byte[] buffer = new byte[2048];
                    Log.i("OpenCPN", "Unzip file: " + _targetLocation + ze.getName());

                    FileOutputStream outStream = new FileOutputStream(_targetLocation + ze.getName());
                    BufferedOutputStream bufferOut = new BufferedOutputStream(outStream, buffer.length);

                    while ((size = zin.read(buffer, 0, buffer.length)) != -1) {
                        bufferOut.write(buffer, 0, size);
                    }

                    bufferOut.flush();
                    bufferOut.close();

                    zin.closeEntry();


                }
            }
            zin.close();
        } catch (Exception e) {
            Log.i("OpenCPN", "ZIP Exception: " + e.getMessage());
            return;
        }
    }

    // this function is used to load and start the loader
    private void loadApplication(Bundle loaderParams) {
        Log.i("OpenCPN", "LoadApplication");

        boolean bStagedFiles = processStagingFiles();

        //if(m_bNeworUpdateInstall || bStagedFiles)
            relocateOCPNPlugins();

        try {
            final int errorCode = loaderParams.getInt(ERROR_CODE_KEY);
            if (errorCode != 0) {
                if (errorCode == INCOMPATIBLE_MINISTRO_VERSION) {
                    downloadUpgradeMinistro(loaderParams.getString(ERROR_MESSAGE_KEY));
                    return;
                }

                // fatal error, show the error and quit
                AlertDialog errorDialog = new AlertDialog.Builder(QtActivity.this).create();
                errorDialog.setMessage(loaderParams.getString(ERROR_MESSAGE_KEY));
                errorDialog.setButton(getResources().getString(android.R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                errorDialog.show();
                return;
            }

            // add all bundled Qt libs to loader params
            ArrayList<String> libs = new ArrayList<String>();
            if (m_activityInfo.metaData.containsKey("android.app.bundled_libs_resource_id"))
                libs.addAll(Arrays.asList(getResources().getStringArray(m_activityInfo.metaData.getInt("android.app.bundled_libs_resource_id"))));

            //  We want the default OCPN plugins bundled into the APK and installed
            //  into the proper app-lib.  So they are listed in ANDROID_EXTRA_LIBS.
            //  But we do not want to pre-load them.  So take them out of the DexClassLoader list.

//                libs.remove("dashboard_pi");
//                libs.remove("grib_pi");


            String libName = null;
            if (m_activityInfo.metaData.containsKey("android.app.lib_name")) {
                libName = m_activityInfo.metaData.getString("android.app.lib_name");
                loaderParams.putString(MAIN_LIBRARY_KEY, libName); //main library contains main() function
            }

            loaderParams.putStringArrayList(BUNDLED_LIBRARIES_KEY, libs);
            loaderParams.putInt(NECESSITAS_API_LEVEL_KEY, NECESSITAS_API_LEVEL);

            // load and start QtLoader class
            m_classLoader = new DexClassLoader(loaderParams.getString(DEX_PATH_KEY), // .jar/.apk files
                    getDir("outdex", Context.MODE_PRIVATE).getAbsolutePath(), // directory where optimized DEX files should be written.
                    loaderParams.containsKey(LIB_PATH_KEY) ? loaderParams.getString(LIB_PATH_KEY) : null, // libs folder (if exists)
                    getClassLoader()); // parent loader

            @SuppressWarnings("rawtypes")
            Class loaderClass = m_classLoader.loadClass(loaderParams.getString(LOADER_CLASS_NAME_KEY)); // load QtLoader class
            Object qtLoader = loaderClass.newInstance(); // create an instance
            Method perpareAppMethod = qtLoader.getClass().getMethod("loadApplication",
                    Activity.class,
                    ClassLoader.class,
                    Bundle.class);
            if (!(Boolean) perpareAppMethod.invoke(qtLoader, this, m_classLoader, loaderParams))
                throw new Exception("");

            QtApplication.setQtActivityDelegate(qtLoader);

            // now load the application library so it's accessible from this class loader
            if (libName != null)
                System.loadLibrary(libName);

            Method startAppMethod = qtLoader.getClass().getMethod("startApplication");
            if (!(Boolean) startAppMethod.invoke(qtLoader))
                throw new Exception("");


        } catch (Exception e) {
            e.printStackTrace();
            AlertDialog errorDialog = new AlertDialog.Builder(QtActivity.this).create();
            if (m_activityInfo.metaData.containsKey("android.app.fatal_error_msg"))
                errorDialog.setMessage(m_activityInfo.metaData.getString("android.app.fatal_error_msg"));
            else
                errorDialog.setMessage("Fatal error, your application can't be started.");

            errorDialog.setButton(getResources().getString(android.R.string.ok), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            errorDialog.show();
        }
    }

    /*
    private ServiceConnection m_ministroConnection=new ServiceConnection() {
        private IMinistro m_service = null;
        @Override
        public void onServiceConnected(ComponentName name, IBinder service)
        {
            m_service = IMinistro.Stub.asInterface(service);
            try {
                if (m_service != null) {
                    Bundle parameters = new Bundle();
                    parameters.putStringArray(REQUIRED_MODULES_KEY, m_qtLibs);
                    parameters.putString(APPLICATION_TITLE_KEY, (String)QtActivity.this.getTitle());
                    parameters.putInt(MINIMUM_MINISTRO_API_KEY, MINISTRO_API_LEVEL);
                    parameters.putInt(MINIMUM_QT_VERSION_KEY, QT_VERSION);
                    parameters.putString(ENVIRONMENT_VARIABLES_KEY, ENVIRONMENT_VARIABLES);
                    if (APPLICATION_PARAMETERS != null)
                        parameters.putString(APPLICATION_PARAMETERS_KEY, APPLICATION_PARAMETERS);
                    parameters.putStringArray(SOURCES_KEY, m_sources);
                    parameters.putString(REPOSITORY_KEY, m_repository);
                    if (QT_ANDROID_THEMES != null)
                        parameters.putStringArray(ANDROID_THEMES_KEY, QT_ANDROID_THEMES);
                    m_service.requestLoader(m_ministroCallback, parameters);
                }
            } catch (RemoteException e) {
                    e.printStackTrace();
            }
        }

        private IMinistroCallback m_ministroCallback = new IMinistroCallback.Stub() {
            // this function is called back by Ministro.
            @Override
            public void loaderReady(final Bundle loaderParams) throws RemoteException {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        unbindService(m_ministroConnection);
                        loadApplication(loaderParams);
                    }
                });
            }
        };

        @Override
        public void onServiceDisconnected(ComponentName name) {
            m_service = null;
        }
    };
*/
    private void downloadUpgradeMinistro(String msg) {
        AlertDialog.Builder downloadDialog = new AlertDialog.Builder(this);
        downloadDialog.setMessage(msg);
        downloadDialog.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Uri uri = Uri.parse("market://search?q=pname:org.kde.necessitas.ministro");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivityForResult(intent, MINISTRO_INSTALL_REQUEST_CODE);
                } catch (Exception e) {
                    e.printStackTrace();
                    ministroNotFound();
                }
            }
        });

        downloadDialog.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                QtActivity.this.finish();
            }
        });
        downloadDialog.show();
    }

    private void ministroNotFound() {
        AlertDialog errorDialog = new AlertDialog.Builder(QtActivity.this).create();

        if (m_activityInfo.metaData.containsKey("android.app.ministro_not_found_msg"))
            errorDialog.setMessage(m_activityInfo.metaData.getString("android.app.ministro_not_found_msg"));
        else
            errorDialog.setMessage("Can't find Ministro service.\nThe application can't start.");

        errorDialog.setButton(getResources().getString(android.R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        errorDialog.show();
    }

    static private void copyFile(InputStream inputStream, OutputStream outputStream)
            throws IOException {
        byte[] buffer = new byte[BUFFER_SIZE];

        int count;
        while ((count = inputStream.read(buffer)) > 0)
            outputStream.write(buffer, 0, count);
    }


    private void copyAsset(String source, String destination)
            throws IOException {
        // Already exists, we don't have to do anything
        File destinationFile = new File(destination);
        if (destinationFile.exists())
            return;

        File parentDirectory = destinationFile.getParentFile();
        if (!parentDirectory.exists())
            parentDirectory.mkdirs();

        destinationFile.createNewFile();

        AssetManager assetsManager = getAssets();
        InputStream inputStream = assetsManager.open(source);
        OutputStream outputStream = new FileOutputStream(destinationFile);
        copyFile(inputStream, outputStream);

        inputStream.close();
        outputStream.close();
    }

    private static void createBundledBinary(String source, String destination)
            throws IOException {
        // Already exists, we don't have to do anything
        File destinationFile = new File(destination);
        if (destinationFile.exists())
            return;

        File parentDirectory = destinationFile.getParentFile();
        if (!parentDirectory.exists())
            parentDirectory.mkdirs();

        destinationFile.createNewFile();

        InputStream inputStream = new FileInputStream(source);
        OutputStream outputStream = new FileOutputStream(destinationFile);
        copyFile(inputStream, outputStream);

        inputStream.close();
        outputStream.close();
    }

    private boolean checkCacheVersionValid(String prefix, String cacheName) {
        Log.i("OpenCPN", "checkCacheVersionValid " + prefix);

        long packageVersion = -1;
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            packageVersion = packageInfo.lastUpdateTime;
        } catch (Exception e) {
            e.printStackTrace();
        }

        ApplicationInfo ai = getApplicationInfo();
        if ((ai.flags & ApplicationInfo.FLAG_EXTERNAL_STORAGE) == ApplicationInfo.FLAG_EXTERNAL_STORAGE)
            packageVersion++;

        Log.i("OpenCPN", "checkCacheVersionValid: current running packageVersion " + String.valueOf(packageVersion));


        File versionFile = new File(prefix + cacheName);

        Log.i("OpenCPN", "checkCacheVersionValid: version file: " + prefix + cacheName);

        long cacheVersion = 0;
        if (versionFile.exists() && versionFile.canRead()) {
            Log.i("OpenCPN", "version file exists ");
            try {
                DataInputStream inputStream = new DataInputStream(new FileInputStream(versionFile));
                cacheVersion = inputStream.readLong();
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Log.i("OpenCPN", "checkCacheVersionValid:  cached value is: " + String.valueOf(cacheVersion));

        if (cacheVersion == packageVersion) {
            Log.i("OpenCPN", "checkCacheVersionValid return true");
            return true;
        } else {
            Log.i("OpenCPN", "checkCacheVersionValid return false");
            return false;
        }
    }

/*
    private boolean cleanCacheIfNecessary(String prefix, String cacheName) {
        Log.i("OpenCPN", "cleanCacheIfNecessary " + prefix);

        boolean bCacheValid = checkCacheVersionValid(prefix, cacheName);

        if (!bCacheValid) {
            Log.i("OpenCPN", "cleanCacheIfNecessary:  deleting old files in: " + prefix);
            deleteRecursively(new File(prefix));
            {

            Log.i("OpenCPN", "cleanCacheIfNecessary:  writing new cache file to: " + prefix);

            long packageVersion = -1;
            try {
                PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
                packageVersion = packageInfo.lastUpdateTime;
            } catch (Exception e) {
                e.printStackTrace();
            }

            ApplicationInfo ai = getApplicationInfo();
            if ((ai.flags & ApplicationInfo.FLAG_EXTERNAL_STORAGE) == ApplicationInfo.FLAG_EXTERNAL_STORAGE)
                packageVersion++;

            Log.i("OpenCPN", "cleanCacheIfNecessary:  value is: " + String.valueOf(packageVersion));

            File versionFile = new File(prefix + "cache.version");

            File parentDirectory = versionFile.getParentFile();
            if (!parentDirectory.exists())
                parentDirectory.mkdirs();

            try {
                versionFile.createNewFile();

                DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(versionFile));
                outputStream.writeLong(packageVersion);
                outputStream.close();
            } catch( java.io.IOException e){
                e.printStackTrace();
            }

            }

            //           Log.i("OpenCPN", "cleanCacheIfNecessary return true");
            return true;
        } else {
            //           Log.i("OpenCPN", "cleanCacheIfNecessary return false");
            return false;
        }
    }
*/

    private void extractBundledPluginsAndImports(String pluginsPrefix)
            throws IOException {
        Log.i("OpenCPN", "extractBundledPluginsAndImports:  pluginsPrefix is: " + pluginsPrefix);

        File f = new File(pluginsPrefix);
        if(!f.exists())
            f.mkdirs();


        ArrayList<String> libs = new ArrayList<String>();

        if (!m_bNeworUpdateInstall)         // No need to copy
            return;

        {
            //  Detect 64 bits:
            String arch;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                arch = TextUtils.join(", ", Build.SUPPORTED_ABIS).contains("64") ? "arm64-v8a" : "armeabi-v7a";
            } else {
                arch = "armeabi-v7a";
            }

            String key = BUNDLED_IN_LIB_RESOURCE_ID_KEY;
            java.util.Set<String> keys = m_activityInfo.metaData.keySet();
            if (m_activityInfo.metaData.containsKey(key)) {
                String[] list = getResources().getStringArray(m_activityInfo.metaData.getInt(key));

                for (String bundledImportBinary : list) {
                    String[] split = bundledImportBinary.split(":");

                    //String sourceFileName = m_filesDir + "/" + "Qtplugins/" + arch + "/" + split[0];    // From relocated assets
                    String sourceFileName = m_nativeLibraryDir + "/" + split[0];    // From relocated assets

                    String destinationFileName = pluginsPrefix + split[1];
                    createBundledBinary(sourceFileName, destinationFileName);
                }
            }
        }

        {
            String key = BUNDLED_IN_ASSETS_RESOURCE_ID_KEY;
            if (m_activityInfo.metaData.containsKey(key)) {
                String[] list = getResources().getStringArray(m_activityInfo.metaData.getInt(key));

                for (String fileName : list) {
                    String[] split = fileName.split(":");
                    String sourceFileName = split[0];
                    String destinationFileName = pluginsPrefix + split[1];
                    copyAsset(sourceFileName, destinationFileName);
                }
            }

        }
    }

    private void deleteRecursively(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory())
                    deleteRecursively(file);
                else
                    file.delete();
            }

            directory.delete();
        }
    }

    private void cleanOldCacheIfNecessary(String oldLocalPrefix, String localPrefix) {
        Log.i("OpenCPN", "cleanOldCacheIfNecessary:  old: " + oldLocalPrefix + " new: " + localPrefix);

        File newCache = new File(localPrefix);
        if (!newCache.exists()) {
            {
                File oldPluginsCache = new File(oldLocalPrefix + "plugins/");
                if (oldPluginsCache.exists() && oldPluginsCache.isDirectory()) {
                    Log.i("OpenCPN", "cleanOldCacheIfNecessary:  clearing old cache");
                    deleteRecursively(oldPluginsCache);
                }
            }

            {
                File oldImportsCache = new File(oldLocalPrefix + "imports/");
                if (oldImportsCache.exists() && oldImportsCache.isDirectory())
                    deleteRecursively(oldImportsCache);
            }

            {
                File oldQmlCache = new File(oldLocalPrefix + "qml/");
                if (oldQmlCache.exists() && oldQmlCache.isDirectory())
                    deleteRecursively(oldQmlCache);
            }
        }
    }

    private void startApp(final boolean firstStart) {
        try {
            if (m_activityInfo.metaData.containsKey("android.app.qt_sources_resource_id")) {
                int resourceId = m_activityInfo.metaData.getInt("android.app.qt_sources_resource_id");
                m_sources = getResources().getStringArray(resourceId);
            }

            if (m_activityInfo.metaData.containsKey("android.app.repository"))
                m_repository = m_activityInfo.metaData.getString("android.app.repository");

            if (m_activityInfo.metaData.containsKey("android.app.qt_libs_resource_id")) {
                int resourceId = m_activityInfo.metaData.getInt("android.app.qt_libs_resource_id");
                m_qtLibs = getResources().getStringArray(resourceId);
            }

            if (m_activityInfo.metaData.containsKey("android.app.use_local_qt_libs")
                    && m_activityInfo.metaData.getInt("android.app.use_local_qt_libs") == 1) {
                ArrayList<String> libraryList = new ArrayList<String>();


                String localPrefix = "/data/local/tmp/qt/";
                if (m_activityInfo.metaData.containsKey("android.app.libs_prefix"))
                    localPrefix = m_activityInfo.metaData.getString("android.app.libs_prefix");

                String pluginsPrefix = localPrefix;

                boolean bundlingQtLibs = false;
                if (m_activityInfo.metaData.containsKey("android.app.bundle_local_qt_libs")
                        && m_activityInfo.metaData.getInt("android.app.bundle_local_qt_libs") == 1) {
                    localPrefix = getApplicationInfo().dataDir + "/";
                    pluginsPrefix = localPrefix + "qt-reserved-files/";

                    extractBundledPluginsAndImports(pluginsPrefix);
                    bundlingQtLibs = true;
                }


                // Set up list of architecture dependent Qt libs to preload
                if (m_qtLibs != null) {
                    for (int i = 0; i < m_qtLibs.length; i++) {
                        libraryList.add(m_nativeLibraryDir + "/lib" + m_qtLibs[i] + ".so");
                    }
                }





                if (m_activityInfo.metaData.containsKey("android.app.load_local_libs")) {
                    String[] extraLibs = m_activityInfo.metaData.getString("android.app.load_local_libs").split(":");
                    for (String lib : extraLibs) {
                        if (lib.length() > 0) {
                            if (lib.startsWith("lib/"))
                                libraryList.add(localPrefix + lib);
                            else
                                libraryList.add(pluginsPrefix + lib);
                        }
                    }
                }


                String dexPaths = new String();
                String pathSeparator = System.getProperty("path.separator", ":");
                if (!bundlingQtLibs && m_activityInfo.metaData.containsKey("android.app.load_local_jars")) {
                    String[] jarFiles = m_activityInfo.metaData.getString("android.app.load_local_jars").split(":");
                    for (String jar : jarFiles) {
                        if (jar.length() > 0) {
                            if (dexPaths.length() > 0)
                                dexPaths += pathSeparator;
                            dexPaths += localPrefix + jar;
                        }
                    }
                }

                Bundle loaderParams = new Bundle();
                loaderParams.putInt(ERROR_CODE_KEY, 0);
                loaderParams.putString(DEX_PATH_KEY, dexPaths);
                loaderParams.putString(LOADER_CLASS_NAME_KEY, "org.qtproject.qt5.android.QtActivityDelegate");
                if (m_activityInfo.metaData.containsKey("android.app.static_init_classes")) {
                    loaderParams.putStringArray(STATIC_INIT_CLASSES_KEY,
                            m_activityInfo.metaData.getString("android.app.static_init_classes").split(":"));
                }
                loaderParams.putStringArrayList(NATIVE_LIBRARIES_KEY, libraryList);
                loaderParams.putString(ENVIRONMENT_VARIABLES_KEY, ENVIRONMENT_VARIABLES
                        + "\tQML2_IMPORT_PATH=" + pluginsPrefix + "/qml"
                        + "\tQML_IMPORT_PATH=" + pluginsPrefix + "/imports"
                        + "\tQT_PLUGIN_PATH=" + pluginsPrefix + "/plugins");

                Intent intent = getIntent();
                if (intent != null) {
                    String parameters = intent.getStringExtra("applicationArguments");
                    if (parameters != null)
                        loaderParams.putString(APPLICATION_PARAMETERS_KEY, parameters.replace(' ', '\t'));
                }

                loadApplication(loaderParams);

                activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);

                PackageManager packMan = getPackageManager();
                m_hasGPS = packMan.hasSystemFeature(PackageManager.FEATURE_LOCATION_GPS);

                return;
            }
/*
            try {
                if (!bindService(new Intent(org.kde.necessitas.ministro.IMinistro.class.getCanonicalName()),
                                 m_ministroConnection,
                                 Context.BIND_AUTO_CREATE)) {
                    throw new SecurityException("");
                }
            } catch (Exception e) {
                if (firstStart) {
                    String msg = "This application requires Ministro service. Would you like to install it?";
                    if (m_activityInfo.metaData.containsKey("android.app.ministro_needed_msg"))
                        msg = m_activityInfo.metaData.getString("android.app.ministro_needed_msg");
                    downloadUpgradeMinistro(msg);
                } else {
                    ministroNotFound();
                }
            }
*/
        } catch (Exception e) {
            Log.e(QtApplication.QtTAG, "Can't create main activity", e);
        }
    }

    /////////////////////////// forward all notifications ////////////////////////////
    /////////////////////////// Super class calls ////////////////////////////////////
    /////////////// PLEASE DO NOT CHANGE THE FOLLOWING CODE //////////////////////////
    //////////////////////////////////////////////////////////////////////////////////

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            Log.i("OpenCPN", "dispatchKeyEvent (KEYCODE_BACK): " + m_backButtonEnable);

            if (!m_backButtonEnable)
                return false;
        }
        Log.i("OpenCPN", "keyEvent: " + keyCode);

        if (QtApplication.m_delegateObject != null && QtApplication.dispatchKeyEvent != null)
            return (Boolean) QtApplication.invokeDelegateMethod(QtApplication.dispatchKeyEvent, event);
        else
            return super.dispatchKeyEvent(event);
    }

    public boolean super_dispatchKeyEvent(KeyEvent event) {
        return super.dispatchKeyEvent(event);
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        if (QtApplication.m_delegateObject != null && QtApplication.dispatchPopulateAccessibilityEvent != null)
            return (Boolean) QtApplication.invokeDelegateMethod(QtApplication.dispatchPopulateAccessibilityEvent, event);
        else
            return super.dispatchPopulateAccessibilityEvent(event);
    }

    public boolean super_dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        return super_dispatchPopulateAccessibilityEvent(event);
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        //Toast.makeText(getApplicationContext(), "dispatchTouchEvent",Toast.LENGTH_LONG).show();

        if ((ev.getAction() == MotionEvent.ACTION_MOVE) && (Math.abs(ev.getRawX() - lastX) < 1.0f) && (Math.abs(ev.getRawY() - lastY) < 1.0f))
            return true;

        lastX = ev.getRawX();
        lastY = ev.getRawY();

        if (ev.getAction() == MotionEvent.ACTION_UP) {
            lastX = -1.0f;
            lastY = -1.0f;
        }
//        Log.i("Sending", String.format("%d  x = %5.2f, y=%5.2f", ev.getAction(), ev.getRawX(), ev.getRawY()));

        if (QtApplication.m_delegateObject != null && QtApplication.dispatchTouchEvent != null)
            return (Boolean) QtApplication.invokeDelegateMethod(QtApplication.dispatchTouchEvent, ev);
        else
            return super.dispatchTouchEvent(ev);
    }

    public boolean super_dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean dispatchTrackballEvent(MotionEvent ev) {
        if (QtApplication.m_delegateObject != null && QtApplication.dispatchTrackballEvent != null)
            return (Boolean) QtApplication.invokeDelegateMethod(QtApplication.dispatchTrackballEvent, ev);
        else
            return super.dispatchTrackballEvent(ev);
    }

    public boolean super_dispatchTrackballEvent(MotionEvent event) {
        return super.dispatchTrackballEvent(event);
    }
    //---------------------------------------------------------------------------


    protected void setAppLocale() {

        // defer a bit
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                nativeLib.invokeCmdEventCmdString(ID_CMD_SET_LOCALE, "fr");
            }
        }, 100);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == OCPN_SETTINGS_REQUEST_CODE) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                m_settingsReturn = data.getStringExtra("SettingsString");
                Log.i("OpenCPN", "onActivityResult.SettingsString: " + m_settingsReturn);
                nativeLib.invokeCmdEventCmdString(ID_CMD_NULL_REFRESH, m_settingsReturn);

                // defer hte application of settings until the screen refreshes

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        nativeLib.invokeCmdEventCmdString(ID_CMD_APPLY_SETTINGS, m_settingsReturn);
                    }
                }, 500);

                //  Apply any Android private settings
                applyAndroidPreferences();

            } else if (resultCode == RESULT_CANCELED) {
            }

            super.onActivityResult(requestCode, resultCode, data);

            return;
        }

        if (requestCode == OCPN_FILECHOOSER_REQUEST_CODE) {
            //Log.i("DEBUGGER_TAG", "onqtActivityResultCf");
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                //Log.i("DEBUGGER_TAG", "onqtActivityResultDf");
                m_filechooserString = "file:" + data.getStringExtra("itemSelected");
                //Log.i("DEBUGGER_TAG", m_filechooserString);
            } else if (resultCode == RESULT_CANCELED) {
                //Log.i("DEBUGGER_TAG", "onqtActivityResultEf");
                m_filechooserString = "cancel:";
            }

            m_FileChooserDone = true;

            super.onActivityResult(requestCode, resultCode, data);

            return;
        }

        if (requestCode == OCPN_AFILECHOOSER_REQUEST_CODE) {
            Log.i("OpenCPN", "onqtActivityResultCa");
            // Make sure the request was successful
            if (resultCode == Activity.RESULT_OK) {
                Log.i("OpenCPN", "onqtActivityResultDa");
                boolean fileCreated = false;
                String filePath = "";

                Bundle bundle = data.getExtras();
                if (bundle != null) {
                    if (bundle.containsKey(FileChooserActivity.OUTPUT_NEW_FILE_NAME)) {
                        fileCreated = true;
                        File folder = (File) bundle.get(FileChooserActivity.OUTPUT_FILE_OBJECT);
                        String name = bundle.getString(FileChooserActivity.OUTPUT_NEW_FILE_NAME);
                        filePath = folder.getAbsolutePath() + "/" + name;
                    } else {
                        fileCreated = false;
                        File file = (File) bundle.get(FileChooserActivity.OUTPUT_FILE_OBJECT);
                        filePath = file.getAbsolutePath();
                    }

                    m_filechooserString = "file:" + filePath;

                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Log.i("OpenCPN", "onqtActivityResultEa");
                m_filechooserString = "cancel:";
            }

            m_FileChooserDone = true;

            super.onActivityResult(requestCode, resultCode, data);

            return;
        }

        if (requestCode == OCPN_SAF_DIALOG_A_REQUEST_CODE) {
            Uri treeUri = null;

            if (resultCode == Activity.RESULT_OK) {

                treeUri = data.getData();

                Log.i("OpenCPN", "onqtActivityResult OCPN_SAF_DIALOG_A_REQUEST_CODE...URI is: " + treeUri.toString());

                // Persist URI in shared preference so that you can use it later.
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("SDURI", treeUri.toString());
                editor.commit();


                getContentResolver().takePersistableUriPermission(treeUri, FLAG_GRANT_WRITE_URI_PERMISSION | FLAG_GRANT_READ_URI_PERMISSION);


                showPermisionGrantedDialog(true);

                m_FileChooserDone = true;
            }
            super.onActivityResult(requestCode, resultCode, data);

            return;
        }


        if (requestCode == OCPN_SAF_DIALOG_DL_REQUEST_CODE) {
                Uri treeUriDL = null;

                if (resultCode == Activity.RESULT_OK) {

                    treeUriDL = data.getData();

                    Log.i("OpenCPN", "onqtActivityResult OCPN_SAF_DIALOG_DL_REQUEST_CODE...URI is: " + treeUriDL.toString());

                    // Persist URI in shared preference so that you can use it later.
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("SDURI", treeUriDL.toString());
                    editor.commit();


                    getContentResolver().takePersistableUriPermission(treeUriDL, FLAG_GRANT_WRITE_URI_PERMISSION | FLAG_GRANT_READ_URI_PERMISSION);


                    showPermisionGrantedDialog(true);

                }

                super.onActivityResult(requestCode, resultCode, data);

            return;
        }


        if (requestCode == OCPN_SAF_DIALOG_MIGRATE_REQUEST_CODE) {
            Uri treeUriDL = null;

            if (resultCode == Activity.RESULT_OK) {

                treeUriDL = data.getData();

                Log.i("OpenCPN", "onqtActivityResult OCPN_SAF_DIALOG_MIGRATE_DL_REQUEST_CODE...URI is: " + treeUriDL.toString());
/*
                File tf = new File(treeUriDL.getPath());
                final String[] split = tf.getPath().split(":");//split the path.

                if(split[0].contains("primary")) {
                    m_SAFmigrateChooserString = "file:internal Storage/" + split[split.length - 1];
                }
                else {
                    m_SAFmigrateChooserString = "file:SdCard/" + split[split.length - 1];
                }
*/

                DocumentFile source = DocumentFile.fromTreeUri(getApplicationContext(), treeUriDL);
                File ff = getFile( getApplicationContext(),  source);
                m_SAFmigrateChooserString = "file:" + ff.getPath();

                g_migrateSourceFolderURI = treeUriDL;
                m_SAFmigrateChooserActive = false;

            }
            else if (resultCode == Activity.RESULT_CANCELED){
                m_SAFmigrateChooserActive = false;
                m_SAFmigrateChooserString = "cancel:";
            }

            super.onActivityResult(requestCode, resultCode, data);

            return;
        }


        if (requestCode == OCPN_GOOGLEMAPS_REQUEST_CODE) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                String finalPosition = data.getStringExtra("finalPosition");
//                Log.i("DEBUGGER_TAG", "finalPositionFromMaps " + finalPosition);

                StringTokenizer tkz = new StringTokenizer(finalPosition, ";");

                String finalLat = finalPosition.valueOf(m_gminitialLat);
                String finalLon = finalPosition.valueOf(m_gminitialLon);
                String finalZoom = finalPosition.valueOf(m_gminitialZoom);
                String zoomFactor = "1.0";

                if (tkz.hasMoreTokens()) {
                    finalLat = tkz.nextToken();
                    finalLon = tkz.nextToken();
                    finalZoom = tkz.nextToken();
                    zoomFactor = tkz.nextToken();
                }

                double zoomF = Double.parseDouble(zoomFactor);
                finalZoom = String.valueOf(m_gminitialZoom * zoomF);


                String vpSet = "";

                vpSet = vpSet.concat(finalLat);
                vpSet = vpSet.concat(";");
                vpSet = vpSet.concat(finalLon);
                vpSet = vpSet.concat(";");
                vpSet = vpSet.concat(finalZoom);
                vpSet = vpSet.concat(";");


                Log.i("DEBUGGER_TAG", "finalPositionString " + vpSet);

                nativeLib.invokeCmdEventCmdString(ID_CMD_SETVP, vpSet);

            } else if (resultCode == RESULT_CANCELED) {
//                Log.i("DEBUGGER_TAG", "onqtActivityResultE");
            }

            super.onActivityResult(requestCode, resultCode, data);

            return;
        }

        if (requestCode == OCPN_GRIB_REQUEST_CODE) {
//            Log.i("DEBUGGER_TAG", "onqtActivityResultGC");
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
//                Log.i("DEBUGGER_TAG", "onqtActivityResultGD");
                m_GRIBReturn = data.getStringExtra("GRIB_JSON");
//                Log.i("GRIB", m_GRIBReturn);

                //  Add a message ID string to the JSON for later processing
                String json = "";
                try {
                    JSONObject js = new JSONObject(m_GRIBReturn);
                    js.put("MessageID", "GRIB_APPLY_JSON_CONFIG");
                    json = js.toString();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                nativeLib.invokeCmdEventCmdString(ID_CMD_POST_JSON_TO_PLUGINS, json);

//                nativeLib.sendPluginMessage( "GRIB_APPLY_JSON_CONFIG", m_GRIBReturn);

                // defer hte application of settings until the screen refreshes
                //Handler handler = new Handler();
                //handler.postDelayed(new Runnable() {
                //   public void run() {
                //      nativeLib.invokeCmdEventCmdString( ID_CMD_APPLY_SETTINGS, m_settingsReturn);
                // }
                // }, 100);
            } else if (resultCode == RESULT_CANCELED) {
//                Log.i("DEBUGGER_TAG", "onqtActivityResultGE");
            }

            super.onActivityResult(requestCode, resultCode, data);
            return;
        }

        if (requestCode == OCPN_ARBITRARY_REQUEST_CODE) {
            Log.i("OpenCPN", "onqtActivityResult ARB");

            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                // Get the results

                Log.i("OpenCPN", "onqtActivityResult ARB OK");
                m_activityArbResult = data.getStringExtra(m_arbResultStringName);
                Log.i("OpenCPN", "onqtActivityResult ARB Result: " + m_arbResultStringName + " : " + m_activityArbResult);

            } else if (resultCode == RESULT_CANCELED) {
                Log.i("OpenCPN", "onqtActivityResult ARB Cancelled");
            }

            super.onActivityResult(requestCode, resultCode, data);

            m_activityARBComplete = true;       // Activity is complete
            return;
        }

        if (QtApplication.m_delegateObject != null && QtApplication.onActivityResult != null) {
            QtApplication.invokeDelegateMethod(QtApplication.onActivityResult, requestCode, resultCode, data);
            return;
        }
        //Log.i("DEBUGGER_TAG", "onqtActivityResultB");
        if (requestCode == MINISTRO_INSTALL_REQUEST_CODE)
            startApp(false);

        super.onActivityResult(requestCode, resultCode, data);
    }

    public void super_onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


    public void applyAndroidPreferences() {
        //  Apply any Android private settings
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        Boolean bnoSleep = preferences.getBoolean("prefb_noSleep", false);
        if (bnoSleep)
            getWindow().addFlags(LayoutParams.FLAG_KEEP_SCREEN_ON);
        else
            getWindow().clearFlags(LayoutParams.FLAG_KEEP_SCREEN_ON);

        m_trackContinuous = preferences.getBoolean("prefb_trackOnPause", false);
    }

    //---------------------------------------------------------------------------
    //  Support for SailTimer Anemometer

    //Define strings for data received action

    public final static String ACTION_DATA_AVAILABLE = "com.ST.bluetooth.le.ACTION_DATA_AVAILABLE";
    public final static String AWD_DATA = "com.ST.bluetooth.le.AWD_DATA";
    public final static String AWS_DATA = "com.ST.bluetooth.le.AWS_DATA";
    public final static String WIMWV = "com.ST.bluetooth.le.WIMWV"; // Action only for API V2.0+
    public final static String WIMWD = "com.ST.bluetooth.le.WIMWD"; // Action only for API V2.0+
    public final static String PSTW = "com.ST.bluetooth.le.PSTW"; // Action only for API V2.0+

    double windSpeed = 0;
    double windDirection = 0;

    double windSpeedAvg = 0;
    double windDirectionAvg = 0;

    double averageCount = 10;
    String ST_NMEA;

    //  Define string for hash code used to decrypt data
    //  This was obtained by executing "TheTask" just once, to get the hash results from SailTimer.com
    //  e.g. new TheTask().execute("https://www.sailtimermaps.com/getHash.php");

    public String hash = "v^2gUAZV7u=wS6xaD^hCxSGT";
    /*
        class TheTask extends AsyncTask<String,Void,String>
         {

          @Override
          protected String doInBackground(String... arg0) {
              String text =null;
              try {
                  Log.i("DEBUGGER_TAG", "TheTask");
                  HttpClient httpclient = new DefaultHttpClient();
                  HttpPost httppost = new HttpPost(arg0[0]);

                  List < NameValuePair > nameValuePairs = new ArrayList < NameValuePair > (5);
                  nameValuePairs.add(new BasicNameValuePair("user", "OpenCPN"));
                  nameValuePairs.add(new BasicNameValuePair("password", "<(d!.U5}j6._]CHH"));
                  httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));


                  HttpResponse resp = httpclient.execute(httppost);
                  HttpEntity ent = resp.getEntity();
                  text = EntityUtils.toString(ent);
              }
              catch (Exception e)
              {
                   e.printStackTrace();
              }

              Log.i("DEBUGGER_TAG", "TheTask Text:" + text);
              return text;
          }

          @Override
          protected void onPostExecute(String result) {
              // TODO Auto-generated method stub
              super.onPostExecute(result);
          }

         }
    */

    public static void dumpIntent(Intent i){

        Bundle bundle = i.getExtras();
        if (bundle != null) {
            Set<String> keys = bundle.keySet();
            Iterator<String> it = keys.iterator();
            Log.e("OpenCPN","Dumping Intent start");
            while (it.hasNext()) {
                String key = it.next();
                Log.e("OpenCPN","[" + key + "=" + bundle.get(key)+"]");
            }
            Log.e("OpenCPN","Dumping Intent end");
        }
    }

    //BroadcastReceiver which receives broadcasted Intents
    private final BroadcastReceiver mGattUpdateReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
//                Log.i("OpenCPN", "mGattUpdateReceiver");

            boolean v1=false;

            final String action = intent.getAction();
            Bundle b = intent.getExtras();
            if (null == b) {
//                    Log.i("OpenCPN", "mGattUpdateReceiver:  NULL Bundle");
            } else {
//                    Log.i("OpenCPN", "mGattUpdateReceiver:  process Bundle");
                if (ACTION_DATA_AVAILABLE.equals(action)) {
                    //dumpIntent(intent);
                    if (intent.getExtras().containsKey(AWD_DATA)) {
                        v1 = true;
                        String awd = intent.getStringExtra(AWD_DATA);
                        try {
                            windDirection = Double.parseDouble(decryptIt(awd, hash));
                        } catch (Exception e) {
                        }
                    }

                    if (intent.getExtras().containsKey(AWS_DATA)) {
                        v1 = true;
                        String aws = intent.getStringExtra(AWS_DATA);
                        try {
                            windSpeed = Double.parseDouble(decryptIt(aws, hash));
                        } catch (Exception e) {
                        }
                    }
                    if (intent.getExtras().containsKey(WIMWV)) {
                        String value = intent.getStringExtra(WIMWV);
                        try {
                            String ST_NMEA = decryptIt(value, hash);
                            //Log.i("OpenCPN", ST_NMEA);
                            if (null != nativeLib) {
                                Thread thread = new Thread() {
                                    @Override
                                    public void run() {
                                        nativeLib.processARBNMEA(ST_NMEA);
                                    }
                                };
                                thread.start();
                            }
                        } catch (Exception e) {
                        }
                    }

                    if (intent.getExtras().containsKey(WIMWD)) {
                        String value = intent.getStringExtra(WIMWD);
                        try {
                            String ST_NMEA = decryptIt(value, hash);
                            //Log.i("OpenCPN", ST_NMEA);
                            if (null != nativeLib) {
                                Thread thread = new Thread() {
                                    @Override
                                    public void run() {
                                        nativeLib.processARBNMEA(ST_NMEA);
                                    }
                                };
                                thread.start();
                            }
                        } catch (Exception e) {
                        }
                    }

                    if (intent.getExtras().containsKey(PSTW)) {
                        String value = intent.getStringExtra(PSTW);
                        try {
                            String ST_NMEA = decryptIt(value, hash);
                            //Log.i("OpenCPN", ST_NMEA);
                            if (null != nativeLib) {
                                Thread thread = new Thread() {
                                    @Override
                                    public void run() {
                                        nativeLib.processARBNMEA(ST_NMEA);
                                    }
                                };
                                thread.start();
                            }
                        } catch (Exception e) {
                        }
                    }

                }

                 //  Process API v1
                if (v1) {
                    windSpeedAvg = (windSpeedAvg * (averageCount - 1) / averageCount) + (windSpeed / averageCount);
                    windDirectionAvg = (windDirectionAvg * (averageCount - 1) / averageCount) + (windDirection / averageCount);

                    final double wsa = windSpeedAvg;
                    final double wda = windDirectionAvg;

                    if (null != nativeLib) {
                        Thread thread = new Thread() {
                            @Override
                            public void run() {
                                nativeLib.processSailTimer(wda, wsa);
                            }
                        };
                        thread.start();
                    }
                }
            }
        }
    };


    public static String decryptIt(String value, String cryptoPass) {
        try {

            DESKeySpec keySpec = new DESKeySpec(cryptoPass.getBytes("UTF8"));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(keySpec);
            byte[] encrypedPwdBytes = Base64.decode(value, DEFAULT);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decrypedValueBytes = (cipher.doFinal(encrypedPwdBytes));
            String decrypedValue = new String(decrypedValueBytes);
            return decrypedValue;

        } catch (InvalidKeyException e) {
            e.printStackTrace();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();

        } catch (InvalidKeySpecException e) {
            e.printStackTrace();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        } catch (BadPaddingException e) {
            e.printStackTrace();

        } catch (NoSuchPaddingException e) {
            e.printStackTrace();

        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();

        }

        return value;

    }

    private static IntentFilter makeGattUpdateIntentFilter() {
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_DATA_AVAILABLE);
        return intentFilter;
    }

    private String createMWD(double magDirection, double speedKnots) {
        // Create an NMEA sentence
        String s = "$STMWD,,,";

        String sDir = "";
        sDir = sDir.format("%.1f,M,%.1f,N,,M", magDirection, speedKnots);

        s = s.concat(sDir);

        byte[] sb = s.getBytes();

        int sum = 0;
        for (int i = 1; i < s.length(); i++) {
            sum = sum ^ sb[i];
        }
        int xsum = sum; // % 256;
        String ssum = "";
        ssum = ssum.format("*%2X", xsum);

        s = s.concat(ssum);    // checksum

        return s;
    }


    //---------------------------------------------------------------------------

    @Override
    protected void onApplyThemeResource(Theme theme, int resid, boolean first) {
        if (!QtApplication.invokeDelegate(theme, resid, first).invoked)
            super.onApplyThemeResource(theme, resid, first);
    }

    public void super_onApplyThemeResource(Theme theme, int resid, boolean first) {
        super.onApplyThemeResource(theme, resid, first);
    }
    //---------------------------------------------------------------------------


    @Override
    protected void onChildTitleChanged(Activity childActivity, CharSequence title) {
        if (!QtApplication.invokeDelegate(childActivity, title).invoked)
            super.onChildTitleChanged(childActivity, title);
    }

    public void super_onChildTitleChanged(Activity childActivity, CharSequence title) {
        super.onChildTitleChanged(childActivity, title);
    }
    //---------------------------------------------------------------------------

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.i("OpenCPN", "onConfigurationChanged to: " + String.valueOf(newConfig.orientation));

        if (!QtApplication.invokeDelegate(newConfig).invoked){
            Log.i("OpenCPN", "onConfigurationChanged::delegate FALSE");
            super.onConfigurationChanged(newConfig);
        }

        int i = nativeLib.onConfigChange( newConfig.orientation );

        lockActivityOrientation(this);
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        Log.i("OpenCPN", "Re-enable rotation");
                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
                    }
                },
                3000);
    }

    public void super_onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
    //---------------------------------------------------------------------------

    @Override
    public void onContentChanged() {
        if (!QtApplication.invokeDelegate().invoked)
            super.onContentChanged();
    }

    public void super_onContentChanged() {
        super.onContentChanged();
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        QtApplication.InvokeResult res = QtApplication.invokeDelegate(item);
        if (res.invoked)
            return (Boolean) res.methodReturns;
        else
            return super.onContextItemSelected(item);
    }

    public boolean super_onContextItemSelected(MenuItem item) {
        return super.onContextItemSelected(item);
    }
    //---------------------------------------------------------------------------

    @Override
    public void onContextMenuClosed(Menu menu) {
        if (!QtApplication.invokeDelegate(menu).invoked)
            super.onContextMenuClosed(menu);
    }

    public void super_onContextMenuClosed(Menu menu) {
        super.onContextMenuClosed(menu);
    }
    //---------------------------------------------------------------------------

    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i("OpenCPN", "onCreate" + this);
        String action = getIntent().getAction();
        Log.i("OpenCPN", "onCreate Action: " + action);

        try{
            ApplicationInfo ainfo = this.getApplicationContext().getPackageManager().getApplicationInfo("org.opencpn.opencpn",  PackageManager.GET_SHARED_LIBRARY_FILES );
            Log.i( "OpenCPN", "native library dir " + ainfo.nativeLibraryDir );
            m_nativeLibraryDir = ainfo.nativeLibraryDir;
        }
        catch( Exception e ){
            Log.i( "OpenCPN", "Exception on getApplicationInfo" );
        }

        //Toast.makeText(getApplicationContext(), "onCreate",Toast.LENGTH_LONG).show();

        super.onCreate(savedInstanceState);

        myReceiver = new MyReceiver();

        fm = getSupportFragmentManager();

        m_UUID = getUUID(this);
        m_OCPNUUID = getOCPNuniqueID();
        m_OCPNWVID = getOCPNWVID();

        if( (m_UUID != null) && (m_UUID.length() > 0) && ( Build.VERSION.SDK_INT < 29) )   // Strictly less than Android 10
            m_selID = m_UUID;
        else if(m_OCPNWVID != null)
            m_selID = m_OCPNWVID;
        else
            m_selID = m_OCPNUUID;

        m_systemName = getSystemName( m_selID );

        Log.i("OpenCPN", "msn " + m_systemName);


        // Dis-allow rotation until the app settles down.
        lockActivityOrientation(this);

         //  Bug fix, see http://code.google.com/p/android/issues/detail?id=26658
        //if(!isTaskRoot()) {
        //    Log.i("OpenCPN", "onCreate NOT ROOT");
        //    finish();
        //    return;
        //}

        try {
            String dir = getExternalCacheDir().getAbsolutePath();

            final File path = new File(getExternalCacheDir(), "OCPN_logs");
            if (!path.exists()) {
                path.mkdir();
            }
            String spath = path.getAbsolutePath() + File.separator + "OCPN_logcat" + ".txt";

            final File oldFile = new File(spath);
            if (oldFile.exists()) {
                Log.i("OpenCPN", "Delete logfile: " + spath);
                oldFile.delete();
            }

            Runtime.getRuntime().exec("logcat " + "-f " + spath + " -s OpenCPN -s libgorp.so ");

        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.i("OpenCPN", "onCreate Root");


        m_backButtonEnable = false;
        Log.i("OpenCPN", "back button enable: " + m_backButtonEnable);

        m_optionsItemActionEnable = false;     // disable Android menu items until stabilized

        setContentView(R.layout.activity_main);
        parentLayout = findViewById(android.R.id.content);


        // We need to get the local data directory, available to all
        Log.i("OpenCPN", "Getting App filesDir..");

        // Verify we have access to the files directory
        //File fa = Environment.getDataDirectory();
        //if(null == fa)
        // Log.i("OpenCPN", "fa null");


        //String sa = Environment.getDataDirectory().getAbsolutePath();
        //if(null == sa)
        //Log.i("OpenCPN", "sa null");
        //else
        //Log.i("OpenCPN", "sa: " + sa);

        String filesDir = "";
        File fFiles = getExternalFilesDir(null);
        if (null != fFiles) {
            filesDir = fFiles.getAbsolutePath();
        } else {
            filesDir = getFilesDir().getAbsolutePath();
        }


        //  Maybe the app has been migrated to SDCard...
        ApplicationInfo aif = getApplicationInfo();
        if ((aif.flags & ApplicationInfo.FLAG_EXTERNAL_STORAGE) == ApplicationInfo.FLAG_EXTERNAL_STORAGE) {
            Log.i("OpenCPN", "App might be on EXTERNAL_STORAGE");

            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
                File[] fx = getExternalFilesDirs(null);
                if (null != fx) {
                    if (fx.length > 1) {
                        Log.i("OpenCPN", "App is really on EXTERNAL_STORAGE");
                        filesDir = fx[1].getAbsolutePath();
                    }
                } else {
                    Log.i("OpenCPN", "App has no ExternalFilesDirs");
                }
            }
        }

        m_filesDir = filesDir;

        Log.i("OpenCPN", "Application filesDir: " + m_filesDir);


        try {
            m_activityInfo = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            for (Field f : Class.forName("android.R$style").getDeclaredFields()) {
                if (f.getInt(null) == m_activityInfo.getThemeResource()) {
                    QT_ANDROID_THEMES = new String[]{f.getName()};
                    QT_ANDROID_DEFAULT_THEME = f.getName();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            finish();
            return;
        }


        /*try {
            setTheme(Class.forName("android.R$style").getDeclaredField(QT_ANDROID_DEFAULT_THEME).getInt(null));
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
        if (Build.VERSION.SDK_INT > 10) {
            try {
                setTitle("OpenCPN");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }

        nativeLib = OCPNNativeLib.getInstance();

        mReceiver = new OCPNResultReceiver(new Handler());
        mReceiver.setReceiver(this);


        // USB Serial Port setup
        PackageManager pm = getPackageManager();
        if (pm.hasSystemFeature(PackageManager.FEATURE_USB_HOST)) {
            uSerialHelper = new UsbSerialHelper();
            Log.i("OpenCPN", "onCreate initUSBSerial");
        }

        // On App Create, we really want the entire app to restart, includiong the Qt parts...
//        if (QtApplication.m_delegateObject != null && QtApplication.onCreate != null) {
//            Log.i("OpenCPN", "onCreate invoking delegate onCreate");
//            QtApplication.invokeDelegateMethod(QtApplication.onCreate, savedInstanceState);
//            return;
//      }

        // Apply any Android specific preference items
        applyAndroidPreferences();

        //----------------------------------------------------------------------------


        buildNotificationBuilder();


        // Set up ActionBar spinner navigation
        actionBar = getActionBar();

        // Setup Spinner title navigation data
        navSpinner = new ArrayList<SpinnerNavItem>();

        spinnerItemRaster = new SpinnerNavItem("Raster", R.drawable.ic_action_map);
        spinnerItemVector = new SpinnerNavItem("Vector", R.drawable.ic_action_map);
        spinnerItemcm93 = new SpinnerNavItem("cm93", R.drawable.ic_action_map);

        // title drop down adapter
        adapter = new TitleNavigationAdapter(getApplicationContext(), navSpinner);
        // assigning the spinner navigation
        actionBar.setListNavigationCallbacks(adapter, this);

        configureNavSpinner(7, 0);

//----------------------------------------------------------------------------

        wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        // On devices supporting (>= API24), establish extended network state callbacks
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
            registerNetworkCallback();
        }

        // Register my desire to get locale change notifications
        IntentFilter filter = new IntentFilter(Intent.ACTION_LOCALE_CHANGED);
        registerReceiver(mLocaleChangeReceiver, filter);

        ENVIRONMENT_VARIABLES += "\tQT_ANDROID_THEME=" + QT_ANDROID_DEFAULT_THEME
                + "/\tQT_ANDROID_THEME_DISPLAY_DPI=" + getResources().getDisplayMetrics().densityDpi + "\t";


        if (null == getLastNonConfigurationInstance()) {
            // if splash screen is defined, then show it
            if (m_activityInfo.metaData.containsKey("android.app.splash_screen"))
                setContentView(m_activityInfo.metaData.getInt("android.app.splash_screen"));

            String tmpdir = "";
            //   ApplicationInfo ai = getApplicationInfo();
            //   if((ai.flags & ApplicationInfo.FLAG_EXTERNAL_STORAGE) ==  ApplicationInfo.FLAG_EXTERNAL_STORAGE)
            //       tmpdir = getExternalFilesDir(null).getPath();
            //   else
            //tmpdir = getFilesDir().getPath();

            tmpdir = getApplicationInfo().dataDir + "/qt-reserved-files/";

            m_bNeworUpdateInstall = !checkCacheVersionValid(tmpdir , "OCPNcache.version");
            boolean b_needcopy = false;

            if(m_bNeworUpdateInstall) {
                b_needcopy = true;

                deleteRecursively(new File(tmpdir ));
            }


            //  Take a look for a specific file in the data directory, just to confirm...
            File testFile = new File(m_filesDir + "/license.txt");
            Log.i("OpenCPN", "Checking for required UI files...");
            if (!testFile.exists()) {
                Log.i("OpenCPN", "Force copy invoked.");
                b_needcopy = true;
            }

            // Create the new cached version file
            if(b_needcopy) {
                try {
                    long packageVersion = -1;
                    try {
                        PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
                        packageVersion = packageInfo.lastUpdateTime;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    ApplicationInfo ai = getApplicationInfo();
                    if ((ai.flags & ApplicationInfo.FLAG_EXTERNAL_STORAGE) == ApplicationInfo.FLAG_EXTERNAL_STORAGE)
                        packageVersion++;

                    File versionFile = new File(tmpdir + "/OCPNcache.version");

                    File parentDirectory = versionFile.getParentFile();
                    if (!parentDirectory.exists())
                        parentDirectory.mkdirs();

                    versionFile.createNewFile();

                    DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(versionFile));
                    outputStream.writeLong(packageVersion);
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


            if (b_needcopy) {
                Log.i("OpenCPN", "b_needcopy true");
            } else {
                Log.i("OpenCPN", "b_needcopy false");
            }


            if (b_needcopy) {
                //Toast.makeText(getApplicationContext(), "Please stand by while OpenCPN initializes..." ,Toast.LENGTH_LONG).show();

                Log.i("OpenCPN", "getSystemDirs(): " + getSystemDirs());

                String dirFiles = m_filesDir;

                Log.i("OpenCPN", "Checking write access to: " + dirFiles);
                File fc = new File(dirFiles);
                boolean bDirReady = false;
                if (!fc.exists()) {
                    Log.i("OpenCPN", "Dir does not exist: " + dirFiles);

                    try {
                        if (fc.mkdirs())
                            bDirReady = true;
                        else{
                            if(fc.isDirectory()){
                                bDirReady = true;
                            }
                            else
                                Log.i("OpenCPN", "mkdirs fails: " + dirFiles);
                        }
                    } catch (Exception e) {
                        Log.i("OpenCPN", "Exception on mkdirs: " + dirFiles);
                    }
                } else
                    bDirReady = true;


                boolean bWrite = false;
                try {
                    if (fc.canWrite()) {
                        bWrite = true;
                    }
                } catch (Exception e) {
                    bWrite = false;
                }

                Log.i("OpenCPN", "Write access check result: " + String.valueOf(bWrite));

                // Actually try a write....
                File testWriteDir = new File(dirFiles + "/uidata");
                try {
                    if (testWriteDir.mkdir()) {
                        Log.i("OpenCPN", "Write access verify resultA: OK");
                    }
                    else{
                        if(testWriteDir.isDirectory()){
                            Log.i("OpenCPN", "Write access verify resultB: OK");
                        }
                        else {
                            Log.i("OpenCPN", "mkdir fails: " + dirFiles + "/uidata");
                            bWrite = false;
                        }
                    }
                } catch (Exception e) {
                    Log.i("OpenCPN", "Write access verify result: FAILS");
                    bWrite = false;
                }


                // Absolute bailout....
                if (!bWrite || !bDirReady) {
                    m_filesDir = getFilesDir().getAbsolutePath();
                    dirFiles = m_filesDir;
                    Log.i("OpenCPN", "Forcing Application filesDir to: " + m_filesDir);
                }


                Log.i("OpenCPN", "asset bridge start unpack");
                Assetbridge.unpackNoDoc(this, dirFiles);
                Log.i("OpenCPN", "asset bridge finish unpack");
            }




            // Validate app permissions
            // Here, thisActivity is the current activity
            if (Build.VERSION.SDK_INT >= 23) {
                Log.i("OpenCPN", "Checking STORAGE permissions");

                if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    // Permission is not granted
                    // No explanation needed; request the permission
                    requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_WRITE_STORAGE);

                    // MY_PERMISSIONS_REQUEST_READ_STORAGE is an
                    // app-defined int constant. The callback method gets the
                    // result of the request.

                } else {
                    // Permission has already been granted
                }
            }
/*
            if (Build.VERSION.SDK_INT >= 19) {
                List<UriPermission> list = getContentResolver().getPersistedUriPermissions();
                for (int i = 0; i < list.size(); i++) {
                    //if (list.get(i).isWritePermission())
                    {
                        getContentResolver().releasePersistableUriPermission(list.get(i).getUri(), FLAG_GRANT_WRITE_URI_PERMISSION);
                        getContentResolver().releasePersistableUriPermission(list.get(i).getUri(), FLAG_GRANT_READ_URI_PERMISSION);

                    }
                }
            }
*/

            startApp(true);

        }
    }

    private void buildNotificationBuilder(){
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {   //6.0

            mNotificationBuilder = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.opencpn_mobile_notification)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            m_notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        }
        else {

            mNotificationBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                    .setSmallIcon(R.drawable.opencpn_mobile_notification)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            m_notificationManager = getSystemService(NotificationManager.class);
            createNotificationChannel();
        }
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "OCPN_DEFAULT_CHANNEL";
            String description = "Normal notifications from OpenCPN";
            int importance = NotificationManager.IMPORTANCE_LOW;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            m_notificationManager = getSystemService(NotificationManager.class);
            m_notificationManager.createNotificationChannel(channel);
        }
    }

    //---------------------------------------------------------------------------


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        if (!QtApplication.invokeDelegate(menu, v, menuInfo).invoked)
            super.onCreateContextMenu(menu, v, menuInfo);
    }

    public void super_onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    //---------------------------------------------------------------------------

    @Override
    public CharSequence onCreateDescription() {
        QtApplication.InvokeResult res = QtApplication.invokeDelegate();
        if (res.invoked)
            return (CharSequence) res.methodReturns;
        else
            return super.onCreateDescription();
    }

    public CharSequence super_onCreateDescription() {
        return super.onCreateDescription();
    }
    //---------------------------------------------------------------------------

    @Override
    protected Dialog onCreateDialog(int id) {
        QtApplication.InvokeResult res = QtApplication.invokeDelegate(id);
        if (res.invoked)
            return (Dialog) res.methodReturns;
        else
            return super.onCreateDialog(id);
    }

    public Dialog super_onCreateDialog(int id) {
        return super.onCreateDialog(id);
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Log.i("DEBUGGER_TAG", "onCreateOptionsMenu");

//      We don't use Qt menu system, since it does not support ActionBar.
//      We handle ActionBar here, in standard Android manner
//
//        QtApplication.InvokeResult res = QtApplication.invokeDelegate(menu);
//        if (res.invoked)
//            return (Boolean)res.methodReturns;
//        else
//            return super.onCreateOptionsMenu(menu);


        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_actions, menu);

        itemRouteAnnunciator = menu.findItem(R.id.ocpn_route_create_active);
        if (null != itemRouteAnnunciator) {
            itemRouteAnnunciator.setVisible(m_showRouteAnnunciator);
        }

        itemRouteMenuItem = menu.findItem(R.id.ocpn_action_createroute);
        if (null != itemRouteMenuItem) {
            itemRouteMenuItem.setVisible(!m_showRouteAnnunciator);
        }


        // Auto follow icon
        itemFollowActive = menu.findItem(R.id.ocpn_action_follow_active);
        itemFollowActiveGreen = menu.findItem(R.id.ocpn_action_follow_active_green);
        itemFollowActiveBlue = menu.findItem(R.id.ocpn_action_follow_active_blue);
        itemFollowInActive = menu.findItem(R.id.ocpn_action_follow);

        if (m_nFollowState == 0) {
            itemFollowInActive.setVisible(true);
            itemFollowActive.setVisible(false);
            itemFollowActiveGreen.setVisible(false);
            itemFollowActiveBlue.setVisible(false);
        } else if (m_nFollowState == 1) {
            itemFollowInActive.setVisible(false);
            itemFollowActive.setVisible(false);
            itemFollowActiveGreen.setVisible(true);
            itemFollowActiveBlue.setVisible(false);
        } else if (m_nFollowState == 2) {
            itemFollowInActive.setVisible(false);
            itemFollowActive.setVisible(false);
            itemFollowActiveGreen.setVisible(false);
            itemFollowActiveBlue.setVisible(true);
        } else {
            itemFollowInActive.setVisible(false);
            itemFollowActive.setVisible(false);
            itemFollowActiveGreen.setVisible(false);
            itemFollowActiveBlue.setVisible(false);
        }

        // Track icon
        itemTrackActive = menu.findItem(R.id.ocpn_action_track_toggle_ison);
        if (null != itemTrackActive) {
            itemTrackActive.setVisible(m_isTrackActive);
        }
        itemTrackInActive = menu.findItem(R.id.ocpn_action_track_toggle_isoff);
        if (null != itemTrackInActive) {
            itemTrackInActive.setVisible(!m_isTrackActive);
        }


        MenuItem itemSendEmailActive = menu.findItem(R.id.ocpn_action_email);
        itemSendEmailActive.setVisible(false);


        return super.onCreateOptionsMenu(menu);


    }

    public boolean super_onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        QtApplication.InvokeResult res = QtApplication.invokeDelegate(featureId, menu);
        if (res.invoked)
            return (Boolean) res.methodReturns;
        else
            return super.onCreatePanelMenu(featureId, menu);
    }

    public boolean super_onCreatePanelMenu(int featureId, Menu menu) {
        return super.onCreatePanelMenu(featureId, menu);
    }
    //---------------------------------------------------------------------------


    @Override
    public View onCreatePanelView(int featureId) {
        QtApplication.InvokeResult res = QtApplication.invokeDelegate(featureId);
        if (res.invoked)
            return (View) res.methodReturns;
        else
            return super.onCreatePanelView(featureId);
    }

    public View super_onCreatePanelView(int featureId) {
        return super.onCreatePanelView(featureId);
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
        QtApplication.InvokeResult res = QtApplication.invokeDelegate(outBitmap, canvas);
        if (res.invoked)
            return (Boolean) res.methodReturns;
        else
            return super.onCreateThumbnail(outBitmap, canvas);
    }

    public boolean super_onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
        return super.onCreateThumbnail(outBitmap, canvas);
    }
    //---------------------------------------------------------------------------

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
//        Toast.makeText(getApplicationContext(), "onCreateView " + name,Toast.LENGTH_LONG).show();

        QtApplication.InvokeResult res = QtApplication.invokeDelegate(name, context, attrs);
        if (res.invoked)
            return (View) res.methodReturns;
        else
            return super.onCreateView(name, context, attrs);
    }

    public View super_onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }
    //---------------------------------------------------------------------------

    @Override
    protected void onDestroy() {
        //Toast.makeText(getApplicationContext(), "onDestroy",Toast.LENGTH_LONG).show();
        Log.i("OpenCPN", "onDestroy " + this);

        nativeLib.onDestroy();

        // Disconnect the Locale broadcast receiver
        unregisterReceiver(mLocaleChangeReceiver);


        super.onDestroy();

        Log.i("OpenCPN", "onDestroy Done");

        //  All ready to kill the process.
        //  this must be done to clean up Qt, and allow subsequent App restarts

        System.exit(0);

    }
    //---------------------------------------------------------------------------


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            Log.i("OpenCPN", "Menu up");
            return false;
        }


        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        audioManager.playSoundEffect(AudioManager.FX_KEY_CLICK);

        if (QtApplication.m_delegateObject != null && QtApplication.onKeyDown != null)
            return (Boolean) QtApplication.invokeDelegateMethod(QtApplication.onKeyDown, keyCode, event);
        else
            return super.onKeyDown(keyCode, event);
    }

    public boolean super_onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }
    //---------------------------------------------------------------------------


    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        if (QtApplication.m_delegateObject != null && QtApplication.onKeyMultiple != null)
            return (Boolean) QtApplication.invokeDelegateMethod(QtApplication.onKeyMultiple, keyCode, repeatCount, event);
        else
            return super.onKeyMultiple(keyCode, repeatCount, event);
    }

    public boolean super_onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        return super.onKeyMultiple(keyCode, repeatCount, event);
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            Log.i("OpenCPN", "Menu up");
            return false;
        }


        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Log.i("OpenCPN", "TLWCount " + nativeLib.getTLWCount());

            if (!m_backButtonEnable)
                return false;

            if (nativeLib.getTLWCount() <= 3) {

                if (this.lastBackPressTime < System.currentTimeMillis() - 3000) {
                    toast = Toast.makeText(this, "Press back again to close OpenCPN", 3000);
                    toast.show();
                    this.lastBackPressTime = System.currentTimeMillis();
                    return false;
                } else {
                    Log.i("OpenCPN", "Processing double-back key");
                    this.lastBackPressTime = System.currentTimeMillis();
                    if (toast != null)
                        toast.cancel();

                    // Set a marker, to avoid calling onStop delegate during exit (Qt bug)
                    m_inExit = true;

                    // Quickly stop the GPS service here, to avoid an orphan
                    quickStopGpsService();

                    // Kill any leftover notification
                    m_notificationManager.cancel(FGBG_notificationID);


                }
            }
        }

        if (QtApplication.m_delegateObject != null && QtApplication.onKeyDown != null)
            return (Boolean) QtApplication.invokeDelegateMethod(QtApplication.onKeyUp, keyCode, event);
        else
            return super.onKeyUp(keyCode, event);
    }

    public boolean super_onKeyUp(int keyCode, KeyEvent event) {
        return super.onKeyUp(keyCode, event);
    }
    //---------------------------------------------------------------------------

    @Override
    public void onLowMemory() {
        if (!QtApplication.invokeDelegate().invoked)
            super.onLowMemory();
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        QtApplication.InvokeResult res = QtApplication.invokeDelegate(featureId, item);
        if (res.invoked)
            return (Boolean) res.methodReturns;
        else
            return super.onMenuItemSelected(featureId, item);
    }

    public boolean super_onMenuItemSelected(int featureId, MenuItem item) {
        return super.onMenuItemSelected(featureId, item);
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        QtApplication.InvokeResult res = QtApplication.invokeDelegate(featureId, menu);
        if (res.invoked)
            return (Boolean) res.methodReturns;
        else
            return super.onMenuOpened(featureId, menu);
    }

    public boolean super_onMenuOpened(int featureId, Menu menu) {
        return super.onMenuOpened(featureId, menu);
    }
    //---------------------------------------------------------------------------

    @Override
    protected void onNewIntent(Intent intent) {
        if (!QtApplication.invokeDelegate(intent).invoked)
            super.onNewIntent(intent);

        Log.i("OpenCPN", "onNewIntent " + this);
/*
        if (UsbManager.ACTION_USB_DEVICE_ATTACHED.equals(intent.getAction())) {
            //LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
            Log.i("DEBUGGER_TAG", "ACTION_USB_DEVICE_ATTACHED");

        }
*/
    }

    public void super_onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        QtApplication.InvokeResult res = QtApplication.invokeDelegate(item);
//        if (res.invoked)
//            return (Boolean)res.methodReturns;
//        else
//            return super.onOptionsItemSelected(item);

        if(!m_optionsItemActionEnable)          // option items may be disabled by core
            return super.onOptionsItemSelected(item);

        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case R.id.ocpn_action_follow:
                //Log.i("DEBUGGER_TAG", "Invoke OCPN_ACTION_FOLLOW while in-active");
                nativeLib.invokeMenuItem(OCPN_ACTION_FOLLOW);
                return true;

            case R.id.ocpn_action_follow_active_blue:
            case R.id.ocpn_action_follow_active_green:
                //Log.i("DEBUGGER_TAG", "Invoke OCPN_ACTION_FOLLOW while active");
                nativeLib.invokeMenuItem(OCPN_ACTION_FOLLOW);
                return true;

            case R.id.ocpn_action_settings_basic:
                nativeLib.invokeMenuItem(OCPN_ACTION_SETTINGS_BASIC);
                return true;

            case R.id.ocpn_action_routemanager:
                nativeLib.invokeMenuItem(OCPN_ACTION_RMD);
                return true;

            case R.id.ocpn_action_track_toggle_ison:
                nativeLib.invokeMenuItem(OCPN_ACTION_TRACK_TOGGLE);
                return true;

            case R.id.ocpn_action_track_toggle_isoff:
                nativeLib.invokeMenuItem(OCPN_ACTION_TRACK_TOGGLE);
                return true;

            case R.id.ocpn_action_createroute:              // entering Route Create Mode
                nativeLib.invokeMenuItem(OCPN_ACTION_ROUTE);
                return true;

            case R.id.ocpn_route_create_active:             // exiting Route Create mode
                nativeLib.invokeMenuItem(OCPN_ACTION_ROUTE);
                return true;

            case R.id.ocpn_action_mob:
                nativeLib.invokeMenuItem(OCPN_ACTION_MOB);
                return true;

            case R.id.ocpn_action_tides:
                nativeLib.invokeMenuItem(OCPN_ACTION_TIDES_TOGGLE);
                return true;

            case R.id.ocpn_action_currents:
                nativeLib.invokeMenuItem(OCPN_ACTION_CURRENTS_TOGGLE);
                return true;

            case R.id.ocpn_action_encText:
                nativeLib.invokeMenuItem(OCPN_ACTION_ENCTEXT_TOGGLE);
                return true;

            case R.id.ocpn_action_encSoundings:
                nativeLib.invokeMenuItem(OCPN_ACTION_ENCSOUNDINGS_TOGGLE);
                return true;

            case R.id.ocpn_action_encLights:
                nativeLib.invokeMenuItem(OCPN_ACTION_ENCLIGHTS_TOGGLE);
                return true;

            case R.id.ocpn_action_googlemaps:
                invokeGoogleMaps();
                return true;

            case R.id.ocpn_action_toggle_fullscreen:
                toggleFullscreen();
                return true;

            case R.id.ocpn_action_email:
                ShareViaEmail("OCPN_logs", "OCPN_logcat.txt");
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public boolean super_onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
    //---------------------------------------------------------------------------

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        if (!QtApplication.invokeDelegate(menu).invoked)
            super.onOptionsMenuClosed(menu);
    }

    public void super_onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }
    //---------------------------------------------------------------------------

    @Override
    public void onPanelClosed(int featureId, Menu menu) {
        if (!QtApplication.invokeDelegate(featureId, menu).invoked)
            super.onPanelClosed(featureId, menu);
    }

    public void super_onPanelClosed(int featureId, Menu menu) {
        super.onPanelClosed(featureId, menu);
    }
    //---------------------------------------------------------------------------

    @Override
    protected void onPause() {
        Log.i("OpenCPN", "onPause " + this);

        if (ToastTimerRunning) {
            mtoastCountDown.cancel();
            Log.i("OpenCPN", "onPause " + "Stopping toast timer");
        }

        if (null != nativeLib)
            nativeLib.onPause();

        // Disconnect the SailTimer API broadcast receiver
        unregisterReceiver(mGattUpdateReceiver);

        // if background tracking is enabled, post a specific notification
        if (m_trackContinuous && !m_inExit) {
            mNotificationBuilder.setContentTitle("OpenCPN Message")
                    .setContentText("OpenCPN is tracking device location in background.")
                    .setSmallIcon(R.drawable.opencpn_mobile_notification)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            // notificationID allows you to update the notification later on.
            mNotificationManager.notify(FGBG_notificationID, mNotificationBuilder.build());
        }


        super.onPause();
        if (!m_inExit)
            QtApplication.invokeDelegate();

        Log.i("OpenCPN", "onPause done");

        // Sometimes, the Qt backend does not allow the Java frontend to call onStop() and onDestroy()
        // after a double-back click.
        // When this happens, the app is left in an undefined state, since the wxWidgets event loop is gone.
        // If we detect this case, the simple, but draconian solution is to kill the app summarily after 3 seconds
        if(m_inExit) {
            new ANRWatchDog(3000).setANRListener(new ANRWatchDog.ANRListener() {
                @Override
                public void onAppNotResponding(ANRError error) {
                    Log.i( "OpenCPN","***ANR Exit");
                    finish();
                    System.exit(0);

                }
            }).start();
        }

    }
    //---------------------------------------------------------------------------

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        QtApplication.invokeDelegate(savedInstanceState);
    }
    //---------------------------------------------------------------------------

    @Override
    protected void onPostResume() {
        super.onPostResume();
        QtApplication.invokeDelegate();
    }
    //---------------------------------------------------------------------------

    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        if (!QtApplication.invokeDelegate(id, dialog).invoked)
            super.onPrepareDialog(id, dialog);
    }

    public void super_onPrepareDialog(int id, Dialog dialog) {
        super.onPrepareDialog(id, dialog);
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        //Log.i("DEBUGGER_TAG", "onPrepareOptionsMenu");


// Use native instead og Qt
//        QtApplication.InvokeResult res = QtApplication.invokeDelegate(menu);
//        if (res.invoked)
//            return (Boolean)res.methodReturns;
//        else
//            return super.onPrepareOptionsMenu(menu);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {

            // set the icon

            // crashes here on some 3.2 devices
            // So, lets require at least Version 4.0 for this method
            if (Build.VERSION.SDK_INT >= 14) {
                actionBar.setLogo(R.drawable.opencpn_mobile);
                actionBar.setDisplayUseLogoEnabled(true);
            }


            //  Use transparent ActionBar background?
            //getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);//or add in style.xml
            //ColorDrawable newColor = new ColorDrawable(getResources().getColor(R.color.action_bar_color));//your color from res
            //newColor.setAlpha(0);//from 0(0%) to 256(100%)
            //getActionBar().setBackgroundDrawable(newColor);

            actionBar.show();
        }


        super.onPrepareOptionsMenu(menu);


        // Fix action bar menu text color on some late-model Android devices
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN_MR2) {          //18
            for (int i = 0; i < menu.size(); i++) {
                MenuItem menuItem = menu.getItem(i);
                if (menuItem != null) {
                    CharSequence menuTitle = menuItem.getTitle();
                    SpannableString styledMenuTitle = new SpannableString(menuTitle);
                    styledMenuTitle.setSpan(new ForegroundColorSpan(Color.WHITE), 0, menuTitle.length(), 0);
                    menuItem.setTitle(styledMenuTitle);
                }
            }
        }


        return optionsMenuEnabled;
    }

    public boolean super_onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        QtApplication.InvokeResult res = QtApplication.invokeDelegate(featureId, view, menu);
        if (res.invoked)
            return (Boolean) res.methodReturns;
        else
            return super.onPreparePanel(featureId, view, menu);
    }

    public boolean super_onPreparePanel(int featureId, View view, Menu menu) {
        return super.onPreparePanel(featureId, view, menu);
    }
    //---------------------------------------------------------------------------

    @Override
    protected void onRestart() {
        Log.i("OpenCPN", "onRestart");
        super.onRestart();
        QtApplication.invokeDelegate();
    }
    //---------------------------------------------------------------------------

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (!QtApplication.invokeDelegate(savedInstanceState).invoked)
            super.onRestoreInstanceState(savedInstanceState);
    }

    public void super_onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
    //---------------------------------------------------------------------------

    @Override
    protected void onResume() {
        Log.i("OpenCPN", "onResume " + this);


        if (null != nativeLib)
            nativeLib.onResume();


        if (null != uSerialHelper) {
            uSerialHelper.initUSBSerial(this);
            m_scannedSerial = scanSerialPorts(UsbSerialHelper.SCAN);      // Full scan.
        }

        super.onResume();

        //Register SailTimer broadcast receiver for updates
        registerReceiver(mGattUpdateReceiver, makeGattUpdateIntentFilter());

        QtApplication.invokeDelegate();
    }

    //---------------------------------------------------------------------------
/*
    @Override
    public Object onRetainNonConfigurationInstance()
    {
        Log.i("OpenCPN", "onRetainNonConfigurationInstance "  + this);

        // We return "null" here, to induce the onCreate method to completely re-init the application
        // This is a bit sub-optimal, but happens mainly on locale changes.
        return null;

//        QtApplication.InvokeResult res = QtApplication.invokeDelegate();
//        if (res.invoked)
//            return res.methodReturns;
//        else
//            return super.onRetainNonConfigurationInstance();
    }
*/
    public Object super_onRetainNonConfigurationInstance() {
        return super.onRetainNonConfigurationInstance();
    }
    //---------------------------------------------------------------------------

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (!QtApplication.invokeDelegate(outState).invoked)
            super.onSaveInstanceState(outState);
    }

    public void super_onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }
    //---------------------------------------------------------------------------

    @Override
    public boolean onSearchRequested() {
        QtApplication.InvokeResult res = QtApplication.invokeDelegate();
        if (res.invoked)
            return (Boolean) res.methodReturns;
        else
            return super.onSearchRequested();
    }

    public boolean super_onSearchRequested() {
        return super.onSearchRequested();
    }
    //---------------------------------------------------------------------------

    @Override
    protected void onStart() {
        Log.i("OpenCPN", "onStart " + this);

        m_notificationManager.cancel(FGBG_notificationID);

        nativeLib.onStart();

        super.onStart();

        QtApplication.invokeDelegate();
    }
    //---------------------------------------------------------------------------

    @Override
    protected void onStop() {
        Log.i("OpenCPN", "onStop " + this);

        if (ToastTimerRunning) {
            mtoastCountDown.cancel();
            Log.i("OpenCPN", "onStop " + "Stopping toast timer");
        }


        nativeLib.onStop();

        // May, 2021...
        // App version 5.2.6/76
        // Google no longer allows background location access without specific app review and approval.
        // We comply by explicitly stopping the GPSServer when the app leaves the foreground.

        // June, 2022
        // App Version 5.2.6/95+
        // On research, it seems OK to use a "foreground-started" service for app background location access
        //  as long as a notification is posted communicating this fact to the user.
        // So, here we only need to stop the the service if continuous tracking is not requested
        // The notification is posted in OnPause() method.

        if(!m_trackContinuous)
            queryGPSServer(GPSServer.GPS_OFF);

        if (null != uSerialHelper)
            uSerialHelper.deinitUSBSerial(this);

        Log.i("OpenCPN", "onStop calling super");
        super.onStop();
//        if(!m_inExit)
//            QtApplication.invokeDelegate();

        // on "un-commanded" onStop(), we need to spin allowing time for the
        // NDK library to persist OCPN data in its own thread.
        // This persist operation is triggered on the wxWidgets event handler
        // by nativeLib.onStop().
        if(!m_inExit) {
            Log.i("OpenCPN", "onStop Spin...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

        Log.i("OpenCPN", "onStop Done");

    }
    //---------------------------------------------------------------------------

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        if (!QtApplication.invokeDelegate(title, color).invoked)
            super.onTitleChanged(title, color);
    }

    public void super_onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (QtApplication.m_delegateObject != null && QtApplication.onTouchEvent != null)
            return (Boolean) QtApplication.invokeDelegateMethod(QtApplication.onTouchEvent, event);
        else
            return super.onTouchEvent(event);
    }

    public boolean super_onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        if (QtApplication.m_delegateObject != null && QtApplication.onTrackballEvent != null)
            return (Boolean) QtApplication.invokeDelegateMethod(QtApplication.onTrackballEvent, event);
        else
            return super.onTrackballEvent(event);
    }

    public boolean super_onTrackballEvent(MotionEvent event) {
        return super.onTrackballEvent(event);
    }
    //---------------------------------------------------------------------------

    @Override
    public void onUserInteraction() {
        if (!QtApplication.invokeDelegate().invoked)
            super.onUserInteraction();
    }

    public void super_onUserInteraction() {
        super.onUserInteraction();
    }
    //---------------------------------------------------------------------------

    @Override
    protected void onUserLeaveHint() {
        if (!QtApplication.invokeDelegate().invoked)
            super.onUserLeaveHint();
    }

    public void super_onUserLeaveHint() {
        super.onUserLeaveHint();
    }
    //---------------------------------------------------------------------------

    @Override
    public void onWindowAttributesChanged(LayoutParams params) {
        if (!QtApplication.invokeDelegate(params).invoked)
            super.onWindowAttributesChanged(params);
    }

    public void super_onWindowAttributesChanged(LayoutParams params) {
        super.onWindowAttributesChanged(params);
    }
    //---------------------------------------------------------------------------

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (!QtApplication.invokeDelegate(hasFocus).invoked)
            super.onWindowFocusChanged(hasFocus);

    if (hasFocus) {
            if (m_fullScreen) {
/*
                 getWindow ().getDecorView().setSystemUiVisibility(
                         View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                         | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                         | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                         | View.SYSTEM_UI_FLAG_FULLSCREEN
                         | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
*/
                int flags = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;


//                if(!m_showAction){
//                    flags |= View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//                }

                getWindow().getDecorView().setSystemUiVisibility(flags);


            }
            //           else{
            //               getWindow ().getDecorView().setSystemUiVisibility(0);
            //           }
        }

    }

    public void super_onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }
    //---------------------------------------------------------------------------

    //////////////// Activity API 5 /////////////
//ANDROID-5
    @Override
    public void onAttachedToWindow() {
        if (!QtApplication.invokeDelegate().invoked)
            super.onAttachedToWindow();
    }

    public void super_onAttachedToWindow() {
        super.onAttachedToWindow();
    }
    //---------------------------------------------------------------------------

    private Toast toast;
    private long lastBackPressTime = 0;

    @Override
    public void onBackPressed() {
        //Log.i("OpenCPN", "Back Press");

        if (this.lastBackPressTime < System.currentTimeMillis() - 3000) {
            toast = Toast.makeText(this, "Press back again to close OpenCPN", 3000);
            toast.show();
            this.lastBackPressTime = System.currentTimeMillis();
        } else {
            if (toast != null) {
                toast.cancel();
            }

            if (!QtApplication.invokeDelegate().invoked)
                super.onBackPressed();
        }
    }

    /*
        @Override
        public void onBackPressed()
        {

            if (!QtApplication.invokeDelegate().invoked)
                super.onBackPressed();
        }
    */
    public void super_onBackPressed() {
        super.onBackPressed();
    }
    //---------------------------------------------------------------------------

    @Override
    public void onDetachedFromWindow() {
        if (!QtApplication.invokeDelegate().invoked)
            super.onDetachedFromWindow();
    }

    public void super_onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        Log.i("OpenCPN", "Long press");

        if (QtApplication.m_delegateObject != null && QtApplication.onKeyLongPress != null)
            return (Boolean) QtApplication.invokeDelegateMethod(QtApplication.onKeyLongPress, keyCode, event);
        else
            return super.onKeyLongPress(keyCode, event);
    }

    public boolean super_onKeyLongPress(int keyCode, KeyEvent event) {
        return super.onKeyLongPress(keyCode, event);
    }
    //---------------------------------------------------------------------------
//ANDROID-5

    //////////////// Activity API 8 /////////////
//ANDROID-8
    @Override
    protected Dialog onCreateDialog(int id, Bundle args) {
        QtApplication.InvokeResult res = QtApplication.invokeDelegate(id, args);
        if (res.invoked)
            return (Dialog) res.methodReturns;
        else
            return super.onCreateDialog(id, args);
    }

    public Dialog super_onCreateDialog(int id, Bundle args) {
        return super.onCreateDialog(id, args);
    }
    //---------------------------------------------------------------------------

    @Override
    protected void onPrepareDialog(int id, Dialog dialog, Bundle args) {
        if (!QtApplication.invokeDelegate(id, dialog, args).invoked)
            super.onPrepareDialog(id, dialog, args);
    }

    public void super_onPrepareDialog(int id, Dialog dialog, Bundle args) {
        super.onPrepareDialog(id, dialog, args);
    }
    //---------------------------------------------------------------------------
//ANDROID-8
    //////////////// Activity API 11 /////////////

    //ANDROID-11
    @Override
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        if (QtApplication.m_delegateObject != null && QtApplication.dispatchKeyShortcutEvent != null)
            return (Boolean) QtApplication.invokeDelegateMethod(QtApplication.dispatchKeyShortcutEvent, event);
        else
            return super.dispatchKeyShortcutEvent(event);
    }

    public boolean super_dispatchKeyShortcutEvent(KeyEvent event) {
        return super.dispatchKeyShortcutEvent(event);
    }
    //---------------------------------------------------------------------------

    @Override
    public void onActionModeFinished(ActionMode mode) {
        if (!QtApplication.invokeDelegate(mode).invoked)
            super.onActionModeFinished(mode);
    }

    public void super_onActionModeFinished(ActionMode mode) {
        super.onActionModeFinished(mode);
    }
    //---------------------------------------------------------------------------

    @Override
    public void onActionModeStarted(ActionMode mode) {
        if (!QtApplication.invokeDelegate(mode).invoked)
            super.onActionModeStarted(mode);
    }

    public void super_onActionModeStarted(ActionMode mode) {
        super.onActionModeStarted(mode);
    }
    //---------------------------------------------------------------------------

    @Override
    public void onAttachFragment(Fragment fragment) {
        if (!QtApplication.invokeDelegate(fragment).invoked)
            super.onAttachFragment(fragment);
    }

    public void super_onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
    }
    //---------------------------------------------------------------------------

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        QtApplication.InvokeResult res = QtApplication.invokeDelegate(parent, name, context, attrs);
        if (res.invoked)
            return (View) res.methodReturns;
        else
            return super.onCreateView(parent, name, context, attrs);
    }

    public View super_onCreateView(View parent, String name, Context context,
                                   AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        if (QtApplication.m_delegateObject != null && QtApplication.onKeyShortcut != null)
            return (Boolean) QtApplication.invokeDelegateMethod(QtApplication.onKeyShortcut, keyCode, event);
        else
            return super.onKeyShortcut(keyCode, event);
    }

    public boolean super_onKeyShortcut(int keyCode, KeyEvent event) {
        return super.onKeyShortcut(keyCode, event);
    }
    //---------------------------------------------------------------------------

    @Override
    public ActionMode onWindowStartingActionMode(Callback callback) {
        QtApplication.InvokeResult res = QtApplication.invokeDelegate(callback);
        if (res.invoked)
            return (ActionMode) res.methodReturns;
        else
            return super.onWindowStartingActionMode(callback);
    }

    public ActionMode super_onWindowStartingActionMode(Callback callback) {
        return super.onWindowStartingActionMode(callback);
    }
    //---------------------------------------------------------------------------
//ANDROID-11
    //////////////// Activity API 12 /////////////

    //ANDROID-12
    @Override
    public boolean dispatchGenericMotionEvent(MotionEvent ev) {
        //Toast.makeText(getApplicationContext(), "dispatchGenericMotionEvent",Toast.LENGTH_LONG).show();

        if (QtApplication.m_delegateObject != null && QtApplication.dispatchGenericMotionEvent != null)
            return (Boolean) QtApplication.invokeDelegateMethod(QtApplication.dispatchGenericMotionEvent, ev);
        else
            return super.dispatchGenericMotionEvent(ev);
    }

    public boolean super_dispatchGenericMotionEvent(MotionEvent event) {
        return super.dispatchGenericMotionEvent(event);
    }
    //---------------------------------------------------------------------------

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        if (0 != (event.getSource() & InputDevice.SOURCE_CLASS_POINTER)) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_SCROLL:
                    if (event.getAxisValue(MotionEvent.AXIS_VSCROLL) < 0.0f) {
                        Log.i("OpenCPN", "Scroll Up");
                        nativeLib.onMouseWheel(-1);
                    } else {
                        Log.i("OpenCPN", "Scroll Down");
                        nativeLib.onMouseWheel(1);
                    }
            }
        }

        if (QtApplication.m_delegateObject != null && QtApplication.onGenericMotionEvent != null)
            return (Boolean) QtApplication.invokeDelegateMethod(QtApplication.onGenericMotionEvent, event);
        else
            return super.onGenericMotionEvent(event);
    }

    public boolean super_onGenericMotionEvent(MotionEvent event) {
        return super.onGenericMotionEvent(event);
    }
    //---------------------------------------------------------------------------
//ANDROID-12


    private void ShareViaEmail(String folder_name, String file_name) {
        try {
            File Root = getExternalCacheDir();
            String filelocation = Root.getAbsolutePath() + "/" + folder_name + "/" + file_name;
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setType("text/plain");
            String message = "File to be shared is " + filelocation + ".";
            intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
            intent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://" + filelocation));
            intent.putExtra(Intent.EXTRA_TEXT, message);
            intent.setData(Uri.parse("mailto:bdbcat@yahoo.com"));
            intent.addFlags(FLAG_ACTIVITY_NEW_TASK);

            startActivity(intent);
        } catch (Exception e) {
            System.out.println("Exception raised during sending mail" + e);
        }
    }


    public String getExtSdCardFolder(final File file) {
        String[] extSdPaths = getExtSdCardPaths();
        try {
            for (int i = 0; i < extSdPaths.length; i++) {
                if (file.getCanonicalPath().startsWith(extSdPaths[i])) {
                    return extSdPaths[i];
                }
            }
        } catch (IOException e) {
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
            if (fullPath.length() > baseFolder.length())
                relativePath = fullPath.substring(baseFolder.length() + 1);
            else
                relativePath = "";
        } catch (IOException e) {
            return null;
        }

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String sUri = preferences.getString("SDURI", "");
        if (sUri.isEmpty())
            return null;

        Uri ltreeUri = Uri.parse(sUri);

        if (ltreeUri == null) {
            return null;
        }


        // start with root of SD card and then parse through document tree.
        DocumentFile document = DocumentFile.fromTreeUri(this, ltreeUri);

        if (relativePath.isEmpty())
            return document;

        try {
            String[] parts = relativePath.split("\\/");
            for (int i = 0; i < parts.length; i++) {
                DocumentFile nextDocument = document.findFile(parts[i]);

                if (nextDocument == null) {
                    if (!bCreate)
                        return null;
                    if ((i < parts.length - 1) || isDirectory) {
                        nextDocument = document.createDirectory(parts[i]);
                    } else {
                        nextDocument = document.createFile("image", parts[i]);
                    }
                }
                document = nextDocument;
            }
        } catch (Exception e) {
            int yyp = 0;
        }

        return document;
    }


    private String SecureFileCopy(String inFile, String outFile) {
        Log.i("OpenCPN", "SecureFileCopy: " + inFile + " to: " + outFile);

        try {
            FileOutputStream outStream = null;
            FileInputStream inStream;

            //  Is destination on an SDCard?
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
                File outFileObj = new File(outFile);
                String sdRoot = getExtSdCardFolder(outFileObj);
                if (null != sdRoot) {
                    Log.i("OpenCPN", "SecureFileCopy destination on SDCard");

                    if (Build.VERSION.SDK_INT >= 30) {      // Android 11 does not need permission to write on private dir
                        File xfiles[] = getExternalFilesDirs(null);
                        if (xfiles.length > 1) {
                            String sdHome = "";
                            try {
                                sdHome = xfiles[1].getCanonicalPath();
                            } catch (Exception e) {
                            }

                            if (outFile.startsWith(sdHome))
                                outStream = new FileOutputStream(outFile);
                        }
                    }

                    else {
                        DocumentFile targetDF = getDocumentFile(outFileObj, false, true);

                        try {
                            OutputStream os = getContentResolver().openOutputStream(targetDF.getUri());
                            outStream = (FileOutputStream) os;
                        } catch (Exception e) {
                            Log.i("OpenCPN", "SecureFileCopy ExceptionB");
                        }
                    }

                } else {
                    outStream = new FileOutputStream(outFile);
                }
            } else {
                Log.i("OpenCPN", "SecureFileCopy destination on internal storage");
                try {
                    outStream = new FileOutputStream(outFile);
                } catch (Exception e) {
                    Log.i("OpenCPN", "SecureFileCopy ExceptionC");
                    return "Exception";
                }
            }

            inStream = new FileInputStream(inFile);

            try {
                copyFile(inStream, outStream);
            } catch (Exception e) {
                Log.i("OpenCPN", "SecureFileCopy ExceptionA");
            }


            return "OK";

        } catch (Exception e) {
            Log.i("OpenCPN", "SecureFileCopy Exception");
            return "Exception";
        }


    }


    private void startSAFDialog(final int code) {
        ContextThemeWrapper ctw = new ContextThemeWrapper(this, R.style.AlertTheme1);
        AlertDialog.Builder builder1 = new AlertDialog.Builder(ctw);

        String msg = getString(R.string.sdcard_permission_help);
        builder1.setMessage(msg);
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();

                        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE);
                        intent.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
                        intent.addFlags(FLAG_GRANT_READ_URI_PERMISSION);
                        startActivityForResult(intent, code);


                    }
                });

        //builder1.setNegativeButton(
        //        "No",
        //        new DialogInterface.OnClickListener() {
        //            public void onClick(DialogInterface dialog, int id) {
        //                dialog.cancel();
        //            }
        //        });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    private void showPermisionGrantedDialog(boolean bGranted) {
        ContextThemeWrapper ctw = new ContextThemeWrapper(this, R.style.AlertTheme1);
        AlertDialog.Builder builder1 = new AlertDialog.Builder(ctw);

        if (bGranted)
            builder1.setMessage(R.string.permission_granted);
        else
            builder1.setMessage(R.string.permission_denied);

        builder1.setCancelable(true);

        builder1.setPositiveButton(R.string.ok_string,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });


        AlertDialog alert11 = builder1.create();
        alert11.show();

    }


    /**
     * Receiver for broadcasts sent by {@link LocationUpdatesService}.
     */
    private int ncb = 0;

    private class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(foregrounded())
                Log.i("OpenCPN", "FOREGROUND");
            else
                Log.i("OpenCPN", "BACKGROUND");


            Location location = intent.getParcelableExtra(LocationUpdatesService.EXTRA_LOCATION);
            if (location != null) {
                String msg = GPSServer.createRMC(location);
                //Log.i("OpenCPN", String.valueOf(ncb) + " " + msg);

                if(null != nativeLib){
                    nativeLib.processNMEA( msg );
                }

                ncb++;

                //Toast.makeText(QtActivity.this, getLocationText(location), Toast.LENGTH_SHORT).show();
            }
        }
    }


    public boolean foregrounded() {
        ActivityManager.RunningAppProcessInfo appProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(appProcessInfo);
        return (appProcessInfo.importance == IMPORTANCE_FOREGROUND || appProcessInfo.importance == IMPORTANCE_VISIBLE);
    }


    public String g_migrateResult = "";
    public boolean g_migrateCancel = false;
    public boolean g_migrateActive = false;
    public boolean m_SAFmigrateChooserActive = false;
    public String m_SAFmigrateChooserString = "";
    public String g_migrateMessage = "";
    public int g_folderCount = 0;
    public Uri g_migrateSourceFolderURI = null;

    public String migrateSetup() {
        DisableRotation();
        m_SAFmigrateChooserActive = true;

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE);
                intent.putExtra("android.content.extra.SHOW_ADVANCED", true);
                intent.putExtra("android.content.extra.INITIAL_URI", "content://com.android.externalstorage.documents/root/primary");
                startActivityForResult(intent, OCPN_SAF_DIALOG_MIGRATE_REQUEST_CODE);
            }
        });

        return "OK";
    }

    public String migrateFolder( String sourceFolder, String destFolder) {
        doMigrateAsync( sourceFolder, destFolder);
        return "OK";
    }

    public String cancelMigration(){
        EnableRotation();
        g_migrateCancel = true;
        return "OK";
    }



    class MigrateFolderTask extends AsyncTask<String, String, String> {

        private List<DocumentFile> walkTreeForDirs( DocumentFile dir){
            List<DocumentFile> fileTree = new ArrayList<DocumentFile>();
            DocumentFile[] array = dir.listFiles();


            for (int i = 0; i < array.length; i++) {
                g_migrateMessage = "Counting folders: " + Integer.toString(g_folderCount);
                g_folderCount++;

                if (array[i].isDirectory()) {
                    if (!containsDirectory(array[i]) )
                        fileTree.add(array[i]);
                    else if (containsFile(array[i])) {
                        fileTree.add(array[i]);
                        fileTree.addAll(walkTreeForDirs(array[i]));
                    }
                    else
                        fileTree.addAll(walkTreeForDirs(array[i]));
                }

                if (g_migrateCancel) {
                    fileTree.clear();
                    break;
                }
            }

            if (g_migrateCancel) {
                fileTree.clear();
            }


            return fileTree;
        }

        private boolean containsDirectory( DocumentFile dir){
            DocumentFile[] array = dir.listFiles();

            for( int i=0 ; i < array.length ; i++) {
                if (array[i].isDirectory()) {
                    return true;
                }
            }
            return  false;

        }
        private boolean containsFile( DocumentFile dir){
            DocumentFile[] array = dir.listFiles();

            for( int i=0 ; i < array.length ; i++) {
                if (array[i].isFile()) {
                    return true;
                }
            }
            return  false;

        }

        @Override
        protected String doInBackground(String... arg0) {

            DisableRotation();

            g_migrateActive = true;
            String rv = "";

            String srcPath = arg0[0]; //"/storage/emulated/0/Charts/RNC/US_REGION02";
            DocumentFile source = DocumentFile.fromTreeUri(getApplicationContext(), g_migrateSourceFolderURI);

            // Get a list of all unique folders
            List<DocumentFile> dirList = walkTreeForDirs( source );

            // If the source has no subdirs, or has files, we just want to copy itself
            if(dirList.isEmpty()){
                dirList.add( source );
            }

            if(containsFile(source)) {
                dirList.add( source );
            }


            int iFile = 0;
            for (DocumentFile file : dirList) {
                if (g_migrateCancel) {
                    rv = "canceled";
                    break;
                }
                String exceptionError;

                if (file.isDirectory()) {

                    Log.i("OpenCPN", "Migrating: " + file.getName());

                    //Make the target directory
                    String path = file.getUri().getPath();

                    File tfile = new File(file.getUri().getPath());//create path from uri
                    final String[] split = tfile.getPath().split(":");//split the path.

                    String sdestDir = arg0[1] + "/MigratedCharts/" + split[2];
                    File destDir = new File(sdestDir);

                    if (!destDir.exists()) {
                        destDir.mkdirs();
                    }

                    // Copy all the files

                    DocumentFile[] array = file.listFiles();
                    for (int i = 0; i < array.length; i++) {

                        if (!array[i].isFile())
                            continue;

                        if (g_migrateCancel) {
                            rv = "canceled";
                            break;
                        }

                        InputStream inStream;
                        BufferedInputStream binStream;
                        try {
                            inStream = getContentResolver().openInputStream(array[i].getUri());
                            binStream = new BufferedInputStream(inStream);

                            String fileName = sdestDir + "/" + array[i].getName();
                            File ffileName = new File(fileName);
                            if(ffileName.exists())
                                ffileName.delete();



                            g_migrateMessage = "Migrating " + iFile + "/" + dirList.size() + ";" + array[i].getName();
                            Log.i("OpenCPN",  g_migrateMessage);

                            OutputStream outStream = new FileOutputStream(fileName);

                            byte[] buffer = new byte[32 * 1024];
                            int read;
                            while ((read = inStream.read(buffer)) != -1) {
                                outStream.write(buffer, 0, read);
                            }
                            inStream.close();
                            // write the output file (You have now copied the file)
                            outStream.flush();
                            outStream.close();

                        } catch (FileNotFoundException fnfe1) {
                            exceptionError = fnfe1.getMessage();
                        } catch (Exception e) {
                            exceptionError = e.getMessage();
                        }
                    }
                }
                else{
                    InputStream inStream;
                    BufferedInputStream binStream;
                    try {
                        inStream = getContentResolver().openInputStream(file.getUri());
                        binStream = new BufferedInputStream(inStream);

                        File tfile = new File(file.getUri().getPath());//create path from uri
                        final String[] split = tfile.getPath().split(":");//split the path.

                        String sdestDir = arg0[1] + "/MigratedCharts/" + split[2];

                        String fileName = sdestDir + "/" + file.getName();
                        File ffileName = new File(fileName);
                        if(ffileName.exists())
                            ffileName.delete();

                        g_migrateMessage = "Migrating " + iFile + "/" + dirList.size() + ";" + file.getName();
                        Log.i("OpenCPN",  g_migrateMessage);

                        OutputStream outStream = new FileOutputStream(fileName);

                        byte[] buffer = new byte[32 * 1024];
                        int read;
                        while ((read = inStream.read(buffer)) != -1) {
                            outStream.write(buffer, 0, read);
                        }
                        inStream.close();
                        // write the output file (You have now copied the file)
                        outStream.flush();
                        outStream.close();

                    } catch (FileNotFoundException fnfe1) {
                        exceptionError = fnfe1.getMessage();
                    } catch (Exception e) {
                        exceptionError = e.getMessage();
                    }
                }
                iFile++;
            }

            // Return the actual new folder
            return rv;
        }

        @Override
        protected void onPostExecute(String result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);

            g_migrateResult = result;
            Log.i("OpenCPN", g_migrateResult);

            g_migrateActive = false;
            g_migrateMessage = "Migration complete";
            EnableRotation();

        }
    }


    public String doMigrateAsync( String sourceFolder, String destinationFolder) {

        // Clear the data
        g_migrateActive = false;
        g_migrateResult = "";
        g_migrateMessage = "Migration started";
        g_migrateCancel = false;


        new MigrateFolderTask().execute(sourceFolder, destinationFolder);

        return "OK";
    }

    public String isSAFChooserFinished() {
        if (!m_SAFmigrateChooserActive) {
            Log.i("OpenCPN", "m_SAFChooserActive:  returning " + m_SAFmigrateChooserString);
            return m_SAFmigrateChooserString;
        } else {
            return "no";
        }
    }


    public String getMigrateStatus(){
        return g_migrateMessage;
    }

    public String restartOCPNAfterMigrate(){
        g_migrateMessage = "Restart pending.";

        PackageManager packageManager = this.getPackageManager();
        Intent intent = packageManager.getLaunchIntentForPackage(this.getPackageName());
        ComponentName componentName = intent.getComponent();
        Intent mainIntent = Intent.makeRestartActivityTask(componentName);

        finish();
        startActivity(mainIntent);


        Log.i("OpenCPN", "System.exit");
        System.exit(0);


        return "OK";
    }

    public static File getFile( final Context context,  final DocumentFile document)
    {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q)
        {
            return null;
        }

        try
        {
            final List<StorageVolume> volumeList = context
                    .getSystemService(StorageManager.class)
                    .getStorageVolumes();

            if ((volumeList == null) || volumeList.isEmpty())
            {
                return null;
            }

            // There must be a better way to get the document segment
            final String documentId      = DocumentsContract.getDocumentId(document.getUri());
            final String documentSegment = documentId.substring(documentId.lastIndexOf(':') + 1);

            for (final StorageVolume volume : volumeList)
            {
                String volumePath = null;

                if (Build.VERSION.SDK_INT == Build.VERSION_CODES.Q)
                {
                    final Class<?> class_StorageVolume = Class.forName("android.os.storage.StorageVolume");

                    @SuppressWarnings("JavaReflectionMemberAccess")
                    @SuppressLint("DiscouragedPrivateApi")
                    final Method method_getPath = class_StorageVolume.getDeclaredMethod("getPath");

                    volumePath = (String)method_getPath.invoke(volume);
                }
                else
                {
                    // API 30
                    if (Build.VERSION.SDK_INT >= 30) {
                        volumePath = volume.getDirectory().getPath();
                    }
                }

                final File storageFile = new File(volumePath + File.separator + documentSegment);

                // Should improve with other checks, because there is the
                // remote possibility that a copy could exist in a different
                // volume (SD-card) under a matching path structure and even
                // same file name, (maybe a user's backup in the SD-card).
                // Checking for the volume Uuid could be an option but
                // as per the documentation the Uuid can be empty.

                final boolean isTarget = (storageFile.exists())
                        && (storageFile.lastModified() == document.lastModified())
                        && (storageFile.length() == document.length());

                if (isTarget)
                {
                    return storageFile;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
