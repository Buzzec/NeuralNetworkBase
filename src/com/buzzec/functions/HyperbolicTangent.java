package com.buzzec.functions;

public class HyperbolicTangent implements Function{
    @Override
    public double getFunctionOutput(double input){
        return Math.tanh(input);
    }
}
