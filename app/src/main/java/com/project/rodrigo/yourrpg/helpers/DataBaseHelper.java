package com.project.rodrigo.yourrpg.helpers;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.project.rodrigo.yourrpg.models.Missao;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "YourRPG.db";
    private static final int DB_VERSION = 1;

    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Missao.CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Missao.DROP_TABLE_QUERY);
        onCreate(db);
    }

}
