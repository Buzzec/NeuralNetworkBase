package com.buzzec.functions;

//Experimentally second fastest
public class Algebraic implements Function{
    @Override
    public double getFunctionOutput(double input){
        return input/(1 + Math.abs(input));
    }
}
