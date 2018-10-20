package com.example.estudiosis_nb.flyiv.model;

import java.io.Serializable;

public class Record implements Serializable {
    private String title;
    private int duration;
    private String path;

    public Record(String title, int duration, String path) {
        this.title = title;
        this.duration = duration;
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
