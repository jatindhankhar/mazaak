package com.udacity.gradle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class JokeActivity extends AppCompatActivity {
    public static final String JOKE_KEY = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        TextView jokeview = (TextView)findViewById(R.id.jokeView);
        jokeview.setText(getIntent().getStringExtra(JOKE_KEY));
    }
}
