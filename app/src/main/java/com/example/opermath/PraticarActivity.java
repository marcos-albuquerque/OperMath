package com.example.opermath;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.opermath.nivel.INivel;
import com.example.opermath.nivel.IScore;
import com.example.opermath.nivel.NivelDificil;
import com.example.opermath.nivel.NivelFacil;
import com.example.opermath.nivel.NivelMedio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class PraticarActivity extends AppCompatActivity
{

    public PraticarActivity()
    {
    }

    private List<Character> operacoes = new ArrayList<>();

    public static String JOGADOR = "Jogador";
    public static char OPERACAO_ADICAO = '+';
    public static char OPERACAO_SUBTRACAO = '-';
    public static char OPERACAO_MULTIPLICACAO = 'x';
    public static char OPERACAO_DIVISAO = '/';

    private TextView score;
    private TextView operando1;
    private TextView operando2;
    private TextView operador;

    private Button answer1;
    private Button answer2;
    private Button answer3;
    private int ponto1;
    private INivel nivel;

    private boolean fecharPraticar = false;

    ProgressBar regressBar;
    int counter = 100; // contador do progressbar

    MediaPlayer mediaPlayer3;
    MediaPlayer mediaPlayer4;

    List<Button> buttonList;

    int ponto;
    ///private INivel nivelp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_praticar);

        score = (TextView) findViewById(R.id.score);
        operando1 = findViewById(R.id.operando1);
        operando2 = findViewById(R.id.operando2);
        operador = findViewById(R.id.operador);

        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);

        buttonList = new ArrayList<>();
        buttonList.add(answer1);
        buttonList.add(answer2);
        buttonList.add(answer3);

        mediaPlayer3 = MediaPlayer.create(this, R.raw.correct2);
        mediaPlayer4 = MediaPlayer.create(this, R.raw.erro);

        Intent second2 = getIntent();

        if(second2.hasExtra(Second2Activity.ADICAO_SELECIONADO) && second2.getBooleanExtra(Second2Activity.ADICAO_SELECIONADO, false) == true)
        {
            //Toast.makeText(getApplicationContext(), "Adicao selecionado.", Toast.LENGTH_LONG).show();
            operacoes.add(OPERACAO_ADICAO);
        }
        if(second2.hasExtra(Second2Activity.SUBTRACAO_SELECIONADO) && second2.getBooleanExtra(Second2Activity.SUBTRACAO_SELECIONADO, false) == true)
        {
            operacoes.add(OPERACAO_SUBTRACAO);
        }
        if(second2.hasExtra(Second2Activity.MULTIPLICACAO_SELECIONADO) && second2.getBooleanExtra(Second2Activity.MULTIPLICACAO_SELECIONADO, false) == true)
        {
            operacoes.add(OPERACAO_MULTIPLICACAO);
        }
        if(second2.hasExtra(Second2Activity.DIVISAO_SELECIONADO) && second2.getBooleanExtra(Second2Activity.DIVISAO_SELECIONADO, false) == true)
        {
            operacoes.add(OPERACAO_DIVISAO);
        }

        //Toast.makeText(getApplicationContext(), "Divisão selecionado." + second2.getBooleanExtra(SecondActivity.DIVISAO_SELECIONADO, false), Toast.LENGTH_LONG).show();

        ponto = 0;

        score.setText("" + 0);
        addActionToButtons2();
        nextProblem();
        regress();

    }

    public void regress()
    {
        regressBar = (ProgressBar) findViewById(R.id.regressBar);

        final Timer t = new Timer();
        TimerTask tt = new TimerTask()
        {
            @Override
            public void run()
            {
                counter--;
                regressBar.setProgress(counter);

                //int record = Integer.parseInt(score.getText().toString());

                if(counter == 0)
                {
                    SharedPreferences preferences = getSharedPreferences("PREFS",  0);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putInt(IScore.ULTIMO_SCORE, ponto);
                    editor.apply();

                    Intent intent2 = new Intent(PraticarActivity.this, GameOverActivity.class);

                    startActivity(intent2);
                    t.cancel();
                    finish();
                }

                if(fecharPraticar)
                {
                    t.cancel();
                    finish();
                }
            }
        };

        t.schedule(tt, 0, 100);
    }

    private INivel getNewNivel(Intent second, char operacao)
    {
        if(second.hasExtra(SecondActivity.FACIL_SELECIONADO) && second.getBooleanExtra(SecondActivity.FACIL_SELECIONADO, false) == true)
        {
            return  new NivelFacil(operacao);
        }
        else if(second.hasExtra(SecondActivity.MEDIO_SELECIONADO) && second.getBooleanExtra(SecondActivity.MEDIO_SELECIONADO, false) == true)
        {
            return new NivelMedio(operacao);
        }
        else if(second.hasExtra(SecondActivity.DIFICIL_SELECIONADO) && second.getBooleanExtra(SecondActivity.DIFICIL_SELECIONADO, false) == true)
        {
            return new NivelDificil(operacao);
        }
        return null;
    }

    private void addActionToButtons2()
    {
        addEventToAnswerP(answer1);
        addEventToAnswerP(answer2);
        addEventToAnswerP(answer3);
    }

    private void addEventToAnswerP(final Button answer)
    {
        answer.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        if(answer.getText().equals(""+nivel.answer()))
                        {
                            mediaPlayer3.start();

                            if(buttonList.contains(answer))
                            {
                                ponto++;
                                score.setText("" + ponto);
                                counter = Math.min(100, counter + 15);
                                nextProblem();
                            }
                            // Toast.makeText(getApplicationContext(), "Resposta correta selecionada.", Toast.LENGTH_LONG).show();
                        } else
                            {
                                mediaPlayer4.start();

                                if(buttonList.contains(answer))
                                {
                                    ponto = Math.max(0, ponto-1);
                                    score.setText("" + ponto);
                                    nextProblem();
                                }
                                //Toast.makeText(getApplicationContext(), "Resposta incorreta selecionada."+answer.getText(), Toast.LENGTH_LONG).show();
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

        operando1.setText("" + a);
        operando2.setText("" + b);
        operador.setText("" + operacaonivel);

        int indice = random.nextInt(3);
        int indice2 = random.nextInt(2);
        int primeiro = -1;
        int segundo = -1;

        List<Button> viewList = new ArrayList<>();
        viewList.add(answer1);
        viewList.add(answer2);
        viewList.add(answer3);

        if(indice == 0)
        {
            answer1.setText("" + nivel.answer());
            if(indice2 == 0)
            {
                primeiro = 2;
                segundo = 3;
            } else
                {
                primeiro = 3;
                segundo = 2;
                }

        }
        if(indice == 1)
        {
            answer2.setText("" + nivel.answer());
            if(indice2 == 0)
            {
                primeiro = 1;
                segundo = 3;
            } else
                {
                primeiro = 3;
                segundo = 1;
                }
        }
        if(indice == 2)
        {
            answer3.setText("" + nivel.answer());
            if(indice2 == 0)
            {
                primeiro = 1;
                segundo = 2;
            } else
                {
                primeiro = 2;
                segundo = 1;
                }
        }
        List<Integer> valores = new ArrayList<>();
        valores.add(nivel.answer());
        INivel nivel2 = getNewNivel(getIntent(), operacao);
        int valor = nivel2.getRandom();

        while(valores.contains(valor))
        {
            valor = nivel2.getRandom();
        }

        viewList.get(primeiro - 1).setText("" + valor);
        valores.add(valor);
        valor = nivel2.getRandom();

        while(valores.contains(valor))
        {
            valor = nivel2.getRandom();
        }

        viewList.get(segundo -1).setText("" + valor);
    }

    @Override
    public void onBackPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Você tem certeza que quer parar de praticar?")
                .setCancelable(false)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        fecharPraticar = true;
                        Intent intent = new Intent(PraticarActivity.this, HomeActivity.class);
                        startActivity(intent);
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