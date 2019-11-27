package com.example.opermath;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    public static String ADICAO_SELECIONADO = "ADICAO_SELECIONADO";
    public static String SUBTRACAO_SELECIONADO = "SUBTRACAO_SELECIONADO";
    public static String MULTIPLICACAO_SELECIONADO = "MULTIPLICACAO_SELECIONADO";
    public static String DIVISAO_SELECIONADO = "DIVISAO_SELECIONADO";
    public static String POTENCIACAO_SELECIONADO = "POTENCIACAO_SELECIONADO";
    public static String RADICIACAO_SELECIONADO = "RADICIACAO_SELECIONADO";
    public static String FACIL_SELECIONADO = "FACIL_SELECIONADO";
    public static String MEDIO_SELECIONADO = "MEDIO_SELECIONADO";
    public static String DIFICIL_SELECIONADO = "DIFICIL_SELECIONADO";

    // private TextView primeiroTextView;
    // private TextView segundoTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final RadioGroup radioGroup = findViewById(R.id.radioGroup);
        final CheckBox adicao = findViewById(R.id.checkBoxAdicao);
        final CheckBox subtracao = findViewById(R.id.checkBoxSubtracao);
        final CheckBox multiplicacao = findViewById(R.id.checkBoxMultiplicacao);
        final CheckBox divisao = findViewById(R.id.checkBoxDivisao);
        final Button buttonDuelar = findViewById(R.id.buttonDuelar);
        final RadioButton facil = findViewById(R.id.radioButtonFacil);
        final RadioButton medio = findViewById(R.id.radioButtonMedio);
        final RadioButton dificil = findViewById(R.id.radioButtonDificil);
        final Button duelar = findViewById(R.id.buttonDuelar);

      /*  primeiroTextView = (TextView) findViewById(R.id.textView);
        Random aleatorio1 = new Random ();
        int v1 = aleatorio1.nextInt(10);

        primeiroTextView.setText(v1+"");

        segundoTextView = (TextView) findViewById(R.id.textView2);
        Random aleatorio2 = new Random ();
        int v2 = aleatorio2.nextInt(10);

        segundoTextView.setText(v2+""); */

        buttonDuelar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if ((adicao.isChecked() || subtracao.isChecked() ||
                                multiplicacao.isChecked() || divisao.isChecked()) && (facil.isChecked() || medio.isChecked()
                                || dificil.isChecked()))
                        {
                            //Toast.makeText(getApplicationContext(), "Que o duelo comece!", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent( SecondActivity.this, DueloActivity.class);
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
                            Toast.makeText(getApplicationContext(), "Selecione um nível e pelo menos uma operação.", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );

      /*  if (adicao.isSelected() || subtracao.isSelected() || multiplicacao.isSelected() ||
                divisao.isSelected() || potenciacao.isSelected() || radiciacao.isSelected()) {
            buttonDuelar.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(SecondActivity.this, DueloActivity.class);
                            startActivity(intent);

                        }
                    }
            );
        } */
    }


      /*  buttonDuelar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        abrirTelaDuelo();
                        if ((adicao.isSelected() || subtracao.isSelected() ||
                                multiplicacao.isSelected() || divisao.isSelected() ||
                                potenciacao.isSelected() || radiciacao.isSelected()) && (facil.isSelected() || medio.isSelected()
                                || dificil.isSelected()))
                        {
                            buttonDuelar.setOnClickListener(
                                    new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent( SecondActivity.this, DueloActivity.class);
                                            startActivity(intent);
                                        }
                                    }
                            );
                        }

                        //Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        //startActivity(intent);
                    }
                }


   }*/
/*
    private void abrirTelaDuelo ()
   {
        if (adicao.isSelected() || subtracao.isSelected() ||
                multiplicacao.isSelected() || divisao.isSelected() ||
                potenciacao.isSelected() || radiciacao.isSelected()) {

        }
        else {
            Toast.makeText(getApplicationContext(), "Selecione pelo menos uma operação.", Toast.LENGTH_LONG).show();
        }

}
*/
}