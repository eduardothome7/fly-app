package com.example.estudiosis_nb.flyiv.model;

public class Chord {
    private String name;
    private String mode;
    private int frequency;
    private String noteAccent;

    public Chord(String name, String mode, int frequency, String noteAccent) {
        this.name = name;
        this.mode = mode;
        this.frequency = frequency;
        this.noteAccent = noteAccent;
    }

    public String getName() {
        return name;
    }

    public void up(int quantity){
    }

    public void down(int quantity){
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getNoteAccent() {
        return noteAccent;
    }

    public void setNoteAccent(String noteAccent) {
        this.noteAccent = noteAccent;
    }
}
