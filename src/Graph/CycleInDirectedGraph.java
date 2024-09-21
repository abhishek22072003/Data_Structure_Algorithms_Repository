package Graph;

public class CycleInDirectedGraph {
    boolean dfs(int node, int [][] graph, boolean [] vis, boolean [] pathVis){
        vis[node] = true;
        pathVis[node] = true;
        for(int adjacent: graph[node]){
            if(!vis[adjacent]){
                if(dfs(adjacent, graph, vis, pathVis)==true)
                    return true;
            }
            else if(pathVis[adjacent]){
                return true;
            }
        }
        pathVis[node] = false;
        return false;
    }
    boolean isCyclic(int [][] graph){
        boolean [] vis = new boolean[graph.length];
        boolean [] pathVis = new boolean[graph.length];
        for(int i = 0; i<graph.length; i++){
            if(!vis[i]){
                if(dfs(i, graph, vis, pathVis)==true)
                    return true;
            }
        }
        return false;
    }
}
