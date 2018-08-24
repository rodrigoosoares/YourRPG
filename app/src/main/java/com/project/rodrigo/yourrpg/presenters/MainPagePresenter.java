package com.project.rodrigo.yourrpg.presenters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.project.rodrigo.yourrpg.helpers.SharedPreferencesHelper;
import com.project.rodrigo.yourrpg.models.Jogador;

import org.w3c.dom.Text;

public class MainPagePresenter {

    private Context context;
    private Jogador jogadorPrefs;
    private SharedPreferencesHelper sharedPreferences;

    public MainPagePresenter(Context context) {

    }

    public void createToolbarUser(TextView tvNome, TextView tvClasse, TextView tvStatusXp, ImageView ivImagem, ProgressBar pbLevel){

        jogadorPrefs = new SharedPreferencesHelper(context).getUserPrefs();
        tvNome.setText(jogadorPrefs.getNome());
        tvClasse.setText(jogadorPrefs.getClasse());

        ivImagem.setImageBitmap(SharedPreferencesHelper.StringToBitMap(jogadorPrefs.getImagemDoJogador()));

        pbLevel.setMax(jogadorPrefs.getProximoNivelXp());
        pbLevel.setProgress(jogadorPrefs.getExperiencia());

        tvStatusXp.setText(jogadorPrefs.getExperiencia() + " / " + jogadorPrefs.getProximoNivelXp());


    }

}
