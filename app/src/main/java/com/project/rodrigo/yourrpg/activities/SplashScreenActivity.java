package com.project.rodrigo.yourrpg.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.project.rodrigo.yourrpg.R;
import com.project.rodrigo.yourrpg.presenters.SplashScreenPresenter;

public class SplashScreenActivity extends AppCompatActivity {

    private SplashScreenPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_view);
        mPresenter = new SplashScreenPresenter(this,this);
        mPresenter.createSplashScreen();
    }
}
