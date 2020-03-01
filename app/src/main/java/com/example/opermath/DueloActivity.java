package com.example.opermath;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.opermath.nivel.INivel;
import com.example.opermath.nivel.NivelDificil;
import com.example.opermath.nivel.NivelFacil;
import com.example.opermath.nivel.NivelMedio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DueloActivity extends AppCompatActivity {

    public DueloActivity() {
    }

    private List<Character> operacoes = new ArrayList<>();

    public static String JOGADOR = "Jogador";
    public static char OPERACAO_ADICAO = '+';
    public static char OPERACAO_SUBTRACAO = '-';
    public static char OPERACAO_MULTIPLICACAO = 'x';
    public static char OPERACAO_DIVISAO = '/';

    private TextView placarj1;
    private TextView placarj2;
    private TextView operando1j1;
    private TextView operando1j2;
    private TextView operando2j1;
    private TextView operando2j2;
    private TextView operadorj1;
    private TextView operadorj2;

    private Button answer1j1;
    private Button answer1j2;
    private Button answer2j1;
    private Button answer2j2;
    private Button answer3j1;
    private Button answer3j2;

    MediaPlayer mediaPlayer3;
    MediaPlayer mediaPlayer4;

    List<Button> buttonListj1;
    List<Button> buttonListj2; //*

    private int ponto1;
    private int ponto2;
    private INivel nivel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duelo);

        placarj1 = findViewById(R.id.placarj1);
        operando1j1 = findViewById(R.id.operando1j1);
        operando2j1 = findViewById(R.id.operando2j1);
        operadorj1 = findViewById(R.id.operadorj1);
        answer1j1 = findViewById(R.id.answer1j1);
        answer2j1 = findViewById(R.id.answer3j1);
        answer3j1 = findViewById(R.id.answer2j1);

        placarj2 = findViewById(R.id.placarj2);
        operando1j2 = findViewById(R.id.operando1j2);
        operando2j2 = findViewById(R.id.operando2j2);
        operadorj2 = findViewById(R.id.operadorj2);
        answer1j2 = findViewById(R.id.answer1j2);
        answer2j2 = findViewById(R.id.answer3j2);
        answer3j2 = findViewById(R.id.answer2j2);

        buttonListj1 = new ArrayList<>();
        buttonListj1.add(answer1j1);
        buttonListj1.add(answer2j1);
        buttonListj1.add(answer3j1);

        buttonListj2 = new ArrayList<>(); //*
        buttonListj2.add(answer1j2);
        buttonListj2.add(answer2j2);
        buttonListj2.add(answer3j2);

        mediaPlayer3 = MediaPlayer.create(this, R.raw.correct);
        mediaPlayer4 = MediaPlayer.create(this, R.raw.erro);

        Intent second = getIntent();

        if(second.hasExtra(SecondActivity.ADICAO_SELECIONADO) && second.getBooleanExtra(SecondActivity.ADICAO_SELECIONADO, false) == true) {
            //Toast.makeText(getApplicationContext(), "Adicao selecionado.", Toast.LENGTH_LONG).show();
            operacoes.add(OPERACAO_ADICAO);
        }
        if(second.hasExtra(SecondActivity.SUBTRACAO_SELECIONADO) && second.getBooleanExtra(SecondActivity.SUBTRACAO_SELECIONADO, false) == true) {
            operacoes.add(OPERACAO_SUBTRACAO);
        }
        if(second.hasExtra(SecondActivity.MULTIPLICACAO_SELECIONADO) && second.getBooleanExtra(SecondActivity.MULTIPLICACAO_SELECIONADO, false) == true) {
            operacoes.add(OPERACAO_MULTIPLICACAO);
        }
        if(second.hasExtra(SecondActivity.DIVISAO_SELECIONADO) && second.getBooleanExtra(SecondActivity.DIVISAO_SELECIONADO, false) == true) {
            operacoes.add(OPERACAO_DIVISAO);
        }
        //Toast.makeText(getApplicationContext(), "Divisão selecionado." + second.getBooleanExtra(SecondActivity.DIVISAO_SELECIONADO, false), Toast.LENGTH_LONG).show();
        /*if(second.hasExtra(SecondActivity.POTENCIACAO_SELECIONADO) && second.getBooleanExtra(SecondActivity.POTENCIACAO_SELECIONADO, false) == true) {
            operacoes.add('^');
        }
        if(second.hasExtra(SecondActivity.RADICIACAO_SELECIONADO) && second.getBooleanExtra(SecondActivity.RADICIACAO_SELECIONADO, false) == true) {
            operacoes.add('RAIZ');
        }*/
        ponto1 = 0;
        ponto2 = 0;
        placarj1.setText("" + 0);
        placarj2.setText("" + 0);
        addActionToButtons();
        nextProblem();
    }

    private INivel getNewNivel(Intent second, char operacao)
    {
        if(second.hasExtra(SecondActivity.FACIL_SELECIONADO) && second.getBooleanExtra(SecondActivity.FACIL_SELECIONADO, false) == true) {
            return  new NivelFacil(operacao);
        }
        else if(second.hasExtra(SecondActivity.MEDIO_SELECIONADO) && second.getBooleanExtra(SecondActivity.MEDIO_SELECIONADO, false) == true) {
            return new NivelMedio(operacao);
        }
        else if(second.hasExtra(SecondActivity.DIFICIL_SELECIONADO) && second.getBooleanExtra(SecondActivity.DIFICIL_SELECIONADO, false) == true){
            return new NivelDificil(operacao);
        }
        return null;
    }

    private void addActionToButtons(){
        addEventToAnswer(answer1j1);
        addEventToAnswer(answer2j1);
        addEventToAnswer(answer3j1);

        addEventToAnswer(answer1j2);
        addEventToAnswer(answer2j2);
        addEventToAnswer(answer3j2);
    }

    private void addEventToAnswer(final Button answer){
        answer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(answer.getText().equals(""+nivel.answer()))
                        {

                            mediaPlayer3.start();

                            if(buttonListj1.contains(answer)) {
                                ponto1++;
                                placarj1.setText("" + ponto1);
                                nextProblem();
                            }
                            else{
                                ponto2++;
                                placarj2.setText("" + ponto2);
                                nextProblem();
                            }
                           // Toast.makeText(getApplicationContext(), "Resposta correta selecionada.", Toast.LENGTH_LONG).show();
                        } else
                            {
                                mediaPlayer4.start();

                                if(buttonListj1.contains(answer)) {
                                    ponto1--;
                                    placarj1.setText("" + ponto1);
                                    nextProblem();
                                }
                                else
                                    {
                                        ponto2--;
                                        placarj2.setText("" + ponto2);
                                        nextProblem();
                                    }
                                //Toast.makeText(getApplicationContext(), "Resposta incorreta selecionada."+answer.getText(), Toast.LENGTH_LONG).show();
                            }
                        if(ponto1 >= 10) {
                            //Toast.makeText(getApplicationContext(), "O jogador 1 venceu!.", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(DueloActivity.this, VencedorActivity.class);
                            intent.putExtra(JOGADOR, 1);
                            startActivity(intent);
                        }
                        else if (ponto2 >= 10){
                            //Toast.makeText(getApplicationContext(), "O jogador ic_launcher2 venceu!.", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(DueloActivity.this, VencedorActivity.class);
                            intent.putExtra(JOGADOR, 2);
                            startActivity(intent);
                        }
                    }
                }
        );
    }

    private void nextProblem()
    {
        Random random = new Random();
        char operacao = operacoes.get(random.nextInt(operacoes.size()));
        nivel = getNewNivel(getIntent(), operacao);
        //Toast.makeText(getApplicationContext(), "Adicao selecionado."+nivel.getA(), Toast.LENGTH_LONG).show();


        int a = nivel.getA();
        int b = nivel.getB();
        char operacaonivel = nivel.getOperacao();

        operando1j1.setText("" + a);
        operando1j2.setText("" + a);
        operando2j1.setText("" + b);
        operando2j2.setText("" + b);
        operadorj1.setText("" + operacaonivel);
        operadorj2.setText("" + operacaonivel);

        int indice = random.nextInt(3);
        int indice2 = random.nextInt(2);
        int primeiro = -1;
        int segundo = -1;

        List<Button> viewList = new ArrayList<>();
        viewList.add(answer1j1);
        viewList.add(answer2j1);
        viewList.add(answer3j1);

        List<Button> viewList2 = new ArrayList<>();
        viewList2.add(answer1j2);
        viewList2.add(answer2j2);
        viewList2.add(answer3j2);


        if(indice == 0){
            answer1j1.setText("" + nivel.answer());
            answer1j2.setText("" + nivel.answer());
            if(indice2 == 0){
                primeiro = 2;
                segundo = 3;
            } else{
                primeiro = 3;
                segundo = 2;
            }

        }
        if(indice == 1){
            answer2j1.setText("" + nivel.answer());
            answer2j2.setText("" + nivel.answer());
            if(indice2 == 0){
                primeiro = 1;
                segundo = 3;
            } else{
                primeiro = 3;
                segundo = 1;
            }
        }
        if(indice == 2){
            answer3j1.setText("" + nivel.answer());
            answer3j2.setText("" + nivel.answer());
            if(indice2 == 0){
                primeiro = 1;
                segundo = 2;
            } else{
                primeiro = 2;
                segundo = 1;
            }
        }
        List<Integer> valores = new ArrayList<>();
        valores.add(nivel.answer());
        INivel nivel2 = getNewNivel(getIntent(), operacao);
        int valor = nivel2.getRandom();
        while(valores.contains(valor)){
            valor = nivel2.getRandom();
        }
        viewList.get(primeiro - 1).setText("" + valor);
        viewList2.get(primeiro -1).setText("" + valor);
        valores.add(valor);
        valor = nivel2.getRandom();
        while(valores.contains(valor)){
            valor = nivel2.getRandom();
        }
        viewList.get(segundo -1).setText("" + valor);
        viewList2.get(segundo -1).setText("" + valor);

    }
}
