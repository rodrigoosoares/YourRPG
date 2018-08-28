package com.project.rodrigo.yourrpg.helpers;


import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import com.project.rodrigo.yourrpg.models.Missao;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "db_YourRPG";
    private static final int DB_VERSION = 1;

    private static String CREATE_TABLE_QUERY;
    private static String DROP_TABLE_QUERY;

    public DataBaseHelper(Context context, String tableName) {
        super(context, DB_NAME, null, DB_VERSION);
        if (tableName.equals(Missao.TABLE_NAME)) {
            CREATE_TABLE_QUERY = "CREATE TABLE " + Missao.TABLE_NAME + " (" +
                    Missao._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    Missao.COLUMN_NOME + " TEXT NOT NULL, " +
                    Missao.COLUMN_CLASSE + " TEXT NOT NULL, " +
                    Missao.COLUMN_IMAGEM_PERFIL + " BLOG NULL, " +
                    Missao.COLUMN_NIVEL + " INT NOT NULL, " +
                    Missao.COLUMN_EXPERIENCIA + " INT NOT NULL);";
            DROP_TABLE_QUERY = "DROP TABLE IF EXISTS " + Jogador.TABLE_NAME;
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_QUERY);
        onCreate(db);
    }
}
