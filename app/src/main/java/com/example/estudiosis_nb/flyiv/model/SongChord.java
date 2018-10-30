package com.example.estudiosis_nb.flyiv.model;

public class SongChord {
    private int id;
    private int position;
    private int note;
    private String tone;

    public SongChord(int position, int note, int songId, String tone) {
        this.position = position;
        this.note = note;
        this.tone = tone;
        this.songId = songId;
    }

    public SongChord(int position, int songId, String tone) {
        this.position = position;
        this.songId = songId;
        this.tone = tone;
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

    public String getTone() {
        return tone;
    }

    public void setTone(String tone) {
        this.tone = tone;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getId() {
        return id;
    }
}
