package com.buzzec.neuralNetworkBase.functions;

import static java.lang.Math.*;

public class Sigmoid implements Function{
    
    @Override
    public double getFunctionOutput(double input){
        double output =  1.0 / (1.0 + exp(-input));
        
        if(output > 1){
            output = 1;
        }
        else if(output < 0){
            output = 0;
        }
        
        return output;
    }
}
