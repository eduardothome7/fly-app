package com.example.estudiosis_nb.flyiv.model;

import java.io.Serializable;
import java.util.List;

public class Song implements Serializable {
    private long id;
    private String title;
    private String chords;
    private String description;
    private long user_id;
    private List<Chord> listChords;

    public String getChords() {
        return chords;
    }

    public void setChords(String chords) {
        this.chords = chords;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Song(String title, String description, long user_id) {
        this.title = title;
        this.description = description;
        this.user_id = user_id;
    }

    public void upTone(int tone){

    }

    public List<Chord> getListChords() {
        return listChords;
    }

    public void setListChords(List<Chord> listChords) {
        this.listChords = listChords;
    }

    public void add(Chord chord) {
        this.listChords.add(chord);
    }

    public void downTone(int tone){

    }

    public Song(long id, String title, String description, long user_id) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.user_id = user_id;
    }

    public Song(String title, String description, String chords) {
        this.title = title;
        this.chords = chords;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
}
