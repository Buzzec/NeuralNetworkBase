package com.buzzec.functions;

public class ArcTangent implements Function{
    @Override
    public double getFunctionOutput(double input){
        return Math.atan(input);
    }
}
