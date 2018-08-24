package com.project.rodrigo.yourrpg.helpers;



/*public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "db_YourRPG";
    private static final int DB_VERSION = 1;

    private static String CREATE_TABLE_QUERY;
    private static String DROP_TABLE_QUERY;

    public DataBaseHelper(Context context, String tableName) {
        super(context, DB_NAME, null, DB_VERSION);
        if (tableName.equals(Jogador.TABLE_NAME)) {
            CREATE_TABLE_QUERY = "CREATE TABLE " + Jogador.TABLE_NAME + " (" +
                    Jogador._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    Jogador.COLUMN_NOME + " TEXT NOT NULL, " +
                    Jogador.COLUMN_CLASSE + " TEXT NOT NULL, " +
                    Jogador.COLUMN_IMAGEM_PERFIL + " BLOG NULL, " +
                    Jogador.COLUMN_NIVEL + " INT NOT NULL, " +
                    Jogador.COLUMN_EXPERIENCIA + " INT NOT NULL);";
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
}*/
