package com.example.administrator.mydialog;

import android.app.Application;

public class DemoApplication extends Application {

    private static DemoApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static DemoApplication getInstance(){
        return instance;
    }

}
