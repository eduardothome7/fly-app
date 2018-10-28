package com.example.estudiosis_nb.flyiv.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseTable extends SQLiteOpenHelper {
    private static String DB_NAME = "fly3.bd";

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

    private static String CREATE_CHORDS = "CREATE TABLE chords" +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "position INTEGER," +
            "tone INTEGER," +
            "note INTEGER," +
            "song_id INTEGER" +
            ")";

    public DatabaseTable(Context context){
        super(context, DB_NAME, null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_SONG);
        sqLiteDatabase.execSQL(CREATE_RECORDS);
        sqLiteDatabase.execSQL(CREATE_CHORDS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE songs");
        db.execSQL("DROP TABLE records");
        db.execSQL("DROP TABLE chords");
        db.execSQL(CREATE_SONG);
        db.execSQL(CREATE_RECORDS);
        db.execSQL(CREATE_CHORDS);
    }
}