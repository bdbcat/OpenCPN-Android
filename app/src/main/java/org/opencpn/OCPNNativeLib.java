package org.opencpn;



public class OCPNNativeLib {

    private static OCPNNativeLib ourInstance = new OCPNNativeLib();

    public static OCPNNativeLib getInstance() {
        return ourInstance;
    }

    private OCPNNativeLib() {
    }



  /**
   * Adds two integers, returning their sum
   */
  public native int add( int v1, int v2 );

  /**
   * Returns Hello World string
   */
  public native String hello();

  public native int test();

  public native int processNMEA(String nmea_string);
  public native int processBTNMEA(String nmea_string);
  public native int processNMEAInt(String nmea_string);
  public native int processARBNMEA(String NMEA_sentence);

  public native int onConfigChange( int orientation );

  public native int onMenuKey();

  public native int onStart();
  public native int onStop();
  public native int onPause();
  public native int onResume();
  public native int onDestroy();

  public native int invokeMenuItem( int item);
  public native int selectChartDisplay( int type, int family);
  public native int invokeCmdEventCmdString( int cmd_id, String s);
  public native String getVPCorners();
  public native String getVPS();

  public native int setDownloadStatus( int status, String url);
  public native int onMouseWheel(int dir);
  public native int notifyFullscreenChange( boolean bFull );

  public native int sendPluginMessage( String iD, String message);
  public native int getTLWCount();

  public native int processSailTimer(double WindAngleMagnetic, double WindSpeedKnots);

  public native int ScheduleCleanExit();
  
  public native int onSoundDone(long androidSoundPtr);

  public native void ImportTmpGPX(String filePath, boolean isLayer, boolean isPersistent);
}
