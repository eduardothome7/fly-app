package com.example.estudiosis_nb.flyiv.auth;

public class AuthSession {
    private int USER_ID;
    private String TOKEN;

    public AuthSession(int USER_ID, String TOKEN) {
        this.USER_ID = USER_ID;
        this.TOKEN = TOKEN;
    }

    public boolean isAuth(){
        return true;
    }

    public int getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(int USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getTOKEN() {
        return TOKEN;
    }

    public void setTOKEN(String TOKEN) {
        this.TOKEN = TOKEN;
    }
}
