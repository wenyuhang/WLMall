package com.wl.wlmall.ui.main;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wl.wlmall.R;

import java.util.List;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

/**
 * create by wyh on 2018/9/25
 * 我的果园
 */

public class TestAdapter extends BaseQuickAdapter<String, BaseViewHolder> {


    private Context context;
    private JzvdStd videoView;

    public TestAdapter(Context context, List<String> data) {
        super(R.layout.recy_news_item, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, final String item) {
//        ImageView view = helper.getView(R.id.recy_img);
//        GlideUtils.load(item,view);
        videoView = helper.getView(R.id.recy_video);
        videoView.setUp(
                item,
                "大标题", Jzvd.SCREEN_NORMAL);
        Glide.with(videoView.getContext()).load("http://video.ldtch.com/Fpq34mmi9zLKiugQH1uSToPV9Jod").into(videoView.thumbImageView);
    }
}
