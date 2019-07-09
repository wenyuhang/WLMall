package com.wl.wlmall.ui.user;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.wl.wlmall.R;
import com.wl.wlmall.base.BaseFragment;
import com.wl.wlmall.desgin.LoadingLayout;
import com.wl.wlmall.ui.main.TestAdapter;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * create by wyh on 2019/6/25
 * 用户点赞视频列表
 */

public class UserAdmireFragment extends BaseFragment {
    @BindView(R.id.recy_view)
    RecyclerView recyView;
    @BindView(R.id.loading_layout)
    LoadingLayout loadingLayout;

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
        for(int i = 0; i <0 ; i++) {
          strList.add("数据"+i);
        }
        TestAdapter adapter = new TestAdapter(context, strList);
        recyclerView.setAdapter(adapter);
    }

}
