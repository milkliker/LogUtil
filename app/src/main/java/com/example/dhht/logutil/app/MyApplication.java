package com.example.dhht.logutil.app;

import android.app.Application;

import toast.ToastUtil;

public class MyApplication extends Application {

    public static Application application;

    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
        ToastUtil.init(this);
    }
}
