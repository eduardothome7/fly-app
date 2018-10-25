package com.example.estudiosis_nb.flyiv.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Song implements Serializable {
    private int id;
    private String title;
    private String chords = "";
    private String description;
    private int user_id;
    private List<SongChord> listChords = new ArrayList<>();
    private List<Record> records = new ArrayList<>();

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public void addRecord(Record record){
        this.records.add(record);
    }

    public String getChords() {
        return chords;
    }

    public void setChords(String chords) {
        this.chords = chords;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Song(String title, String description, int user_id) {
        this.title = title;
        this.description = description;
        this.user_id = user_id;
    }

    public void upTone(int tone){

    }

    public List<SongChord> getListChords() {
        return listChords;
    }

    public void setListChords(List<SongChord> listChords) {
        this.listChords = listChords;
    }

    public void add(SongChord songChord) {
        this.listChords.add(songChord);
    }

    public void downTone(int tone){

    }

    public Song(int id, String title, String description, int user_id) {
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

    public void setId(int id) {
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
