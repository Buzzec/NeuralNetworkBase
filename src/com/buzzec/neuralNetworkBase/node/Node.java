package com.buzzec.neuralNetworkBase.node;

import com.buzzec.neuralNetworkBase.exceptions.*;
import com.buzzec.neuralNetworkBase.functions.*;
import com.buzzec.neuralNetworkBase.util.*;

import java.util.*;

public class Node{
    private ArrayList<Node> inputs;
    ArrayList<Double> inputWeights;
    double output;
    Function function;
    
    public Node(ArrayList<Node> inputs, ArrayList<Double> inputWeights, Function function){
        this.inputs = inputs;
        this.inputWeights = inputWeights;
        checkNodeWeightSize();
        this.function = function;
    }
    public Node(ArrayList<Node> inputs, Random random, Function function){
        this(inputs, genWeights(inputs.size(), random), function);
    }
    public Node(Function function){
        this(new ArrayList<>(), new ArrayList<>(), function);
    }
    public Node(){
        this(new Sigmoid());
    }
    
    public double getOutput(){
        return output;
    }
    
    public void addInput(Node input, double weight){
        inputs.add(input);
        inputWeights.add(weight);
        checkNodeWeightSize();
    }
    public void removeWeight(int index){
        inputs.remove(index);
        inputWeights.remove(index);
        checkNodeWeightSize();
    }
    public void changeWeight(double weight, int index){
        inputWeights.remove(index);
        inputWeights.add(index, weight);
        checkNodeWeightSize();
    }
    
    public double calcOutput(){
        int out = 0;
        
        for(int x = 0; x < inputs.size(); x++){
            out += inputs.get(x).getOutput() * inputWeights.get(x);
        }
        
        output = function.getFunctionOutput(out);
        return output;
    }
    public void mutate(double mutationFactor, double mutationChance, Random random){
        for(int x = 0; x < inputWeights.size(); x++){
            if(random.nextDouble() < mutationChance){
                changeWeight(inputWeights.get(x) +
                        (random.nextDouble() * 2 - 1) * mutationFactor, x);
            }
        }
    }
    
    private static ArrayList<Double> genWeights(int size, Random random){
        ArrayList<Double> output = new ArrayList<>();
        
        for(int x = 0; x < size; x++){
            output.add(RefNode.genWeightBetween(random));
        }
        
        return output;
    }
    private void checkNodeWeightSize(){
        if(inputs.size() != inputWeights.size()){
            throw new NodeWeightMismatch(inputs.size(), inputWeights.size());
        }
    }
    
    @Override
    public String toString(){
        return "[Node] Function: " + function.getClass().getName() +
                " InputWeights: " + inputWeights;
    }
}
