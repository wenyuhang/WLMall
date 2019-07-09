package com.wl.wlmall.ui.follow.conteact;

import com.wl.wlmall.base.BaseObserver;
import com.wl.wlmall.config.Action;
import com.wl.wlmall.http.ExceptionHandle;
import com.wl.wlmall.http.RetrofitService;
import com.wl.wlmall.model.entity.FollowListBean;
import com.wl.wlmall.ui.follow.FollowListFragment;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by ${wyh} on 2018/5/10.
 */

public class FollowListPresenter implements FollowListContract.Presenter {
    private FollowListFragment followFragment;
    private JSONObject jsonObject;

    public FollowListPresenter(FollowListFragment followFragment) {
        this.followFragment = followFragment;
        this.followFragment.setPresenter(this);
    }


    /**
     * 获取文案
     * @param page
     */
    @Override
    public void getList(String token,int page) {
        followFragment.showProgress();
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), buildJson(page));
        RetrofitService.createYoaWo()
                .getFollowList(token,requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<FollowListBean>() {
                    @Override
                    public void onNext(FollowListBean followListBean) {
                        followFragment.cancelProgress();
                        if(Action.STATUS_CODE == followListBean.getCode()) {
                            followFragment.showList(followListBean);
                        }else {
                            followFragment.loadFail(followListBean.getMsg());
                        }
                    }

                    @Override
                    public void onError(ExceptionHandle.ResponeThrowable responeThrowable) {
                        followFragment.cancelProgress();
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
