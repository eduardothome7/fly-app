package com.example.estudiosis_nb.flyiv.dao;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import com.example.estudiosis_nb.flyiv.bd.DatabaseTable;
import com.example.estudiosis_nb.flyiv.model.Record;
import com.example.estudiosis_nb.flyiv.model.Session;
import com.example.estudiosis_nb.flyiv.model.Song;
import com.example.estudiosis_nb.flyiv.model.User;
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

    public boolean create(Session session){
        SQLiteDatabase db = databaseTable.getWritableDatabase();

        ContentValues params = new ContentValues();
        params.put("user_id", session.getUser().getId());
        params.put("name", session.getUser().getName());
        params.put("email", session.getUser().getEmail());
        params.put("picture", session.getUser().getPicture());
        params.put("auth_token", session.getUser().getToken());

        try {
            db.insert("sessions", null, params);
            db.close();
            return true;
        } catch(SQLiteAbortException error) {
            db.close();
            return false;
        }
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

    public User currentUser() {
        User currentUser = new User();

        SQLiteDatabase db = databaseTable.getReadableDatabase();
        Cursor cursor = db.query("sessions",
                new String[]{"id", "auth_token", "email", "name", "picture", "user_id"},
                ""
                ,null,null,null,"id DESC");

        while(cursor.moveToNext()){
            currentUser.setId(cursor.getInt(cursor.getColumnIndex("id")));
            currentUser.setName(cursor.getString(cursor.getColumnIndex("name")));
            currentUser.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            currentUser.setPicture(cursor.getString(cursor.getColumnIndex("picture")));
            currentUser.setToken(cursor.getString(cursor.getColumnIndex("auth_token")));
            break;
        }

        return currentUser;
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
