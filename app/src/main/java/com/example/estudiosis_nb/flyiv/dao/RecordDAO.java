package com.example.estudiosis_nb.flyiv.dao;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import com.example.estudiosis_nb.flyiv.bd.DatabaseTable;
import com.example.estudiosis_nb.flyiv.model.Record;
import com.example.estudiosis_nb.flyiv.model.Song;
import com.example.estudiosis_nb.flyiv.popup.AudioRecorderDialog;

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
                new String[]{"id", "name","path","api_path", "song_id", "duration"},
                null,null,null,null,"id desc");

        List<Record> listRecords = new ArrayList<>();

        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String path = cursor.getString(cursor.getColumnIndex("path"));
            String api_path = cursor.getString(cursor.getColumnIndex("api_path"));
            int songId = cursor.getInt(cursor.getColumnIndex("song_id"));
            int duration = cursor.getInt(cursor.getColumnIndex("duration"));

            Record record = new Record(name, duration, path, api_path, songId);
            listRecords.add(record);
        }

        return listRecords;
    }

    public boolean create(Record record) {
        SQLiteDatabase db = databaseTable.getWritableDatabase();

        ContentValues params = new ContentValues();
        params.put("name", record.getName());
        params.put("path", record.getPath());
        params.put("api_path", record.getApiPath());
        params.put("song_id", record.getSongId());
        params.put("duration", record.getDuration());

        try {
            db.insert("records", null, params);
            db.close();
            return true;
        } catch(SQLiteAbortException error) {
            db.close();
            return false;
        }
    }

    public Record get(int id) {
        return null;
    }

    public void destroy(int id) {

    }
}
