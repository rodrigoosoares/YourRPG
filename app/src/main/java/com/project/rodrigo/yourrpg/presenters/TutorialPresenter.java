package com.project.rodrigo.yourrpg.presenters;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.rodrigo.yourrpg.R;
import com.project.rodrigo.yourrpg.activities.TutorialActivity;
import com.project.rodrigo.yourrpg.helpers.SliderTutorialAdapter;

public class TutorialPresenter {
    private Context context;
    private TutorialActivity activity;
    private SliderTutorialAdapter sliderTutorialAdapter;


    public TutorialPresenter(Context context, TutorialActivity activity) {
        this.context = context;
        this.activity = activity;
        sliderTutorialAdapter = new SliderTutorialAdapter(context);
    }

    public SliderTutorialAdapter getSliderTutorialAdapter() {
        return sliderTutorialAdapter;
    }

    /**
     * Método que adiciona os Dots dos slides e altera a visiviliade do botão Finish para visível
     * @param position Int - Posição no array dos Dots respectivo ao slide atual
     * @param llTutorialDots LinearLayout - Layout onde os Dots serão adicionados
     * @author Rodrigo de Oliveira Soares
     */
    public void addDots(int position, LinearLayout llTutorialDots){
        TextView[] tvDots = new TextView[sliderTutorialAdapter.getCount()];

        llTutorialDots.removeAllViews();
        for (int i=0; i<tvDots.length; i++){
            tvDots[i] = new TextView(context);
            tvDots[i].setText(Html.fromHtml("&#8226"));
            tvDots[i].setTextSize(35);
            tvDots[i].setTextColor(activity.getResources().getColor(R.color.colorTransparentWhite));
            llTutorialDots.addView(tvDots[i]);
        }
        if(tvDots.length > 0)
            tvDots[position].setTextColor(activity.getResources().getColor(R.color.colorWhite));

        if ((position+1) == sliderTutorialAdapter.getCount()) {
            activity.findViewById(R.id.btnTutorialFinish).setEnabled(true);
            activity.findViewById(R.id.btnTutorialFinish).setVisibility(View.VISIBLE);
        }
    }

    /**
     *  Metodo responsável pela ação após clicar nos botões dos slides
     * @param v View - View passada pelo método OnClick
     * @author Rodrigo de Oliveira Soares
     */
    public void click(View v) {
        switch (v.getId()) {
            case R.id.btnTutorialSkip:
                activity.finish();
                break;
            case R.id.btnTutorialFinish:
                activity.finish();
                break;
        }
    }
}
