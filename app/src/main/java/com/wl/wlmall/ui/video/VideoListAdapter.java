package com.wl.wlmall.ui.video;

import android.content.Context;
import android.widget.ImageView;
import android.widget.VideoView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wl.wlmall.R;
import com.wl.wlmall.http.GlideUtils;
import com.wl.wlmall.model.entity.VideoListBean;
import com.wl.wlmall.utils.StringUtil;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * create by wyh on 2019/1/6
 */

public class VideoListAdapter extends BaseQuickAdapter<VideoListBean.DataBean.RecordsBean, BaseViewHolder> {

    private int[] imgs = {R.mipmap.img_video_1, R.mipmap.img_video_2};
    private int[] videos = {R.raw.video_1, R.raw.video_2};
    private String[] paths = {"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/f16deefa5285890789837664303/OznAXqScXVAA.mp4",
            "http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/f1a438815285890789837694307/1LnZsPFJQyMA.mp4",
    };
    private Context context;
    private ImageView bgview;
    private VideoView videoView;
    private CircleImageView headerView;
    private String title;
    private String nickname;
    private String commentNum;
    private String forwardNum;
    private String followNum;

    public VideoListAdapter(Context context, List<VideoListBean.DataBean.RecordsBean> data) {
        super(R.layout.item_view_pager, data);
        this.context = context;
    }


    @Override
    protected void convert(BaseViewHolder holder, VideoListBean.DataBean.RecordsBean item) {
        //背景图
        bgview = holder.getView(R.id.img_thumb);
        GlideUtils.load(item.getCoverUrl(),bgview);
        //视频
        videoView = holder.getView(R.id.video_view);
//        view.setVideoURI(Uri.parse("android.resource://" + context.getPackageName() + "/" + videos[holder.getAdapterPosition() % 2]));
//        view.setVideoPath(paths[holder.getAdapterPosition() % 2]);
        videoView.setVideoPath(item.getVideoUrl());
        //头像
        headerView = holder.getView(R.id.recy_img_header);
        GlideUtils.load(item.getAvatar(),headerView);
        //标题
        title = item.getTitle();
        if(!StringUtil.getInstance().isEmpty(title)) {
            holder.setText(R.id.recy_tv_title,title);
        }
        //昵称
        nickname = item.getNickname();
        if(!StringUtil.getInstance().isEmpty(nickname)) {
            holder.setText(R.id.recy_tv_name,nickname);
        }
        //点赞数
        followNum = String.valueOf(item.getFollowNum());
        if(!StringUtil.getInstance().isEmpty(followNum)) {
            holder.setText(R.id.recy_btn_heart,followNum);
        }
        //评论数
        commentNum = String.valueOf(item.getCommentNum());
        if(!StringUtil.getInstance().isEmpty(commentNum)) {
            holder.setText(R.id.recy_btn_comment,commentNum);
        }
        //分享数
        forwardNum = String.valueOf(item.getForwardNum());
        if(!StringUtil.getInstance().isEmpty(forwardNum)) {
            holder.setText(R.id.recy_btn_share,forwardNum);
        }

        holder.addOnClickListener(R.id.layout_love_view);

    }
}