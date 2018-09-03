package com.project.rodrigo.yourrpg.presenters;

import android.content.Context;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.project.rodrigo.yourrpg.helpers.MissoesListAdapter;
import com.project.rodrigo.yourrpg.helpers.SharedPreferencesHelper;
import com.project.rodrigo.yourrpg.models.Jogador;
import com.project.rodrigo.yourrpg.models.Missao;

import java.util.ArrayList;

public class MainPagePresenter {

    private Context context;
    private Jogador jogadorPrefs;
    private SharedPreferencesHelper sharedPreferences;

    public MainPagePresenter(Context context) {
        this.context = context;
    }

    public void createToolbarUser(TextView tvNome, TextView tvClasse, TextView tvNivel, TextView tvStatusXp, ImageView ivImagem, ProgressBar pbLevel){
        jogadorPrefs = new SharedPreferencesHelper(context).getUserPrefs();
        tvNome.setText(jogadorPrefs.getNome());
        tvClasse.setText(jogadorPrefs.getClasse());
        tvNivel.setText(String.format("%d", jogadorPrefs.getNivel()));
        ivImagem.setImageBitmap(SharedPreferencesHelper.StringToBitMap(jogadorPrefs.getImagemDoJogador()));

        pbLevel.setMax(jogadorPrefs.getProximoNivelXp());
        pbLevel.setProgress(jogadorPrefs.getExperiencia());

        tvStatusXp.setText(jogadorPrefs.getExperiencia() + " / " + jogadorPrefs.getProximoNivelXp());
    }
    public void createListaMissoes(ListView listaMissoes){
        Missao.insertDados(context);
        ArrayList<MissoesListAdapter.MissoesListHelper> arrayList = Missao.getDados(context);
        MissoesListAdapter missoesListAdapter = new MissoesListAdapter(context, arrayList);

        listaMissoes.setAdapter(missoesListAdapter);
    }


}
