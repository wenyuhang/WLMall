package com.wl.wlmall.ui.user;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.immersionbar.BarProperties;
import com.gyf.immersionbar.ImmersionBar;
import com.wl.wlmall.R;
import com.wl.wlmall.adapter.BannerAdapter;
import com.wl.wlmall.adapter.MainAdapter;
import com.wl.wlmall.base.BaseActivity;
import com.wl.wlmall.http.GlideUtils;
import com.wl.wlmall.model.entity.FunBean;
import com.wl.wlmall.utils.DensityUtil;
import com.wl.wlmall.utils.Utils;
import com.wl.wlmall.utils.ViewUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * create by wyh on 2019/1/3
 */

public class UserActivity extends BaseActivity {
    @BindView(R.id.mRv)
    RecyclerView mRv;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.activity_main)
    FrameLayout activityMain;
    Unbinder unbinder;
    private BannerAdapter mBannerAdapter;
    private LinearLayoutManager mLayoutManager;
    private MainAdapter mMainAdapter;
    private ImageView mIvBanner;

    private int mBannerPosition = -1;

    private int mBannerHeight;
    private ArrayList<FunBean> mMainData;

    @Override
    public int getLayoutId() {
        return R.layout.activity_user;
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).titleBar(R.id.toolbar).setOnBarListener(this::adjustView).init();
    }

    @Override
    public void init() {
        mMainAdapter = new MainAdapter();
        mMainAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        mMainAdapter.isFirstOnly(false);
        mRv.setAdapter(mMainAdapter);
        mMainData = getMainData(this);
        mMainAdapter.setNewData(mMainData);
        addHeaderView();

        mBannerHeight = DensityUtil.dip2px(this, 180) - ImmersionBar.getActionBarHeight(this)
                - ImmersionBar.getStatusBarHeight(this);

        setListener();
    }

    private void setListener() {
        mRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            private int totalDy = 0;

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    Glide.with(UserActivity.this).resumeRequests();
                } else {
                    Glide.with(UserActivity.this).pauseRequests();
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalDy += dy;
                if (totalDy <= mBannerHeight) {
                    float alpha = (float) totalDy / mBannerHeight;
                    mToolbar.setAlpha(alpha);
                } else {
                    mToolbar.setAlpha(1);
                }

            }
        });
    }

    public ArrayList<FunBean> getMainData(Context context) {
        ArrayList<FunBean> funBeans = new ArrayList<>();
        funBeans.add(new FunBean(context.getString(R.string.text_params), null));
        funBeans.add(new FunBean(context.getString(R.string.text_params_kotlin), null));
        funBeans.add(new FunBean(context.getString(R.string.text_pic_color), null));
        funBeans.add(new FunBean(context.getString(R.string.text_pic), null));
        funBeans.add(new FunBean(context.getString(R.string.text_color), null));
        funBeans.add(new FunBean(context.getString(R.string.text_shape), null));
        funBeans.add(new FunBean(context.getString(R.string.text_swipe_back), null));
        funBeans.add(new FunBean(context.getString(R.string.text_fragment), null));
        funBeans.add(new FunBean(context.getString(R.string.text_dialog), null));
        funBeans.add(new FunBean(context.getString(R.string.text_drawer), null));
        funBeans.add(new FunBean(context.getString(R.string.text_coordinator), null));
        funBeans.add(new FunBean(context.getString(R.string.text_tab), null));
        funBeans.add(new FunBean(context.getString(R.string.text_tab_two), null));
        funBeans.add(new FunBean(context.getString(R.string.text_web), null));
        funBeans.add(new FunBean(context.getString(R.string.text_action_bar), null));
        funBeans.add(new FunBean(context.getString(R.string.text_flyme), null));
        funBeans.add(new FunBean(context.getString(R.string.text_over), null));
        funBeans.add(new FunBean(context.getString(R.string.text_key_board), null));
        funBeans.add(new FunBean(context.getString(R.string.text_all_edit), null));
        funBeans.add(new FunBean(context.getString(R.string.text_login), null));
        funBeans.add(new FunBean(context.getString(R.string.text_white_bar), null));
        funBeans.add(new FunBean(context.getString(R.string.text_auto_status_font), null));
        funBeans.add(new FunBean(context.getString(R.string.text_status_hide), null));
        funBeans.add(new FunBean(context.getString(R.string.text_navigation_hide), null));
        funBeans.add(new FunBean(context.getString(R.string.text_bar_hide), null));
        funBeans.add(new FunBean(context.getString(R.string.text_bar_show), null));
        funBeans.add(new FunBean(context.getString(R.string.text_full), null));
        funBeans.add(new FunBean(context.getString(R.string.text_bar_font_dark), null));
        funBeans.add(new FunBean(context.getString(R.string.text_bar_font_light), null));
        return funBeans;
    }

    private void addBannerView() {
        View bannerView = LayoutInflater.from(this).inflate(R.layout.item_main_banner, mRv, false);
        mIvBanner = bannerView.findViewById(R.id.iv_banner);
        RecyclerView recyclerView = bannerView.findViewById(R.id.rv_content);
        ViewUtils.increaseViewHeightByStatusBarHeight(this, mIvBanner);
        ImmersionBar.setTitleBarMarginTop(this, recyclerView);

        mLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        mBannerAdapter = new BannerAdapter(Utils.getPics());
        recyclerView.setAdapter(mBannerAdapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (mBannerPosition != mLayoutManager.findFirstVisibleItemPosition()) {
                    mBannerPosition = mLayoutManager.findFirstVisibleItemPosition();
                    ArrayList<String> data = mBannerAdapter.getData();
                    String s = data.get(mBannerPosition % data.size());
                    GlideUtils.loadBlurry(mIvBanner, s);
                }
            }
        });
        mMainAdapter.addHeaderView(bannerView);
    }

    private void addHeaderView() {
        addBannerView();
    }
    /**
     * 适配刘海屏遮挡数据问题
     * Adjust view.
     *
     * @param barProperties the bar properties,ImmersionBar#setOnBarListener
     */
    private void adjustView(BarProperties barProperties) {
        if (barProperties.isNotchScreen()) {
            if (mMainData != null) {
                for (FunBean funBean : mMainData) {
                    if (barProperties.isPortrait()) {
                        funBean.setMarginStart(DensityUtil.dip2px(this, 8));
                        funBean.setMarginEnd(DensityUtil.dip2px(this, 8));
                    } else {
                        if (barProperties.isLandscapeLeft()) {
                            funBean.setMarginStart(DensityUtil.dip2px(this, 8) + barProperties.getNotchHeight());
                            funBean.setMarginEnd(DensityUtil.dip2px(this, 8));
                        } else {
                            funBean.setMarginStart(DensityUtil.dip2px(this, 8));
                            funBean.setMarginEnd(DensityUtil.dip2px(this, 8) + barProperties.getNotchHeight());
                        }
                    }
                }
            }
            if (mMainAdapter != null) {
                mMainAdapter.notifyDataSetChanged();
            }
        }
    }

}
