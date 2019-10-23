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
        final CheckBox potenciacao = findViewById(R.id.checkBoxPotenciacao);
        final CheckBox radiciacao = findViewById(R.id.checkBoxRadiciacao);
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
                                multiplicacao.isChecked() || divisao.isChecked() ||
                                potenciacao.isChecked() || radiciacao.isChecked()) && (facil.isChecked() || medio.isChecked()
                                || dificil.isChecked()))
                        {
                            //Toast.makeText(getApplicationContext(), "Que o duelo comece!", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent( SecondActivity.this, DueloActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Selecione pelo menos uma operação.", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );

        //Toast.makeText(getApplicationContext(), "Selecione pelo menos uma operação." + adicao.isChecked(), Toast.LENGTH_LONG).show();


        if (adicao.isSelected() || subtracao.isSelected() || multiplicacao.isSelected() ||
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
        }
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