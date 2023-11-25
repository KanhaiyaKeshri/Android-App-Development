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

public class RegisterActivity extends AppCompatActivity {

    EditText register_email_id, register_username, register_password, register_repassword;
    Button register,back_to_login;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();

        setContentView(R.layout.activity_register);
        register_email_id = findViewById(R.id.register_email_id);
        register_username = findViewById(R.id.register_username);
        register_password = findViewById(R.id.register_password);
        register_repassword = findViewById(R.id.register_reenter_password);
        register = findViewById(R.id.register_button);
        back_to_login = findViewById(R.id.back_to_login_button);
        DB = new DBHelper(this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rusername = register_username.getText().toString();
                String rpassword =  register_password.getText().toString();
                String remail_id = register_email_id.getText().toString();
                String rrepassword = register_repassword.getText().toString();

                if(rusername.equals("")|| rpassword.equals("")||remail_id.equals("")||rrepassword.equals(""))
                    Toast.makeText(RegisterActivity.this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
                else {
                    if(rpassword.equals(rrepassword)){
                        Boolean checkuser = DB.checkusername(rusername);

                        if(checkuser==false ){
                            Boolean insert = DB.insertData(rusername,rpassword,remail_id);
                            if(insert == true) {
                                Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();

                                Intent I3 = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(I3);
                                finish();
                            }
                            else{
                                Toast.makeText(RegisterActivity.this, "Registeration failed,Try Again!!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(RegisterActivity.this, "User already exists! Use different Username or Email Id", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(RegisterActivity.this, "Passwords did not match", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        back_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I1 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(I1);
                finish();

            }
        });
    }
}