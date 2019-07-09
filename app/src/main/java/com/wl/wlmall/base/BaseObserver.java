package com.wl.wlmall.base;


import com.wl.wlmall.application.App;
import com.wl.wlmall.http.ExceptionHandle;
import com.wl.wlmall.utils.NetWorkUtils;

import java.net.SocketTimeoutException;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;


/**
 * Created by WYH.
 */

public abstract class BaseObserver<T> implements Observer<T> {


    public abstract void onError(ExceptionHandle.ResponeThrowable responeThrowable);
    public abstract void onNetError(String s);
    @Override
    public void onError(@NonNull Throwable e) {
        if(e instanceof Exception){
            //访问获得对应的Exception
            if (!NetWorkUtils.isNetworkConnected(App.context)) {

                onNetError("当前网络不可用，请检查网络情况");
                // 一定好主动调用下面这一句
//                onCompleted();
            }else if(e instanceof SocketTimeoutException){
                onNetError("当前网络链接超时，请检查网络情况");
            }else {
                onError(ExceptionHandle.handleException(e));
            }
        }else {
            //将Throwable 和 未知错误的status code返回
            onError(new ExceptionHandle.ResponeThrowable(e,ExceptionHandle.ERROR.UNKNOWN));
        }
    }

    @Override
    public void onComplete() {
        //取消请求
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }
}

