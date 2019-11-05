package com.example.opermath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

    private TextView placar;
    private TextView operando1;
    private TextView operando2;
    private TextView operador;
    private Button answer1;
    private Button answer2;
    private Button answer3;
    private int ponto1;
    private int ponto2;
    private INivel nivel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duelo);

        placar = findViewById(R.id.placar);
        operando1 = findViewById(R.id.operando1);
        operando2 = findViewById(R.id.operando2);
        operador = findViewById(R.id.operador);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);

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
        ponto1 = 0;
        ponto2 = 0;
        placar.setText("" + 0);
        addActionToButtons();
        nextProblem();

        /*Random random = new Random();
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
        segundo.setText("" + nivel2.getA());*/

    }

    private void addActionToButtons(){
        addEventToAnswer(answer1);
        addEventToAnswer(answer2);
        addEventToAnswer(answer3);
    }

    private void addEventToAnswer(final Button answer){
        answer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(answer.getText().equals(""+nivel.answer())){
                            ponto1 ++;
                            placar.setText("" + ponto1);
                            nextProblem();
                           // Toast.makeText(getApplicationContext(), "Resposta correta selecionada.", Toast.LENGTH_LONG).show();
                        } else {
                            ponto1 --;
                            placar.setText("" + ponto1);
                            nextProblem();
                            //Toast.makeText(getApplicationContext(), "Resposta incorreta selecionada."+answer.getText(), Toast.LENGTH_LONG).show();
                        }

                    }
                }
        );
    }

    private void nextProblem(){
        Random random = new Random();
        char operacao = operacoes.get(random.nextInt(operacoes.size()));
        nivel = new NivelFacil(operacao);
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
        List<Integer> valores = new ArrayList<>();
        valores.add(nivel.answer());
        INivel nivel2 = new NivelFacil(operacao);
        int valor = nivel2.getA();
        while(valores.contains(valor)){
            valor = nivel2.getA();
        }
        primeiro.setText("" + valor);
        valores.add(valor);
        valor = nivel2.getA();
        while(valores.contains(valor)){
            valor = nivel2.getA();
        }
        segundo.setText("" + valor);

    }
}
