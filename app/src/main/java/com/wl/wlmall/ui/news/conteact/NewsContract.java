package com.wl.wlmall.ui.news.conteact;


import com.wl.wlmall.base.BaseProView;
import com.wl.wlmall.model.entity.NewsListBean;

/**
 * Created by ${wyh} on 2018/5/10.
 */

public interface NewsContract {
    interface View extends BaseProView<Presenter> {
        void showList(NewsListBean orchardListBean);
        void loadFail(String msg);
        void setRefreshLayoutHide();
    }

    interface Presenter{
        void getList(String id, int page);
    }
}
