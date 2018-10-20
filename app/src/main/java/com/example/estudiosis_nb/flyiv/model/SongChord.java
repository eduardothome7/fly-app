package com.example.estudiosis_nb.flyiv.model;

public class SongChord {

    private int i;
    private int mode;
    private String note;

    public SongChord(int i, int mode, String note) {
        this.i = i;
        this.mode = mode;
        this.note = note;
    }

    public int getI() {
        return i;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
