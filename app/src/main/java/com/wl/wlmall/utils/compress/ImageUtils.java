package com.wl.wlmall.utils.compress;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;


/**
 * Created by lilonghui on 2017/9/1.
 */

public class ImageUtils {
    private static final int reqWidth = 720;
    private static final int reqHeight = 720;

    public static String getMapViewUrl(String lonlat) {

        String url = "http://restapi.amap.com/v3/staticmap?location=" + lonlat + "&zoom=15&size=600*600&markers=large,0x3C64D8,A:" + lonlat + "&key=7406763d2f1dcbe4cd21cd917889fd27";
        return url;
    }


    public static String compressBitmap(Context context, String src, int limite) {
        File file = new File(src);
        if (file.exists()) {
            int[] bitmapWidtHeight = getImageWidthHeight(src);

            int divi;
            int w = bitmapWidtHeight[0];
            int h = bitmapWidtHeight[1];
            int min=w>h?h:w;
            if (min<1400){
                divi=1;
            }else if(min<2400){
                divi=2;
            }else if(min<3800){
                divi=3;
            }else{
                divi=4;
            }

            String newpath = CacheUtils.getExternalCacheDir(context) +
                    System.currentTimeMillis() + "/.yoawo";
            File newFile = new CompressHelper.Builder(context)
                    .setMaxWidth(w/divi)
                    .setMaxHeight(h/divi)
                    .setQuality(limite)
                    .setCompressFormat(Bitmap.CompressFormat.JPEG) // 设置默认压缩为jpg格式
                    .setDestinationDirectoryPath(newpath)
                    .build()
                    .compressToFile(file);

            String absolutePath = newFile.getAbsolutePath();
            return absolutePath;
        }

        return null;
    }


    public static int[] getImageWidthHeight(String path) {
        BitmapFactory.Options options = new BitmapFactory.Options();

        /**
         * 最关键在此，把options.inJustDecodeBounds = true;
         * 这里再decodeFile()，返回的bitmap为空，但此时调用options.outHeight时，已经包含了图片的高了
         */
        options.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeFile(path, options); // 此时返回的bitmap为null
        /**
         *options.outHeight为原始图片的高
         */
        return new int[]{options.outWidth, options.outHeight};
    }


}

