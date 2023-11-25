package com.example.contact_contracting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    EditText login_username,login_password;
    Button login_button, new_user_button;
  DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
//        requestWindowFeature(Window.FEATURE_NO_TITLE); // for hiding title
//
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);



        login_username = findViewById(R.id.login_username);
        login_password = findViewById(R.id.login_password);
        login_button = findViewById(R.id.login_button);
        new_user_button = findViewById(R.id.new_user_button);
        DB = new DBHelper(this);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = login_username.getText().toString();
                String pass = login_password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(MainActivity.this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(MainActivity.this, "Signed in successfully", Toast.LENGTH_SHORT).show();
                        Intent I4  = new Intent(getApplicationContext(), HomeActivity.class);
                        I4.putExtra("username1",user);
                        startActivity(I4);
                        finish();
                    }else{
                        Toast.makeText(MainActivity.this, "Invalid Username or Password !!", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        new_user_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I2 = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(I2);

            }
        });

    }
}