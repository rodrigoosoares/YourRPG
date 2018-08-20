package com.project.rodrigo.yourrpg.helpers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.project.rodrigo.yourrpg.R;

/**
 * Adapter contendo os slides do tutorial
 */
public class SliderTutorialAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    //Slides do tutorial
    private static final android.graphics.drawable.Drawable[] wallpaper = {

    };
    private static final int[] slide_header = {
            R.string.slide1_header,
            R.string.slide2_header,
            R.string.slide3_header
    };
    private static final int[] slide_content = {
            R.string.slide1_content,
            R.string.slide2_content,
            R.string.slide3_content
    };

    public SliderTutorialAdapter(Context context) { this.context = context;}

    @Override
    public int getCount() {
        return slide_header.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.tutorial_slides_layout,container,false);
        //Componentes do layout
        TextView tvTutorialHeader = view.findViewById(R.id.tvTutorialHeader);
        TextView tvTutorialContent = view.findViewById(R.id.tvTutorialContent);
        RelativeLayout rlLayoutTutorial = view.findViewById(R.id.rlTutorialLayout);
        //Set dos arrays
        //rlLayoutTutorial.setBackground(wallpaper[position]);
        tvTutorialHeader.setText(slide_header[position]);
        tvTutorialContent.setText(slide_content[position]);
        //Add a view ao container
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
