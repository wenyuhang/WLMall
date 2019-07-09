package com.wl.wlmall.ui.video.conteact;


import com.wl.wlmall.base.BaseView;
import com.wl.wlmall.model.entity.VideoListBean;

/**
 * Created by ${wyh} on 2018/5/10.
 */

public interface VideoContract {
    interface View extends BaseView<Presenter> {
        void showList(VideoListBean videoListBean);
        void loadFail(String msg);
        void setRefreshLayoutHide();
    }

    interface Presenter{
        void getList(int page);
    }
}
