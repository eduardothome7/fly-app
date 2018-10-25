package com.example.estudiosis_nb.flyiv.dao;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import com.example.estudiosis_nb.flyiv.bd.DatabaseTable;
import com.example.estudiosis_nb.flyiv.model.Song;

import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteDatabase;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class SongDAO {
    private DatabaseTable databaseTable;

    public SongDAO(Context context) {
        databaseTable = new DatabaseTable(context);
    }

    public List<Song> fetchAll() {
        SQLiteDatabase db = databaseTable.getReadableDatabase();
        Cursor cursor = db.query("songs",
                new String[]{"id","title","description"},
                null,null,null,null,"title");

        List<Song> listSongs= new ArrayList<>();

        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String description = cursor.getString(cursor.getColumnIndex("description"));
            Song song = new Song(id, title,description, 0);
            listSongs.add(song);
        }

        return listSongs;
    }

    public boolean create(Song song) {
        SQLiteDatabase db = databaseTable.getWritableDatabase();

        ContentValues params = new ContentValues();
        params.put("title", song.getTitle());
        params.put("description", song.getDescription());

        try {
            db.insert("songs", null, params);
            db.close();
            return true;
        } catch(SQLiteAbortException error) {
            db.close();
            return false;
        }
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
