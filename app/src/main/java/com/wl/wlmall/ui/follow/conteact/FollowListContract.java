package com.wl.wlmall.ui.follow.conteact;


import com.wl.wlmall.base.BaseProView;
import com.wl.wlmall.model.entity.FollowListBean;

/**
 * Created by ${wyh} on 2018/5/10.
 */

public interface FollowListContract {
    interface View extends BaseProView<Presenter> {
        void showList(FollowListBean followListBean);
        void loadFail(String msg);
        void setRefreshLayoutHide();
    }

    interface Presenter{
        void getList(String token, int page);
    }
}
