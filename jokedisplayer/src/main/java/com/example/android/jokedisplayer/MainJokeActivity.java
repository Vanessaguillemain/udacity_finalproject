package com.example.android.jokedisplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainJokeActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_joke);

        Intent intent = getIntent();
        if(intent.hasExtra(Intent.EXTRA_TEXT)) {
            String joke = intent.getStringExtra(Intent.EXTRA_TEXT);
            TextView tvJoke = findViewById(R.id.tvJoke);
            tvJoke.setText(joke);
        }
    }
}
