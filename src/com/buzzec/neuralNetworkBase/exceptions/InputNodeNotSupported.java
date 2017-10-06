package com.buzzec.neuralNetworkBase.exceptions;

public class InputNodeNotSupported extends RuntimeException{
    public InputNodeNotSupported(String method){
        super("Input node does not support " + method + ".");
    }
}
