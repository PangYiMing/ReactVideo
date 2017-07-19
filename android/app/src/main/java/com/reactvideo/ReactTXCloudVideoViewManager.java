package com.reactvideo;


import android.support.annotation.Nullable;
import android.util.Log;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;

/**
 * Created by YiBing on 2017/4/28.
 */
public class ReactTXCloudVideoViewManager extends ViewGroupManager<TXCloudVideoView> {
    ThemedReactContext context;
    String TAG = ReactTXCloudVideoViewManager.class.getSimpleName();
    public static final String REACT_CLASS = "RCTTXCloudVideoView";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected TXCloudVideoView createViewInstance(ThemedReactContext reactContext) {
        this.context = reactContext;
        TXCloudVideoView txCloudVideoView = new TXCloudVideoView(reactContext);
        return txCloudVideoView;
    }

    @ReactProp(name = "url")
    public void setUrl(TXCloudVideoView TXCloudVideoView, @Nullable String url) {
        Log.i(TAG, "setUrl;".concat(url));

        TXLivePlayer txLivePlayer = new TXLivePlayer(context);
        txLivePlayer.setPlayerView(TXCloudVideoView);
        txLivePlayer.startPlay(url, TXLivePlayer.PLAY_TYPE_VOD_MP4);
    }
}