package com.example.opermath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class Subt1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subt1);

        final Toolbar toolBarSubt1 = findViewById(R.id.toolBarSubt1);
        final TextView textViewSubt1 = findViewById(R.id.textViewSubt1);

        setSupportActionBar(toolBarSubt1);
        getSupportActionBar().setTitle("Esquerda para direita, Decomposição");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}