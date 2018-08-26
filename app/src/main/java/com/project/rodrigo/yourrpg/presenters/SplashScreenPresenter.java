package com.project.rodrigo.yourrpg.presenters;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;

import com.project.rodrigo.yourrpg.activities.*;
import com.project.rodrigo.yourrpg.helpers.SharedPreferencesHelper;

public class SplashScreenPresenter {

    private SplashScreenActivity activity;
    private SharedPreferencesHelper mSharedPreferences;
    private Context context;

    public SplashScreenPresenter(Context context, SplashScreenActivity activity) {
        this.activity = activity;
        this.context = context;
    }

    public void createSplashScreen(){
        if(activity.getSupportActionBar() != null)
            activity.getSupportActionBar().hide();
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        View decorView = activity.getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        if(new SharedPreferencesHelper(context).getUserPreferencesStatus())
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    activity.startActivity(new Intent(context, CriarPersonagemActivity.class));
                    activity.finish();
                }
            },2000);
        else
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    activity.startActivity(new Intent(context, MainActivity.class));
                    activity.finish();
                }
            },2000);

    }
}
