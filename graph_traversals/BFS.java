package graph_traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Queue;
import java.util.LinkedList;


public class BFS {
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

        sc.close();

        Queue<Integer> q = new LinkedList<>();
        List<Integer> bfsPath = new ArrayList<>();
        boolean[] isVisited = new boolean[n+1];
        q.add(0); // source as 0
        isVisited[0] = true;
        while(!q.isEmpty()) {
            int topNode = q.peek();
            bfsPath.add(topNode);
            q.poll();
            for(Integer node : adjList.get(topNode)) {
                if(!isVisited[node]) {
                    q.add(node);
                    isVisited[node] = true;
                }
            }
        }
        System.out.println("The BFS Path is : " + bfsPath.stream().map(Object::toString).collect(Collectors.joining(", ")));
    }
}
