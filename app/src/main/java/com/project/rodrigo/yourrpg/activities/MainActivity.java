package com.project.rodrigo.yourrpg.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.project.rodrigo.yourrpg.R;
import com.project.rodrigo.yourrpg.presenters.MainPagePresenter;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView tvNomeJogador;
    private TextView tvClasseJogador;
    private TextView tvStatusXp;
    private TextView tvNivelJogador;
    private ImageView ivImageJogador;
    private ProgressBar pbAtualJogadorXp;
    private ListView listaMissoes;
    private DrawerLayout drawer;
    private NavigationView navigationView;

    private MainPagePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mPresenter = new MainPagePresenter(this, this);

        tvNomeJogador = findViewById(R.id.tvNomeJogador);
        tvClasseJogador = findViewById(R.id.tvClasseJogador);
        tvNivelJogador = findViewById(R.id.tvNivelJogador);
        tvStatusXp = findViewById(R.id.tvStatusXp);
        ivImageJogador = findViewById(R.id.ivImageJogador);
        pbAtualJogadorXp = findViewById(R.id.pbAtualJogadorXp);
        listaMissoes = findViewById(R.id.lvMainMissoes);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        mPresenter.createToolbarUser(tvNomeJogador,tvClasseJogador,tvNivelJogador,tvStatusXp,ivImageJogador,pbAtualJogadorXp);
        mPresenter.createListaMissoes(listaMissoes);
        mPresenter.createNavigationDrawer(drawer, toolbar);

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return mPresenter.navigationItemSelected(item);
    }
}
