package com.wl.wlmall.ui.video.conteact;

import com.wl.wlmall.base.BaseObserver;
import com.wl.wlmall.config.Action;
import com.wl.wlmall.http.ExceptionHandle;
import com.wl.wlmall.http.RetrofitService;
import com.wl.wlmall.model.entity.VideoListBean;
import com.wl.wlmall.ui.video.VideoFragment;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by ${wyh} on 2018/5/10.
 */

public class VideoPresenter implements VideoContract.Presenter {
    private VideoFragment videoFragment;
    private JSONObject jsonObject;

    public VideoPresenter(VideoFragment videoFragment) {
        this.videoFragment = videoFragment;
        this.videoFragment.setPresenter(this);
    }


    /**
     * 获取文案
     * @param page
     */
    @Override
    public void getList(int page) {

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), buildJson(page));
        RetrofitService.createYoaWo()
                .getVideoList(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<VideoListBean>() {
                    @Override
                    public void onNext(VideoListBean videoListBean) {
                        if(Action.STATUS_CODE == videoListBean.getCode()) {
                            videoFragment.showList(videoListBean);
                        }else {
                            videoFragment.loadFail(videoListBean.getMsg());
                        }
                    }

                    @Override
                    public void onError(ExceptionHandle.ResponeThrowable responeThrowable) {
                        videoFragment.loadFail(responeThrowable.message);
                        videoFragment.setRefreshLayoutHide();
                    }

                    @Override
                    public void onNetError(String s) {
//                        mallFragment.loadFail(s);
                        videoFragment.setRefreshLayoutHide();
//                        videoFragment.showList(orchardListBean);
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
