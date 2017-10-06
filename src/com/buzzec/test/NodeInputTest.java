package com.buzzec.test;

import com.buzzec.node.*;

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
        return "Input Test " + id;
    }
}
