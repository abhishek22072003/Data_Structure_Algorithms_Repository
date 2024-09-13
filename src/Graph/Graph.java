package Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Graph {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nodes = in.nextInt(), edges = in.nextInt();
        //considered zero based nodes here
        // adjacency matrix reprentation
        int [][] adj = new int[nodes][nodes];
        for(int i = 0; i<edges; i++){
            int u  = in.nextInt(), v = in.nextInt();
            adj[u][v] = 1;
            // if a graph is directed comment below line
            adj[v][u] = 1;
        }
        // adjancency list representation
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i<nodes; i++)
            list.add(new ArrayList<>());
        for(int i = 0; i<edges; i++){
            int u = in.nextInt(), v = in.nextInt();
            list.get(u).add(v);
            // if a graph is directed comment below line
            list.get(v).add(u);
        }
    }
}
