package graph_traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class DFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //no of nodes and edges
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> adjList = new ArrayList<>();
        boolean[] isVisited = new boolean[n+1];

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

        sc.close();
        List<Integer> dfsPath = new ArrayList<>();
        dfsTraversal(adjList, isVisited, 0, dfsPath);
        System.out.println("The DFS path is :"+dfsPath.stream().map(Object::toString).collect(Collectors.joining(", ")));
    }

    private static void dfsTraversal(List<List<Integer>> adjList, boolean[] isVisited, int node, List<Integer> dfsPath) {
        dfsPath.add(node);
        isVisited[node] = true;
        for(Integer child : adjList.get(node)) {
            if(!isVisited[child]) {
                dfsTraversal(adjList, isVisited, child, dfsPath);
            }
        }
    }
}
