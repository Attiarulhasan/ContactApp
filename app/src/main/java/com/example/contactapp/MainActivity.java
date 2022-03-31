package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
       EditText name, email,number;
       Button insert, view;
       DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.et_name);
        email=findViewById(R.id.et_email);
        number=findViewById(R.id.et_number);
        DB= new DBHelper(this);


        insert=findViewById(R.id.btn_insert);
        view=findViewById(R.id.btn_ViewData);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,userList.class));
            }
        });

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTEXT= name.getText().toString();
                String emailTEXT= email.getText().toString();
                String numberTEXT= number.getText().toString();

                boolean checkinsertdata= DB.insertData(nameTEXT,emailTEXT,numberTEXT);
                if(checkinsertdata==true){
                    Toast.makeText(MainActivity.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "please fill out above fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}