package com.buzzec.neuralNetworkBase.functions;

//Experimentally fastest
public class Algebraic2 implements Function{
    @Override
    public double getFunctionOutput(double input){
        return input/Math.sqrt(1 + Math.pow(input, 2));
    }
}
