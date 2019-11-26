package com.example.opermath.nivel;

import com.example.opermath.DueloActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NivelMedio extends INivel {
    public NivelMedio(char operacao) {
        super(operacao);
        a = -1;
        if(operacao == DueloActivity.OPERACAO_ADICAO
                || operacao == DueloActivity.OPERACAO_SUBTRACAO
                || operacao == DueloActivity.OPERACAO_DIVISAO){
            a = getRandom();
        }
        else if(operacao == DueloActivity.OPERACAO_MULTIPLICACAO){
            a = getRandom(11);
        }
        //a = -1;
        b = -1;
        if(operacao == DueloActivity.OPERACAO_ADICAO
                || operacao == DueloActivity.OPERACAO_SUBTRACAO){
            b = getRandom();
        }
        else if (operacao == DueloActivity.OPERACAO_MULTIPLICACAO){
            b = getRandom(21);
        }
        else if(operacao == DueloActivity.OPERACAO_DIVISAO){
            if (a == 0){
                b = getRandom();
            }
            else{
                int i;
                List<Integer> list = new ArrayList<>();
                for(i = 1; i <= a; i++){
                    if(a%i == 0){
                        list.add(i);
                    }
                }
                int indice = getRandom(list.size());
                b = list.get(indice);
            }

        }

        if(operacao == DueloActivity.OPERACAO_MULTIPLICACAO) {
            int i = getRandom(2);
            if (i == 1) {
                int temp = a;
                a = b;
                b = temp;
            }
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
        return random.nextInt(31);
    }

    public int getRandom(int i){
        Random random = new Random();
        return random.nextInt(i);
    }
}
