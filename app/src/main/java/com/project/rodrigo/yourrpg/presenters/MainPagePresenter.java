package com.project.rodrigo.yourrpg.presenters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.project.rodrigo.yourrpg.R;
import com.project.rodrigo.yourrpg.activities.MainActivity;
import com.project.rodrigo.yourrpg.activities.TutorialActivity;
import com.project.rodrigo.yourrpg.helpers.MissoesListAdapter;
import com.project.rodrigo.yourrpg.helpers.SharedPreferencesHelper;
import com.project.rodrigo.yourrpg.models.Jogador;
import com.project.rodrigo.yourrpg.models.Missao;

import java.util.ArrayList;

public class MainPagePresenter {

    private Context context;
    private MainActivity activity;
    private Jogador jogadorPrefs;
    private Intent navigationIntent;
    private SharedPreferencesHelper sharedPreferences;

    public MainPagePresenter(Context context, MainActivity activity) {

        this.context = context;
        this.activity = activity;
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
    public void createNavigationDrawer(DrawerLayout drawer, Toolbar toolbar){
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                activity, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }
    public boolean navigationItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.nav_tutorial) {
            navigationIntent = new Intent(context, TutorialActivity.class);
            activity.startActivity(navigationIntent);
        }

        DrawerLayout drawer = activity.findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
