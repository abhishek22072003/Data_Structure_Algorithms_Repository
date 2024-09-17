package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    static boolean check(int start, int [][] graph, int [] color){
        color[start] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int a: graph[node]){
                if(color[a]==-1){
                    color[a]  = color[node]==1?0:1;
                    q.add(a);
                }
                else if(color[a]==color[node]){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isBipartite(int[][] graph) {
        int [] color = new int[graph.length];
        Arrays.fill(color, -1);
        for(int i = 0; i<graph.length; i++)
            if(color[i]==-1)
                if(check(i, graph, color)==false)
                    return false;
        return true;
    }

    public static void main(String[] args) {
        int [][] g= {{1,2,3},{0,2},{0,1,3},{0,2}};

        System.out.println(isBipartite(g));
    }
}
