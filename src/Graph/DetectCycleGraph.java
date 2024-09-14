package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleGraph {
    static boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean [] vis){
        vis[node] = true;
        for(int adjacent : adj.get(node)){
            if(!vis[adjacent]){
                if(dfs(adjacent, node, adj, vis)){
                    return true;
                }
            }
            else if(adjacent != parent){
                return true;
            }
        }
        return false;
    }
    static boolean bfs(int start,ArrayList<ArrayList<Integer>> adj, boolean [] vis){
        vis[start] = true;
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[]{start, -1});
        while(!q.isEmpty()){
            int ele = q.peek()[0];
            int parent = q.peek()[1];
            q.poll();
            for(int adjacent: adj.get(ele)){
                if(!vis[adjacent]){
                    q.offer(new int[]{adjacent, ele});
                    vis[adjacent] = true;
                }
                else if(adjacent != parent)
                    return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean [] vis = new boolean[V];
        for(int i= 0; i<V; i++){
            if(!vis[i]){
                boolean ans = dfs(i, -1, adj, vis);
                if(ans)
                    return ans;
            }
        }
        return false;
    }
}
