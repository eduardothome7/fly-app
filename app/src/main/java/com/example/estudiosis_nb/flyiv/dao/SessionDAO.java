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

public class SessionDAO {
    private DatabaseTable databaseTable;

    public SessionDAO(Context context) {
        databaseTable = new DatabaseTable(context);
    }

    public boolean isLogged() {
        SQLiteDatabase db = databaseTable.getReadableDatabase();
        Cursor cursor = db.query("sessions",
                new String[]{"id", "token_auth",},
                "",null,null,null,"");

        boolean logged = false;
        while(cursor.moveToNext()){
            logged = true;
            break;
        }

        return logged;
    }

    public boolean deleteUserSession() {
        SQLiteDatabase db = databaseTable.getWritableDatabase();

        try {
            db.delete("sessions", null, null);
            db.close();
            return true;
        } catch(SQLiteAbortException error) {
            db.close();
            return false;
        }
    }
}
