package com.buzzec.exceptions;

public class NodeWeightMismatch extends RuntimeException{
    public NodeWeightMismatch(int numNodes, int numWeights){
        super("Number of Nodes and Weights mismatch. Num Nodes: " + numNodes +
                ", Num Weights: " + numWeights);
    }
}
