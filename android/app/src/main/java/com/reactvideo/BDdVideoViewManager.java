package com.reactvideo;


import android.support.annotation.Nullable;
import android.util.Log;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

import videoplayer.widget.BDCloudVideoView;


public class BDdVideoViewManager extends ViewGroupManager<BDCloudVideoView>{
    private String TAG = BDdVideoViewManager.class.getSimpleName();
    private static final String REACT_CLASS = "BDdVideoViewManager";

    @Override
    public String getName() {
        return REACT_CLASS;
    }
    private static BDCloudVideoView currentCloudVideoView;
    private static BDCloudVideoView lastCloudVideoView;
    @Override
    protected BDCloudVideoView createViewInstance(ThemedReactContext reactContext) {
            lastCloudVideoView=new BDCloudVideoView(reactContext);
            return lastCloudVideoView;
    }
    public static BDCloudVideoView getInstance(){
        if(currentCloudVideoView!=null){
            return currentCloudVideoView;
        }
        return lastCloudVideoView;
    }
    @ReactProp(name = "setCurrent")
    public void setCurrent(BDCloudVideoView bdCloudVideoView,@Nullable int i) {
        currentCloudVideoView=bdCloudVideoView;
    }
    @ReactProp(name = "url")
    public void setUrl(BDCloudVideoView bdCloudVideoView, @Nullable String url) {
        Log.i(TAG, "setUrl;".concat(url));
        bdCloudVideoView.setVideoPath(url);
        bdCloudVideoView.setVideoScalingMode(bdCloudVideoView.VIDEO_SCALING_MODE_SCALE_TO_FIT);

    }

    /**
     * i=1 填充，保持视频内容的宽高比。视频与屏幕宽高不一致时，会留有黑边
     * i=2 裁剪，保持视频内容的宽高比。视频与屏幕宽高不一致时，会裁剪部分视频内容
     * i=3 铺满，不保证视频内容宽高比。视频显示与屏幕宽高相等
     */
    public static final int VIDEO_SCALING_MODE_SCALE_TO_MATCH_PARENT = 3;


    @ReactProp(name = "setVideoScalingMode")
    public void setVideoScalingMode(BDCloudVideoView bdCloudVideoView, @Nullable int i) {
        bdCloudVideoView.setVideoScalingMode(i);
    }

    @ReactProp(name = "start")
    public void start(BDCloudVideoView bdCloudVideoView,@Nullable int i) {
        bdCloudVideoView.start();
    }

    @ReactProp(name = "pause")
    public void pause(BDCloudVideoView bdCloudVideoView,@Nullable int i) {
        bdCloudVideoView.pause();
    }


    @ReactProp(name = "release")
    public void release(BDCloudVideoView bdCloudVideoView,@Nullable int i) {
        bdCloudVideoView.release();
    }


    /**
     * 将播放器指定到某个播放位置
     */
    @ReactProp(name = "seekTo")
    public void seekTo(BDCloudVideoView bdCloudVideoView,@Nullable int i) {
        bdCloudVideoView.seekTo(i);
    }
    /**
     * 重新设置render渲染目标，该方法能达到抹去之前视频最后一帧的效果<br>
     * 一般在stopPlayBack后，设置新播放源之前调用。
     */
    @ReactProp(name = "reSetRender")
    public void reSetRender(BDCloudVideoView bdCloudVideoView,@Nullable int i) {
        bdCloudVideoView.reSetRender();
    }

}