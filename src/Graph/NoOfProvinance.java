package Graph;
import java.util.ArrayList;

class NoOfProvinance {
    static void dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean [] vis){
        vis[i]=true;
        for(int neighbour: adj.get(i)){
            if(!vis[neighbour])
                dfs(neighbour, adj, vis);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj  = new ArrayList<>();
        for(int i= 0; i<isConnected.length+1; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<isConnected.length; i++){
            for(int j = 0; j<isConnected.length; j++){
                if(isConnected[i][j]==1){
                    adj.get(i+1).add(j+1);
                }
            }
        }
        int cnt = 0;
        boolean [] vis = new boolean[isConnected.length+1];
        for(int i = 1; i<=isConnected.length; i++){
            if(!vis[i]){
                cnt++;
                dfs(i, adj, vis);
            }

        }
        return cnt;
    }
}