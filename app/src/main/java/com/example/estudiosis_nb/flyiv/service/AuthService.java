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
import java.util.Map;

public class AuthService {
    private int USER_ID;
    private String TOKEN;
    private final String API_URL = "http://estudiosis.com.br/api_v1_tcc/?path=";
    private RequestQueue requestQueue;
    private SessionDAO sessionDAO;
    private static boolean success;
    private static User user;
    private Session session = new Session();

    public boolean isSuccess() {
        return success;
    }

    public AuthService(int USER_ID, String TOKEN) {
        this.USER_ID = USER_ID;
        this.TOKEN = TOKEN;
    }

    public AuthService() {};

    public AuthService(Context context) {
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
        if(this.sessionDAO.currentUser().getToken() != null){
            return true;
        } else {
            return false;
        }
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

    public void setUser(User userauth){
        this.user = userauth;
        this.success = true;
        Log.e("AUTH_DEBUG", "set user");
    }

    public User create(final User user, Context context){
        final boolean success = false;

        requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, API_URL+"users_sign_up", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject res = new JSONObject(response);
                    String status = res.getString("status");
                    Log.e("API DEBUG","OK2");
                    if(status.equals("success")){
                        JSONObject user = new JSONObject(res.getString("user"));
                        int id = Integer.parseInt(user.getString("id"));
                        String name = user.getString("name");
                        String email = user.getString("email");
                        String authToken = user.getString("auth_token");
                        String picture = user.getString("picture");
                        User userAuth = new User(id, name, email, authToken, picture);
                        setUser(userAuth);
                    } else {
                        Log.e("API_DEBUG", status);
                    }
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
                parameters.put("name", user.getName());
                parameters.put("email", user.getEmail());
                parameters.put("password", user.getName());
                return parameters;
            }
        };
        requestQueue.add(stringRequest);

        if(this.success){
            Log.e("debug","success");
            this.session.setUser(this.user);
            if(sessionDAO.create(session)){
                return this.user;
            } else {
                Log.e("debug","error 2");
            }
        } else {
            this.user = null;
        }
        return this.user;
    }

    public User auth(final String email, final String password, Context context){
        final boolean success = false;

        Map<String, String> params = new HashMap();
        params.put("email", email);
        params.put("password", password);

        JSONObject parameters = new JSONObject(params);

        // Busca na API por email e senha
        requestQueue = Volley.newRequestQueue(context);
            StringRequest stringRequest = new StringRequest(Request.Method.POST, API_URL+"users_sign_in", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    //extracting json array from response string
                    JSONObject res = new JSONObject(response);
                    String status = res.getString("status");

                    if(status.equals("success")){
                        JSONObject user = new JSONObject(res.getString("user"));
                        int id = Integer.parseInt(user.getString("id"));
                        String name = user.getString("name");
                        String email = user.getString("email");
                        String authToken = user.getString("auth_token");
                        String picture = user.getString("picture");
                        User userAuth = new User(id, name, email, authToken, picture);
                        setUser(userAuth);
                    } else {
                        Log.e("API_DEBUG", status);
                    }
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
                parameters.put("email",email);
                parameters.put("password",password);
                return parameters;
            }
        };
        requestQueue.add(stringRequest);

        if(this.success){
            Log.e("debug","success");
            this.session.setUser(this.user);
            if(sessionDAO.create(session)){
                return this.user;
            } else {
                Log.e("debug","error 2");
            }
        } else {
            this.user = null;
        }
        return this.user;
    }

    public User getUser() {
        return this.sessionDAO.currentUser();
    }
}
