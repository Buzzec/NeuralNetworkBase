package com.buzzec.neuralNetworkBase.exceptions.network;

public class InvalidOutputSize extends RuntimeException{
    public InvalidOutputSize(int size){
        super("Invalid size for output: " + size);
    }
}
