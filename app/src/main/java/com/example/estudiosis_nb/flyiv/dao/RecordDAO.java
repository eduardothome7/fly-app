package com.example.estudiosis_nb.flyiv.dao;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import com.example.estudiosis_nb.flyiv.bd.DatabaseTable;
import com.example.estudiosis_nb.flyiv.model.Record;
import com.example.estudiosis_nb.flyiv.model.Song;

import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteDatabase;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class RecordDAO {
    private DatabaseTable databaseTable;

    public RecordDAO(Context context) {
        databaseTable = new DatabaseTable(context);
    }

    public List<Record> fetchAll(int song_id) {
        SQLiteDatabase db = databaseTable.getReadableDatabase();
        Cursor cursor = db.query("records",
                new String[]{"id","song_id", "name","path","api_path", "duration"},
                null,null,null,null,"id desc");

        List<Record> listRecords = new ArrayList<>();

        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String description = cursor.getString(cursor.getColumnIndex("description"));
            //Song record = new Record();
            //listRecords.add(record);
        }

        return listRecords;
    }

    public boolean create(Record record) {
        SQLiteDatabase db = databaseTable.getWritableDatabase();

        ContentValues params = new ContentValues();
       /* params.put("title", song.getTitle());
        params.put("description", song.getDescription());

        try {
            db.insert("songs", null, params);
            db.close();
            return true;
        } catch(SQLiteAbortException error) {
            db.close();
            return false;
        } */
       return true;
    }

    public Song get(int id) {
        return null;
    }

    public boolean update(Song song) {
        SQLiteDatabase db = databaseTable.getWritableDatabase();

        ContentValues params = new ContentValues();
        params.put("title", song.getTitle());
        params.put("description", song.getDescription());

        try {
            db.update("songs", params, "id =?", new String[]{String.valueOf(song.getId())});
            db.close();
            return true;
        } catch(SQLiteAbortException error) {
            db.close();
            return false;
        }
    }

    public void destroy(int id) {

    }
}
