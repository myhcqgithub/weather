package com.app.weather.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

import com.app.weather.App;

/**
 * Created by wangshuo on 16/12/8.
 */

public class ToastUtil {
    private static Context sContext = App.getInstance().getBaseContext();
    private static Toast toast;

    public static void showToastShort( String str) {
        if (toast == null) {
            toast = Toast.makeText(sContext, str, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 20);
        } else {
            toast.setText(str);
        }
        toast.show();
    }
    public static void showToastLong( String str) {
        if (toast == null) {
            toast = Toast.makeText(sContext, str, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP, 0, 20);
        } else {
            toast.setText(str);
        }
        toast.show();
    }
}
