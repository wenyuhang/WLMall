package com.wl.wlmall.application;


import android.app.Application;

import com.wl.wlmall.base.BaseActivity;


public class App extends Application{
    public static BaseActivity context = null;
    @Override
    public void onCreate() {
        super.onCreate();

    }
}
