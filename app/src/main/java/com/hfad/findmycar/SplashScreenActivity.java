package com.hfad.findmycar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen config = new EasySplashScreen(SplashScreenActivity.this)
                .withFullScreen()
                .withTargetActivity(MapsActivity.class)
                .withSplashTimeOut(6000)
                .withLogo(R.mipmap.appfront);

        View easySplashScreen = config.create();
        setContentView(easySplashScreen);
    }
}
