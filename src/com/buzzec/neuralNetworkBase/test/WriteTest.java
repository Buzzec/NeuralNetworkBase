package com.buzzec.neuralNetworkBase.test;

import com.buzzec.neuralNetworkBase.functions.*;
import com.buzzec.neuralNetworkBase.network.*;
import com.buzzec.neuralNetworkBase.node.*;

import java.util.*;

public class WriteTest{
    public static void main(String[] args){
        long first = System.nanoTime();
        
        ArrayList<NodeInput> inputs = new ArrayList<>();
        for(int x = 0; x < 20; x++){
            inputs.add(new NodeInputTest(x));
        }
        
        ArrayList<Integer> structure = new ArrayList<>();
        structure.add(16);
        structure.add(16);
        
        ArrayList<NodeOutput> outputLocations = new ArrayList<>();
        for(int x = 30; x < 33; x++){
            outputLocations.add(new NodeOutputTest(x));
        }
        
        AllConnectNetwork network = new AllConnectNetwork(inputs,
                true,
                new Algebraic2(),
                structure,
                outputLocations,
                0,
                0.01,
                0.01);
    
        System.out.println(System.nanoTime() - first);
        network.printToFile("test", "File1.txt");
        System.out.println(System.nanoTime() - first);
        network.updateNodes();
        System.out.println(System.nanoTime() - first);
        network.mutateNodes();
        System.out.println(System.nanoTime() - first);
        network.printToFile("test", "File2.txt");
        System.out.println(System.nanoTime() - first);
    }
}
