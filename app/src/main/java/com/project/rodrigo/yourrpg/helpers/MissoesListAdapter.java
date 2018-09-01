package com.project.rodrigo.yourrpg.helpers;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.project.rodrigo.yourrpg.R;
import com.project.rodrigo.yourrpg.models.Missao;

import java.util.ArrayList;

public class MissoesListAdapter extends ArrayAdapter<MissoesListHelper> {

    private Context context;
    private ArrayList<MissoesListHelper> dataSet;

    public MissoesListAdapter(@NonNull Context context, ArrayList list) {
        super(context, R.layout.listview_missao_layout , list);
        this.context = context;
        dataSet = list;
    }

    @Override
    public View getView(int position, View view,@NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listItem = view;
        if(listItem == null)
            listItem = inflater.inflate(R.layout.listview_missao_layout,parent,false);

        MissoesListHelper currentMissao = dataSet.get(position);

        TextView tvNome = listItem.findViewById(R.id.lv_tvNomeMissao);
        TextView tvDesc = listItem.findViewById(R.id.lv_tvDescricaoMissao);
        TextView tvRank = listItem.findViewById(R.id.lv_tvRankMissao);

        tvNome.setText(currentMissao.nomeMissao);
        tvDesc.setText(currentMissao.descricaoMissao);
        tvRank.setText(currentMissao.rankMissao);

        return listItem;
    }
}
