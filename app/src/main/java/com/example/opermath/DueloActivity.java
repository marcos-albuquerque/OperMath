package com.example.opermath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.opermath.nivel.INivel;
import com.example.opermath.nivel.NivelFacil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

        Random random = new Random();
        char operacao = operacoes.get(random.nextInt(operacoes.size()));
        INivel nivel = new NivelFacil(operacao);
        //Toast.makeText(getApplicationContext(), "Adicao selecionado."+nivel.getA(), Toast.LENGTH_LONG).show();

        operando1.setText("" + nivel.getA());
        operando2.setText("" + nivel.getB());
        operador.setText("" + nivel.getOperacao());

        int indice = random.nextInt(3);
        int indice2 = random.nextInt(2);
        Button primeiro = null;
        Button segundo = null;


        if(indice == 0){
            answer1.setText("" + nivel.answer());
            if(indice2 == 0){
                primeiro = answer2;
                segundo = answer3;
            } else{
                primeiro = answer3;
                segundo = answer2;
            }

        }
        if(indice == 1){
            answer2.setText("" + nivel.answer());
            if(indice2 == 0){
                primeiro = answer1;
                segundo = answer3;
            } else{
                primeiro = answer3;
                segundo = answer1;
            }
        }
        if(indice == 2){
            answer3.setText("" + nivel.answer());
            if(indice2 == 0){
                primeiro = answer1;
                segundo = answer2;
            } else{
                primeiro = answer2;
                segundo = answer1;
            }
        }
        INivel nivel2 = new NivelFacil(operacao);
        primeiro.setText("" + nivel2.getA());
        segundo.setText("" + nivel2.getA());

    }
}
