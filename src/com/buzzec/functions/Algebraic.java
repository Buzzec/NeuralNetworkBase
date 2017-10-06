package com.buzzec.functions;

public class Algebraic implements Function{
    @Override
    public double getFunctionOutput(double input){
        return input/(1 + Math.abs(input));
    }
}
