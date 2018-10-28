package com.example.estudiosis_nb.flyiv.model;

public class SongChord {

    private int position;
    private int note;
    private String mode;

    public SongChord(int position, int note, int songId, String mode) {
        this.position = position;
        this.note = note;
        this.mode = mode;
        this.songId = songId;
    }

    public SongChord(int position, int songId, String mode) {
        this.position = position;
        this.songId = songId;
        this.mode = mode;
    }

    private int songId;

    public SongChord() {

    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public int getPosition() {
        return position;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}
