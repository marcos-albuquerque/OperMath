package com.example.opermath.nivel;

import java.util.Random;

public class NivelFacil extends INivel {
    public NivelFacil(char operacao) {
        super(operacao);
    }

    @Override
    public int getA() {
        a = -1;
        if(operacao == '+' || operacao == '-'){
            Random random = new Random();
            a = random.nextInt(11);
        }
        //a = -1;
        return a;
    }

    @Override
    public int getB() {
        b = -1;
        if(operacao == '+' || operacao == '-') {
            Random random = new Random();
            b = random.nextInt(11);
        }
        return b;
    }
}
