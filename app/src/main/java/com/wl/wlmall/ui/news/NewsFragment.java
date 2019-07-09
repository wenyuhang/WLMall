package com.wl.wlmall.ui.news;

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
import com.gyf.immersionbar.ImmersionBar;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.extras.recyclerview.PullToRefreshRecyclerView;
import com.wl.wlmall.R;
import com.wl.wlmall.adapter.BannerAdapter;
import com.wl.wlmall.adapter.MainAdapter;
import com.wl.wlmall.adapter.NewsListAdapter;
import com.wl.wlmall.base.BaseFragment;
import com.wl.wlmall.desgin.LoadingLayout;
import com.wl.wlmall.desgin.refresh.RefreshHeaderLayout;
import com.wl.wlmall.http.GlideUtils;
import com.wl.wlmall.model.entity.NewsListBean;
import com.wl.wlmall.ui.main.MainActivity;
import com.wl.wlmall.ui.news.conteact.NewsContract;
import com.wl.wlmall.ui.news.conteact.NewsPresenter;
import com.wl.wlmall.utils.DensityUtil;
import com.wl.wlmall.utils.LoadMoreUtils;
import com.wl.wlmall.utils.Utils;
import com.wl.wlmall.utils.ViewUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.jzvd.Jzvd;


/**
 * create by wyh on 2null18/9/11
 */

public class NewsFragment extends BaseFragment implements NewsContract.View, PullToRefreshRecyclerView.OnRefreshListener2<RecyclerView>, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.recy_news)
    PullToRefreshRecyclerView recyNews;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.activity_main)
    FrameLayout activityMain;
    @BindView(R.id.loading_layout)
    LoadingLayout loadingLayout;
    private int page = 1;
    private int pageSize = 10;
    private String status = "30";
    private BannerAdapter mBannerAdapter;
    private LinearLayoutManager mLayoutManager;
    private MainAdapter mMainAdapter;
    private ImageView mIvBanner;

    private int mBannerPosition = -1;

    private int mBannerHeight;
    private RecyclerView rvNews;
    private MainActivity activity;
    private NewsListAdapter adapter;
    private NewsContract.Presenter presenter;
    private List<NewsListBean.DataBean.RecordsBean> data;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    protected void init(View view) {
        loadingLayout.setStatus(LoadingLayout.Success);
        new NewsPresenter(this);
        setAdapter(recyNews, getActivity());
        presenter.getList(status, page);
        activity = (MainActivity) getActivity();

        //
        mBannerHeight = (DensityUtil.dip2px(getActivity(), 180) - ImmersionBar.getActionBarHeight(getActivity())
                - ImmersionBar.getStatusBarHeight(getActivity()))*2;

        setListener();
    }
    @Override
    protected void onHidden() {
        super.onHidden();
        Jzvd.resetAllVideos();
    }

    @Override
    public void onPause() {
        super.onPause();
        Jzvd.resetAllVideos();
    }

    private RecyclerView setAdapter(PullToRefreshRecyclerView refreshLayout, Context context) {
        refreshLayout.setScrollingWhileRefreshingEnabled(true);
        refreshLayout.setHeaderLayout(new RefreshHeaderLayout(context));
        rvNews = refreshLayout.getRefreshableView();
        rvNews.setLayoutManager(new LinearLayoutManager(context));
        adapter = new NewsListAdapter(context, null);
//        adapter.setLoadMoreView(new CustomLoadMoreView());
        rvNews.setAdapter(adapter);
        refreshLayout.setOnRefreshListener(NewsFragment.this);
        addHeaderView();
        return rvNews;
    }

    @Override
    public void showList(NewsListBean orchardListBean) {
        data = orchardListBean.getData().getRecords();
        LoadMoreUtils.getInstance().setNewsLoadMore(page, pageSize, adapter, data, this, rvNews);
        recyNews.onRefreshComplete();
    }

    @Override
    public void setRefreshLayoutHide() {
        if (recyNews != null) {
            recyNews.onRefreshComplete();
        }
    }

    @Override
    public void loadFail(String msg) {
        if (recyNews != null)
            recyNews.onRefreshComplete();
    }

    @Override
    public void setPresenter(NewsContract.Presenter presenter) {
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


    @Override
    public void onLoadMoreRequested() {
        if (data.size() >= 10) {
            page++;
            presenter.getList(status, page);
        }
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
        page = 1;
        presenter.getList(status, page);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<RecyclerView> refreshView) {

    }

    private void setListener() {
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                data = adapter.getData();
                activity.showCommentData(String.valueOf( data.get(position).getId()));
            }
        });

        rvNews.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(View view) {

            }

            @Override
            public void onChildViewDetachedFromWindow(View view) {
                Jzvd jzvd = view.findViewById(R.id.recy_video);
                if (jzvd != null && Jzvd.CURRENT_JZVD != null &&
                        jzvd.jzDataSource.containsTheUrl(Jzvd.CURRENT_JZVD.jzDataSource.getCurrentUrl())) {
                    if (Jzvd.CURRENT_JZVD != null && Jzvd.CURRENT_JZVD.screen != Jzvd.SCREEN_FULLSCREEN) {
                        Jzvd.resetAllVideos();
                    }
                }
            }
        });
        rvNews.addOnScrollListener(new RecyclerView.OnScrollListener() {
            private int totalDy = 0;

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    Glide.with(mActivity).resumeRequests();
                } else {
                    Glide.with(mActivity).pauseRequests();
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalDy += dy;
                if (totalDy < 0) {
                    totalDy = 0;
                }
                if (totalDy <= mBannerHeight) {
                    float alpha = (float) totalDy / mBannerHeight;
                    mToolbar.setAlpha( alpha);
                } else {
                    mToolbar.setAlpha( 1);
                }

            }
        });
    }


    private void addBannerView() {
        View bannerView = LayoutInflater.from(getActivity()).inflate(R.layout.item_main_banner, recyNews, false);
        mIvBanner = bannerView.findViewById(R.id.iv_banner);
        RecyclerView recyclerView = bannerView.findViewById(R.id.rv_content);
        ViewUtils.increaseViewHeightByStatusBarHeight(getActivity(), mIvBanner);
        ImmersionBar.setTitleBarMarginTop(getActivity(), recyclerView);

        mLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
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
        adapter.addHeaderView(bannerView);
    }

    private void addHeaderView() {
        addBannerView();
    }

}
