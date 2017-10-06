package com.buzzec.test;

import com.buzzec.functions.*;
import com.buzzec.network.*;
import com.buzzec.node.*;

import java.util.*;

public class ReadTest{
    public static void main(String[] args){
        ArrayList<NodeInput> inputs = new ArrayList<>();
        for(int x = 0; x < 20; x++){
            inputs.add(new NodeInputTest(x));
        }
    
        ArrayList<NodeOutput> outputLocations = new ArrayList<>();
        for(int x = 30; x < 33; x++){
            outputLocations.add(new NodeOutputTest(x));
        }
        
        AllConnectNetwork network = new AllConnectNetwork(
                "test\\File1.txt",
                inputs,
                true,
                new Algebraic2(),
                outputLocations,
                0
        );
        network.printToFile("test", "File3.txt");
    }
}
