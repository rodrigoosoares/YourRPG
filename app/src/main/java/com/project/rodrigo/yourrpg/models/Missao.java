package com.project.rodrigo.yourrpg.models;

import android.provider.BaseColumns;

public class Missao implements BaseColumns{

    private String COLUMN_NOME = "nomeMissao";
    private String COLUMN_DESC = "descricao";
    private String COLUMN_STATUS = "status";
    private String COLUMN_RANK = "rank";
    /*
    Nome
    Descrição
    status
    Rank
    */

    public String CREATE_TABLE_QUERY = "CREATE TABLE " + Missao.TABLE_NAME + " (" +
    _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
    COLUMN_NOME + " TEXT NOT NULL, " +
    COLUMN_DESC + " TEXT NOT NULL, " +
    COLUMN_STATUS + " BLOG NULL, " +
    COLUMN_RANK + " INT NOT NULL, " + ");";

    private Missao(){}
}
