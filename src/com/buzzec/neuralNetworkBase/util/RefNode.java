package com.buzzec.neuralNetworkBase.util;

import java.util.*;

public class RefNode{
    public static final double MAX_RANDOM_WEIGHT = 1.0;
    public static final double MIN_RANDOM_WEIGHT = -1.0;
    
    public static double genWeightBetween(Random random){
        double range = MAX_RANDOM_WEIGHT - MIN_RANDOM_WEIGHT;
        
        return random.nextDouble() % range + MIN_RANDOM_WEIGHT;
    }
}
