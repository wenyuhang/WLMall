package com.wl.wlmall.base;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

import com.gyf.immersionbar.ImmersionBar;
import com.wl.wlmall.R;
import com.wl.wlmall.application.App;
import com.wl.wlmall.utils.AppManager;
import com.wl.wlmall.utils.PermissionUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by WYH on 2017/8/18.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getInstance().addActivity(this);
        App.context = this;

        setContentView(getLayoutId());

        bind = ButterKnife.bind(this);
        //初始化沉浸式
        initImmersionBar();

        init();
    }

    /**
     * 是否可以使用沉浸式
     * Is immersion bar enabled boolean.
     *
     * @return the boolean
     */
    protected boolean isImmersionBarEnabled() {
        return true;
    }

    /**
     * 初始化沉浸式
     * Init immersion bar.
     */
    protected void initImmersionBar() {
        //设置共同沉浸式样式
        ImmersionBar.with(this).navigationBarColor(R.color.colorPrimary).init();
    }


    /**
     * 设置状态栏颜色
     *
     * @param color
     */
    public void makeStatusBar(int color, boolean isBlack) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {//亮色时状态栏显示黑字
            getWindow().setStatusBarColor(ContextCompat.getColor(this, color));
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            if (isBlack) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//设置状态栏黑色字体
            } else {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);//恢复状态栏白色字体
            }

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        App.context = this;
    }


    /**
     * 加载布局
     *
     * @return
     */
    public abstract int getLayoutId();

    /**
     * 初始化数据
     *
     * @return
     */
    public abstract void init();


    /**
     * 老人机字体适配
     *
     * @return
     */
    @Override
    public Resources getResources() {
        Resources resources = super.getResources();
        Configuration newConfig = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();

        if (resources != null && newConfig.fontScale != 1) {
            newConfig.fontScale = 1;
            if (Build.VERSION.SDK_INT >= 17) {
                Context configurationContext = createConfigurationContext(newConfig);
                resources = configurationContext.getResources();
                displayMetrics.scaledDensity = displayMetrics.density * newConfig.fontScale;
            } else {
                resources.updateConfiguration(newConfig, displayMetrics);
            }
        }
        return resources;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionUtils.getInstance().onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
        AppManager.getInstance().removeActivity(this);
    }

}
