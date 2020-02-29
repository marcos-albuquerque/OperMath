package com.example.opermath;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button duelarButton;
    private Button praticarButton;
    private Button aprenderButton;

    private long backPressedTime;
    //private boolean isUserClickBackButton = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        duelarButton = (Button) findViewById(R.id.button1);
        praticarButton = (Button) findViewById(R.id.button2);
        aprenderButton = (Button) findViewById(R.id.button3);


        duelarButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        startActivity(intent);
                    }
                }
        );

        praticarButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, Second2Activity.class);
                        startActivity(intent);
                    }
                }
        );
        aprenderButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, AprenderActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }

    @Override
    public void onBackPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Você tem certeza que quer sair?")
                .setCancelable(false)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //MainActivity.super.onBackPressed();
                        moveTaskToBack(true);
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);
                    }
                })

                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();


        /*if(!isUserClickBackButton)
        {
            Toast.makeText(this, "Pressione volta de novo para sair", Toast.LENGTH_LONG).show();
            isUserClickBackButton = true;
        } else {
            super.onBackPressed();
        }
        new CountDownTimer(2000, 1000){

            @Override
            public void onTick(long millisUtilFinished) {

            }

            @Override
            public void onFinish() {
                isUserClickBackButton = false;
            }
        }.start(); */
    }

    /*@Override
    public void onBackPressed() // Preciso melhorar
    {
        if(backPressedTime + 1500 > System.currentTimeMillis())
        {
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
            //super.onBackPressed();
            //return;
        } else
        {
            Toast.makeText(getBaseContext(), "Pressione voltar duas vezes para sair", Toast.LENGTH_SHORT).show();
        }

        backPressedTime = System.currentTimeMillis();
    }*/ // Quando o app é aberto novamente, ele não abre na MainActivity
}
