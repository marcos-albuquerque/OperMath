package com.example.opermath;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VencedorActivity extends AppCompatActivity {

    private TextView vencendorMensagem;
    private TextView vencendorMensagem2;
    private  Button jogarNovamente;
    private  Button jogarNovamente2;
    private Button backMenu;
    private Button backMenu2;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vencedor);

        vencendorMensagem = findViewById(R.id.vencedorMensagem);
        vencendorMensagem2 = findViewById(R.id.vencedorMensagem2);
        jogarNovamente = findViewById(R.id.jogarNovamente);
        jogarNovamente2 = findViewById(R.id.jogarNovamente2);
        backMenu = findViewById(R.id.backMenu);
        backMenu2 = findViewById(R.id.backMenu2);

        mediaPlayer = MediaPlayer.create(this, R.raw.sound);

        // Quem venceu
        Intent intent = getIntent();
        if(intent.hasExtra(DueloActivity.JOGADOR1))
        {
            int jogador = intent.getIntExtra(DueloActivity.JOGADOR1, 0);
            //vencendorMensagem.setText("O jogador " + jogador + " venceu!");
            vencendorMensagem.setText("Você venceu o duelo!");
            vencendorMensagem2.setText("Não foi dessa vez");
        }
        if(intent.hasExtra(DueloActivity.JOGADOR2))
        {
            int jogador2 = intent.getIntExtra(DueloActivity.JOGADOR2, 0);
            vencendorMensagem2.setText("Você venceu o duelo!");
            vencendorMensagem.setText("Não foi dessa vez");
        }


        jogarNovamente.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        mediaPlayer.start();
                        Intent intent = new Intent(VencedorActivity.this, SecondActivity.class);
                        startActivity(intent);
                    }
                }
        );

        jogarNovamente2.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        mediaPlayer.start();
                        Intent intent = new Intent(VencedorActivity.this, SecondActivity.class);
                        startActivity(intent);
                    }
                }
        );


        backMenu.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view) {
                        mediaPlayer.start();
                        Intent intent = new Intent(VencedorActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }
                }
        );

        backMenu2.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view) {
                        mediaPlayer.start();
                        Intent intent = new Intent(VencedorActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }
                }
        );

    }
    @Override
    public void onBackPressed ()
    {
        Intent intent = new Intent(VencedorActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}
