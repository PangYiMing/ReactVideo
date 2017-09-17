package videoplayer;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.baidu.cloud.media.player.IMediaPlayer;
import com.facebook.common.activitylistener.ActivityListener;

import java.util.Timer;
import java.util.TimerTask;

import videoplayer.bar.SimpleMediaController;
import videoplayer.info.SharedPrefsStore;
import videoplayer.widget.BDCloudVideoView;

/**
 * Created by Administrator on 2017/9/11.
 */

public class BDVideoView extends RelativeLayout implements IMediaPlayer.OnPreparedListener,
        IMediaPlayer.OnCompletionListener, IMediaPlayer.OnErrorListener,
        IMediaPlayer.OnInfoListener, IMediaPlayer.OnBufferingUpdateListener,
        BDCloudVideoView.OnPlayerStateListener,ActivityListener {
    private static final String TAG = "SimplePlayActivity";

    /**
     * 您的AK 请到http://console.bce.baidu.com/iam/#/iam/accesslist获取
     */
    private String ak = ""; // 请录入您的AK !!!

    private BDCloudVideoView mVV = null;
    private SimpleMediaController mediaController = null;
    private RelativeLayout mViewHolder = null;

    private Timer barTimer;
    Context context;

    public BDVideoView(Context context) {
        super(context);
        this.context = context;
    }

    public BDVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public BDVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }


    /**
     * 初始化界面
     */
    public void initUI() {
        mediaController = new SimpleMediaController(context);
        LayoutParams rlCn = new LayoutParams(-2, -2);
        rlCn.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        /**
         * 设置ak
         */
        BDCloudVideoView.setAK(ak);

        mVV = new BDCloudVideoView(context);
        mVV.setVideoPath("http://101.201.68.107/热血沸腾!_国外跑酷玩家超能集锦!_标清.mp4");
        Log.i(TAG," new BDCloudVideoView");
        mVV.setVideoScalingMode(BDCloudVideoView.VIDEO_SCALING_MODE_SCALE_TO_FIT);

//        if (SharedPrefsStore.isPlayerFitModeCrapping(context)) {
//            mVV.setVideoScalingMode(BDCloudVideoView.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING);
//            Log.i(TAG," new BDCloudVideoView");
//        } else {
//            mVV.setVideoScalingMode(BDCloudVideoView.VIDEO_SCALING_MODE_SCALE_TO_FIT);
//            Log.i(TAG," new BDCloudVideoView");
//        }

        LayoutParams rllp = new LayoutParams(-2, -2);
        rllp.addRule(RelativeLayout.CENTER_IN_PARENT);
        mVV.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (barTimer != null) {
                    barTimer.cancel();
                    barTimer = null;
                }
                if (mediaController != null) {
                    if (mediaController.getVisibility() == View.VISIBLE) {
                        mediaController.hide();
                    } else {
                        mediaController.show();
                        hideOuterAfterFiveSeconds();
                    }
                }
            }
        });
        addView(mVV,rllp);
        /**
         * 注册listener
         */
        mVV.setOnPreparedListener(this);
        mVV.setOnCompletionListener(this);
        mVV.setOnErrorListener(this);
        mVV.setOnInfoListener(this);
        mVV.setOnBufferingUpdateListener(this);
        mVV.setOnPlayerStateListener(this);

        mediaController.setMediaPlayerControl(mVV);
        addView(mediaController,rlCn);

        mVV.start();
        Log.i(TAG," mVV.start");

    }

    public  void destroy(){
        mVV.release();
    }

    public  void pause(){
        mVV.pause();
    }



    /**
     * 检测'点击'空白区的事件，若播放控制控件未显示，设置为显示，否则隐藏。
     *
     */
//    public void onClickEmptyArea(View v) {
//        if (barTimer != null) {
//            barTimer.cancel();
//            barTimer = null;
//        }
//        if (this.mediaController != null) {
//            if (mediaController.getVisibility() == View.VISIBLE) {
//                mediaController.hide();
//            } else {
//                mediaController.show();
//                hideOuterAfterFiveSeconds();
//            }
//        }
//    }

    private void hideOuterAfterFiveSeconds() {
        if (barTimer != null) {
            barTimer.cancel();
            barTimer = null;
        }
        barTimer = new Timer();
        barTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                if (mediaController != null) {
                    mediaController.getMainThreadHandler().post(new Runnable() {

                        @Override
                        public void run() {
                            mediaController.hide();
                        }

                    });
                }
            }

        }, 5 * 1000);

    }

    @Override
    public boolean onInfo(IMediaPlayer mp, int what, int extra) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean onError(IMediaPlayer mp, int what, int extra) {
        // restart player?

        return false;
    }

    @Override
    public void onCompletion(IMediaPlayer mp) {
    }

    @Override
    public void onPrepared(IMediaPlayer mp) {
    }

    @Override
    public void onBufferingUpdate(IMediaPlayer mp, int percent) {
        if (mediaController != null && mVV != null) {
            mediaController.onTotalCacheUpdate(percent * mVV.getDuration() / 100);
        }
    }

    @Override
    public void onPlayerStateChanged(BDCloudVideoView.PlayerState nowState) {
        if (mediaController != null) {
            mediaController.changeState();
        }
    }

    @Override
    public void onActivityCreate(Activity activity) {

    }

    @Override
    public void onStart(Activity activity) {

    }

    @Override
    public void onResume(Activity activity) {
        Log.v(TAG, "onRestart");
        if (mVV != null&&mVV.isFocused()) {
            mVV.enterForeground();
        }
    }

    @Override
    public void onPause(Activity activity) {
        Log.v(TAG, "onStop");
        if (mVV != null) {
            mVV.enterBackground();
        }
    }

    @Override
    public void onStop(Activity activity) {

    }


    @Override
    public void onDestroy(Activity activity) {
        if (mVV != null) {
            mVV.stopPlayback();
        }
        Log.v(TAG, "onDestroy");
    }



}
