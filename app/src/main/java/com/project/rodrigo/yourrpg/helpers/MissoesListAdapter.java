package com.project.rodrigo.yourrpg.helpers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.project.rodrigo.yourrpg.R;
import com.project.rodrigo.yourrpg.models.Missao;

import java.util.ArrayList;

public class MissoesListAdapter extends ArrayAdapter<MissoesListHelper> {

    private Context context;
    private ArrayList<MissoesListHelper> dataSet;
    public MissoesListAdapter(ArrayList<MissoesListHelper> data, Context context) {
        super(context, R.layout.list_view_missoes_layout, data);
        this.dataSet = data;
        this.context=context;

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public MissoesListHelper getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        //Missao.getDados(context);

        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.list_view_missoes_layout, null);

        TextView tvNome = view.findViewById(R.id.lv_tvNomeMissao);
        TextView tvDesc = view.findViewById(R.id.lv_tvDescricaoMissao);
        TextView tvRank = view.findViewById(R.id.lv_tvRankMissao);

        tvNome.setText("Missao "+ position);
        tvDesc.setText("Descricao "+ position);
        tvRank.setText("Rank "+ position);
        /*listaMissoes = Missao.getDados(MainActivity.this);
        tvNome.setText(listaMissoes.get(position).toString());
        tvDesc.setText(Missao.MissoesListHelper.descricaoMissao);
        tvRank.setText(Missao.MissoesListHelper.rankMissao);*/

        return view;
    }
}
