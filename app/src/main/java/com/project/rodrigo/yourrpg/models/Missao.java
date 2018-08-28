package com.project.rodrigo.yourrpg.models;

import android.provider.BaseColumns;

public class Missao implements BaseColumns{

    private String COLUMN_NOME = "nomeMissao";
    private String COLUMN_PARENT = "parentMissao";
    /*
    Nome
    Descrição
    Parente
    Tipo
    Tipo Atualização
     */

    public String CREATE_TABLE_QUERY = "CREATE TABLE " + Missao.TABLE_NAME + " (" +
    _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
    COLUMN_NOME + " TEXT NOT NULL, " +
    COLUMN_CLASSE + " TEXT NOT NULL, " +
    COLUMN_IMAGEM_PERFIL + " BLOG NULL, " +
    COLUMN_NIVEL + " INT NOT NULL, " +
    COLUMN_EXPERIENCIA + " INT NOT NULL);";

    private Missao(){}
}
