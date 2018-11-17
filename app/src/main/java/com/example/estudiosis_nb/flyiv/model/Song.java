package com.example.estudiosis_nb.flyiv.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Song implements Parcelable {
    private int id;
    private String title;
    private String chords = "";
    private String description;
    private int userId;
    private List<SongChord> listChords = new ArrayList<>();
    private List<Record> records = new ArrayList<>();

    protected Song(Parcel in) {
        id = in.readInt();
        title = in.readString();
        chords = in.readString();
        description = in.readString();
        userId = in.readInt();
    }

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

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

    public Song(String title, String description, int userId) {
        this.title = title;
        this.description = description;
        this.userId = userId;
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

    public Song(int id, String title, String description, int userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.userId = userId;
    }

    public Song(String title, String description, String chords) {
        this.title = title;
        this.chords = chords;
        this.description = description;
    }

    public int getId() {
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(chords);
        dest.writeString(description);
        dest.writeInt(userId);
    }
}
