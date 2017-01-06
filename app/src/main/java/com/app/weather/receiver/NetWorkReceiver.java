package com.app.weather.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.app.weather.utils.NetWorkUtil;

/**
 * Created by wangshuo on 16/12/12.
 */

public class NetWorkReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mobNetInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        NetworkInfo wifiNetInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (!mobNetInfo.isConnected()) {
            NetWorkUtil.setHasMoblie(false);
        } else {
            NetWorkUtil.setHasMoblie(true);
        }

        if (!wifiNetInfo.isConnected()) {
            NetWorkUtil.setHasWifi(false);
        } else {
            NetWorkUtil.setHasWifi(true);
        }
        if (!wifiNetInfo.isConnected() && !mobNetInfo.isConnected()) {
            NetWorkUtil.setHasInternet(false);
        }
        if (wifiNetInfo.isConnected() || mobNetInfo.isConnected()) {
            NetWorkUtil.setHasInternet(true);
        }

    }
}
