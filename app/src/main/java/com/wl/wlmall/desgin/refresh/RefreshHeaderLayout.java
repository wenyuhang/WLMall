package com.wl.wlmall.desgin.refresh;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.handmark.pulltorefresh.library.LoadingLayoutBase;
import com.nineoldandroids.view.ViewHelper;
import com.wl.wlmall.R;


/**
 * Created by WHY 2018/7/26
 */

public class RefreshHeaderLayout extends LoadingLayoutBase {

    static final String LOG_TAG = "PullToRefresh-RefreshHeaderLayout";

    private FrameLayout mInnerLayout;
    private ImageView mBabyImage;

    private AnimationDrawable animBabyShow;
    private AnimationDrawable animBabyShake;

    public RefreshHeaderLayout(Context context) {
        super(context);

        LayoutInflater.from(context).inflate(R.layout.refresh_header_loadinglayout, this);
        mInnerLayout = (FrameLayout) findViewById(R.id.fl_inner);
        mBabyImage = (ImageView) mInnerLayout.findViewById(R.id.pull_to_refresh_baby);

        LayoutParams lp = (LayoutParams) mInnerLayout.getLayoutParams();
        lp.gravity = Gravity.BOTTOM;

        reset();
    }

    // 获取"加载头部"高度
    @Override
    public int getContentSize() {
        return mInnerLayout.getHeight();
    }

    // 开始下拉时的回调
    @Override
    public void pullToRefresh() {
        mBabyImage.setImageResource(R.mipmap.push_down_1);
    }

    // "加载头部"完全显示时的回调
    @Override
    public void releaseToRefresh() {
        mBabyImage.setImageResource(R.drawable.animation_push_down_list);
        if (animBabyShow == null) {
            animBabyShow = (AnimationDrawable) mBabyImage.getDrawable();
        }
        animBabyShow.start();
    }

    // 下拉拖动时的回调
    @Override
    public void onPull(float scaleOfLayout) {
        scaleOfLayout = scaleOfLayout > 1.0f ? 1.0f : scaleOfLayout;

        //缩放动画
        ViewHelper.setPivotY(mBabyImage, mBabyImage.getMeasuredHeight());   // 设置中心点
        ViewHelper.setPivotX(mBabyImage, mBabyImage.getMeasuredWidth() / 2);
        ObjectAnimator animPX = ObjectAnimator.ofFloat(mBabyImage, "scaleX", 0, 1).setDuration(300);
        animPX.setCurrentPlayTime((long) (scaleOfLayout * 300));
        ObjectAnimator animPY = ObjectAnimator.ofFloat(mBabyImage, "scaleY", 0, 1).setDuration(300);
        animPY.setCurrentPlayTime((long) (scaleOfLayout * 300));
    }

    // 释放后刷新时的回调
    @Override
    public void refreshing() {
        if(null != animBabyShow) {
            animBabyShow.stop();
        }
        mBabyImage.setImageResource(R.drawable.animation_push_up_list);
        if (animBabyShake == null) {
            animBabyShake = (AnimationDrawable) mBabyImage.getDrawable();
        }
        animBabyShake.start();
    }

    @Override
    public void reset() {
        if(animBabyShow != null) {
            animBabyShow.stop();
            animBabyShow = null;
        }
        if (animBabyShake != null) {
            animBabyShake.stop();
            animBabyShake = null;
        }
    }

    @Override
    public void setPullLabel(CharSequence pullLabel) {

    }

    @Override
    public void setRefreshingLabel(CharSequence refreshingLabel) {

    }

    @Override
    public void setReleaseLabel(CharSequence releaseLabel) {

    }
}
