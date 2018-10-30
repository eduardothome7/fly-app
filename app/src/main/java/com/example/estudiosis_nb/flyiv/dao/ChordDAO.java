package com.example.estudiosis_nb.flyiv.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteDatabase;

import com.example.estudiosis_nb.flyiv.bd.DatabaseTable;
import com.example.estudiosis_nb.flyiv.model.Chord;
import com.example.estudiosis_nb.flyiv.model.Record;
import com.example.estudiosis_nb.flyiv.model.Song;
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
            int note = cursor.getInt(cursor.getColumnIndex("note"));
            String tone = cursor.getString(cursor.getColumnIndex("tone"));
            int songId = cursor.getInt(cursor.getColumnIndex("song_id"));

            SongChord songChord = new SongChord(position, note, songId, tone);
            listSongChords.add(songChord);
        }
        return listSongChords;
    }

    public boolean create(SongChord chord) {
        SQLiteDatabase db = databaseTable.getWritableDatabase();

        ContentValues params = new ContentValues();
        params.put("position", chord.getPosition());
        params.put("tone", chord.getTone());
        params.put("note", chord.getNote());
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

    public boolean update(SongChord chord) {
        SQLiteDatabase db = databaseTable.getWritableDatabase();

        ContentValues params = new ContentValues();
        params.put("position", chord.getPosition());
        params.put("note", chord.getNote());
        params.put("tone", chord.getTone());
        params.put("song_id", chord.getSongId());

        try {
            db.update("chords", params, "id =?", new String[]{String.valueOf(chord.getId())});
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
