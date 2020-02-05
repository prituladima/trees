package com.prituladima.trees;

public class Node {

    private Integer to;
    private Integer cost;

    public Node(Integer to, Integer cost) {
        this.to = to;
        this.cost = cost;
    }

    public Integer getTo() {
        return to;
    }

    public Integer getCost() {
        return cost;
    }
}
