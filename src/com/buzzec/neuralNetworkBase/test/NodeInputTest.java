package com.buzzec.neuralNetworkBase.test;

import com.buzzec.neuralNetworkBase.node.*;

public class NodeInputTest implements NodeInput{
    private int id;
    
    public NodeInputTest(int id){
        this.id = id;
    }
    
    @Override
    public double getOutput(){
        return id;
    }
    @Override
    public String getName(){
        return "InputTest:" + id;
    }
}
