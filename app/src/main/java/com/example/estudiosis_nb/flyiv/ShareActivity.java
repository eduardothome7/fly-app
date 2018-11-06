package com.example.estudiosis_nb.flyiv;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.example.estudiosis_nb.flyiv.adapter.SongListAdapter;
import com.example.estudiosis_nb.flyiv.adapter.UserListAdapter;
import com.example.estudiosis_nb.flyiv.model.Song;
import com.example.estudiosis_nb.flyiv.model.User;
import com.google.gson.Gson;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ShareActivity extends AppCompatActivity {
    private TextView txtTitle;
    private Song song;
    private UserListAdapter adapter;
    private List<User> users = new ArrayList<User>();
    private ProgressDialog pDialogList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        users.add(new User(2,"Felipe Almeida","fealmeida@hotmail.com",""));
        adapter = new UserListAdapter(users, this, new UserListAdapter.BtnClickListener() {
            @Override
            public void onBtnClick(int position) {
                Log.e("DEBUG", "Ok2!");
            }
        });
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        Intent it = getIntent();
        this.song = (Song) it.getExtras().getParcelable("song");

        txtTitle.setText(song.getTitle());

        final ListView mainListView = (ListView) findViewById(R.id.listUsers);
        mainListView.setAdapter(adapter);

        this.fetchUsers("");

    }

    public void fetchUsers(String term){

        //pDialogList = ProgressDialog.show(this, "Aviso", "Buscando itens. Por favor aguarde.");


    }
}
