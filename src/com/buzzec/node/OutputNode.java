package com.buzzec.node;

import com.buzzec.functions.*;

import java.util.*;

public class OutputNode extends Node{
    private NodeOutput nodeOutput;
    
    public OutputNode(ArrayList<Node> inputs, ArrayList<Double> inputWeights, Function function, NodeOutput nodeOutput){
        super(inputs, inputWeights, function);
        this.nodeOutput = nodeOutput;
    }
    public OutputNode(ArrayList<Node> inputs, Random random, Function function, NodeOutput nodeOutput){
        super(inputs, random, function);
        this.nodeOutput = nodeOutput;
    }
    
    @Override
    public double calcOutput(){
        super.calcOutput();
        nodeOutput.receiveInput(output);
        return output;
    }
    
    @Override
    public String toString(){
        return super.toString() + " NodeOutput: " + nodeOutput.getName();
    }
}
