package com.wl.wlmall.ui.follow.conteact;


import com.wl.wlmall.base.BaseProView;
import com.wl.wlmall.model.entity.AllUserListBean;

/**
 * Created by ${wyh} on 2018/5/10.
 */

public interface AddFollowerContract {
    interface View extends BaseProView<Presenter> {
        void showList(AllUserListBean allUserListBean);
        void loadFail(String msg);
        void setRefreshLayoutHide();
    }

    interface Presenter{
        void getList( int page);
    }
}
