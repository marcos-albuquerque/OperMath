package com.example.opermath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class AdicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adic);

        final Button buttonAdic1 = findViewById(R.id.buttonAdic1);
        final Button buttonAdic2 = findViewById(R.id.buttonAdic2);
        final Toolbar toolBarAdic = findViewById(R.id.toolBarAdic);

        setSupportActionBar(toolBarAdic);
        getSupportActionBar().setTitle("Adição");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buttonAdic1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(AdicActivity.this, Adic1Activity.class);
                        startActivity(intent);
                    }
                }
        );

        buttonAdic2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(AdicActivity.this, Adic2Activity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}
