package com.example.estudiosis_nb.flyiv.model;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String name;
    private String email;
    private String token;
    private String picture;
    private String password;

    public String getPicture() {
        return picture;
    }

    public User(int id, String name, String email, String token, String picture, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.token = token;
        this.picture = picture;
        this.password = password;
    }

    public User(String name, String email, String picture) {
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public User(int id, String name, String email, String token, String picture) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.token = token;
        this.picture = picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User(int id, String name, String email, String picture) {
        this.id = id;
        this.name = name;
        this.email = picture;
        this.picture = picture;
    }

    public User() {
    }
}
