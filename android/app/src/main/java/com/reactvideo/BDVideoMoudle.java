package com.reactvideo;


import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * Created by Administrator on 2017/9/16.
 */

public class BDVideoMoudle extends ReactContextBaseJavaModule {

    public BDVideoMoudle(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return "BDVideoMoudle";
    }


    @ReactMethod
    public void start() {
        BDdVideoViewManager.getInstance().start();
    }

    @ReactMethod
    public void pause() {
        BDdVideoViewManager.getInstance().pause();
    }

    @ReactMethod
    public void release() {
        BDdVideoViewManager.getInstance().release();
    }

    /**
     * 重新设置render渲染目标，该方法能达到抹去之前视频最后一帧的效果<br>
     * 一般在stopPlayBack后，设置新播放源之前调用。
     */
    @ReactMethod
    public void reSetRender() {
        BDdVideoViewManager.getInstance().reSetRender();
    }

    /**
     * 获得视频时长，单位为毫秒！
     * @return
     */
    @ReactMethod
    public void getDuration() {
        BDdVideoViewManager.getInstance().getDuration();
    }

    /**
     * 获取当前播放进度，单位为毫秒！
     * @return
     */
    @ReactMethod
    public void getCurrentPosition() {
        BDdVideoViewManager.getInstance().getDuration();
    }

    /**
     * 将播放器指定到某个播放位置
     */
    @ReactMethod
    public void seekTo(int i) {
        BDdVideoViewManager.getInstance().seekTo(i);
    }

    /**
     * 获取视频宽度
     * @return
     */
    @ReactMethod
    public void getVideoHeight() {
        BDdVideoViewManager.getInstance().getVideoHeight();
    }

    /**
     * 获取视频宽度
     * @return
     */
    @ReactMethod
    public void getVideoWidth() {
        BDdVideoViewManager.getInstance().getVideoWidth();
    }

    /**
     * 获取视频宽度
     * @return
     */
    @ReactMethod
    public void getVariantInfo() {
        BDdVideoViewManager.getInstance().getVariantInfo();
    }


}
