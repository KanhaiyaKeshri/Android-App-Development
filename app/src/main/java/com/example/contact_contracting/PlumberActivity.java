package com.example.contact_contracting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlumberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<Contracter> contracters = new ArrayList<>();

        contracters.add(new Contracter("Sam group of Plumber","8745250000 , sam_group_plumber@gmail",R.drawable.img_15));
        contracters.add(new Contracter("KK group of Plumber","9745250000 , kk_group_plumber@gmail",R.drawable.img_13));
        contracters.add(new Contracter("SK group of Plumber","7845250000 , sk_group_plumber@gmail",R.drawable.img_14));
        contracters.add(new Contracter("Khanna group of Plumber","6585250000 , khanna_group_plumber@gmail",R.drawable.img_13));
        contracters.add(new Contracter("Raj group of Plumber","9995250000 , raj_group_plumber@gmail",R.drawable.img_15));

        ContracterAdapter adapter = new ContracterAdapter(this,contracters,R.color.default_color);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView cname = view.findViewById(R.id.contracters_name);
                TextView caddress = view.findViewById(R.id.contracters_address);
              //  Intent intent1 = new Intent(getApplicationContext(),Customer_details.class);
                Intent intent = new Intent(getApplicationContext(),Customer_details.class);
                intent.putExtra("contractor_address",caddress.getText().toString());
                intent.putExtra("contractor_name",cname.getText().toString());
                startActivity(intent);

            }
        });


    }
}