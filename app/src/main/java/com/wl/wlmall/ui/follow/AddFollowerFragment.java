package com.wl.wlmall.ui.follow;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.extras.recyclerview.PullToRefreshRecyclerView;
import com.wl.wlmall.R;
import com.wl.wlmall.adapter.FollowUserAdapter;
import com.wl.wlmall.base.BaseFragment;
import com.wl.wlmall.desgin.LoadingLayout;
import com.wl.wlmall.desgin.refresh.RefreshHeaderLayout;
import com.wl.wlmall.model.entity.AllUserListBean;
import com.wl.wlmall.ui.follow.conteact.AddFollowerContract;
import com.wl.wlmall.ui.follow.conteact.AddFollowerPresenter;
import com.wl.wlmall.ui.main.MainActivity;
import com.wl.wlmall.utils.LoadMoreUtils;

import java.util.List;

import butterknife.BindView;
import cn.jzvd.Jzvd;

/**
 * create by wyh on 2019/6/25
 */

public class AddFollowerFragment extends BaseFragment implements AddFollowerContract.View
        , PullToRefreshRecyclerView.OnRefreshListener2<RecyclerView>, BaseQuickAdapter.RequestLoadMoreListener {


    @BindView(R.id.recy_news)
    PullToRefreshRecyclerView recyNews;
    @BindView(R.id.loading_layout)
    LoadingLayout loadingLayout;
    private int page = 1;
    private int pageSize = 10;
    private AddFollowerContract.Presenter presenter;
    private List<AllUserListBean.DataBean.RecordsBean> data;
    private FollowUserAdapter adapter;
    private RecyclerView rvNews;
    private MainActivity activity;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_follow_list;
    }

    @Override
    protected void init(View view) {
        loadingLayout.setStatus(LoadingLayout.Success);
        new AddFollowerPresenter(this);

        setAdapter(recyNews, getActivity());
        presenter.getList( page);
        activity = (MainActivity) getActivity();

        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
            }
        });
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                activity.hideCommentData();
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
        adapter = new FollowUserAdapter(context, null);
//        adapter.setLoadMoreView(new CustomLoadMoreView());
        rvNews.setAdapter(adapter);
        refreshLayout.setOnRefreshListener(AddFollowerFragment.this);
        return rvNews;
    }

    @Override
    public void showList(AllUserListBean allUserListBean) {
        data = allUserListBean.getData().getRecords();
        LoadMoreUtils.getInstance().setFollowUserLoadMore(page, pageSize, adapter, data, this, rvNews);
        recyNews.onRefreshComplete();
    }

    //关闭刷新
    @Override
    public void setRefreshLayoutHide() {
        if (recyNews != null) {
            recyNews.onRefreshComplete();
        }
    }

    //加载失败
    @Override
    public void loadFail(String msg) {
        if (recyNews != null)
            recyNews.onRefreshComplete();
    }

    @Override
    public void setPresenter(AddFollowerContract.Presenter presenter) {
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
            presenter.getList(page);
        }
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
        page = 1;
        presenter.getList(page);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<RecyclerView> refreshView) {

    }


}
