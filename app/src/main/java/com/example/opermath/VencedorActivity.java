package com.example.opermath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VencedorActivity extends AppCompatActivity {

    private TextView vencendorMensagem;
    private  Button jogarNovamente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vencedor);

        vencendorMensagem = findViewById(R.id.vencedorMensagem);
        jogarNovamente = findViewById(R.id.jogarNovamente);

        Intent intent = getIntent();
        if(intent.hasExtra(DueloActivity.JOGADOR)) {
            int jogador = intent.getIntExtra(DueloActivity.JOGADOR, 0);
            vencendorMensagem.setText("O jogador " + jogador + " venceu!");
        }

        jogarNovamente.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(VencedorActivity.this, SecondActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }
    @Override
    public void onBackPressed (){
        Intent intent = new Intent(VencedorActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
