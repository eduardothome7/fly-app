package com.example.estudiosis_nb.flyiv.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteDatabase;

import com.example.estudiosis_nb.flyiv.bd.DatabaseTable;
import com.example.estudiosis_nb.flyiv.model.Chord;
import com.example.estudiosis_nb.flyiv.model.Record;
import com.example.estudiosis_nb.flyiv.model.SongChord;

import java.util.ArrayList;
import java.util.List;

public class ChordDAO {
    private DatabaseTable databaseTable;

    public ChordDAO(Context context) {
        databaseTable = new DatabaseTable(context);
    }

    public List<SongChord> fetchAll(int song_id) {
        SQLiteDatabase db = databaseTable.getReadableDatabase();
        Cursor cursor = db.query("chords",
                new String[]{"id", "position","tone","note", "song_id"},
                "song_id="+song_id,null,null,null,"id");

        List<SongChord> listSongChords = new ArrayList<>();

        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            int position = cursor.getInt(cursor.getColumnIndex("position"));
            int tone = cursor.getInt(cursor.getColumnIndex("tone"));
            String mode = cursor.getString(cursor.getColumnIndex("mode"));
            int songId = cursor.getInt(cursor.getColumnIndex("song_id"));

            SongChord songChord = new SongChord(position, tone, songId, mode);
            listSongChords.add(songChord);
        }
        return listSongChords;
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
