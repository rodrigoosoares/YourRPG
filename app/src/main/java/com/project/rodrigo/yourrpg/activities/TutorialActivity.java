package com.project.rodrigo.yourrpg.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.project.rodrigo.yourrpg.R;
import com.project.rodrigo.yourrpg.presenters.TutorialPresenter;

public class TutorialActivity extends AppCompatActivity implements View.OnClickListener{

    private TutorialPresenter mPresenter;
    private ViewPager vpTutorialPager;

    private Button btnTutorialSkip;
    private Button btnTutorialFinish;
    private LinearLayout llTutorialDots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        vpTutorialPager = findViewById(R.id.vpTutorialPager);
        btnTutorialSkip = findViewById(R.id.btnTutorialSkip);
        btnTutorialFinish = findViewById(R.id.btnTutorialFinish);
        llTutorialDots = findViewById(R.id.llTutorialDots);
        mPresenter = new TutorialPresenter(this,this);

        btnTutorialSkip.setOnClickListener(this);
        btnTutorialFinish.setOnClickListener(this);

        vpTutorialPager.setAdapter(mPresenter.getSliderTutorialAdapter());
        vpTutorialPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                mPresenter.addDots(position, llTutorialDots);
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });
        mPresenter.addDots(0, llTutorialDots);
    }

    @Override
    public void onClick(View v) {
        mPresenter.click(v);
    }
}
