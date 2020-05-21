package com.andrea.puccia;

public class Calculator {
    private int result;
    public Calculator(int n) {
        result = n;
    }
    public void add(int a){
        result+=a;
    }
    public int getResult(){
        return result;
    }

    public void minus(int a) {
        result-=a;
    }
    public void multiply(int a) {
        result*=a;
    }

}
