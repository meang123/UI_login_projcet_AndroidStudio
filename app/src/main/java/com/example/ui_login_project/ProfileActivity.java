package com.example.ui_login_project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.active_profile);

        TextView text_name = findViewById(R.id.username);
        TextView text_email = findViewById(R.id.useremail);

        Intent i = getIntent();

        String temp = i.getStringExtra("name");
        String temp2 = i.getStringExtra("email");

        text_name.setText("Welcome "+temp);
        text_email.setText(temp2);


    }

}
