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

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SongAddActivity extends AppCompatActivity {

    Song song =  new Song("Nova composição","Clique aqui para editar a letra da composição,", USER_ID);;
    private static long USER_ID = 1;
    SongDAO dao = new SongDAO(this);
    EditText txtTitle;
    EditText txtDescription;
    TextView msgAudios;
    TextView txtChords;
    List<Record> records = new ArrayList<>();
    Snackbar mySnackbar;
    Boolean saved = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_add);

        this.populateFields(this.song);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_song_detail, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 2){
            this.song = (Song) data.getSerializableExtra("song");
            this.populateFields(song);
        }
    }

    public void share(MenuItem item) {

    }

    public void play(View view){

    }

    public void save(MenuItem item) {
        this.song.setTitle(this.txtTitle.getText().toString());
        this.song.setDescription(this.txtTitle.getText().toString());

        if(this.dao.create(this.song)){
            mySnackbar = Snackbar.make(findViewById(R.id.txtDescription),
                    "Alterações salvas com sucesso!", Snackbar.LENGTH_SHORT);
            this.saved = true;
        } else {
            mySnackbar = Snackbar.make(findViewById(R.id.txtDescription),
                    "Erro ao salvar a composição!", Snackbar.LENGTH_SHORT);
        }
        mySnackbar.show();
    }

    public void populateFields(Song song){
        txtTitle = (EditText) findViewById(R.id.txtTitle);
        txtTitle.setText(song.getTitle());

        txtDescription = (EditText) findViewById(R.id.txtDescription);
        txtDescription.setText(song.getDescription());

        if(this.song.getChords().length() > 0){
            txtChords = (TextView) findViewById(R.id.txtChords);
            txtChords.setText(this.song.getChords());
        }
    }
}
