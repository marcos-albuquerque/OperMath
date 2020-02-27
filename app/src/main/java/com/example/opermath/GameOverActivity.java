package com.example.opermath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {

    private TextView gameOver;
    private TextView showScore;
    private TextView scoreValue;

    private Button inicio;
    private Button jogarNov;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        gameOver = findViewById(R.id.gameOver);
        showScore = findViewById(R.id.showScore);
        scoreValue = findViewById(R.id.scoreValue);

        inicio = findViewById(R.id.inicio);
        jogarNov = findViewById(R.id.jogarNov);

    }
}
