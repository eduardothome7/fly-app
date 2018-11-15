package com.example.estudiosis_nb.flyiv.service;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.example.estudiosis_nb.flyiv.dao.SessionDAO;
import com.example.estudiosis_nb.flyiv.model.Session;
import com.example.estudiosis_nb.flyiv.model.Song;
import com.example.estudiosis_nb.flyiv.model.User;

import java.util.List;

public class SongService {
    private final String API_URL = "http://estudiosis.com.br/api_v1_tcc/?path=";
    private RequestQueue requestQueue;
    private AuthService auth;
    private List<Song> list;

    public SongService(Context context) {
        this.auth = new AuthService(context);
    }

    public void setSongList(List<Song> list){
        this.list = list;
    }

    public List<Song> getSongsShared(){

        return null;
    }

}
