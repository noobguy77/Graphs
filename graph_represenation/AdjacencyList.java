package graph_represenation;

import java.util.ArrayList;
import java.util.Scanner;

public class AdjacencyList {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //no of nodes and edges
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<n+1;i++) {
            adjList.add(new ArrayList<>());
        }


        for(int i=0;i<m;i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            System.out.println(n1+"->"+n2);
            adjList.get(n1).add(n2);
            adjList.get(n2).add(n1); // Remove this line for directed graph
        }

        //print the matrix
        for(int i=0;i<n+1;i++) {
            System.out.println(adjList.get(i).toString());
        }

        sc.close();
    }
}
