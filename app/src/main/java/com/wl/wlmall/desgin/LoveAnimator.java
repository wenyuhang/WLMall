package com.wl.wlmall.desgin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.wl.wlmall.R;

import java.util.Random;

/**
 * create by wyh on 2019/1/9
 * 在点击时触发将心形的图片 add 到整个 view 中，然后在执行动画。主要的处理逻辑都在 onTouchEvent() 事件中
 */

public class LoveAnimator extends RelativeLayout {

    private Context mContext;
    final float[] num = {-30, -20, 0, 20, 30}; // 随机心形图片的角度
    private MotionEvent event;

    public LoveAnimator(Context context) {
        this(context, null);
    }

    public LoveAnimator(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoveAnimator(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @SuppressLint("NewApi")
    public LoveAnimator(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context) {
        mContext = context;
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.event = event;
        return super.onTouchEvent(event);
    }

    /**
     * 创建爱心
     */
    public void creatLove() {
        // 首先，我们需要在触摸事件中做监听，当有触摸时，创建一个展示心形图片的 ImageView
        final ImageView imageView = new ImageView(mContext);

        // 设置图片展示的位置，需要在手指触摸的位置上方，即触摸点是心形的下方角的位置。所以我们需要将 ImageView 设置到手指的位置
        LayoutParams params = new LayoutParams(300, 300);
        params.leftMargin = (int) event.getX() - 150;
        params.topMargin = (int) event.getY() - 300;

        imageView.setImageDrawable(getResources().getDrawable(R.mipmap.details_icon_like_pressed));
        imageView.setLayoutParams(params);
        addView(imageView);

        // 设置 imageView 动画
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(scale(imageView, "scaleX", 2f, 0.9f, 100, 0)) // 缩放动画，X轴2倍缩小至0.9倍
                .with(scale(imageView, "scaleY", 2f, 0.9f, 100, 0)) // 缩放动画，Y轴2倍缩小至0.9倍
                .with(rotation(imageView, 0, 0, num[new Random().nextInt(4)])) // 旋转动画，随机旋转角度num={-30.-20，0，20，30}
                .with(alpha(imageView, 0, 1, 100, 0)) // 渐变透明度动画，透明度从0-1.
                .with(scale(imageView, "scaleX", 0.9f, 1, 50, 150)) // 缩放动画，X轴0.9倍缩小至1倍
                .with(scale(imageView, "scaleY", 0.9f, 1, 50, 150)) // 缩放动画，Y轴0.9倍缩小至1倍
                .with(translationY(imageView, 0, -600, 800, 400)) // 平移动画，Y轴从0向上移动600单位
                .with(alpha(imageView, 1, 0, 300, 400)) // 透明度动画，从1-0
                .with(scale(imageView, "scaleX", 1, 3f, 700, 400)) // 缩放动画，X轴1倍放大至3倍
                .with(scale(imageView, "scaleY", 1, 3f, 700, 400)); // 缩放动画，Y轴1倍放大至3倍
        animatorSet.start();

        // 我们不可能无限制的增加 view，在 view 消失之后，需要手动的移除改 imageView
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                removeViewInLayout(imageView);
            }
        });
    }


    public static ObjectAnimator scale(View view, String propertyName, float from, float to, long time, long delayTime) {
        ObjectAnimator translation = ObjectAnimator.ofFloat(view
                , propertyName
                , from, to);
        translation.setInterpolator(new LinearInterpolator());
        translation.setStartDelay(delayTime);
        translation.setDuration(time);
        return translation;
    }

    public static ObjectAnimator translationX(View view, float from, float to, long time, long delayTime) {
        ObjectAnimator translation = ObjectAnimator.ofFloat(view
                , "translationX"
                , from, to);
        translation.setInterpolator(new LinearInterpolator());
        translation.setStartDelay(delayTime);
        translation.setDuration(time);
        return translation;
    }

    public static ObjectAnimator translationY(View view, float from, float to, long time, long delayTime) {
        ObjectAnimator translation = ObjectAnimator.ofFloat(view
                , "translationY"
                , from, to);
        translation.setInterpolator(new LinearInterpolator());
        translation.setStartDelay(delayTime);
        translation.setDuration(time);
        return translation;
    }

    public static ObjectAnimator alpha(View view, float from, float to, long time, long delayTime) {
        ObjectAnimator translation = ObjectAnimator.ofFloat(view
                , "alpha"
                , from, to);
        translation.setInterpolator(new LinearInterpolator());
        translation.setStartDelay(delayTime);
        translation.setDuration(time);
        return translation;
    }

    public static ObjectAnimator rotation(View view, long time, long delayTime, float... values) {
        ObjectAnimator rotation = ObjectAnimator.ofFloat(view, "rotation", values);
        rotation.setDuration(time);
        rotation.setStartDelay(delayTime);
        rotation.setInterpolator(new TimeInterpolator() {
            @Override
            public float getInterpolation(float input) {
                return input;
            }
        });
        return rotation;
    }
}
