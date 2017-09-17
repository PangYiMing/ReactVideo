package videoplayer;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;

import com.reactvideo.R;


/**
 * Created by Administrator on 2017/9/11.
 */

public class TestActivity extends Activity {
    BDVideoView bdVideoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_test);
        bdVideoView=(BDVideoView)findViewById(R.id.bd);
        bdVideoView.initUI();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        bdVideoView.pause();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        bdVideoView.destroy();
    }
}
