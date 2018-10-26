package com.example.estudiosis_nb.flyiv.popup;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.estudiosis_nb.flyiv.R;
import com.example.estudiosis_nb.flyiv.model.Chord;
import com.example.estudiosis_nb.flyiv.model.DictionaryChords;
import com.example.estudiosis_nb.flyiv.model.Song;
import com.example.estudiosis_nb.flyiv.model.SongChord;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.UUID;

public class AudioRecorderDialog extends AppCompatDialogFragment {

    private ImageButton btnPlayPause;
    private MediaRecorder mediaRecorder;
    private boolean playing;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.audio_recorder,null);

        btnPlayPause = (ImageButton) view.findViewById(R.id.btnPlayPause);
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

        btnPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPlayPause.setEnabled(false);
                //btnStop.setEnabled(true);

                String path = Environment.getExternalStorageDirectory()
                        .getAbsolutePath()+
                        "/"+UUID.randomUUID().toString()+"_audio_record.3gp";
                setupMediaRecord(path);
                try {
                    mediaRecorder.prepare();
                    mediaRecorder.start();
                } catch (IOException e) {

                }

                //btnPlayPause.setImageIcon();
            }
        });
        //txtSelectChordName = (TextView) view.findViewById(R.id.txtSelectChordName);

        return builder.create();
    }

    private void setupMediaRecord(String path) {
        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        mediaRecorder.setOutputFile(path);
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
