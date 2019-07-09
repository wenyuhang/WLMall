package com.wl.wlmall.ui.follow.conteact;

import com.wl.wlmall.base.BaseObserver;
import com.wl.wlmall.config.Action;
import com.wl.wlmall.http.ExceptionHandle;
import com.wl.wlmall.http.RetrofitService;
import com.wl.wlmall.model.entity.AllUserListBean;
import com.wl.wlmall.ui.follow.AddFollowerFragment;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by ${wyh} on 2018/5/10.
 */

public class AddFollowerPresenter implements AddFollowerContract.Presenter {
    private AddFollowerFragment followFragment;
    private JSONObject jsonObject;

    public AddFollowerPresenter(AddFollowerFragment followFragment) {
        this.followFragment = followFragment;
        this.followFragment.setPresenter(this);
    }


    /**
     * 获取文案
     * @param page
     */
    @Override
    public void getList(int page) {
        if(page==1) {
            followFragment.showProgress();
        }
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), buildJson(page));
        RetrofitService.createYoaWo()
                .getAllUserList(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<AllUserListBean>() {
                    @Override
                    public void onNext(AllUserListBean allUserListBean) {
                        followFragment.cancelProgress();
                        if(Action.STATUS_CODE == allUserListBean.getCode()) {
                            followFragment.showList(allUserListBean);
                        }else {
                            followFragment.loadFail(allUserListBean.getMsg());
                        }
                    }

                    @Override
                    public void onError(ExceptionHandle.ResponeThrowable responeThrowable) {
                        followFragment.cancelProgress();
                        followFragment.setRefreshLayoutHide();
                        followFragment.loadFail(responeThrowable.message);
                    }

                    @Override
                    public void onNetError(String s) {
//                        followFragment.loadFail(s);
                        followFragment.cancelProgress();
                        followFragment.setRefreshLayoutHide();
                        followFragment.showList(null);
                    }
                });
    }
    private String buildJson(int page) {

        try {
            jsonObject = new JSONObject();
            jsonObject.put("page",page);
            jsonObject.put("videoChannelId",-1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
