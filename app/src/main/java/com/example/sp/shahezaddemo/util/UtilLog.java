package com.example.sp.shahezaddemo.util;

import android.util.Log;

/**
 * Created by SP on 2/6/17.
 */

public class UtilLog {

    private static boolean Debug = false;
    private static boolean Error = false;
    private static boolean Info = false;
    private static boolean Verbose = false;
    private static boolean Warn = false;


    public static void setDebug(boolean b)
    {
        Debug = b;
    }
    public static void setError(boolean e) { Error = e; }
    public static void setInfo(boolean i) { Error = i; }
    public static void setVerbose(boolean v) { Error = v; }
    public static void setWarn(boolean w) { Error = w; }


    public static void logD(String key, String value)
    {
        if (Debug)
        {
            Log.d(key, value);

        }

    }

    public static void logE(String key, String value)
    {
        if (Error)
        {
            Log.e(key, value);

        }

    }

    public static void logI(String key, String value)
    {
        if (Info)
        {
            Log.i(key, value);

        }

    }

    public static void logV(String key, String value)
    {
        if (Verbose)
        {
            Log.v(key, value);

        }

    }

    public static void logW(String key, String value)
    {
        if (Warn)
        {
            Log.w(key, value);

        }

    }




}
