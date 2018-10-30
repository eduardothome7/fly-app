package com.example.estudiosis_nb.flyiv.popup;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.estudiosis_nb.flyiv.R;
import com.example.estudiosis_nb.flyiv.dao.ChordDAO;
import com.example.estudiosis_nb.flyiv.model.Chord;
import com.example.estudiosis_nb.flyiv.model.DictionaryChords;
import com.example.estudiosis_nb.flyiv.model.Record;
import com.example.estudiosis_nb.flyiv.model.Song;
import com.example.estudiosis_nb.flyiv.model.SongChord;

import org.w3c.dom.Text;

import java.io.IOException;

public class SelectChordDialog extends AppCompatDialogFragment {
    TextView txtSelectChordName;
    private SongChord songChord;
    private DictionaryChords dicionaryChords = new DictionaryChords();
    private int position;
    private int songId;
    private Chord chord;
    private ImageButton btnNext;
    private ImageButton btnPrev;
    private ChordDAO chordDAO;
    private String action;
    private Switch chkDmin;
    private Switch chkSus;
    private Switch chkMenor;
    private Switch chkSeven;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.modal_chord,null);
        chordDAO = new ChordDAO(getContext());

        chkMenor = (Switch) view.findViewById(R.id.chkMenor);
        chkDmin  = (Switch) view.findViewById(R.id.chkDmin);
        chkSus = (Switch) view.findViewById(R.id.chkSus);
        chkSeven = (Switch) view.findViewById(R.id.chkSeven);

        btnNext = (ImageButton) view.findViewById(R.id.btnNext);
        btnPrev = (ImageButton) view.findViewById(R.id.btnPrev);

        txtSelectChordName = (TextView) view.findViewById(R.id.txtSelectChordName);
        populate();

        //chkSeven.

        builder.setView(view)
                .setTitle("Selecionar acorde")
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
                    @Override
                     public void onClick(DialogInterface dialog, int which) {
                        boolean success = false;
                        Log.e("debug", "SONG: "+songChord.getPosition()+songChord.getSongId());
                        if(action == "new"){
                            if(chordDAO.create(songChord)){
                              success = true;
                            }
                        } else {
                            if(chordDAO.update(songChord)){
                                success = true;
                            }
                        }
                        if(success){
                            Toast.makeText(getContext(), "Acorde adicionado com sucesso!", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getContext(), "Erro ao adicionar acorde.", Toast.LENGTH_LONG).show();
                        }
                    }
                });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev();
            }
        });

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void prev(){
        if(this.position == 0){
            this.position = this.dicionaryChords.getChords().size() - 1;
        } else {
            this.position--;
        }
        //Toast.makeText(this.getContext(),"pos:"+this.position, Toast.LENGTH_SHORT).show();
        this.chord = this.dicionaryChords.getChord(this.position);
        songChord.setPosition(this.position);
        Log.d("DEBUG", "position: "+this.position);
        populate();
    }

    public void next(){
        if(this.position == (this.dicionaryChords.getChords().size() - 1)){
            this.position = 0;
        } else {
            this.position++;
        }
        this.chord = this.dicionaryChords.getChord(this.position);
        songChord.setPosition(this.position);
        //Log.d("DEBUG", "position: "+this.position);
        populate();
    }

    public void populate(){
        txtSelectChordName.setText(this.chord.getName());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        this.position = Integer.parseInt(args.getString("position"));
        this.action = args.getString("action");
        this.songChord = new SongChord();
        this.chord = this.dicionaryChords.getChord(this.position);
        this.songChord.setSongId(Integer.parseInt(args.getString("songId")));
        Log.e("DEBUG", "SONG_ID:"+Integer.parseInt(args.getString("songId")));
        this.songChord.setTone("");
        this.songChord.setNote(0);
    }
}
