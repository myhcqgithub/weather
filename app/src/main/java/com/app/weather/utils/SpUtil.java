package com.app.weather.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.app.weather.App;

/**
 * Created by Norton on 2016/6/21 0021.
 */
public class SpUtil {

    public static final String PREFERENCE_NAME = "weather_config";

    private static SpUtil spUtils;
    private final App mApp;
    private final SharedPreferences mPreferences;
    private final SharedPreferences.Editor mEditor;

    public synchronized static SpUtil getInstance() {
        synchronized (SpUtil.class) {
            if (spUtils == null) {
                spUtils = new SpUtil();
            }
        }
        return spUtils;
    }

    private SpUtil() {
        mApp = App.getInstance();
        mPreferences = mApp.getApplicationContext()
                .getSharedPreferences(PREFERENCE_NAME,
                Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();
    }

    public String getString(String key, String defValue) {
        if (mPreferences != null) {
            return mPreferences.getString(key, defValue);
        }
        return "";
    }

    public String getString(String key) {
        return getString(key, "");
    }

    public boolean getBoolean(String key, boolean defValue) {
        if (mPreferences != null) {
            return mPreferences.getBoolean(key, defValue);
        }
        return false;
    }

    public boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    public int getInt(String key, int defValue) {
        if (mPreferences != null) {
            return mPreferences.getInt(key, defValue);
        }
        return 0;
    }

    public int getInt(String key) {
        return getInt(key, 0);
    }

    public boolean putStr(String key, String var) {
        return mEditor.putString(key, var).commit();
    }

    public boolean putBoolean(String key, boolean var) {
        return mEditor.putBoolean(key, var).commit();
    }

    public boolean putInt(String key, int var) {
        return mEditor.putInt(key, var).commit();
    }
}
