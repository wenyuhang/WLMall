package com.wl.wlmall.utils;

import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wl.wlmall.model.entity.AllUserListBean;
import com.wl.wlmall.model.entity.CommentListBean;
import com.wl.wlmall.model.entity.FollowListBean;
import com.wl.wlmall.model.entity.NewsListBean;
import com.wl.wlmall.model.entity.VideoListBean;

import java.util.List;

/**
 * create by wyh on 2018/9/25
 */

public class LoadMoreUtils {

    private static LoadMoreUtils loadMoreUtils;

    public static LoadMoreUtils getInstance() {
        if (loadMoreUtils == null) {
            synchronized (LoadMoreUtils.class) {
                if (loadMoreUtils == null) {
                    loadMoreUtils = new LoadMoreUtils();
                }
            }
        }
        return loadMoreUtils;
    }

    //测试列表
    public void setTestLoadMore(int page, int pageSize, BaseQuickAdapter adapter,
                            List<String> data,
                            BaseQuickAdapter.RequestLoadMoreListener listener,
                            RecyclerView recyclerView) {
        adapter.setEnableLoadMore(true);
        if (page <= 1) {
            adapter.setNewData(data);
        } else if (data == null || data.size() <= 0) {
            adapter.loadMoreComplete();
        } else {
            adapter.addData(data);
            adapter.loadMoreComplete();
        }
        if (data != null && data.size() > 0 && data.size() >= pageSize) {
            adapter.loadMoreEnd(true);
            adapter.setOnLoadMoreListener(listener, recyclerView);
        } else {
            adapter.setOnLoadMoreListener(listener, recyclerView);
            adapter.loadMoreEnd(false);
        }
    }

    //咨询列表
    public void setNewsLoadMore(int page, int pageSize, BaseQuickAdapter adapter,
                            List<NewsListBean.DataBean.RecordsBean> data,
                            BaseQuickAdapter.RequestLoadMoreListener listener,
                            RecyclerView recyclerView) {
        adapter.setEnableLoadMore(true);
        if (page <= 1) {
            adapter.setNewData(data);
        } else if (data == null || data.size() <= 0) {
            adapter.loadMoreComplete();
        } else {
            adapter.addData(data);
            adapter.loadMoreComplete();
        }
        if (data != null && data.size() > 0 && data.size() >= pageSize) {
            adapter.loadMoreEnd(true);
            adapter.setOnLoadMoreListener(listener, recyclerView);
        } else {
            adapter.setOnLoadMoreListener(listener, recyclerView);
            adapter.loadMoreEnd(false);
        }
    }

    //关注列表
    public void setFollowLoadMore(int page, int pageSize, BaseQuickAdapter adapter,
                                List<FollowListBean.DataBean.RecordsBean> data,
                                BaseQuickAdapter.RequestLoadMoreListener listener,
                                RecyclerView recyclerView) {
        adapter.setEnableLoadMore(true);
        if (page <= 1) {
            adapter.setNewData(data);
        } else if (data == null || data.size() <= 0) {
            adapter.loadMoreComplete();
        } else {
            adapter.addData(data);
            adapter.loadMoreComplete();
        }
        if (data != null && data.size() > 0 && data.size() >= pageSize) {
            adapter.loadMoreEnd(true);
            adapter.setOnLoadMoreListener(listener, recyclerView);
        } else {
            adapter.setOnLoadMoreListener(listener, recyclerView);
            adapter.loadMoreEnd(false);
        }
    }

    //用户列表
    public void setFollowUserLoadMore(int page, int pageSize, BaseQuickAdapter adapter,
                                  List<AllUserListBean.DataBean.RecordsBean> data,
                                  BaseQuickAdapter.RequestLoadMoreListener listener,
                                  RecyclerView recyclerView) {
        adapter.setEnableLoadMore(true);
        if (page <= 1) {
            adapter.setNewData(data);
        } else if (data == null || data.size() <= 0) {
            adapter.loadMoreComplete();
        } else {
            adapter.addData(data);
            adapter.loadMoreComplete();
        }
        if (data != null && data.size() > 0 && data.size() >= pageSize) {
            adapter.loadMoreEnd(true);
            adapter.setOnLoadMoreListener(listener, recyclerView);
        } else {
            adapter.setOnLoadMoreListener(listener, recyclerView);
            adapter.loadMoreEnd(false);
        }
    }

    //视频列表
    public static void setVideoLoadMore(int page, int pageSize, BaseQuickAdapter adapter,
                                   List<VideoListBean.DataBean.RecordsBean> data,
                                   BaseQuickAdapter.RequestLoadMoreListener listener,
                                   RecyclerView recyclerView) {
        adapter.setEnableLoadMore(true);
        if (page <= 1) {
            adapter.setNewData(data);
        } else if (data == null || data.size() <= 0) {
            adapter.loadMoreComplete();
        } else {
            adapter.addData(data);
            adapter.loadMoreComplete();
        }
        if (data != null && data.size() > 0 && data.size() >= pageSize) {
            adapter.loadMoreEnd(true);
            adapter.setOnLoadMoreListener(listener, recyclerView);
        } else {
            adapter.setOnLoadMoreListener(listener, recyclerView);
            adapter.loadMoreEnd(false);
        }
    }


    //视频评论列表
    public static void setCommentLoadMore(int page, int pageSize, BaseQuickAdapter adapter,
                                        List<CommentListBean.DataBean.RecordsBean> data,
                                        BaseQuickAdapter.RequestLoadMoreListener listener,
                                        RecyclerView recyclerView) {
        adapter.setEnableLoadMore(true);
        if (page <= 1) {
            adapter.setNewData(data);
        } else if (data == null || data.size() <= 0) {
            adapter.loadMoreComplete();
        } else {
            adapter.addData(data);
            adapter.loadMoreComplete();
        }
        if (data != null && data.size() > 0 && data.size() >= pageSize) {
            adapter.loadMoreEnd(true);
            adapter.setOnLoadMoreListener(listener, recyclerView);
        } else {
            adapter.setOnLoadMoreListener(listener, recyclerView);
            adapter.loadMoreEnd(false);
        }
    }

}
