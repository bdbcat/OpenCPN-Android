package org.opencpn.opencpn;



import android.os.Bundle;
import org.qtproject.qt5.android.bindings.QtActivity;
//import eu.microscopictopic.scratchclib.JavaNatives;

public class MyActivity extends QtActivity {
    public static MyActivity s_activity = null;

    @Override
    public void  onCreate(Bundle savedInstanceState)
    {
        //JavaNatives.init(getApplicationContext());
//        JavaNatives.sendIntToClib(222);

        s_activity = this;
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        s_activity = null;
    }
}