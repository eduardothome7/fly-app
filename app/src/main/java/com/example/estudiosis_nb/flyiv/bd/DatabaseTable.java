package com.example.estudiosis_nb.flyiv.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseTable extends SQLiteOpenHelper {
    private static String DB_NAME = "fly5.bd";

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
            "tone VARCHAR(10)," +
            "note INTEGER," +
            "song_id INTEGER" +
            ")";

    private static String CREATE_USERS = "CREATE TABLE users" +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name VARCHAR(100)," +
            "email VARCHAR(60)," +
            "password VARCHAR(20)," +
            "picture VARCHAR(20)," +
            "token VARCHAR(20)"+
            ")";

    private static String CREATE_SHARES = "CREATE TABLE shares" +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "song_id INTEGER," +
            "user_id INTEGER" +
            ")";

    private static String CREATE_SESSIONS = "CREATE TABLE sessions" +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "user_id INTEGER," +
            "auth_token INTEGER" +
            ")";

    public DatabaseTable(Context context){
        super(context, DB_NAME, null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_SONG);
        sqLiteDatabase.execSQL(CREATE_RECORDS);
        sqLiteDatabase.execSQL(CREATE_CHORDS);
        sqLiteDatabase.execSQL(CREATE_USERS);
        sqLiteDatabase.execSQL(CREATE_SHARES);
        sqLiteDatabase.execSQL(CREATE_SESSIONS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE songs");
        db.execSQL("DROP TABLE records");
        db.execSQL("DROP TABLE chords");
        db.execSQL("DROP TABLE users");
        db.execSQL("DROP TABLE shares");
        db.execSQL("DROP TABLE sessions");
        db.execSQL(CREATE_SONG);
        db.execSQL(CREATE_RECORDS);
        db.execSQL(CREATE_CHORDS);
        db.execSQL(CREATE_USERS);
        db.execSQL(CREATE_SHARES);
        db.execSQL(CREATE_SESSIONS);
    }
}