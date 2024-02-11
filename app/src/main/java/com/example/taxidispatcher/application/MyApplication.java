package com.example.taxidispatcher.application;

import android.app.Application;

import com.example.taxidispatcher.util.StreetUtil;

public class MyApplication extends Application {

    public MyApplication() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        StreetUtil.readFiles(this);
    }
}
