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

    public boolean create(SongChord chord) {
        SQLiteDatabase db = databaseTable.getWritableDatabase();

        ContentValues params = new ContentValues();
        params.put("position", chord.getPosition());
        params.put("tone", chord.getNote());
        params.put("mode", chord.getMode());
        params.put("song_id", chord.getSongId());

        try {
            db.insert("chords", null, params);
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
