package com.example.opermath;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameOverActivity extends AppCompatActivity {

    private TextView gameOver;
    private TextView showScore;

    private Button inicio;
    private Button jogarNov;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        gameOver = findViewById(R.id.gameOver);
        showScore = findViewById(R.id.showScore);

        inicio = findViewById(R.id.inicio);
        jogarNov = findViewById(R.id.jogarNov);

        mediaPlayer = MediaPlayer.create(this, R.raw.sound);

        Intent intentReceptor = getIntent();

        Bundle parametros = intentReceptor.getExtras();

        int record = parametros.getInt("key_record");

        showScore.setText("score: " + record );

        inicio.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                            mediaPlayer.start();
                            Intent intent = new Intent( GameOverActivity.this, HomeActivity.class);
                            startActivity(intent);
                    }
                }
        );
        jogarNov.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        mediaPlayer.start();
                        Intent intent = new Intent( GameOverActivity.this, Second2Activity.class);
                        startActivity(intent);
                    }
                }
        );

    }
    @Override
    public void onBackPressed (){
        Intent intent = new Intent(GameOverActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}
