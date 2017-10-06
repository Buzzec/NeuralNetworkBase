package com.buzzec.functions;

//Experimentally super slow
public class HyperbolicTangent implements Function{
    @Override
    public double getFunctionOutput(double input){
        return Math.tanh(input);
    }
}
