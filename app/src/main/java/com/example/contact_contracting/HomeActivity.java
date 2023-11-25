package com.example.contact_contracting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    EditText username;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//       username= findViewById(R.id.login_username);
      textView = findViewById(R.id.textView);
//
//       String user = username.getText().toString();
//       textView.setText(user);

        Intent intent = getIntent();
        String str = intent.getStringExtra("username1");
        textView.setText(str);

        TextView plumber = findViewById(R.id.plumber);
        plumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "Welcome to Plumber Section!!", Toast.LENGTH_SHORT).show();
                Intent plumberintent = new Intent(HomeActivity.this,PlumberActivity.class);
                startActivity(plumberintent);
            }
        });

        TextView carpentry = findViewById(R.id.carpentry);
        carpentry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "Welcome to Carpenter Section!!", Toast.LENGTH_SHORT).show();
                Intent carpenterintent = new Intent(HomeActivity.this,CarpenterActivity.class);
                startActivity(carpenterintent);

            }
        });

        TextView electrician = findViewById(R.id.electrician);
        electrician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "Welcome to Electrician Section!!", Toast.LENGTH_SHORT).show();
                Intent electricianintent = new Intent(HomeActivity.this,ElectricianActivity.class);
                startActivity(electricianintent);
            }
        });
        TextView labourer = findViewById(R.id.labourers);
        labourer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "Welcome to Labour Section!!", Toast.LENGTH_SHORT).show();
                Intent labourerintent = new Intent(HomeActivity.this,LabourersActivity.class);
                startActivity(labourerintent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.main_menu,menu);
            return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.logout){
            Toast.makeText(HomeActivity.this, "Log out Successfully!!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(HomeActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

       // super.onBackPressed();
    }
}