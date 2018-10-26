package com.example.estudiosis_nb.flyiv.popup;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;
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
import com.example.estudiosis_nb.flyiv.SongDetailActivity;
import com.example.estudiosis_nb.flyiv.dao.RecordDAO;
import com.example.estudiosis_nb.flyiv.model.Chord;
import com.example.estudiosis_nb.flyiv.model.DictionaryChords;
import com.example.estudiosis_nb.flyiv.model.Record;
import com.example.estudiosis_nb.flyiv.model.Song;
import com.example.estudiosis_nb.flyiv.model.SongChord;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.UUID;

public class AudioRecorderDialog extends AppCompatDialogFragment {

    private ImageButton btnPlayPause;
    private MediaRecorder mediaRecorder;
    private MediaPlayer mediaPlayer;
    private boolean playing;
    private boolean done;
    private boolean stop;
    private Record record;
    private RecordDAO recordDAO;
    private TextView msg;
    private String path;
    private String file;
    private int songId;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.audio_recorder,null);

        btnPlayPause = (ImageButton) view.findViewById(R.id.btnPlayPause);
        msg = (TextView) view.findViewById(R.id.txtMsg);

        //btnNext = (ImageButton) view.findViewById(R.id.btnNext);        //
        recordDAO = new RecordDAO(this.getContext());

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

                        if(done) {
                            record = new Record();
                            record.setName(file);
                            record.setPath(path);
                            record.setSongId(songId);
                            record.setapiPath("");
                            record.setDuration(102);

                            if (recordDAO.create(record)) {
                                Toast.makeText(getContext(), "Ok", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getContext(), "Deu erro", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                });

        btnPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!done) {
                    if(!playing){
                        msg.setText("Gravando...");
                        btnPlayPause.setImageDrawable(getResources().getDrawable(R.drawable.ic_icon_stop));
                        path = Environment.getExternalStorageDirectory()
                                .getAbsolutePath();
                        file = UUID.randomUUID().toString()+"_audio_record.3gp";
                        String path_file = path+"/"+file;
                        setupMediaRecord(path_file);
                        try {
                            mediaRecorder.prepare();
                            mediaRecorder.start();
                        } catch (IOException e) {

                        }
                        playing = true;
                    } else {
                        //stop
                        mediaRecorder.stop();
                        msg.setText("Gravação realizada! Para adiciona á composição, clique em 'Salvar'");
                        btnPlayPause.setImageDrawable(getResources().getDrawable(R.drawable.ic_play_button));
                        //playing = false;
                        done = true;
                    }
                } else {
                    if(!stop) {
                        //playAudio
                        msg.setText("...");
                        mediaPlayer = new MediaPlayer();
                        try {
                            String path_file = path+"/"+file;
                            mediaPlayer.setDataSource(path_file);
                            mediaPlayer.prepare();
                        } catch(IOException e) {
                            e.printStackTrace();
                        }
                        mediaPlayer.start();
                        stop = true;
                    } else {
                        msg.setText("Clique no botão abaixo para continuar execução do áudio");
                        mediaPlayer.pause();
                        //mediaPlayer.release();
                    }
                }
            }
        });
        //txtSelectChordName = (TextView) view.findViewById(R.id.txtSelectChordName);

        return builder.create();
    }

    private void setupMediaRecord(String path_file) {
        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        mediaRecorder.setOutputFile(path_file);
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
        this.songId = Integer.parseInt(args.getString("songId"));
        this.done = false;
        this.playing = false;
        this.stop = false;
    }
}


/*
* <div>Icons made by <a href="https://www.flaticon.com/authors/hirschwolf" title="hirschwolf">hirschwolf</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a></div>
<div>Icons made by <a href="https://www.flaticon.com/authors/smashicons" title="Smashicons">Smashicons</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a></div>
* */