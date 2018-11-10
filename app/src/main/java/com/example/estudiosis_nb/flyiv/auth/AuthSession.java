package com.example.estudiosis_nb.flyiv.auth;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.estudiosis_nb.flyiv.dao.SessionDAO;
import com.example.estudiosis_nb.flyiv.model.User;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class AuthSession {
    private int USER_ID;
    private String TOKEN;
    private final String API_URL = "http://estudiosis.com.br/api_v1_tcc/?path=users_sign_in";
    private RequestQueue requestQueue;
    private SessionDAO sessionDAO;

    public AuthSession(int USER_ID, String TOKEN) {
        this.USER_ID = USER_ID;
        this.TOKEN = TOKEN;
    }

    public AuthSession() {};

    public AuthSession(Context context) {
        this.sessionDAO = new SessionDAO(context);
    }

    public boolean destroy(){
        if(this.sessionDAO.deleteUserSession()){
            return true;
        } else {
            return false;
        }
    }

    public boolean isAuth(){
        return false;
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

    public User auth(String email, String password, Context context){

        Map<String, String> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);

        // Busca na API por email e senha
        requestQueue = Volley.newRequestQueue(context);
        JsonArrayRequest objectRequest = new JsonArrayRequest(
                Request.Method.POST,
                API_URL,
                null,
                 new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.e("API_DEBUG", "Ok2"+response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("v", "error: "+error.toString());
                    }
                }
        );

        requestQueue.add(objectRequest);
        User user = new User(0,"","","");
        return null;
    }
}
