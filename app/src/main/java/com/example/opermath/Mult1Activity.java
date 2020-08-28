package com.example.opermath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class Mult1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mult1);

        final Toolbar toolBarMult1 = findViewById(R.id.toolBarMult1);
        final TextView textViewMult1 = findViewById(R.id.textViewMult1);

        setSupportActionBar(toolBarMult1);
        getSupportActionBar().setTitle("Multiplicando por 10, 100, ...");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}