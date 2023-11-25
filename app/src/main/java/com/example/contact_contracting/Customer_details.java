package com.example.contact_contracting;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class Customer_details extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);

        TextView cont_name = findViewById(R.id.contractor_name_textview);
        TextView cont_add = findViewById(R.id.contractor_address_textview);
        String str = getIntent().getStringExtra("contractor_address");
        String str1 = getIntent().getStringExtra("contractor_name");
       cont_name.setText(str1);
       cont_add.setText(str);

      Button  place_order = findViewById(R.id.customer_confirm_button);



       place_order.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View view) {
               EditText customer_name = findViewById(R.id.customer_name_editview);
               EditText customer_phone = findViewById(R.id.customer_phone_edittext);
               EditText  customer_address = findViewById(R.id.customer_address_edittext);
               String cust_name= customer_name.getText().toString();
               String cust_phone = customer_phone.getText().toString();
               String cust_address = customer_address.getText().toString();

               String cust_details = cust_phone+"\n"+cust_address;

               if(cust_name.equals("")||cust_phone.equals("")||cust_address.equals(""))
                   Toast.makeText(Customer_details.this, "Please fill in all the required fields", Toast.LENGTH_SHORT).show();
               else {
                   Intent intent = new Intent(Intent.ACTION_SENDTO);
                   intent.setData(Uri.parse("mailto:"));
                   final Intent emailIntent = new Intent(Intent.ACTION_SEND);
                   emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"i.28.kanhaiya@gmail.com"});
                   emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Contact_Contracting App- Order Placed for : " + cust_name);
                   emailIntent.putExtra(Intent.EXTRA_TEXT, "Customer_Mobile_Number:: "+cust_phone+"\n\nCustomer_Full Address ::"+cust_address);
                   emailIntent.setSelector(intent);

                   startActivity(Intent.createChooser(emailIntent, "Send email..."));
               }

//               intent.putExtra(Intent.EXTRA_SUBJECT,cust_name);
//               intent.putExtra(Intent.EXTRA_TEXT,cust_details);
//
////               intent.putExtra(Intent.EXTRA_CC,"kaha@gmail.com");
//
//
//               if (intent.resolveActivity(getPackageManager()) != null) {
//                   startActivity(intent);
//               }
           }
       });





    }
}