package com.reactvideo;


import android.support.annotation.Nullable;
import android.util.Log;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

import videoplayer.widget.BDCloudVideoView;

/**
 * Created by YiBing on 2017/4/28.
 */
public class BDdVideoViewManager extends ViewGroupManager<BDCloudVideoView>{
    ThemedReactContext context;
    String TAG = BDdVideoViewManager.class.getSimpleName();
    public static final String REACT_CLASS = "BDdVideoViewManager";

    @Override
    public String getName() {
        return REACT_CLASS;
    }
    static BDCloudVideoView txCloudVideoView;
    @Override
    protected BDCloudVideoView createViewInstance(ThemedReactContext reactContext) {
        this.context = reactContext;
        if(txCloudVideoView==null) {
            txCloudVideoView = new BDCloudVideoView(reactContext);
        }else {
            txCloudVideoView.release();
            txCloudVideoView = new BDCloudVideoView(reactContext);
        }

        return txCloudVideoView;
    }

    @ReactProp(name = "url")
    public void setUrl(BDCloudVideoView BDCloudVideoView, @Nullable String url) {
        Log.i(TAG, "setUrl;".concat(url));
        txCloudVideoView.setVideoPath(url);
        txCloudVideoView.setVideoScalingMode(BDCloudVideoView.VIDEO_SCALING_MODE_SCALE_TO_FIT);
        txCloudVideoView.start();

    }
    public static BDCloudVideoView getInstance(){
        return txCloudVideoView;
    }
    /**
     * i=1 填充，保持视频内容的宽高比。视频与屏幕宽高不一致时，会留有黑边
     * i=2 裁剪，保持视频内容的宽高比。视频与屏幕宽高不一致时，会裁剪部分视频内容
     * i=3 铺满，不保证视频内容宽高比。视频显示与屏幕宽高相等
     */
    public static final int VIDEO_SCALING_MODE_SCALE_TO_MATCH_PARENT = 3;

    @ReactProp(name = "setVideoScalingMode")
    public void setVideoScalingMode(BDCloudVideoView BDCloudVideoView, int i) {
        BDCloudVideoView.setVideoScalingMode(i);
    }

}