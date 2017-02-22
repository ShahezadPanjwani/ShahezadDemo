package com.example.sp.shahezaddemo.util;

import android.app.Application;

import com.example.sp.shahezaddemo.util.UtilLog;

/**
 * Created by SP on 2/6/17.
 */

public class ShahezadApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UtilLog.setDebug(true);
        UtilLog.setVerbose(true);
        UtilLog.setWarn(true);
        UtilLog.setInfo(true);
        UtilLog.setError(true);
    }


}
