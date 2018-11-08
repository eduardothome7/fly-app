package com.example.estudiosis_nb.flyiv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.estudiosis_nb.flyiv.auth.AuthSession;

public class SignUpActivity extends AppCompatActivity {

    AuthSession auth = new AuthSession();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        if(auth.isAuth()){
            Intent it = new Intent(SignUpActivity.this, MainActivity.class);
            startActivity(it);
        }
    }

    public void SignIn(View view) {
        Intent it = new Intent(SignUpActivity.this, SignInActivity.class);
        startActivity(it);
    }

}