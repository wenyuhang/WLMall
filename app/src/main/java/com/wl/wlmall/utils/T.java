package com.wl.wlmall.utils;

import android.view.Gravity;
import android.widget.Toast;

import com.wl.wlmall.application.App;


/**
 * Created by WYH on 2017/9/21.
 * Toast管理
*/

public class T {
    public static void s(String msg){
        Toast toast = Toast.makeText(App.context, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM,0,300);
        toast.show();
    }
    public static void l(String msg){
        Toast.makeText(App.context,msg, Toast.LENGTH_LONG).show();
    }
}
