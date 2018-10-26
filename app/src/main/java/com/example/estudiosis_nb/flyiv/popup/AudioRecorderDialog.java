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

public class AudioRecorderDialog extends AppCompatDialogFragment {

    private ImageButton btnPlayPause;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.audio_recorder,null);

        //btnNext = (ImageButton) view.findViewById(R.id.btnNext);

        builder.setView(view)
                .setTitle("Gravar áudio")
                .setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        //txtSelectChordName = (TextView) view.findViewById(R.id.txtSelectChordName);

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void startStop(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();

    }
}