package com.example.littlekingsapp.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.littlekingsapp.R;

public class SignUp_Main extends AppCompatActivity {

    EditText usename, password, rePassword;
    Button btnSignUp, btnSignIn;
    DBHelper userLoginDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main_layout);

        //Casting
        usename = (EditText) findViewById(R.id.et_userName);
        password = (EditText) findViewById(R.id.et_password);
        rePassword = (EditText) findViewById(R.id.et_repeatPassword);

        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);

        userLoginDB = new DBHelper(this);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = usename.getText().toString();
                String psw = password.getText().toString();
                String repsw = rePassword.getText().toString();

                if (user.equals("")||psw.equals("")||repsw.equals("")){
                    Toast.makeText(SignUp_Main.this, "Please fill up all fields.", Toast.LENGTH_SHORT).show();
                } else {
                    if (psw.equals(repsw)){
                        //check user already exist or not
                        Boolean checkUserResult =  userLoginDB.checkusername(user);
                        if (checkUserResult == false){
                            //new user can be created
                            Boolean registrationResult = userLoginDB.insertData(user, psw);
                            if(registrationResult == true){
                                Toast.makeText(SignUp_Main.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignUp_Main.this, LoginActivity.class);
                                startActivity(intent);

                            }else {
                                Toast.makeText(SignUp_Main.this, "Registration fail!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(SignUp_Main.this, "User is already Exists.\n please Sign-In.", Toast.LENGTH_SHORT).show();

                        }

                    }
                    else{
                        Toast.makeText(SignUp_Main.this, "Password not matching.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp_Main.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}