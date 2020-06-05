package com.example.opermath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class Adic2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adic2);

        final Toolbar toolBarAdic2 = findViewById(R.id.toolBarAdic2);

        setSupportActionBar(toolBarAdic2);
        getSupportActionBar().setTitle("Arredondamento");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}