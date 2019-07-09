package com.wl.wlmall.ui.main.conteact;

import com.wl.wlmall.base.BaseObserver;
import com.wl.wlmall.config.Action;
import com.wl.wlmall.http.ExceptionHandle;
import com.wl.wlmall.http.RetrofitService;
import com.wl.wlmall.model.entity.CommentListBean;
import com.wl.wlmall.ui.main.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by ${wyh} on 2018/5/10.
 */

public class MainPresenter implements MainContract.Presenter {
    private MainActivity mainActivity;
    private JSONObject jsonObject;

    public MainPresenter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.mainActivity.setPresenter(this);
    }


    /**
     * 获取文案
     * @param page
     */
    @Override
    public void getList(String videoId,int page) {
        if(page==1) {
            mainActivity.showProgress();
        }

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), buildJson(videoId,page));
        RetrofitService.createYoaWo()
                .getCommentList(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<CommentListBean>() {
                    @Override
                    public void onNext(CommentListBean commentListBean) {
                        if(page==1) {
                            mainActivity.cancelProgress();
                        }
                        if(Action.STATUS_CODE == commentListBean.getCode()) {
                            mainActivity.showList(commentListBean);
                        }else {
                            mainActivity.loadFail(commentListBean.getMsg());
                        }
                    }

                    @Override
                    public void onError(ExceptionHandle.ResponeThrowable responeThrowable) {
                        if(page==1) {
                            mainActivity.cancelProgress();
                        }
                        mainActivity.loadFail(responeThrowable.message);
                    }

                    @Override
                    public void onNetError(String s) {
                        if(page==1) {
                            mainActivity.cancelProgress();
                        }
                        mainActivity.showList(null);
                    }
                });
    }
    private String buildJson(String videoId,int page) {

        try {
            jsonObject = new JSONObject();
            jsonObject.put("page",page);
            jsonObject.put("videoId",videoId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
