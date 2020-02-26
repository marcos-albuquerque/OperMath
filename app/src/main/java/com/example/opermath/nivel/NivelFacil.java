package com.example.opermath.nivel;

import com.example.opermath.DueloActivity;
import com.example.opermath.PraticarActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NivelFacil extends INivel {
    public NivelFacil(char operacao) {
        super(operacao);
        a = -1;
        if(operacao == DueloActivity.OPERACAO_ADICAO
                || operacao == DueloActivity.OPERACAO_SUBTRACAO || operacao == DueloActivity.OPERACAO_MULTIPLICACAO
                || operacao == DueloActivity.OPERACAO_DIVISAO ||
        operacao == PraticarActivity.OPERACAO_ADICAO
                || operacao == PraticarActivity.OPERACAO_SUBTRACAO || operacao == PraticarActivity.OPERACAO_MULTIPLICACAO
                || operacao == PraticarActivity.OPERACAO_DIVISAO
        ){
            a = getRandomNumber();
        }
        //a = -1;
        b = -1;
        if(operacao == DueloActivity.OPERACAO_ADICAO
                || operacao == DueloActivity.OPERACAO_SUBTRACAO || operacao == DueloActivity.OPERACAO_MULTIPLICACAO ||
                operacao == PraticarActivity.OPERACAO_ADICAO
                || operacao == PraticarActivity.OPERACAO_SUBTRACAO || operacao == PraticarActivity.OPERACAO_MULTIPLICACAO
        ){
            b = getRandomNumber();
        }
        else if(operacao == DueloActivity.OPERACAO_DIVISAO || operacao == PraticarActivity.OPERACAO_DIVISAO){
            if (a == 0){
                b = getRandomNumber();
            }
            else{
                int i;
                List<Integer> list = new ArrayList<>();
                for(i = 1; i <= a; i++){
                    if(a%i == 0){
                        list.add(i);
                    }
                }
                int indice = getRandomNumber(list.size());
                b = list.get(indice);
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

    @Override
    public int getRandom() {
        Random random = new Random();
        return answer() + getRandomNumber(-10, 10);
    }


    private int getRandomNumber(){
        Random random = new Random();
        return random.nextInt(11);
    }

    public int getRandomNumber(int i){
        Random random = new Random();
        return random.nextInt(i);
    }
}
