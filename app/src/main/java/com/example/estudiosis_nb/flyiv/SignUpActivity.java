package com.example.estudiosis_nb.flyiv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.estudiosis_nb.flyiv.service.AuthService;

public class SignUpActivity extends AppCompatActivity {

    AuthService auth = new AuthService(this);

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
