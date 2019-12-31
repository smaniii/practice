package com.seth.basicAlgo;

public class DijkstraNode implements Comparable<DijkstraNode> {
    public int node;
    public int cost;
    public int costFromPrev = 0;

    public DijkstraNode(int node, int cost)
    {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(DijkstraNode o) {
        if(o.cost >= this.cost) return -1;
        return 1;
    }
}
