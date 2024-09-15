package Graph;

import java.util.LinkedList;
import java.util.Queue;
// this question is submitted on geekforgeeks
// similar question on leetcode is known as 01 matrix
public class NearestCellHavingOne {
    static void bfs(int [][] grid, boolean [][] vis){
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    q.add(new int[]{i, j});
                    vis[i][j] = true;
                    grid[i][j] = 0;
                }
            }
        }
        int [] deltai = {1, -1, 0, 0};
        int [] deltaj = {0, 0, -1, 1};
        int cnt = 0;
        while(!q.isEmpty()){
            int size = q.size();
            cnt++;
            for(int i = 0; i<size; i++){
                int row = q.peek()[0];
                int col = q.peek()[1];
                q.poll();
                for(int k = 0; k < 4; k++){
                    int nr = row + deltai[k];
                    int nc = col + deltaj[k];
                    if(nr >= 0 && nr < grid.length && nc >=0 && nc <grid[0].length && !vis[nr][nc]){
                        vis[nr][nc] = true;
                        grid[nr][nc] = cnt;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }

    }
    public int[][] nearest(int[][] grid){
        boolean [][] vis  = new boolean[grid.length][grid[0].length];
        bfs(grid, vis);
        return grid;
    }
}
