package com.wl.wlmall.ui.main;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wl.wlmall.R;
import com.wl.wlmall.adapter.NormalAdapter;
import com.wl.wlmall.base.BaseActivity;
import com.wl.wlmall.desgin.LoadingLayout;
import com.wl.wlmall.model.entity.CommentListBean;
import com.wl.wlmall.ui.follow.FollowFragment;
import com.wl.wlmall.ui.main.conteact.MainContract;
import com.wl.wlmall.ui.main.conteact.MainPresenter;
import com.wl.wlmall.ui.news.NewsFragment;
import com.wl.wlmall.ui.user.UserFragment;
import com.wl.wlmall.ui.video.VideoFragment;
import com.wl.wlmall.utils.LoadMoreUtils;
import com.wl.wlmall.utils.T;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.jzvd.Jzvd;

/**
 * create by wyh on 2019/1/5
 */

public class MainActivity extends BaseActivity implements MainContract.View, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.tab_news)
    RadioButton tabNews;
    @BindView(R.id.tab_video)
    RadioButton tabVideo;
    @BindView(R.id.tab_mall)
    RadioButton tabMall;
    @BindView(R.id.tab_user)
    RadioButton tabUser;
    @BindView(R.id.tab_content)
    FrameLayout tabContent;
    @BindView(R.id.bottom)
    RadioGroup bottom;
    @BindView(R.id.bottom_sheet)
    View nestedScrollView;
    @BindView(R.id.recyclerView)
    RecyclerView recyview;
    @BindView(R.id.btn_sheet_close)
    ImageView btnSheetClose;
    @BindView(R.id.layout_coordi)
    CoordinatorLayout layoutCoordi;
    @BindView(R.id.loading_layout)
    LoadingLayout loadingLayout;

    private NewsFragment newsFragment;          //新闻模块
    private VideoFragment videoFragment;        //视屏模块
    private FollowFragment followFragment;          //商城模块
    private UserFragment userFragment;          //个人中心模块
    public static final int TAB_NEWS = 1;
    public static final int TAB_VIDEO = 2;
    public static final int TAB_MALL = 3;
    public static final int TAB_USER = 4;
    long firstTime = 0;

    BottomSheetBehavior behavior;

    private NormalAdapter normalAdapter;
    private List<CommentListBean.DataBean.RecordsBean> data;

    private int page = 1;
    private int pageSize = 20;
    private String videoID = "24086";
    private MainContract.Presenter presenter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        new MainPresenter(this);
        selectFragment(TAB_NEWS);

        setUpRecy();
    }


    private void setUpRecy() {
        ViewGroup.LayoutParams layoutParams = nestedScrollView.getLayoutParams();
        CoordinatorLayout.Behavior b = ((CoordinatorLayout.LayoutParams) layoutParams)
                .getBehavior();
        behavior = (BottomSheetBehavior) b;
        setupRecyclerView();
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (BottomSheetBehavior.STATE_HIDDEN == newState||BottomSheetBehavior.STATE_COLLAPSED == newState) {
                    layoutCoordi.setVisibility(View.GONE);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            }
        });
    }


    /**
     * 展示评论页
     */
    public void showCommentData(String videoID) {
        this.videoID = videoID;
        if (behavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            layoutCoordi.setVisibility(View.VISIBLE);
            behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            page = 1;
            presenter.getList(this.videoID, page);
        } else {
            hideCommentData();
        }
    }

    /**
     * 关闭评论页
     */
    public boolean hideCommentData() {
        if (behavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            normalAdapter.setNewData(null);
            return true;
        }
        return false;
    }

    @OnClick({R.id.tab_news, R.id.tab_video, R.id.tab_mall, R.id.tab_user, R.id.layout_coordi, R.id.btn_sheet_close})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tab_news:
                selectFragment(TAB_NEWS);
                break;
            case R.id.tab_video:
                selectFragment(TAB_VIDEO);
                break;
            case R.id.tab_mall:
                selectFragment(TAB_MALL);
                break;
            case R.id.tab_user:
                selectFragment(TAB_USER);
                break;
            case R.id.layout_coordi:
                hideCommentData();
                break;
            case R.id.btn_sheet_close:
                hideCommentData();
                break;
        }
    }

    /**
     * 做返回键处理
     *
     * @return
     */
    @Override
    public void onBackPressed() {
        //关闭bottomsheet
        if(hideCommentData()) {
            return;
        }
        //关闭横屏视频播放
        if (Jzvd.backPress()) {
            return;
        }
        //退出应用
        long secondTime = System.currentTimeMillis();
        if (secondTime - firstTime > 2000) {
            T.s(getString(R.string.toast_back));
            firstTime = secondTime;
        } else {
            super.onBackPressed();
        }

    }

    /**
     * 是否添加
     *
     * @param type
     */
    private void selectFragment(int type) {
        FragmentManager fragmentmanager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentmanager.beginTransaction();
        hideFragment(transaction);
//        bottom.setBackgroundColor(ContextCompat.getColor(this, R.color.black_a_color));
        switch (type) {
            case TAB_NEWS:
                if (newsFragment == null) {
                    newsFragment = new NewsFragment();
                    transaction.add(R.id.tab_content, newsFragment);
                } else {
                    transaction.show(newsFragment);
                }
                break;
            case TAB_VIDEO:
                if (videoFragment == null) {
                    videoFragment = new VideoFragment();
                    transaction.add(R.id.tab_content, videoFragment);
                } else {
                    transaction.show(videoFragment);
                }
//                bottom.setBackgroundColor(ContextCompat.getColor(this, R.color.alpha_g_black));
                break;
            case TAB_MALL:
                if (followFragment == null) {
                    followFragment = new FollowFragment();
                    transaction.add(R.id.tab_content, followFragment);
                } else {
                    transaction.show(followFragment);
                }
                break;
            case TAB_USER:
                if (userFragment == null) {
                    userFragment = new UserFragment();
                    transaction.add(R.id.tab_content, userFragment);
                } else {
                    transaction.show(userFragment);
                }
                break;
        }
        transaction.commit();
    }

    /**
     * 隐藏fragment
     *
     * @param transaction
     */
    private void hideFragment(FragmentTransaction transaction) {
        if (newsFragment != null) {
            transaction.hide(newsFragment);
        }
        if (videoFragment != null) {
            transaction.hide(videoFragment);
        }
        if (followFragment != null) {
            transaction.hide(followFragment);
        }
        if (userFragment != null) {
            transaction.hide(userFragment);
        }
    }

    private void setupRecyclerView() {
        loadingLayout.setStatus(LoadingLayout.Sub_loading);
        recyview.setLayoutManager(new LinearLayoutManager(this));
        normalAdapter = new NormalAdapter();
        normalAdapter.setOnLoadMoreListener(this, recyview);
        recyview.setAdapter(normalAdapter);
    }

    /**
     * 获取数据
     *
     * @param commentListBean
     */
    @Override
    public void showList(CommentListBean commentListBean) {
        data = commentListBean.getData().getRecords();
        LoadMoreUtils.getInstance().setCommentLoadMore(page, pageSize, normalAdapter, data, this, recyview);
    }

    @Override
    public void loadFail(String msg) {

    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onFailed(String msg) {

    }

    @Override
    public void showProgress() {
        loadingLayout.setStatus(LoadingLayout.Sub_loading);
    }

    @Override
    public void cancelProgress() {
        loadingLayout.setStatus(LoadingLayout.Success);
    }

    /**
     * 加载更多
     */
    @Override
    public void onLoadMoreRequested() {
        if (data.size() >= 20) {
            page++;
            presenter.getList(videoID, page);
        }
    }
}
