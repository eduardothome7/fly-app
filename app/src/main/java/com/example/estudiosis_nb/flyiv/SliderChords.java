package com.example.estudiosis_nb.flyiv;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class SliderChords extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_chords);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_save_slider_chords, menu);
        return true;
    }

    public void save(MenuItem item) {
        //Snackbar mySnackbar = Snackbar.make(findViewById(R.id.editText),
        //       "Acorde adicionado com sucesso", Snackbar.LENGTH_SHORT);
        // mySnackbar.show();
    }
}
