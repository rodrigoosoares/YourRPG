package com.project.rodrigo.yourrpg.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.rodrigo.yourrpg.helpers.SliderTutorialAdapter;
import com.project.rodrigo.yourrpg.R;

public class TutorialActivity extends AppCompatActivity {

    private ViewPager vpTutorialPager;
    private SliderTutorialAdapter sliderTutorialAdapter;

    private TextView[] tvDots;
    private LinearLayout llTutorialDots;
    private Button btnTutorialSkip;
    private Button btnTutorialFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_view);

        vpTutorialPager = findViewById(R.id.vpTutorialPager);
        btnTutorialSkip = findViewById(R.id.btnTutorialSkip);
        btnTutorialFinish = findViewById(R.id.btnTutorialFinish);
        llTutorialDots = findViewById(R.id.llTutorialDots);

        sliderTutorialAdapter = new SliderTutorialAdapter(this);

        vpTutorialPager.setAdapter(sliderTutorialAdapter);
        vpTutorialPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                addDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });
        addDots(0);
    }
    private void addDots(int position){
        tvDots = new TextView[sliderTutorialAdapter.getCount()];
        llTutorialDots.removeAllViews();
        for (int i=0; i<tvDots.length; i++){
            tvDots[i] = new TextView(this);
            tvDots[i].setText(Html.fromHtml("&#8226"));
            tvDots[i].setTextSize(35);
            tvDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            llTutorialDots.addView(tvDots[i]);
        }
        if(tvDots.length > 0)
            tvDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        if ((position+1) == sliderTutorialAdapter.getCount()) {
            btnTutorialFinish.setEnabled(true);
            btnTutorialFinish.setVisibility(View.VISIBLE);
        }
    }

    protected void click(View v) {
        switch (v.getId()){
            case R.id.btnTutorialSkip:
                finish();
                break;
            case R.id.btnTutorialFinish:
                finish();
        }
    }
}
