package com.example.opermath;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Integer.valueOf;

public class GameOverActivity extends AppCompatActivity {

    private TextView gameOver;
    private TextView showScore;

    private Button inicio;
    private Button jogarNov;
    private Button resetScore;

    int lastScore;
    int bestScore;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        gameOver = findViewById(R.id.gameOver);
        showScore = findViewById(R.id.showScore);

        inicio = findViewById(R.id.inicio);
        jogarNov = findViewById(R.id.jogarNov);
        resetScore = findViewById(R.id.resetScore);

        mediaPlayer = MediaPlayer.create(this, R.raw.sound);


        // Carrega o score antigo
        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        lastScore = preferences.getInt("Último score", 0);
        bestScore = preferences.getInt("Melhor score", 0);

        // Substitui se houver um score mais maior
        if(lastScore > bestScore)
        {
            bestScore = lastScore;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("Melhor score", bestScore);
            editor.apply();
        }

        // Exibe os scores
        showScore.setText("Último score: " + lastScore + "\n" + "Melhor score: " + bestScore);

        /*
        Intent intentReceptor = getIntent();

        Bundle parametros = intentReceptor.getExtras();

        int record = parametros.getInt("key_record");

        showScore.setText("Score: " + record );
        */

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
        resetScore.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(GameOverActivity.this);

                        builder.setMessage("Você tem certeza que quer resetar o Melhor score?")
                                .setCancelable(false)
                                .setPositiveButton("Sim", new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i)
                                    {
                                        bestScore = 0;
                                        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
                                        SharedPreferences.Editor editor = preferences.edit();
                                        editor.putInt("Melhor score", bestScore);
                                        editor.apply();
                                    }
                                })

                                .setNegativeButton("Não", new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i)
                                    {
                                        dialogInterface.cancel();
                                    }
                                });

                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
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