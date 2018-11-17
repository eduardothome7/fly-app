package com.example.estudiosis_nb.flyiv;

import android.app.ProgressDialog;
import android.app.VoiceInteractor;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.estudiosis_nb.flyiv.adapter.SongListAdapter;
import com.example.estudiosis_nb.flyiv.adapter.UserListAdapter;
import com.example.estudiosis_nb.flyiv.model.Song;
import com.example.estudiosis_nb.flyiv.model.User;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ShareActivity extends AppCompatActivity {
    private TextView txtTitle;
    private Song song;
    private UserListAdapter adapter;
    private List<User> users = new ArrayList<User>();
    private ProgressDialog pDialogList;
    private RequestQueue requestQueue;
    private final String API_URL = "http://estudiosis.com.br/api_v1_tcc/?path=users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        User user1 = new User(2,"Felipe Almeida","fealmeida@hotmail.com","");
        User user2 = new User(3,"André da Rosa","andreribeiro@hotmail.com","");
        User user3 = new User(4,"Vinicius Lima","vinilima@hotmail.com","");
        User user4 = new User(4,"Fábio Mendes","vinilima@hotmail.com","");
        User user5 = new User(5,"Vitin","vinilima@hotmail.com","");
        User user6 = new User(6,"Derek","vinilima@hotmail.com","");
        User user7 = new User(7,"Mark","vinilima@hotmail.com","");

        requestQueue = Volley.newRequestQueue(this);
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

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);

        adapter = new UserListAdapter(users, this, new UserListAdapter.BtnClickListener() {
            @Override
            public void onBtnClick(int position) {
                Log.e("DEBUG", "Ok2!");
            }
        });
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        Intent it = getIntent();
        this.song = (Song) it.getExtras().getParcelable("song");

        txtTitle.setText(song.getTitle());

        final ListView mainListView = (ListView) findViewById(R.id.listUsers);
        mainListView.setAdapter(adapter);

        this.fetchUsers("");

    }

    public void fetchUsers(String term){

        //pDialogList = ProgressDialog.show(this, "Aviso", "Buscando itens. Por favor aguarde.");

    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case android.R.id.home:
                //onBackPressed();
                Intent intent = new Intent(this, SongDetailActivity.class);
                intent.putExtra("song", this.song);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
