package com.project.rodrigo.yourrpg.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.project.rodrigo.yourrpg.R;
import com.project.rodrigo.yourrpg.helpers.SharedPreferencesHelper;
import com.project.rodrigo.yourrpg.presenters.SplashScreenPresenter;

public class SplashScreenActivity extends AppCompatActivity {

    private SplashScreenPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_view);
        //new SharedPreferencesHelper(this).clearUserPrefs();
        //Descomentar o código acima para resetar as SharedPrefs do jogador
        mPresenter = new SplashScreenPresenter(this,this);
        mPresenter.createSplashScreen();
    }
}
