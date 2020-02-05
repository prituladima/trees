package com.prituladima.trees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinimalSpanningTree {

    public List<Edge<Integer>> kruskal(int vertexCount, List<Edge<Integer>> edgeList){
        if (edgeList.isEmpty()) {
            return new ArrayList<>();
        }

        edgeList.sort(Comparator.comparingInt(Edge::getCost));

        DisjointUnionSets disjointUnionSets = new DisjointUnionSets(vertexCount);

        List<Edge<Integer>> minimalSpanningTree = new ArrayList<>();
        minimalSpanningTree.add(edgeList.get(0));
        disjointUnionSets.union(edgeList.get(0).getFrom(), edgeList.get(0).getTo());

        for (int i = 1; i < edgeList.size(); i++) {
            if (!disjointUnionSets.isInSameSet(edgeList.get(i).getFrom(), edgeList.get(i).getTo())) {
                disjointUnionSets.union(edgeList.get(i).getFrom(), edgeList.get(i).getTo());
                minimalSpanningTree.add(edgeList.get(i));
            }
        }

        return minimalSpanningTree;
    }

}
