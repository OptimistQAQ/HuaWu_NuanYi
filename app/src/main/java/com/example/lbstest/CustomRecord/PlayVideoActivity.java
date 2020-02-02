package com.example.lbstest.CustomRecord;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.lbstest.CustomRecord.util.mMediaController;
import com.example.lbstest.CustomRecord.view.MyVideoView;
import com.example.lbstest.R;

import java.io.File;

public class PlayVideoActivity extends Activity implements MediaPlayer.OnPreparedListener, mMediaController.MediaPlayerControl, MediaPlayer.OnCompletionListener {


    public static final String TAG = "PlayVideo";
    private MyVideoView videoView;
    private mMediaController controller;
    private String mVideoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[] {Manifest.permission.CAMERA}, 1);
            }
        }
        //无title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
                WindowManager.LayoutParams. FLAG_FULLSCREEN);

        setContentView(R.layout.activity_play_video);

        mVideoPath = getIntent().getExtras().getString("videoPath");

        File sourceVideoFile = new File(mVideoPath);
        videoView = (MyVideoView) findViewById(R.id.videoView);
        int screenW = getWindowManager().getDefaultDisplay().getWidth();
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) videoView.getLayoutParams();
        params.width = screenW;
        params.height = screenW * 4 / 3;
        params.gravity = Gravity.TOP;
        videoView.setLayoutParams(params);

        videoView.setOnPreparedListener(this);
        videoView.setOnCompletionListener(this);
        controller = new mMediaController(this);

        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            videoView.setVideoURI(Uri.fromFile(sourceVideoFile));
        }
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        controller.setMediaPlayer(this);
        controller.setAnchorView((ViewGroup) findViewById(R.id.fl_videoView_parent));
        controller.show();

        videoView.start();
    }

    @Override
    public void start() {
        videoView.start();
    }

    @Override
    public void pause() {
        if (videoView.isPlaying()) {
            videoView.pause();
        }
    }

    @Override
    public int getDuration() {
        return videoView.getDuration();
    }

    @Override
    public int getCurrentPosition() {
        return videoView.getCurrentPosition();
    }

    @Override
    public void seekTo(int pos) {
        videoView.seekTo(pos);
    }

    @Override
    public boolean isPlaying() {
        return videoView.isPlaying();
    }

    @Override
    public int getBufferPercentage() {
        return 0;
    }

    @Override
    public boolean canPause() {
        return videoView.canPause();
    }

    @Override
    public boolean canSeekBackward() {
        return videoView.canSeekBackward();
    }

    @Override
    public boolean canSeekForward() {
        return videoView.canSeekForward();
    }

    @Override
    public boolean isFullScreen() {
        return false;
    }

    @Override
    public void toggleFullScreen() {

    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        Toast.makeText(this, "播放完成了", Toast.LENGTH_SHORT).show();
        finish();
    }
}
