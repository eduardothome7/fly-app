package com.example.estudiosis_nb.flyiv.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteDatabase;
import com.example.estudiosis_nb.flyiv.bd.DatabaseTable;
import com.example.estudiosis_nb.flyiv.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
     private DatabaseTable databaseTable;

     public UserDAO(Context context) {
            databaseTable = new DatabaseTable(context);
        }

     public List<User> find(String[] terms) {
         SQLiteDatabase db = databaseTable.getReadableDatabase();
         Cursor cursor = db.query("users",
                    new String[]{"id","name", "email", "picture"},
                    "where email LIKE '%"+terms[0]+"'",null,null,null,"name");

         List<User> listUsers = new ArrayList<>();

         while(cursor.moveToNext()){
             int id = cursor.getInt(cursor.getColumnIndex("id"));
             String name = cursor.getString(cursor.getColumnIndex("name"));
             String email = cursor.getString(cursor.getColumnIndex("email"));
             String picture = cursor.getString(cursor.getColumnIndex("picture"));
             User user = new User(id, name, email, picture);
             listUsers.add(user);
         }

         return listUsers;
     }

     public boolean create(User user) {
        SQLiteDatabase db = databaseTable.getWritableDatabase();

        ContentValues params = new ContentValues();
        params.put("name", user.getName());
        params.put("email", user.getEmail());
        params.put("picture", user.getPicture());
        params.put("password", user.getPassword());

        try {
            db.insert("users", null, params);
            db.close();
            return true;
        } catch(SQLiteAbortException error) {
            db.close();
            return false;
        }
     }

      public User get(int id) {
            return null;
        }
      public boolean update(User user) {
        SQLiteDatabase db = databaseTable.getWritableDatabase();

        ContentValues params = new ContentValues();
        params.put("name", user.getName());
        params.put("email", user.getEmail());
        params.put("picture", user.getPicture());
        params.put("password", user.getPassword());

        try {
            db.update("users", params, "id =?", new String[]{String.valueOf(user.getId())});
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
