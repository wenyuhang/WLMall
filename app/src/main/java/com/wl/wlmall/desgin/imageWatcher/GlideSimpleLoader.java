package com.wl.wlmall.desgin.imageWatcher;

import android.content.Context;
import android.net.Uri;

public class GlideSimpleLoader implements ImageWatcher.Loader {
    @Override
    public void load(Context context, Uri uri, final ImageWatcher.LoadCallback lc) {
//        Glide.with(context).load(uri)
//                .into(new SimpleTarget<Drawable>() {
//                    @Override
//                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
//                        lc.onResourceReady(resource);
//                    }
//
//                    @Override
//                    public void onLoadFailed(@Nullable Drawable errorDrawable) {
//                        lc.onLoadFailed(errorDrawable);
//                    }
//
//                    @Override
//                    public void onLoadStarted(@Nullable Drawable placeholder) {
//                        lc.onLoadStarted(placeholder);
//                    }
//
//                });
//
//        Glide.with(context).load(uri).into(new SimpleTarget<GlideDrawable>() {
//            @Override
//            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
//                lc.onResourceReady(resource);
//            }
//
//            @Override
//            public void onLoadFailed(Exception e, Drawable errorDrawable) {
//                lc.onLoadFailed(errorDrawable);
//            }
//
//            @Override
//            public void onLoadStarted(Drawable placeholder) {
//                lc.onLoadStarted(placeholder);
//            }
//        });
    }
}
