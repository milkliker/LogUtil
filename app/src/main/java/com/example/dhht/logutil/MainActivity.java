package com.example.dhht.logutil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.dhht.logutil.app.MyApplication;

import log.LogUtils;
import toast.ToastUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToastUtil.showShort("沙雕");
        LogUtils.init(true, new LogUtils.OnLogInfoListener() {
            @Override
            public void onLog(String logFrom, String logInfo) {

            }
        });
        LogUtils.jsonE("{ \"code\": 200, \"msg\": \"ok\", \"data\": { \"version\": \"1.0\", \"url\": \"http://ozr6klu3a.bkt.clouddn.com/app_1516350756866\", \"info\": \"第一个版本\", \"imageUrl\": null, \"forced\": false } }");
    }
}
