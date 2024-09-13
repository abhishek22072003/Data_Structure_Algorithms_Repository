package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSandDFS {
    static int nodes = 7, edges = 7;
    static ArrayList<ArrayList<Integer>> buildGraph(){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i<nodes; i++)
            list.add(new ArrayList<>());
        int [] u = {0, 1, 2, 3, 2, 4, 4};
        int [] v = {1, 2, 3, 0, 4, 5, 6};
        for(int i= 0; i<edges; i++){
            list.get(u[i]).add(v[i]);
            list.get(v[i]).add(u[i]);
        }
        return list;
    }

    static ArrayList<Integer> bfs(int start, ArrayList<ArrayList<Integer>> list){
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean [] visited = new boolean[nodes];
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int val = queue.poll();
            bfs.add(val);
            for(int a: list.get(val)){
                if(!visited[a]){
                    visited[a] = true;
                    queue.add(a);
                }
            }
        }
        return bfs;
    }
    static void dfs(int start, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs, boolean [] visited){
        visited[start] = true;
        dfs.add(start);
        for(int a: adj.get(start)){
            if(!visited[a])
                dfs(a, adj, dfs, visited);
        }
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = buildGraph();
        ArrayList<Integer> bfs = bfs(0, list);
        System.out.println(bfs);
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean [] vis = new boolean[nodes];
        dfs(5, list, dfs, vis);
        System.out.println(dfs);
    }
}
