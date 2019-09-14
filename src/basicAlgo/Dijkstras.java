package basicAlgo;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstras {

    public static void start() {
        int V = 5;

        // Adjacency list representation of the  
        // connected edges 
        List<List<DijkstraNode>> adj = new ArrayList<>();

        // Initialize list for every node 
        for (int i = 0; i < V; i++) {
            List<DijkstraNode> item = new ArrayList<>();
            adj.add(item);
        }

        // Inputs for the DPQ graph 
        adj.get(0).add(new DijkstraNode(1, 9));
        adj.get(0).add(new DijkstraNode(2, 6));
        adj.get(0).add(new DijkstraNode(3, 5));
        adj.get(0).add(new DijkstraNode(4, 3));
        adj.get(2).add(new DijkstraNode(1, 2));
        adj.get(2).add(new DijkstraNode(3, 4));
        findShortestPathToNode(0, adj, new DijkstraNode(0, 0));
        findShortestPathToNode(1, adj, new DijkstraNode(0, 0));
        findShortestPathToNode(2, adj, new DijkstraNode(0, 0));
        findShortestPathToNode(3, adj, new DijkstraNode(0, 0));
        findShortestPathToNode(4, adj, new DijkstraNode(0, 0));
        findShortestPathToNode(10, adj, new DijkstraNode(0, 0));
    }

    private static void findShortestPathToNode(int nodeName, List<List<DijkstraNode>> adj, DijkstraNode zeroNode) {
        boolean pathFound = false;
        PriorityQueue<DijkstraNode> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(zeroNode);
        while (!pathFound  && !priorityQueue.isEmpty()) {
            DijkstraNode dijkstraNodePopped = priorityQueue.poll();
            assert dijkstraNodePopped != null;
            if (dijkstraNodePopped.node == nodeName) {
                pathFound = true;
                System.out.println(String.format("Shortest path to %s is %s", nodeName, (dijkstraNodePopped.cost + dijkstraNodePopped.costFromPrev)));
            }
            List<DijkstraNode> edges = adj.get(dijkstraNodePopped.node);
            for (DijkstraNode edge : edges) {
                edge.costFromPrev = dijkstraNodePopped.costFromPrev + dijkstraNodePopped.cost;
            }
            priorityQueue.addAll(edges);
        }
        if(!pathFound){
            throw new RuntimeException("Path Cannot Be Found");
        }
    }

}
