package com.wl.wlmall.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wl.wlmall.R;
import com.wl.wlmall.http.GlideUtils;
import com.wl.wlmall.model.entity.NewsListBean;
import com.wl.wlmall.utils.StringUtil;

import java.util.List;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

/**
 * create by wyh on 2018/9/25
 * 我的果园
 */

public class NewsListAdapter extends BaseQuickAdapter<NewsListBean.DataBean.RecordsBean, BaseViewHolder> {


    private Context context;
    private ImageView bgView;
    private String title;
    private String nickname;
    private int commentNum;
    private int followNum;
    private ImageView imgHeader;
    private JzvdStd videoView;

    public NewsListAdapter(Context context, List<NewsListBean.DataBean.RecordsBean> data) {
        super(R.layout.recy_news_item, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, final NewsListBean.DataBean.RecordsBean item) {
        videoView = helper.getView(R.id.recy_video);
        videoView.setUp(
                item.getVideoUrl(),
                null, Jzvd.SCREEN_NORMAL);
        Glide.with(videoView.getContext()).load(item.getCoverUrl()).into(videoView.thumbImageView);
//        bgView = helper.getView(R.id.recy_img);
//        GlideUtils.load(item.getCoverUrl(), bgView);
        //头像
        imgHeader = helper.getView(R.id.recy_img_header);
        GlideUtils.load(item.getAvatar(), imgHeader);
        //标题
        title = item.getTitle();
        if(!StringUtil.getInstance().isEmpty(title)) {
            helper.setText(R.id.recy_tv_title,title);
        }
        //昵称
        nickname = item.getNickname();
        if(!StringUtil.getInstance().isEmpty(nickname)) {
            helper.setText(R.id.recy_tv_name,nickname);
        }
        //评论数
        commentNum = item.getCommentNum();
        helper.setText(R.id.recy_tv_comment,String.valueOf(commentNum));
        //点赞数
        followNum = item.getFollowNum();
        helper.setText(R.id.recy_tv_praise,String.valueOf(followNum));

        helper.addOnClickListener(R.id.recy_tv_comment);
    }
}
