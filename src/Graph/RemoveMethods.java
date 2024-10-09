package Graph;

import java.util.*;

public class RemoveMethods {
    static void dfs(int node,ArrayList<ArrayList<Integer>> adj, boolean [] vis){
        vis[node]=true;
        for(int neighbour: adj.get(node)){
            if(!vis[neighbour]){
                dfs(neighbour, adj, vis);
            }
        }
    }
    static void dfs2(int node, ArrayList<ArrayList<Integer>> adj, boolean [] vis, boolean [] sus){
        vis[node]=true;
        for(int neighbour: adj.get(node)){
            if(!vis[neighbour] && !sus[neighbour]){
                dfs2(neighbour, adj, vis, sus);
            }
            else if(!vis[neighbour] && sus[neighbour]){
                Arrays.fill(sus, false);
            }
        }
    }
   static public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        boolean [] vis  = new boolean[n];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i<invocations.length; i++)
            list.get(invocations[i][0]).add(invocations[i][1]);
        dfs(k, list, vis);
        boolean [] sus  = vis.clone();
        Arrays.fill(vis, false);
        for(int i = 0; i<n; i++){
            if(!vis[i] && !sus[i]){
                dfs2(i, list, vis, sus);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i<n; i++){
            if(!sus[i]){
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int [][] invo = {{1,2},{0,1},{3,2}};
        System.out.println(remainingMethods(4, 1, invo));
    }
}
