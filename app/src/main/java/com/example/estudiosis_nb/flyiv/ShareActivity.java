package com.example.estudiosis_nb.flyiv;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.example.estudiosis_nb.flyiv.adapter.UserListAdapter;
import com.example.estudiosis_nb.flyiv.model.Song;
import com.example.estudiosis_nb.flyiv.model.User;
import com.example.estudiosis_nb.flyiv.service.AuthService;
import com.example.estudiosis_nb.flyiv.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class ShareActivity extends AppCompatActivity {
    private TextView txtTitle;
    private Song song;
    private UserListAdapter adapter;
    private List<User> users = new ArrayList<User>();
    private ProgressDialog pDialogList;
    private RequestQueue requestQueue;
    private UserService userService;
    private final String API_URL = "http://estudiosis.com.br/api_v1_tcc/?path=users";
    private AuthService authService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.authService = new AuthService(this);

        setContentView(R.layout.activity_share);

        txtTitle = (TextView) findViewById(R.id.txtTitle);
        Intent it = getIntent();
        this.song = (Song) it.getExtras().getParcelable("song");

        txtTitle.setText(song.getTitle());

        final ListView mainListView = (ListView) findViewById(R.id.listUsers);
        mainListView.setAdapter(adapter);

        this.fetchUsers(this.authService.getUser().getToken());

    }

    public void fetchUsers(String token){
        Log.e("e", "Share");
        this.userService = new UserService(token, this);
        userService.fetchAll();
        this.users = this.userService.getUsers();

        adapter = new UserListAdapter(this.users, this, new UserListAdapter.BtnClickListener() {
            @Override
            public void onBtnClick(int position) {
                Log.e("DEBUG", "Ok2!");
            }
        });

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
