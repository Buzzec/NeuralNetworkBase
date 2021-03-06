package com.buzzec.neuralNetworkBase.node;

import com.buzzec.neuralNetworkBase.exceptions.*;
import com.buzzec.neuralNetworkBase.functions.*;

public class InputNode extends Node{
    private NodeInput nodeInput;
    private boolean useFunction;
    private Function function;
    
    public InputNode(NodeInput nodeInput, boolean useFunction, Function function){
        super(function);
        this.nodeInput = nodeInput;
        this.useFunction = useFunction;
        this.function = function;
    }
    
    @Override
    public void addInput(Node input, double weight){
        throw new InputNodeNotSupported("addInput()");
    }
    @Override
    public void removeWeight(int index){
        throw new InputNodeNotSupported("removeWeight()");
    }
    @Override
    public void changeWeight(double weight, int index){
        throw new InputNodeNotSupported("changeWeight()");
    }
    
    @Override
    public double calcOutput(){
        if(useFunction){
            output = function.getFunctionOutput(nodeInput.getOutput());
            return output;
        }
        else {
            output = nodeInput.getOutput();
            return output;
        }
    }
    
    @Override
    public String toString(){
        return "[InputNode] NodeInput: " + nodeInput.getName() + " Function: " + function.getClass().getName();
    }
}
