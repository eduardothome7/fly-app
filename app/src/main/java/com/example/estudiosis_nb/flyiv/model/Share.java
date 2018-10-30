package com.example.estudiosis_nb.flyiv.model;

import java.io.Serializable;

public class Share implements Serializable {
    private int id;
    private int songId;
    private int userId;

    public Share(int id, int songId, int userId) {
        this.id = id;
        this.songId = songId;
        this.userId = userId;
    }

    public Share(int songId, int userId) {
        this.songId = songId;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
