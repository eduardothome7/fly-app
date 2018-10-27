package com.example.estudiosis_nb.flyiv.model;

import android.media.MediaPlayer;

import java.io.IOException;
import java.io.Serializable;

public class Record implements Serializable {
    private String name;
    private int duration;
    private String path;
    private String apiPath;
    private int songId;

    public Record(String name, int duration, String path, String apiPath, int songId) {
        this.name = name;
        this.duration = duration;
        this.path = path;
        this.apiPath = apiPath;
        this.songId = songId;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getApiPath() {
        return apiPath;
    }

    public Record() {
    }

    public void setapiPath(String apiPath) {
        this.apiPath = apiPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMinutes() {
        int minutes = (this.duration % 3600) / 60;
        int seconds = this.duration % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    public boolean play(){
        MediaPlayer player = new MediaPlayer();
        try {
            String path_file = this.getPath()+"/"+this.getName();
            player.setDataSource(path_file);
            player.prepare();
            player.start();
            return true;
        } catch(IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
