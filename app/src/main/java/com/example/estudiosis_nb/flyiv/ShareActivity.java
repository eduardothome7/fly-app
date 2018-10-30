package com.example.estudiosis_nb.flyiv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.estudiosis_nb.flyiv.model.Song;

public class ShareActivity extends AppCompatActivity {
    private TextView txtTitle;
    private Song song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        Intent it = getIntent();
        this.song = (Song) it.getSerializableExtra("song");

        txtTitle.setText(song.getTitle());

    }
}
