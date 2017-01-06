package com.app.weather;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.app.weather.weather.MainActivity;

public class SplashActivity extends AppCompatActivity {

    public static final int READ_PHONE_STATE = 0x110;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        checkPermission(new String[]{
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE});

    }

    private void checkPermission(String[] permissions) {
//        String[] permissions = new String[4];
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED) {
//                permissions[0] = Manifest.permission.ACCESS_COARSE_LOCATION;
//            } else {
//                permissions[0] = null;
//            }
//
//            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED) {
//                permissions[1] = Manifest.permission.ACCESS_FINE_LOCATION;
//            } else {
//                permissions[1] = null;
//            }
//
//            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE
//            ) != PackageManager.PERMISSION_GRANTED) {
//                permissions[2] = Manifest.permission.READ_EXTERNAL_STORAGE;
//            } else {
//                permissions[2] = null;
//            }
//
//            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE
//            ) != PackageManager.PERMISSION_GRANTED) {
//                permissions[3] = Manifest.permission.WRITE_EXTERNAL_STORAGE;
//            } else {
//                permissions[3] = null;
//            }
            if (checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED
                    || checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED
                    || checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED
                    || checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                // 申请一个（或多个）权限，并提供用于回调返回的获取码（用户定义)
                requestPermissions(permissions, READ_PHONE_STATE);

            } else {

                startActivity();

            }

        } else {
            startActivity();
        }
    }

    private void startActivity() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, 1000);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull final
    String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case READ_PHONE_STATE:
                boolean isGrant = false;
                for (int gr : grantResults) {
                    if (gr != PackageManager.PERMISSION_GRANTED) {
                        isGrant = true;
                        break;
                    }
                }
                if (isGrant) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setCancelable(false);
                    builder.setTitle("权限");
                    builder.setMessage("未获得权限，导致APP无法正常运行 是否重新获取？");
                    builder.setNegativeButton("退出", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
                    builder.setPositiveButton("获取", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            checkPermission(permissions);
                        }
                    });
                    builder.show();
                } else {
                    startActivity();
                }
                break;

        }


    }
}
