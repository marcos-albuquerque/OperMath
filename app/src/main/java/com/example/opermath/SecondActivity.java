package com.example.opermath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    // private TextView primeiroTextView;
    // private TextView segundoTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

      /*  primeiroTextView = (TextView) findViewById(R.id.textView);
        Random aleatorio1 = new Random ();
        int v1 = aleatorio1.nextInt(10);

        primeiroTextView.setText(v1+"");

        segundoTextView = (TextView) findViewById(R.id.textView2);
        Random aleatorio2 = new Random ();
        int v2 = aleatorio2.nextInt(10);

        segundoTextView.setText(v2+""); */


        RadioGroup radioGroup;

        radioGroup = findViewById(R.id.radioGroup);


    }
}