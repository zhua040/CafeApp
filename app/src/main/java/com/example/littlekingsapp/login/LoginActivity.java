package com.example.littlekingsapp.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.littlekingsapp.MainActivity;
import com.example.littlekingsapp.R;

public class LoginActivity extends AppCompatActivity {

    private EditText username, password;
    private Button btnLogin;

    private DBHelper userDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_layout);

        username = (EditText) findViewById(R.id.edt_username_login);
        password = (EditText) findViewById(R.id.edt_password_login);
        btnLogin = (Button) findViewById(R.id.btn_login);

        userDB = new DBHelper(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = username.getText().toString();
                String passWord = password.getText().toString();
                if(userName.equals("")||passWord.equals("")){
                    Toast.makeText(LoginActivity.this, "Please enter the credentials.", Toast.LENGTH_SHORT).show();
                }else {
                    Boolean login_result = userDB.checkusernamePassword(userName, passWord);
                    if (login_result == true){

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        //extra data with intent
                        intent.putExtra("user_name", userName);
                        startActivity(intent);

                    }else {
                        Toast.makeText(LoginActivity.this, "Invalid Creditial.", Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });

    }
}