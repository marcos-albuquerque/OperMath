package com.example.opermath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DueloActivity extends AppCompatActivity {

    private List<Character> operacoes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duelo);

        TextView placar = findViewById(R.id.placar);
        TextView operando1 = findViewById(R.id.operando1);
        TextView operando2 = findViewById(R.id.operando2);
        TextView operador = findViewById(R.id.operador);
        Button answer1 = findViewById(R.id.answer1);
        Button answer2 = findViewById(R.id.answer2);
        Button answer3 = findViewById(R.id.answer3);

        Intent second = getIntent();

        if(second.hasExtra(SecondActivity.ADICAO_SELECIONADO) && second.getBooleanExtra(SecondActivity.ADICAO_SELECIONADO, false) == true) {
            //Toast.makeText(getApplicationContext(), "Adicao selecionado.", Toast.LENGTH_LONG).show();
            operacoes.add('+');
        }
        if(second.hasExtra(SecondActivity.SUBTRACAO_SELECIONADO) && second.getBooleanExtra(SecondActivity.SUBTRACAO_SELECIONADO, false) == true) {
            operacoes.add('-');
        }
        if(second.hasExtra(SecondActivity.MULTIPLICACAO_SELECIONADO) && second.getBooleanExtra(SecondActivity.MULTIPLICACAO_SELECIONADO, false) == true) {
            operacoes.add('x');
        }
        if(second.hasExtra(SecondActivity.DIVISAO_SELECIONADO) && second.getBooleanExtra(SecondActivity.DIVISAO_SELECIONADO, false) == true) {
            operacoes.add('/');
        }
        /*if(second.hasExtra(SecondActivity.POTENCIACAO_SELECIONADO) && second.getBooleanExtra(SecondActivity.POTENCIACAO_SELECIONADO, false) == true) {
            operacoes.add('^');
        }
        if(second.hasExtra(SecondActivity.RADICIACAO_SELECIONADO) && second.getBooleanExtra(SecondActivity.RADICIACAO_SELECIONADO, false) == true) {
            operacoes.add('RAIZ');
        }*/

    }
}
