package com.wl.wlmall.config;

/**
 * create by wyh on2018/9/11
 */

public class Action {
    public static final int STATUS_CODE = 0;              //返回code

    //    OnActivityResult    requestcode值
    public static final int CLOSE = 1000;                    //取消
    public static final int TYPE_CAMERA = 1001;              //拉起相机
    public static final int TYPE_ALBUM = 1002;               //相册
    public static final int CODE_CROP = 1003;                //图片裁剪
    public static final int TYPE_MORE_ALBUM = 1004;          //相册多选
    public static final int TYPE_VIDEO = 1005;               //打开系统媒体库


    //sharedPreferences    key值

    public static final String SP_START_FLAG = "sp_start_flag";            //首次安装
    public static final String SP_TOKEN = "sp_token";                      //token
    public static final String SP_TOKEN_TYPE = "sp_token_type";            //token_type
}
