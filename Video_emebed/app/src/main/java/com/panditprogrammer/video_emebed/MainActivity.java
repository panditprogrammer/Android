package com.panditprogrammer.video_emebed;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView my_video = findViewById(R.id.videoView);
        my_video.setVideoPath(String.format("android.resource://%s/%s", getPackageName(), R.raw.vclip));
        MediaController mediaController = new MediaController(this);
        my_video.setMediaController(mediaController);
        mediaController.setAnchorView(my_video);

    }
}