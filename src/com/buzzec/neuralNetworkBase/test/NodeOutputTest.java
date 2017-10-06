package com.buzzec.neuralNetworkBase.test;

import com.buzzec.neuralNetworkBase.node.*;

public class NodeOutputTest implements NodeOutput{
    private double input;
    private int id;
    
    public NodeOutputTest(int id){
        this.id = id;
    }
    
    @Override
    public void receiveInput(double input){
        this.input = input;
    }
    
    @Override
    public String getName(){
        return "OutputTest:" + id;
    }
}
