package com.buzzec.exceptions.network;

public class InvalidStructureSize extends RuntimeException{
    public InvalidStructureSize(int size){
        super("Invalid size for structure: " + size);
    }
}
