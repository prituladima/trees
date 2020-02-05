package com.prituladima.trees;

import java.util.*;

public class ShortestPath {

    public static int[] dijkstra(int source, Map<Integer, List<Node>> graph){
        //Answer
        int[] ans = new int[graph.size()];
        //We put Integer.MAX_VALUE as big value
        Arrays.fill(ans, Integer.MAX_VALUE);

        //Used
        boolean[] used = new boolean[graph.size()];
        Arrays.fill(used, false);


        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparing(Node::getCost));
        priorityQueue.add(new Node(source, 0));
//        used[source] = true;
        ans[source] = 0;

        while (!priorityQueue.isEmpty()){
            int from = priorityQueue.remove().getTo();

            used[from] = true;

            for (Node node : graph.get(from)) {
                int to = node.getTo();
                int toCost = node.getCost();
                if(!used[to]){
                    //Relaxation
                    ans[to] = Math.min(ans[to], ans[from] + toCost);
                    priorityQueue.add(new Node(to, ans[to]));
                }
            }
        }

        return ans;
    }



}
