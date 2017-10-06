package com.buzzec.network;

import com.buzzec.exceptions.network.*;
import com.buzzec.functions.*;
import com.buzzec.node.*;

import java.io.*;
import java.util.*;

public class AllConnectNetwork{
    private ArrayList<ArrayList<Node>> network;
    private Random random;
    private double mutationFactor;
    private double mutationChance;
    
    public AllConnectNetwork(ArrayList<NodeInput> inputs,
                             boolean useFunctionOnInputs,
                             Function function,
                             ArrayList<Integer> structure,
                             ArrayList<NodeOutput> outputLocations,
                             long seed,
                             double mutationFactor,
                             double mutationChance){
        random = new Random(seed);
        network = genAllConnectNetwork(inputs,
                                       useFunctionOnInputs,
                                       function,
                                       structure,
                                       outputLocations,
                                       random);
        this.mutationFactor = mutationFactor;
        this.mutationChance = mutationChance;
    }
    
    private static ArrayList<ArrayList<Node>> genAllConnectNetwork(ArrayList<NodeInput> inputs,
                                                                  boolean useFunctionOnInputs,
                                                                  Function function,
                                                                  ArrayList<Integer> structure,
                                                                  ArrayList<NodeOutput> outputLocations,
                                                                  Random random){
        if(outputLocations.size() < 1){
            throw new InvalidOutputSize(outputLocations.size());
        }
        
        ArrayList<ArrayList<Node>> output = new ArrayList<>();
        
        ArrayList<Node> first = new ArrayList<>();
        for(NodeInput x : inputs){
            first.add(new InputNode(x, useFunctionOnInputs, function));
        }
        output.add(first);
        
        System.out.println();
        for(int x : structure){
            if(x < 1){
                throw new InvalidStructureSize(x);
            }
            
            ArrayList<Node> next = new ArrayList<>();
            for(int y = 0; y < x; y++){
                next.add(new Node(output.get(output.size() - 1), random, function));
            }
            output.add(next);
        }
        
        ArrayList<Node> last = new ArrayList<>();
        for(NodeOutput x : outputLocations){
            last.add(new OutputNode(output.get(output.size() - 1), random, function, x));
        }
        output.add(last);
        
        return output;
    }
    
    public void updateNodes(){
        for(ArrayList<Node> x : network){
            for(Node y : x){
                y.calcOutput();
            }
        }
    }
    public void mutateNodes(){
        for(int x = 1; x < network.size(); x++){
            for(Node y : network.get(x)){
                y.mutate(mutationFactor, mutationChance, random);
            }
        }
    }
    
    public void printToFile(String fileFolder, String fileName){
        if(new File(fileFolder).mkdirs()) System.out.println("New folders made.");
        BufferedWriter bw = null;
        FileWriter fw = null;
        try{
            fw = new FileWriter(fileFolder + "\\" + fileName, true);
            bw = new BufferedWriter(fw);
            bw.write("MutationFactor: " + mutationFactor + "\n");
            bw.write("MutationChance: " + mutationChance + "\n");
            bw.write("\n");
            for(int x = 0; x < network.size(); x++){
                bw.write(x + "\n");
                for(Node y : network.get(x)){
                    bw.write(y + "\n");
                }
                bw.write("\n");
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally{
            try{
                if(bw != null){
                    bw.close();
                }
                if(fw != null){
                    fw.close();
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
