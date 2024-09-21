package Graph;

import java.util.Arrays;

public class BipartiteGraphWithDFS {
    static boolean dfs(int start, int [][] graph, int[] color, int parentColor){
        color[start] = parentColor == 1 ? 0: 1;
        for(int adjacent: graph[start]){
            if(color[adjacent]==-1){
                dfs(adjacent, graph, color, color[start]);
            }
        }
        for(int adjacent: graph[start])
            if(color[adjacent]==color[start])
                return false;
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int [] color = new int[graph.length];
        Arrays.fill(color, -1);
        for(int i = 0; i<graph.length; i++){
            if(color[i]==-1){
                if(!dfs(i, graph, color, 1))
                    return false;
            }
        }
        return true;
    }
}
