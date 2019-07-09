package com.wl.wlmall.config;

/**
 * Created by wyh on 2017/9/21.
 * URL管理
 */

public class Urls {

    //*正式服地址
    public static final String BASEURL = "http://gxt.ldtch.com";
//    public static final String BASEURL = "http://192.168.1.18:8088";

    //*测试服地址
    public static final String DEV_BASEURL = "";

    //*服务器地址
    public static final String ONLINE_URL = BASEURL;

    //*baseimg
    public static final String BASE_IMGURL = "";


    public static final String s = "/user/nuo_star";



    //    用户
    //*手机号登录
    public static final String PHONE_LOGIN = "/api/authorizations";
    //*用户信息&&修改用户信息
    public static final String USER_INFO = "/api/user";
    //*用户果园
    public static final String USER_ORCHARD = "/api/user/orchard";
    //*用户果园&&用户提交收藏
    public static final String USER_COLLECTION = "/api/user/collection";
    //*用户果园订单
    public static final String USER_ORDER = "/api/user/order/orchard";
    //*用户商城订单
    public static final String USER_MALL_ORDER = "/api/user/order/shop";
    //*用户通知列表
    public static final String USER_NOTICE = "/api/user/notice/list";
    //*用户通知详情
    public static final String NOTICE_INFO = "/api/user/notice/1";
    //*邀请用户
    public static final String INVITE_PERSON = "/api/user/invite";
    //*用户添加积分
    public static final String USER_INTE = "/api/user/point";


    //  Video
    //*热门视频列表
    public static final String VIDEO_LIST = "/app/video/findPage";
    //*资讯列表
    public static final String NEWS_LSIT = "/app/video/channelPage";
    //*我的关注列表
    public static final String FOLLOW_LIST = "/app/user/attentPageVideo ";
    //*所有用户列表
    public static final String ALL_USER_LIST = "/app/user/attentPage/allUser";
    //*视频评论列表
    public static final String COMMENT_LIST= "/app/comment/page";


    //    商城
    //*轮播图
    public static final String MALL_BANNER = "/api/shop/slide";
    //*商品列表
    public static final String MALL_GOODS_LIST = "/api/shop/good/list";
    //*商品详情
    public static final String MALL_GOODS_INFO = "/api/shop/good/1";
    //*购买商品
    public static final String MALL_TO_BUY = "/api/shop/buy";
}
