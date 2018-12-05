package com.example.dhht.logutil.app;

import android.app.Application;
import android.os.SystemClock;

import log.LogUtils;
import toast.ToastUtil;
import util.ClipbordUtil;
import util.InternetUtil;
import util.ScreenUtil;
import util.SharedPreferencesUtil;
import util.VibrateUtil;

public class MyApplication extends Application {

    public static Application application;
    public static final boolean IS_DEBUG = true;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;


        LogUtils.init(IS_DEBUG, null);
        ToastUtil.init(this);
        ScreenUtil.init(this);
        ClipbordUtil.init(this);
        InternetUtil.init(this);
        SharedPreferencesUtil.init(this);
        VibrateUtil.init(this);


    }
}
