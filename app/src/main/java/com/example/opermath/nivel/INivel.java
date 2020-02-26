package com.example.opermath.nivel;

import com.example.opermath.DueloActivity;
import com.example.opermath.PraticarActivity;


import java.util.Random;

public abstract class INivel {
    protected int a;
    protected int b;
    protected char operacao;

    public INivel (char operacao){
        this.operacao = operacao;
    }

    public char getOperacao() {
        return operacao;
    }

    public abstract int getA();

    public abstract int getB();

    public abstract int getRandom();

    public int answer (){
        if(operacao == DueloActivity.OPERACAO_ADICAO || operacao == PraticarActivity.OPERACAO_ADICAO){
            return a + b;
        }
        if(operacao == DueloActivity.OPERACAO_SUBTRACAO  || operacao == PraticarActivity.OPERACAO_SUBTRACAO){
            return  a - b;
        }
        if(operacao == DueloActivity.OPERACAO_MULTIPLICACAO || operacao == PraticarActivity.OPERACAO_MULTIPLICACAO){
            return a * b;
        }
        if(operacao == DueloActivity.OPERACAO_DIVISAO || operacao == PraticarActivity.OPERACAO_DIVISAO){
            return a / b;

        }
        return -1;
    }

    public int getRandomNumber(int a, int b){
        Random random = new Random();
        return random.nextInt(b-a) + a;
    }
}
