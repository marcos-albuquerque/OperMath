package com.example.opermath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class Adic1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adic1);

        final Toolbar toolBarAdic1 = findViewById(R.id.toolBarAdic1);
        final TextView textViewAdic1 = findViewById(R.id.textViewAdic1);

        setSupportActionBar(toolBarAdic1);
        getSupportActionBar().setTitle("Esquerda para direita, Decomposição");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}