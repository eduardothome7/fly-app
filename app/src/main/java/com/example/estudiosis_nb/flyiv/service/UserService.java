package com.example.estudiosis_nb.flyiv.service;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.estudiosis_nb.flyiv.dao.SessionDAO;
import com.example.estudiosis_nb.flyiv.model.Session;
import com.example.estudiosis_nb.flyiv.model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private String TOKEN;
    private final String API_URL = "http://estudiosis.com.br/api_v1_tcc/?path=users";
    private RequestQueue requestQueue;
    private static boolean success;
    private static List<User> users;
    private Context context;

    public boolean isSuccess() {
        return success;
    }

    public UserService(String TOKEN, Context context) {;
        this.TOKEN = TOKEN;
        this.context = context;
        this.fetchAll();
        Log.e("debug", "fetch");
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void fetchAll(){
        final boolean success = false;
        Log.e("debug", "fetch 2");
        requestQueue = Volley.newRequestQueue(this.context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, API_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject res = new JSONObject(response);

                    setUsers(null);

                    Log.e("API_DEBUG", response);

                } catch (JSONException e) {

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parameters = new HashMap<String,String>();
                parameters.put("auth_token",TOKEN);
                return parameters;
            }
        };
        requestQueue.add(stringRequest);

        //return this.users;
    }

    public static List<User> getUsers() {
        return users;
    }
}
