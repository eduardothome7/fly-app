package com.example.estudiosis_nb.flyiv.popup;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.estudiosis_nb.flyiv.R;
import com.example.estudiosis_nb.flyiv.model.Chord;
import com.example.estudiosis_nb.flyiv.model.DictionaryChords;
import com.example.estudiosis_nb.flyiv.model.Song;
import com.example.estudiosis_nb.flyiv.model.SongChord;

import org.w3c.dom.Text;

public class SelectChordDialog extends AppCompatDialogFragment {
    TextView txtSelectChordName;
    private SongChord songChord;
    private DictionaryChords dicionaryChords = new DictionaryChords();
    private int position;
    private Chord chord;
    private ImageButton btnNext;
    private ImageButton btnPrev;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.modal_chord,null);

        btnNext = (ImageButton) view.findViewById(R.id.btnNext);

        builder.setView(view)
                .setTitle("Selecionar acorde")
                .setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Incluir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        txtSelectChordName = (TextView) view.findViewById(R.id.txtSelectChordName);
        populate();

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void next(){
        this.chord = this.dicionaryChords.next(this.position);
        populate();
    }

    public void prev(){
        this.chord = this.dicionaryChords.prev(this.position);
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
        this.chord = this.dicionaryChords.getChord(this.position);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });

    }
}