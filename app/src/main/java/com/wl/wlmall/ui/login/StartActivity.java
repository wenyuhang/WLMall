package com.wl.wlmall.ui.login;

import android.Manifest;
import android.content.Intent;

import com.wl.wlmall.R;
import com.wl.wlmall.base.BaseActivity;
import com.wl.wlmall.config.Keys;
import com.wl.wlmall.ui.main.MainActivity;
import com.wl.wlmall.utils.PermissionUtils;
import com.wl.wlmall.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * create by wyh on 2018/12/29
 * 启动页
 */

public class StartActivity extends BaseActivity {

    private ArrayList<String> perList;
    private Timer timer;
    private Intent intent;

    @Override
    public int getLayoutId() {
        return R.layout.activity_start;
    }


    @Override
    public void init() {
        creatTimer();
        initPre();
        SharedPreferencesUtils.putDate(Keys.SP_TOKEN,"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsaWNlbnNlIjoibWFkZSBieSBsZW5kZSIsInVzZXJfbmFtZSI6Ind4XzAxNDEzNDM0NzQwMjQiLCJzY29wZSI6WyJzZXJ2ZXIiXSwiZXhwIjoxNTYxOTc1MzM4LCJ1c2VySWQiOjEyNzcxNTQsImF1dGhvcml0aWVzIjpbIlJPTEVfQkFTRSIsIlJPTEVfVVNFUiJdLCJqdGkiOiJhNzcyOWQ5My04ZDcxLTQ5OWQtYmRhYi1jNjJiMzBkNDc0YzkiLCJjbGllbnRfaWQiOiJhcHAifQ.9DnGBahbPqPtZ3HiB1A3FbxAitW2IABv4kVoHaUCJKk");
    }

    /**
     * 初始化权限
     */
    private void initPre() {
        perList = new ArrayList<>();
        //对文件读写权限
        perList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        PermissionUtils.getInstance().inspect(this, perList);//检查本页面所需权限（必须调用）
    }


    private void creatTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        intent = new Intent(StartActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        }, 2000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }
}
