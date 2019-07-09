package com.wl.wlmall.ui.main;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.wl.wlmall.R;
import com.wl.wlmall.base.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * create by wyh on 2019/6/14
 */

public class TestActivity extends BaseActivity {
    @BindView(R.id.recy_test)
    RecyclerView rvNews;
    private TestAdapter adapter;
    private int page = 1;
    private int pageSize = 10;

    @Override
    public int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    public void init() {
        setAdapter(rvNews, this);
    }


    public void add(View view) {
    }

    public void over(View view) {
    }



    private RecyclerView setAdapter(RecyclerView recyclerView, Context context) {
        rvNews.setLayoutManager(new LinearLayoutManager(context));


        ArrayList<String> strList = new ArrayList<>();
        strList.add("http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/3e15e0505285890790450658361/UtqoVIKS2AwA.mp4");
        adapter = new TestAdapter(context, strList);
        rvNews.setAdapter(adapter);
        return rvNews;
    }

}
