package com.wl.wlmall.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wl.wlmall.R;
import com.wl.wlmall.http.GlideUtils;
import com.wl.wlmall.model.entity.AllUserListBean;
import com.wl.wlmall.utils.StringUtil;

import java.util.List;

import cn.jzvd.JzvdStd;

/**
 * create by wyh on 2018/9/25
 * 我的果园
 */

public class FollowUserAdapter extends BaseQuickAdapter<AllUserListBean.DataBean.RecordsBean, BaseViewHolder> {


    private Context context;
    private ImageView bgView;
    private String title;
    private String nickname;
    private int commentNum;
    private int followNum;
    private ImageView imgHeader;
    private JzvdStd videoView;

    public FollowUserAdapter(Context context, List<AllUserListBean.DataBean.RecordsBean> data) {
        super(R.layout.recy_follower_item, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, final AllUserListBean.DataBean.RecordsBean item) {

        //头像
        imgHeader = helper.getView(R.id.recy_img_header);
        GlideUtils.load(item.getAvatar(), imgHeader);
        //个性签名
        title = item.getSignature();
        if(!StringUtil.getInstance().isEmpty(title)) {
            helper.setText(R.id.recy_tv_auto,title);
        }
        //昵称
        nickname = item.getNickname();
        if(!StringUtil.getInstance().isEmpty(nickname)) {
            helper.setText(R.id.recy_tv_name,nickname);
        }

//        helper.addOnClickListener(R.id.recy_tv_comment);
    }
}
