package com.example.estudiosis_nb.flyiv;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.estudiosis_nb.flyiv.adapter.ChordGridAdapter;
import com.example.estudiosis_nb.flyiv.adapter.RecordListAdapter;
import com.example.estudiosis_nb.flyiv.dao.ChordDAO;
import com.example.estudiosis_nb.flyiv.model.Song;
import com.example.estudiosis_nb.flyiv.model.SongChord;
import com.example.estudiosis_nb.flyiv.popup.SelectChordDialog;

import java.util.ArrayList;
import java.util.List;

public class EditChords extends AppCompatActivity {
    Song song;
    TextView msgChord;
    ChordDAO chordDAO;
    List<SongChord> chords = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_chords);
        chordDAO = new ChordDAO(this);

        Intent it = getIntent();
        //this.song = (Song) it.getSerializableExtra("song");
        this.song = (Song) it.getExtras().getParcelable("song");
        Log.e("DEBUG", "song_id: "+this.song.getId());

        this.chords = this.chordDAO.fetchAll(this.song.getId());
        /* chords.add(new SongChord(0,0,""));
        chords.add(new SongChord(2,0,""));
        chords.add(new SongChord(4,0,""));
        chords.add(new SongChord(2,0,"")); */

        GridView chordGridView = (GridView) findViewById(R.id.gridChords);
        ChordGridAdapter adapter = new ChordGridAdapter(this.chords, this);
        chordGridView.setAdapter(adapter);
        registerForContextMenu(chordGridView);

        chordGridView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                        SongChord songChord = chords.get(position);
                        openDialog(songChord, "edit");
                    }
                }
        );

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SongChord songChord = new SongChord(0,0,"");
                openDialog(songChord,"new");
            }
        });
    }

    private void openDialog(SongChord songChord, String action) {
        SelectChordDialog selectChordDialog = new SelectChordDialog();

        Bundle args = new Bundle();
        args.putString("position", String.valueOf(songChord.getPosition()));
        args.putString("songId", String.valueOf(this.song.getId()));
        args.putString("action", action);
        selectChordDialog.setArguments(args);
        selectChordDialog.show(getSupportFragmentManager(), "select dialog");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //return super.onContextItemSelected(item);
        AdapterView.AdapterContextMenuInfo info = ( AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        /* switch (item.getItemId()) {
            default:
        } */
        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_delete_chord, menu);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent();
        intent.putExtra("song", this.song);
        setResult(2, intent);
    }
}
