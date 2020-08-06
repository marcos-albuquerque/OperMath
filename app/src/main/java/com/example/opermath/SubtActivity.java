package com.example.opermath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class SubtActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subt);

        final Button buttonSubt1 = findViewById(R.id.buttonSubt1);
        final Button buttonSubt2 = findViewById(R.id.buttonSubt2);
        final Toolbar toolBarSubt = findViewById(R.id.toolBarSubt);

        setSupportActionBar(toolBarSubt);
        getSupportActionBar().setTitle("Subtração");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buttonSubt1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(SubtActivity.this, Subt1Activity.class);
                        startActivity(intent);
                    }
                }
        );

        buttonSubt2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(SubtActivity.this, Subt2Activity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}
