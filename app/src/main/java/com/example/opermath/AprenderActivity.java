package com.example.opermath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class AprenderActivity extends AppCompatActivity {

    private Button adicButton;
    private Button subtButton;
    private Button multButton;
    private Button diviButton;
    //private Toolbar toolBarLearn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprender);

        adicButton = findViewById(R.id.button);
        subtButton = findViewById(R.id.button4);
        multButton = findViewById(R.id.button5);
        diviButton = findViewById(R.id.button6);
        final Toolbar toolBarLearn = findViewById(R.id.toolBarLearn);

        setSupportActionBar(toolBarLearn);
        getSupportActionBar().setTitle("Aprender");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adicButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(AprenderActivity.this, AdicActivity.class);
                        startActivity(intent);
                    }
                }
        );

        subtButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(AprenderActivity.this, SubtActivity.class);
                        startActivity(intent);
                    }
                }
        );

        multButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(AprenderActivity.this, MultActivity.class);
                        startActivity(intent);
                    }
                }
        );

        diviButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(AprenderActivity.this, DiviActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }

    @Override
    public void onBackPressed (){
        Intent intent = new Intent(AprenderActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}
