package com.example.estudiosis_nb.flyiv;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.estudiosis_nb.flyiv.adapter.RecordListAdapter;
import com.example.estudiosis_nb.flyiv.adapter.SongListAdapter;
import com.example.estudiosis_nb.flyiv.dao.SongDAO;
import com.example.estudiosis_nb.flyiv.model.Record;
import com.example.estudiosis_nb.flyiv.model.Song;

import java.util.ArrayList;
import java.util.List;

public class SongDetailActivity extends AppCompatActivity {

    Song song;
    private static long USER_ID = 1;
    SongDAO dao;
    EditText txtTitle;
    EditText txtDescription;
    TextView msgAudios;
    TextView txtChords;
    List<Record> records = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_detail);

        // ActionBar bar = getSupportActionBar();
        // bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));

        Intent it = getIntent();

        if(it.getExtras() != null){
            this.song = (Song) it.getSerializableExtra("song");
        } else {
            this.song = new Song("Nova composição","Clique aqui para editar a letra da composição,", USER_ID);
        }

        txtTitle = (EditText) findViewById(R.id.txtTitle);
        txtTitle.setText(song.getTitle());

        txtDescription = (EditText) findViewById(R.id.txtDescription);
        txtDescription.setText(song.getDescription());

        if(this.song.getChords().length() > 0){
            txtChords = (TextView) findViewById(R.id.txtChords);
            txtChords.setText(this.song.getChords());
        }

        msgAudios = (TextView) findViewById(R.id.msgAudios);

        //if(this.song.getRecords().size() == 0){
         //   msgAudios.setVisibility(TextView.VISIBLE);
        //} else {
          //  msgAudios.setVisibility(TextView.INVISIBLE);
        //}

        /*records.add(new Record("file001.wav",140,"/audios/mp3"));
        records.add(new Record("file002.wav",120,"/audios/mp3"));
        records.add(new Record("file003.wav",110,"/audios/mp3")); */

        if(this.song.getRecords().size() > 0){
            RecordListAdapter adapter = new RecordListAdapter(this.song.getRecords(), this);
            ListView recordListView = (ListView) findViewById(R.id.recordListView);
            recordListView.setAdapter(adapter);
        } else {
            msgAudios.setVisibility(TextView.VISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      getMenuInflater().inflate(R.menu.menu_song_detail, menu);
      return true;
    }

    public void editChords(View view) {
        Intent it = new Intent(SongDetailActivity.this, EditChords.class);
        startActivity(it);
    }

    public void share(MenuItem item) {

    }

    public void play(View view){

    }

    public void save(MenuItem item) {
        Snackbar mySnackbar = Snackbar.make(findViewById(R.id.txtDescription),
                "Alterações salvas com sucesso!", Snackbar.LENGTH_SHORT);
        mySnackbar.show();
    }
}
