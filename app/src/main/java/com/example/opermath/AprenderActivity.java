package com.example.opermath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AprenderActivity extends AppCompatActivity {

    private Button adicButton;
    private Button subtButton;
    private Button multButton;
    private Button diviButton;
    private Button poteButton;
    private Button radiButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprender);

        adicButton = (Button) findViewById(R.id.button);
        subtButton = (Button) findViewById(R.id.button4);
        multButton = (Button) findViewById(R.id.button5);
        diviButton = (Button) findViewById(R.id.button6);
        poteButton = (Button) findViewById(R.id.button7);
        radiButton = (Button) findViewById(R.id.button8);

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

        poteButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(AprenderActivity.this, PoteActivity.class);
                        startActivity(intent);
                    }
                }
        );

        radiButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(AprenderActivity.this, RadiActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}
