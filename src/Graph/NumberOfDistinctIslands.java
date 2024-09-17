package Graph;

import java.util.ArrayList;
import java.util.HashSet;

public class NumberOfDistinctIslands {
    int [] deltai = {1, -1, 0, 0};
    int [] deltaj = {0, 0, -1, 1};
    void dfs(int sr, int sc, int [][] grid, boolean [][] vis, ArrayList<String> list, int row0, int col0){
        vis[sr][sc] = true;
        list.add(""+(sr-row0)+" "+(sc-col0));
        for(int i = 0; i<4; i++){
            int nr = sr+deltai[i];
            int nc = sc + deltaj[i];
            if(nr >=0 && nr < grid.length && nc >=0 && nc< grid[0].length && !vis[nr][nc] && grid[nr][nc]==1){
                dfs(nr, nc, grid, vis, list, row0, col0);
            }
        }
    }
    int countDistinctIslands(int[][] grid) {
        HashSet<ArrayList<String>> set  = new HashSet<>();
        boolean [][] vis = new boolean[grid.length][grid[0].length];
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    ArrayList<String> list = new ArrayList<>();
                    dfs(i, j, grid, vis, list, i, j);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
}
