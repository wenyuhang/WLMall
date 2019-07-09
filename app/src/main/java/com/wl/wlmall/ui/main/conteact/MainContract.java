package com.wl.wlmall.ui.main.conteact;


import com.wl.wlmall.base.BaseProView;
import com.wl.wlmall.model.entity.CommentListBean;

/**
 * Created by ${wyh} on 2018/5/10.
 */

public interface MainContract {
    interface View extends BaseProView<Presenter> {
        void showList(CommentListBean commentListBean);
        void loadFail(String msg);
    }

    interface Presenter{
        void getList(String id, int page);
    }
}
