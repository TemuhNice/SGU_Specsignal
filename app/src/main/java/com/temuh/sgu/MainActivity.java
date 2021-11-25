package com.temuh.sgu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button horn1sh = findViewById(R.id.horn1s);
        final MediaPlayer mp1 = MediaPlayer.create(this, R.raw.horn1sss);
        final MediaPlayer siren1 = MediaPlayer.create(this, R.raw.siren1);
        final MediaPlayer siren2 = MediaPlayer.create(this, R.raw.siren2);
        siren1.setLooping(true);
        siren2.setLooping(true);
        mp1.setLooping(true);
        final Button sir1 = findViewById(R.id.siren1);
        final Button sir2 = findViewById(R.id.siren2);
        sir1.setOnClickListener(v -> {
            if(siren1.isPlaying()){
                siren1.pause();
                siren1.seekTo(0);
            }else if(siren2.isPlaying()){
                siren2.pause();
                siren2.seekTo(0);
                siren1.start();
            }
            else{
                siren1.start();
            }
        });
        sir2.setOnClickListener(v -> {
            if(siren2.isPlaying()){
                siren2.pause();
                siren2.seekTo(0);
            }else if(siren1.isPlaying()){
                siren1.pause();
                siren1.seekTo(0);
                siren2.start();
            }
            else{
                siren2.start();
            }
        });
        horn1sh.setOnTouchListener((v, event) -> {
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                mp1.start();
            }
            if(event.getAction() == MotionEvent.ACTION_UP){
                mp1.pause();
                mp1.seekTo(0);
            }
            return false;
        });
        final Button horn2sh = findViewById(R.id.horn2s2);
        final Button horn3sh = findViewById(R.id.horn3s);
        final MediaPlayer horn3s = MediaPlayer.create(this, R.raw.airhorn2s);
        final MediaPlayer horn2s = MediaPlayer.create(this, R.raw.wail1);
        horn2s.setLooping(true);
        horn3s.setLooping(true);
        horn3sh.setOnTouchListener((v, event) -> {
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                horn3s.start();
            }
            if(event.getAction() == MotionEvent.ACTION_UP){
                horn3s.pause();
                horn3s.seekTo(0);
            }
            return false;
        });
        horn2sh.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    horn2s.start();
                }if(event.getAction() == MotionEvent.ACTION_UP){
                    horn2s.pause();
                    horn3s.seekTo(0);
                }
                return false;
            }
        });

        final Button set1 = findViewById(R.id.sirenset1);
        final Button set2 = findViewById(R.id.sirenset2);
        final Button set3 = findViewById(R.id.sirenset3);
        final LinearLayout group1 = findViewById(R.id.sirenGroup1);
        set1.setOnClickListener(v -> {

        });
        set2.setOnClickListener(v -> {
            group1.setVisibility(View.GONE);
        });
    }
    public void horn1Long(View view) {
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.airhorn1l);
        mediaPlayer.start();
    }

    public void horn2Long(View view) {
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.airhorn3s);
        mp.start();
    }

    public void horn3Long(View view) {
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.airhorn2l);
        mp.start();
    }

    public void siren3(View view) {
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.siren3);
        mp.start();
    }
    public void siren4(View view) {
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.siren4);
        mp.start();
    }
}
