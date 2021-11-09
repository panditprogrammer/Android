package com.panditprogrammer.pplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    // initialize the music
    MediaPlayer music_player;
    AudioManager audioManager;
    // play the sound
    public void play(View view){
        music_player.start();
    }
    //pause the sound
    public void pause(View view){
        music_player.pause();
    }
    // stop the music
    public void stop(View view){
        music_player.stop();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get the music file
        music_player = MediaPlayer.create(this,R.raw.music);
        // initilize the audioManager
        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        // get the volue of music
        int max_volume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int current_volume  = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        // create seekbar
        SeekBar seek_volume = findViewById(R.id.seek_volume);
        seek_volume.setMax(max_volume);
        seek_volume.setProgress(current_volume);

//        on seekbar change for volume control
        seek_volume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        
        SeekBar progress_audio = findViewById(R.id.audio_time);
        progress_audio.setMax(music_player.getDuration());

//        this is for audio play duration
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                progress_audio.setProgress(music_player.getCurrentPosition());
            }
        },0,1000);

//        on seek bar change for audio duration
        progress_audio.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                music_player.seekTo(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}