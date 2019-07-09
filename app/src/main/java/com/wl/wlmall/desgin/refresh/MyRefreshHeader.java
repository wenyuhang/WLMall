package com.wl.wlmall.desgin.refresh;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.wl.wlmall.R;

import in.srain.cube.views.ptr.indicator.PtrIndicator;


/**
 * Created by WHY 2018/7/26
 */

public class MyRefreshHeader extends FrameLayout implements PtrUIHandler {


    /**
     * 快递员logo
     */
    private ImageView mIvMan;


    /**
     * 状态识别
     */
    private int mState;

    /**
     * 重置
     * 准备刷新
     * 开始刷新
     * 结束刷新
     */
    public static final int STATE_RESET = -1;
    public static final int STATE_PREPARE = 0;
    public static final int STATE_BEGIN = 1;
    public static final int STATE_FINISH = 2;


    /**
     * 动画
     */
    private AnimationDrawable mAnimation;


    public MyRefreshHeader(Context context) {
        super(context);
        initView();
    }

    public MyRefreshHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public MyRefreshHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    /**
     * 初始化view
     */
    private void initView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.my_refresh_header_view, this, false);
        mIvMan = (ImageView) view.findViewById(R.id.pull_to_refresh_baby);
        addView(view);

    }


    @Override
    public void onUIReset(PtrFrameLayout frame) {
        mState = STATE_RESET;
    }

    @Override
    public void onUIRefreshPrepare(PtrFrameLayout frame) {
        mState = STATE_PREPARE;
    }

    @Override
    public void onUIRefreshBegin(PtrFrameLayout frame) {
        mState = STATE_BEGIN;
        //隐藏商品logo,开启跑步动画
//        mIvMan.setBackgroundResource(R.drawable.animation_push_down_list);
        mIvMan.setImageResource(R.drawable.animation_push_up_list);
        mAnimation = (AnimationDrawable) mIvMan.getDrawable();
        if (mAnimation!=null&&!mAnimation.isRunning()) {
            mAnimation.start();
        }
    }

    @Override
    public void onUIRefreshComplete(PtrFrameLayout frame) {
        mState = STATE_FINISH;
        //停止动画
        if (mAnimation!=null&&mAnimation.isRunning()) {
            mAnimation.stop();
        }
    }

    @Override
    public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {
        //处理提醒字体
        switch (mState) {
            case STATE_PREPARE:
                //logo设置
                mIvMan.setAlpha(ptrIndicator.getCurrentPercent());
                LayoutParams mIvManLayoutParams = (LayoutParams) mIvMan.getLayoutParams();
                if (ptrIndicator.getCurrentPercent() <= 1) {
                    mIvMan.setScaleX(ptrIndicator.getCurrentPercent());
                    mIvMan.setScaleY(ptrIndicator.getCurrentPercent());
                    mIvManLayoutParams.setMargins(0, 0, 0, 0);
                    mIvMan.setLayoutParams(mIvManLayoutParams);
                }
                if (ptrIndicator.getCurrentPercent() < 1.2) {
//                    mTvRemind.setText("下拉刷新...");
                } else {
//                    mTvRemind.setText("松开刷新...");
                }
                break;
            case STATE_BEGIN:
//                mTvRemind.setText("更新中...");
                break;
            case STATE_FINISH:
//                mTvRemind.setText("加载完成...");
                break;
        }
    }
}


