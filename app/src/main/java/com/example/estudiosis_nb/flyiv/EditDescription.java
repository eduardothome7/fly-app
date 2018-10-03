package com.example.estudiosis_nb.flyiv;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.support.v7.widget.Toolbar;

import com.example.estudiosis_nb.flyiv.dao.SongDAO;
import com.example.estudiosis_nb.flyiv.model.Song;

public class EditDescription extends AppCompatActivity {

    Song song;
    SongDAO dao;
    EditText editDescripion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_description);

        Intent it = getIntent();
        this.song = (Song) it.getSerializableExtra("song");
        editDescripion = (EditText) findViewById(R.id.editText);
        editDescripion.setText(song.getDescription());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_save_edit_description, menu);
        return true;
    }

    public void save(MenuItem item) {
        Snackbar mySnackbar = Snackbar.make(findViewById(R.id.editText),
                "Alterações salvas na letra com sucesso", Snackbar.LENGTH_SHORT);
        mySnackbar.show();
    }
}
