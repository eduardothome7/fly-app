package com.example.estudiosis_nb.flyiv.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseTable extends SQLiteOpenHelper {
    private static String DB_NAME = "fly.bd";
    private static String createTable = "CREATE TABLE songs" +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "title VARCHAR(30)," +
            "description VARCHAR(600)" +
            ")";


    public DatabaseTable(Context context){
        super(context, DB_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE songs");
        db.execSQL(createTable);
    }

}