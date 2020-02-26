package com.example.opermath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button duelarButton;
    private Button praticarButton;
    private Button aprenderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        duelarButton = (Button) findViewById(R.id.button1);
        praticarButton = (Button) findViewById(R.id.button2);
        aprenderButton = (Button) findViewById(R.id.button3);


        duelarButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        startActivity(intent);
                    }
                }
        );

        praticarButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, Second2Activity.class);
                        startActivity(intent);
                    }
                }
        );
        aprenderButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, AprenderActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}
