package com.example.estudiosis_nb.flyiv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.estudiosis_nb.flyiv.service.AuthService;
import com.example.estudiosis_nb.flyiv.model.User;

public class SignInActivity extends AppCompatActivity {
    AuthService auth = new AuthService(this);
    private EditText editEmail;
    private EditText editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        this.editEmail = (EditText) findViewById(R.id.email_sign_in);
        this.editPassword = (EditText) findViewById(R.id.password_sign_in);

        if(auth.isAuth()){
            Intent it = new Intent(SignInActivity.this, MainActivity.class);
            startActivity(it);
        } else {

        }
    }

    public void singUp(View view) {
        Intent it = new Intent(SignInActivity.this, SignUpActivity.class);
        startActivity(it);
    }

    public void signIn(View view){

        String email = this.editEmail.getText().toString();
        String password = this.editPassword.getText().toString();

        if(email.equals("")|| password.equals("") ){
            Toast toast = Toast.makeText(this,"Preencha email/senha", Toast.LENGTH_LONG);
            toast.show();
        } else {
            User authUser = this.auth.auth(email, password, this);

            if(authUser == null){
                Toast toast = Toast.makeText(this,"Email/Senha incorretos. Tente novamente",Toast.LENGTH_LONG);
                toast.show();
            } else {
                Intent it = new Intent(SignInActivity.this, MainActivity.class);
                startActivity(it);
            }
        }

    }
}
