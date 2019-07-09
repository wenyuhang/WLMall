package com.wl.wlmall.http;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.wl.wlmall.config.Urls;

import java.net.Proxy;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by wyh on 2017/9/21.
 * 服务
 */

public class RetrofitService {

    private static Retrofit retrofit;
    private static Api api;
    private static Retrofit retrofitWx;
    private static Api wxApi;

    private RetrofitService() {
    }

    /**
     * 公司域名
     * @return
     */
    public static Api createYoaWo() {
        if (retrofit == null) synchronized (RetrofitService.class) {
            if (retrofit == null) {
                OkHttpClient client = new OkHttpClient.Builder()
                        .proxy(Proxy.NO_PROXY).build();
                retrofit = new Retrofit.Builder()
                            .client(client)
                        .baseUrl(Urls.ONLINE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build();
                api = retrofit.create(Api.class);

            }
        }
        return api;
    }


    /**
     * 更新公司域名
     */
    public static void refreshUrl() {
        OkHttpClient client = new OkHttpClient.Builder()
                .proxy(Proxy.NO_PROXY).build();
        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(Urls.ONLINE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        api = retrofit.create(Api.class);
    }
}
