package com.example.opermath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mult);

        final Button buttonMult1 = findViewById(R.id.buttonMult1);
        final Button buttonMult2 = findViewById(R.id.buttonMult2);
        final Button buttonMult3 = findViewById(R.id.buttonMult3);
        final Button buttonMult4 = findViewById(R.id.buttonMult4);
        final Toolbar toolBarMult = findViewById(R.id.toolBarMult);

        setSupportActionBar(toolBarMult);
        getSupportActionBar().setTitle("Multiplicação");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buttonMult1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MultActivity.this, Mult1Activity.class);
                        startActivity(intent);
                    }
                }
        );

        buttonMult2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MultActivity.this, Mult2Activity.class);
                        startActivity(intent);
                    }
                }
        );

        buttonMult3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MultActivity.this, Mult3Activity.class);
                        startActivity(intent);
                    }
                }
        );

        buttonMult4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MultActivity.this, Mult4Activity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}
