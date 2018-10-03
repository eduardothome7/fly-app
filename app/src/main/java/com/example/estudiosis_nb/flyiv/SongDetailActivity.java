package com.example.estudiosis_nb.flyiv;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.estudiosis_nb.flyiv.dao.SongDAO;
import com.example.estudiosis_nb.flyiv.model.Song;

public class SongDetailActivity extends AppCompatActivity {

    Song song;
    private static long USER_ID = 1;
    SongDAO dao;
    TextView txtTitle;
    TextView txtDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_detail);

        Intent it = getIntent();

        if(it.getExtras() != null){
            this.song = (Song) it.getSerializableExtra("song");
        } else {
            this.song = new Song("Sem Título","Clique aqui para editar a letra da composição,", USER_ID);
        }

        this.setTitle(song.getTitle());

        // txtTitle = (EditText) findViewById(R.id);
        txtDescription = (TextView) findViewById(R.id.songDescription);
        txtDescription.setText(song.getDescription());

        txtDescription.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                Intent it  = new Intent(SongDetailActivity.this, EditDescription.class);
                it.putExtra("song",song);
                startActivity(it);

                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_song_detail, menu);
        return true;
    }

    public void editText(View view) {
        Intent it = new Intent(SongDetailActivity.this, FullDescription.class);
        it.putExtra("description", song.getDescription());
        startActivity(it);
    }

    public void editChords(View view) {
        Intent it = new Intent(SongDetailActivity.this, EditChords.class);
        startActivity(it);
    }

    public void share(MenuItem item) {

    }
}
