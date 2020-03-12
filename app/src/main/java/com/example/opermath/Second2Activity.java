package com.example.opermath;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Second2Activity extends AppCompatActivity {

    public static String ADICAO_SELECIONADO = "ADICAO_SELECIONADO";
    public static String SUBTRACAO_SELECIONADO = "SUBTRACAO_SELECIONADO";
    public static String MULTIPLICACAO_SELECIONADO = "MULTIPLICACAO_SELECIONADO";
    public static String DIVISAO_SELECIONADO = "DIVISAO_SELECIONADO";
    public static String POTENCIACAO_SELECIONADO = "POTENCIACAO_SELECIONADO";
    public static String RADICIACAO_SELECIONADO = "RADICIACAO_SELECIONADO";
    public static String FACIL_SELECIONADO = "FACIL_SELECIONADO";
    public static String MEDIO_SELECIONADO = "MEDIO_SELECIONADO";
    public static String DIFICIL_SELECIONADO = "DIFICIL_SELECIONADO";

    MediaPlayer mediaPlayer;
    MediaPlayer mediaPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        final RadioGroup radioGroup = findViewById(R.id.radioGroup);
        final CheckBox adicao = findViewById(R.id.checkBoxAdicao);
        final CheckBox subtracao = findViewById(R.id.checkBoxSubtracao);
        final CheckBox multiplicacao = findViewById(R.id.checkBoxMultiplicacao);
        final CheckBox divisao = findViewById(R.id.checkBoxDivisao);
        final Button buttonIniciar = findViewById(R.id.buttonIniciar);
        final RadioButton facil = findViewById(R.id.radioButtonFacil);
        final RadioButton medio = findViewById(R.id.radioButtonMedio);
        final RadioButton dificil = findViewById(R.id.radioButtonDificil);
        final Button iniciar = findViewById(R.id.buttonIniciar);
        final Toolbar toolBar2 = findViewById(R.id.toolBar2);

        mediaPlayer = MediaPlayer.create(this, R.raw.sound);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.sound2);

        setSupportActionBar(toolBar2);
        getSupportActionBar().setTitle("Opções do Jogo");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //toolBar2.setTitleTextColor(0xFFFFFFFF);


        buttonIniciar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if ((adicao.isChecked() || subtracao.isChecked() ||
                                multiplicacao.isChecked() || divisao.isChecked()) && (facil.isChecked() || medio.isChecked()
                                || dificil.isChecked()))
                        {
                            //Toast.makeText(getApplicationContext(), "Que o duelo comece!", Toast.LENGTH_LONG).show();
                            mediaPlayer.start();
                            Intent intent = new Intent( Second2Activity.this, PraticarActivity.class);
                            intent.putExtra(ADICAO_SELECIONADO, adicao.isChecked());
                            intent.putExtra(SUBTRACAO_SELECIONADO, subtracao.isChecked());
                            intent.putExtra(MULTIPLICACAO_SELECIONADO, multiplicacao.isChecked());
                            intent.putExtra(DIVISAO_SELECIONADO, divisao.isChecked());
                            intent.putExtra(FACIL_SELECIONADO, facil.isChecked());
                            intent.putExtra(MEDIO_SELECIONADO, medio.isChecked());
                            intent.putExtra(DIFICIL_SELECIONADO, dificil.isChecked());
                            //Toast.makeText(getApplicationContext(), "Difícil foi verificado ." + dificil.isChecked(), Toast.LENGTH_LONG).show();

                            startActivity(intent);
                        }
                        else {
                            mediaPlayer2.start();
                            Toast.makeText(getApplicationContext(), "Selecione um nível e pelo menos uma operação.", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }

    @Override
    public void onBackPressed (){
        Intent intent = new Intent(Second2Activity.this, HomeActivity.class);
        startActivity(intent);
    }

}