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
import com.example.estudiosis_nb.flyiv.model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AuthService {
    private int USER_ID;
    private String TOKEN;
    private final String API_URL = "http://estudiosis.com.br/api_v1_tcc/?path=users_sign_in";
    private RequestQueue requestQueue;
    private SessionDAO sessionDAO;
    private static boolean success;
    private User user;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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

    public void setUser(User userauth, boolean success){
        this.user = userauth;
        Log.e("debug", user.getName());
    }

    public User auth(final String email, final String password, Context context){
        final boolean success = false;

        Map<String, String> params = new HashMap();
        params.put("email", email);
        params.put("password", password);

        JSONObject parameters = new JSONObject(params);

        // Busca na API por email e senha
        requestQueue = Volley.newRequestQueue(context);
            StringRequest stringRequest = new StringRequest(Request.Method.POST, API_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    //extracting json array from response string
                    JSONObject res = new JSONObject(response);
                    String status = res.getString("status");

                    if(status.equals("success")){
                        JSONObject user = new JSONObject(res.getString("user"));
                        Log.e("API_DEBUG", user.getString("name"));
                        int id = Integer.parseInt(user.getString("id"));
                        String name = user.getString("name");
                        String email = user.getString("email");
                        User userAuth = new User(id, name, email, "");
                        setUser(userAuth, success);
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
        Log.e("debug","ok2");
        requestQueue.add(stringRequest);



        if(success){
            User user = new User(0,"","","");
            Log.e("DEBUG","OK2");
            //return user;
            return null;
            //
        } else {
            return null;
        }
    }
}
