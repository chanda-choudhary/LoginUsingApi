package com.example.user.loginusingapi.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.user.loginusingapi.R;

public class MainActivity extends AppCompatActivity {
    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.tv_name);
        Intent intent = getIntent();
        String userName = intent.getStringExtra("username");
        name.setText(userName);
    }
}
