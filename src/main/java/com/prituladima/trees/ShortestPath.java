package com.prituladima.trees;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;

public class ShortestPath {

    public static int[] dijkstra(int from, Map<Integer, IntIntPair> graph){
        int[] costs = new int[graph.size()];
        Arrays.fill(costs, Integer.MAX_VALUE);
        boolean[] used = new boolean[graph.size()];

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(from);
        used[from] = false;
        costs[from] = 0;

        while (!priorityQueue.isEmpty()){
            int cur = priorityQueue.remove();



        }


        return costs;
    }

}
