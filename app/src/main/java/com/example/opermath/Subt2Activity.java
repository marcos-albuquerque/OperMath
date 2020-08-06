package com.example.opermath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class Subt2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subt2);

        final Toolbar toolBarSubt2 = findViewById(R.id.toolBarSubt2);
        final TextView textViewSubt2 = findViewById(R.id.textViewSubt2);

        setSupportActionBar(toolBarSubt2);
        getSupportActionBar().setTitle("Arredondamento");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}