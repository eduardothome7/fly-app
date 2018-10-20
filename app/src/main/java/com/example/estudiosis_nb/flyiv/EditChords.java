package com.example.estudiosis_nb.flyiv;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.estudiosis_nb.flyiv.adapter.ChordGridAdapter;
import com.example.estudiosis_nb.flyiv.adapter.RecordListAdapter;
import com.example.estudiosis_nb.flyiv.model.Song;
import com.example.estudiosis_nb.flyiv.model.SongChord;

import java.util.ArrayList;
import java.util.List;

public class EditChords extends AppCompatActivity {
    Song song;
    TextView msgChord;
    List<SongChord> chords = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_chords);

        Intent it = getIntent();
        this.song = (Song) it.getSerializableExtra("song");

        chords.add(new SongChord(0,0,""));
        chords.add(new SongChord(2,0,""));
        chords.add(new SongChord(4,0,""));
        chords.add(new SongChord(2,0,""));

        GridView chordGridView = (GridView) findViewById(R.id.gridChords);
        ChordGridAdapter adapter = new ChordGridAdapter(this.chords, this);
        chordGridView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent it  = new Intent(EditChords.this, SliderChords.class);
                //startActivity(it);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent();
        intent.putExtra("song", this.song);
        setResult(2, intent);
    }
}
