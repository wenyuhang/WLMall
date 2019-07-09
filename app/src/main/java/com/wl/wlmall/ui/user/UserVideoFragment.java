package com.wl.wlmall.ui.user;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wl.wlmall.R;
import com.wl.wlmall.base.BaseFragment;
import com.wl.wlmall.desgin.LoadingLayout;
import com.wl.wlmall.ui.main.TestAdapter;
import com.wl.wlmall.utils.T;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * create by wyh on 2019/6/25
 * 用户视频列表
 */

public class UserVideoFragment extends BaseFragment{
    @BindView(R.id.recy_view)
    RecyclerView recyView;
    @BindView(R.id.loading_layout)
    LoadingLayout loadingLayout;
    Unbinder unbinder;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recyclerview;
    }

    @Override
    protected void init(View view) {
        loadingLayout.setStatus(LoadingLayout.Success);
        setAdapter(recyView,getActivity());
    }

    private void setAdapter(RecyclerView recyclerView, Context context) {
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        ArrayList<String> strList = new ArrayList<>();
        for(int i = 0; i <50 ; i++) {
            strList.add("数据"+i);
        }
        TestAdapter adapter = new TestAdapter(context, strList);

        recyclerView.setAdapter(adapter);
        adapter.setEnableLoadMore(true);
        adapter.loadMoreEnd(true);
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                T.s("加载更多");
            }
        },recyclerView);
    }
}
