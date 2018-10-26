package com.example.estudiosis_nb.flyiv.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseTable extends SQLiteOpenHelper {
    private static String DB_NAME = "fly2.bd";

    private static String CREATE_SONG = "CREATE TABLE songs" +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "title VARCHAR(30)," +
            "description VARCHAR(600)" +
            ")";

    private static String CREATE_RECORDS = "CREATE TABLE records" +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name VARCHAR(30)," +
            "path VARCHAR(600)," +
            "api_path VARCHAR(600)," +
            "song_id INTEGER," +
            "duration INTEGER" +
            ")";

    public DatabaseTable(Context context){
        super(context, DB_NAME, null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_SONG);
        sqLiteDatabase.execSQL(CREATE_RECORDS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE songs");
        db.execSQL("DROP TABLE records");
        db.execSQL(CREATE_SONG);
        db.execSQL(CREATE_RECORDS);
    }

}