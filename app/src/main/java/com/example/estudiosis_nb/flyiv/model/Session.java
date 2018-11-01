package com.example.estudiosis_nb.flyiv.model;

public class Session {
    private int id;
    private int userId;
    private String authToken;

    public Session(int id, int userId) {
        this.id = id;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public Session(int userId, String authToken) {
        this.userId = userId;
        this.authToken = authToken;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
