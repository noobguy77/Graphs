package graph_represenation;

import java.util.ArrayList;
import java.util.Scanner;

record Pair(int node, int weight) {
    @Override
    public String toString() {
        return "Node: " + node + ", Weight: " + weight;
    }
}


public class WeightedAdjacencyListGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int n = sc.nextInt();
        int m = sc.nextInt();
    
        ArrayList<ArrayList<Pair>> adjWtGraph = new ArrayList<ArrayList<Pair>>();

        for(int i=0;i<n+1;i++) {
            adjWtGraph.add(new ArrayList<Pair>());
        }

        for(int i=0;i<m;i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int wt = sc.nextInt();
            adjWtGraph.get(n1).add(new Pair(n2, wt));
            adjWtGraph.get(n2).add(new Pair(n1, wt)); // remove this for directed graph
        }

        for(int i=0;i<n+1;i++) {
            System.out.println("Nodes connected to "+i+" are : ");
            for(Pair p : adjWtGraph.get(i)) {
                System.out.println("Node : "+p.node()+" Weight: "+p.weight());
            }
        }

        
        sc.close();
        
    }
}
