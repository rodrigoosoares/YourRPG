package com.project.rodrigo.yourrpg.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.project.rodrigo.yourrpg.helpers.DataBaseHelper;
import com.project.rodrigo.yourrpg.helpers.MissoesListHelper;

import java.util.ArrayList;
import java.util.List;

public class Missao implements BaseColumns{

    private static String TABLE_NAME = "tb_Missao";
    private static String COLUMN_NOME = "nomeMissao";
    private static String COLUMN_DESC = "descricao";
    private static String COLUMN_STATUS = "status";
    private static String COLUMN_RANK = "rank";
    /*
    Nome
    Descrição
    status
    Rank
    */

    public static String CREATE_TABLE_QUERY = "CREATE TABLE " + TABLE_NAME + " (" +
    _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
    COLUMN_NOME + " TEXT NOT NULL, " +
    COLUMN_DESC + " TEXT NOT NULL, " +
    COLUMN_STATUS + " BLOG NOT NULL, " +
    COLUMN_RANK + " TEXT NOT NULL " + ");";

    public static String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;

    private Missao(){}

    public static void insertDados(Context context){
        DataBaseHelper mDbHelper = new DataBaseHelper(context);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NOME, "Nome");
        values.put(COLUMN_DESC, "Descrição");
        values.put(COLUMN_STATUS, false);
        values.put(COLUMN_RANK, "S");

        long newRowId = db.insert(TABLE_NAME, null, values);
    }
    public static ArrayList<MissoesListHelper> getDados(Context context){
        DataBaseHelper mDbHelper = new DataBaseHelper(context);

        SQLiteDatabase writer = mDbHelper.getReadableDatabase();

        String[] projection = {
                BaseColumns._ID,
                COLUMN_NOME,
                COLUMN_DESC,
                COLUMN_STATUS,
                COLUMN_RANK
        };

        /*String selection = COLUMN_NOME + " = ?";
        String[] selectionArgs = { "" };*/

        String sortOrder =
                COLUMN_NOME + " DESC";

        Cursor cursor = writer.query(
                TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,            // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,          // don't group the rows
                null,           // don't filter by row groups
                sortOrder               // The sort order
        );
        ArrayList<MissoesListHelper> itemIds = new ArrayList<>();
        MissoesListHelper missoeshelper = new MissoesListHelper();
        while(cursor.moveToNext()) {
            //itemIds.add(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NOME)));
            missoeshelper.nomeMissao = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NOME));
            missoeshelper.descricaoMissao = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DESC));
            missoeshelper.rankMissao = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_RANK));
            itemIds.add(missoeshelper);
        }
        cursor.close();
        return itemIds;
    }
}
