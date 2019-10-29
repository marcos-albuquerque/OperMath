package com.example.opermath.nivel;

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

    public int answer (){
        if(operacao == '+'){
            return a + b;
        }
        if(operacao == '-'){
            return  a - b;
        }
        return -1;
    }

}
