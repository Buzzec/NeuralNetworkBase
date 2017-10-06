package com.buzzec.node;

public interface NodeOutput{
    void receiveInput(double input);
    
    /**
     * @return a name with NO SPACES
     */
    String getName();
}
