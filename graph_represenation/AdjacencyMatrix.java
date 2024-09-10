package graph_represenation;

import java.util.Scanner;

class AdjacencyMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the number of nodes and edges
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] adjMatrix = new int[n+1][n+1];


        for (int i = 0; i < m; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            adjMatrix[n1][n2] = 1;
            adjMatrix[n2][n1] = 1;  // Remove this line for directed graph
        }
        
        sc.close();
    }
}
