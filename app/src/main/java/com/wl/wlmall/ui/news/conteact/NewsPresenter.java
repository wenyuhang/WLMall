package com.wl.wlmall.ui.news.conteact;

import com.wl.wlmall.base.BaseObserver;
import com.wl.wlmall.config.Action;
import com.wl.wlmall.http.ExceptionHandle;
import com.wl.wlmall.http.RetrofitService;
import com.wl.wlmall.model.entity.NewsListBean;
import com.wl.wlmall.ui.news.NewsFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by ${wyh} on 2018/5/10.
 */

public class NewsPresenter implements NewsContract.Presenter {
    private NewsFragment newsFragment;
    private JSONObject jsonObject;

    public NewsPresenter(NewsFragment newsFragment) {
        this.newsFragment = newsFragment;
        this.newsFragment.setPresenter(this);
    }


    /**
     * 获取文案
     * @param page
     */
    @Override
    public void getList(String id,int page) {
        newsFragment.showProgress();
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), buildJson(id,page));
        RetrofitService.createYoaWo()
                .getNewsList(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<NewsListBean>() {
                    @Override
                    public void onNext(NewsListBean orchardListBean) {
                        newsFragment.cancelProgress();
                        if(Action.STATUS_CODE == orchardListBean.getCode()) {
                            newsFragment.showList(orchardListBean);
                        }else {
                            newsFragment.loadFail(orchardListBean.getMsg());
                        }
                    }

                    @Override
                    public void onError(ExceptionHandle.ResponeThrowable responeThrowable) {
                        newsFragment.cancelProgress();
                        newsFragment.loadFail(responeThrowable.message);
                    }

                    @Override
                    public void onNetError(String s) {
//                        mallFragment.loadFail(s);
                        newsFragment.cancelProgress();
                        NewsListBean orchardListBean = new NewsListBean();
                        orchardListBean.setData(new NewsListBean.DataBean());
                        orchardListBean.getData().setRecords(new ArrayList<NewsListBean.DataBean.RecordsBean>());
                        newsFragment.setRefreshLayoutHide();
                        newsFragment.showList(orchardListBean);
                    }
                });
    }
    private String buildJson(String id,int page) {

        try {
            jsonObject = new JSONObject();
            jsonObject.put("channelId",id);
            jsonObject.put("page",page);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
