package com.buzzec.neuralNetworkBase.node;

public interface NodeInput{
    double getOutput();
    
    /**
     * @return a name with NO SPACES
     */
    String getName();
}
