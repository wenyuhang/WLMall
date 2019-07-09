package com.wl.wlmall.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wl.wlmall.R;
import com.wl.wlmall.http.GlideUtils;
import com.wl.wlmall.model.entity.CommentListBean;
import com.wl.wlmall.utils.StringUtil;

/**
 * create by wyh on 2019/6/18
 */

public class NormalAdapter extends BaseQuickAdapter<CommentListBean.DataBean.RecordsBean, BaseViewHolder> {

    private ImageView headerView;
    private String content;
    private String nickname;
    private String timeStr;
    private String replyNum;

    public NormalAdapter() {
        super(R.layout.item_comment);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommentListBean.DataBean.RecordsBean item) {
        //头像
        headerView = helper.getView(R.id.recy_img_header);
        GlideUtils.load(item.getAvatar(),headerView);
        //昵称
        nickname = item.getNickname();
        if(!StringUtil.getInstance().isEmpty(nickname)) {
            helper.setText(R.id.recy_tv_name,nickname);
        }
        //评论
        content = item.getContent();
        if(!StringUtil.getInstance().isEmpty(content)) {
            helper.setText(R.id.recy_tv_comment,content);
        }
        //时间
        timeStr = item.getTimeStr();
        if(!StringUtil.getInstance().isEmpty(timeStr)) {
           helper.setText(R.id.recy_tv_time,timeStr);
        }
        //点赞数
        replyNum = String.valueOf(item.getFollowNum());
        if(!StringUtil.getInstance().isEmpty(replyNum)) {
            helper.setText(R.id.rect_tv_num,replyNum);
        }
    }
}
