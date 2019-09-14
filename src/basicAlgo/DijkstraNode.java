package basicAlgo;

import java.util.Comparator;

public class DijkstraNode implements Comparator<DijkstraNode>, Comparable<DijkstraNode> {
    public int node;
    public int cost;
    public int costFromPrev = 0;

    public DijkstraNode(int node, int cost)
    {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compare(DijkstraNode o1, DijkstraNode o2) {
        if(o1.cost >= o2.cost) return 1;
        return -1;
    }

    @Override
    public int compareTo(DijkstraNode o) {
        if(o.cost >= this.cost) return -1;
        return 1;
    }
}
