package com.wl.wlmall.http;


import com.wl.wlmall.config.Urls;
import com.wl.wlmall.model.entity.AllUserListBean;
import com.wl.wlmall.model.entity.CommentListBean;
import com.wl.wlmall.model.entity.FollowListBean;
import com.wl.wlmall.model.entity.NewsListBean;
import com.wl.wlmall.model.entity.VideoListBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by WHY on 2017/9/21.
 */
public interface Api {

    /**
     * 咨询列表
     *
     * @param body
     * @return
     */
    @POST(Urls.NEWS_LSIT)
    Observable<NewsListBean> getNewsList(@Body RequestBody body);


    /**
     * 获取视屏列表
     * @param body
     * @return
     */
    @POST(Urls.VIDEO_LIST)
    Observable<VideoListBean> getVideoList(@Body RequestBody body);

    /**
     * 视频评论列表
     */
    @POST(Urls.COMMENT_LIST)
    Observable<CommentListBean> getCommentList(@Body RequestBody body);

    /**
     * 我的关注
     *
     * @param body
     * @return
     */
    @POST(Urls.FOLLOW_LIST)
    Observable<FollowListBean> getFollowList(@Header("authorization")String token,
                                             @Body RequestBody body);

    /**
     * 所有用户
     *
     * @param body
     * @return
     */
    @POST(Urls.ALL_USER_LIST)
    Observable<AllUserListBean> getAllUserList(@Body RequestBody body);

//    用户

    /**
     * 手机号登录
     *
     * @param mobile 手机号
     * @param code   验证码
     * @return
     */
    @FormUrlEncoded
    @POST(Urls.PHONE_LOGIN)
    Observable<ResponseBody> phoneLogin(@Field("mobile") String mobile,
                                     @Field("code") String code);

    @FormUrlEncoded
    @POST(Urls.s)
    Observable<ResponseBody> get(@Header("authorization") String mobile,
                                 @Field("page") String page,
                                 @Field("pagesize") String pagesize);

    /**
     * 用户信息
     *
     * @param authorization
     * @return
     */
    @GET(Urls.USER_INFO)
    Observable<ResponseBody> userInfo(@Header("authorization") String authorization);

    /**
     * 修改用户信息
     *
     * @param authorization
     * @param name
     * @return
     */
    @GET(Urls.USER_INFO)
    Observable<ResponseBody> editUserInfo(@Header("authorization") String authorization,
                                          @Field("name") String name);




}
