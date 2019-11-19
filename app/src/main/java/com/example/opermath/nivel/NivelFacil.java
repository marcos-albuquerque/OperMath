package com.example.opermath.nivel;

import java.util.Random;

public class NivelFacil extends INivel {
    public NivelFacil(char operacao) {
        super(operacao);
        a = -1;
        if(operacao == '+' || operacao == '-'){
            a = getRandom();
        }
        //a = -1;
        b = -1;
        if(operacao == '+' || operacao == '-') {
            b = getRandom();
        }
    }

    @Override
    public int getA() {
        return a;
    }

    @Override
    public int getB() {
        return b;
    }

    public int getRandom(){
        Random random = new Random();
        return random.nextInt(11);
    }
}
