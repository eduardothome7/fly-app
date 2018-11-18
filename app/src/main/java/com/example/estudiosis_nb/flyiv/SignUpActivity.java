package com.example.estudiosis_nb.flyiv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.estudiosis_nb.flyiv.model.User;
import com.example.estudiosis_nb.flyiv.service.AuthService;

public class SignUpActivity extends AppCompatActivity {
    private EditText editName;
    private EditText editEmail;
    private EditText editPassword;
    private EditText editPassword2;

    AuthService auth = new AuthService(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        this.editName = (EditText) findViewById(R.id.txtSUNome);
        this.editEmail = (EditText) findViewById(R.id.txtSUEmail);
        this.editPassword = (EditText) findViewById(R.id.passwordSU);
        this.editPassword2 = (EditText) findViewById(R.id.passwordSUConfirmation);

        if(auth.isAuth()){
            Intent it = new Intent(SignUpActivity.this, MainActivity.class);
            startActivity(it);
        }
    }

    public void SignIn(View view) {
        Intent it = new Intent(SignUpActivity.this, SignInActivity.class);
        startActivity(it);
    }

    public void SignUp(View view){
        String name = this.editName.getText().toString();
        String email = this.editEmail.getText().toString();
        String password = this.editPassword.getText().toString();
        String password2 = this.editPassword2.getText().toString();

        if(email.equals("")|| password.equals("") ){
            Toast toast = Toast.makeText(this,"Preencha email/senha", Toast.LENGTH_SHORT);
            toast.show();
        } else if (password != password2) {
            Toast toast = Toast.makeText(this,"As senhas devem ser compatíveis", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            User user = new User(name, email, password);

            if(auth.create(user, this) == null){
                Toast toast = Toast.makeText(this,"Erro ao criar usuário. Tente novamente",Toast.LENGTH_SHORT);
                toast.show();
            } else {
                Intent it = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(it);
            }
        }
    }

}
