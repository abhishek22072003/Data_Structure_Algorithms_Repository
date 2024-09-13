package Graph;

import java.util.LinkedList;
import java.util.Queue;
// 0 - empty cell
// 1 - fresh mango
// 2 - rotten mango
public class RottenOranges {
    static int bfs(int [][] grid, boolean [][] vis){
        int cnt = 0;
        Queue<int []> q = new LinkedList<>();
        for(int i = 0; i<grid.length; i++)
            for(int j = 0; j<grid[0].length; j++)
                if(grid[i][j] == 2)
                    q.add(new int[]{i, j});
        int [] deltai = {1, -1, 0, 0};
        int [] deltaj = {0, 0, -1, 1};
        while(!q.isEmpty()){
             int size = q.size();
             cnt++;
             for(int i = 0; i<size; i++){
                 int row = q.peek()[0];
                 int col = q.peek()[1];
                 q.poll();
                 vis[row][col] = true;
                 grid[row][col] = 2;
                 for(int ind  = 0; ind < 4; ind++){
                     int nrow = row+deltai[ind];
                     int ncol = col+deltaj[ind];
                     if(nrow >=0 && nrow < grid.length && ncol >=0 && ncol < grid[0].length
                        && grid[nrow][ncol] == 1 && !vis[nrow][ncol]){
                         q.add(new int[]{nrow, ncol});
                         grid[row][col] = 2;
                         vis[nrow][ncol] = true;
                     }
                 }
             }
        }
        return cnt-1;
    }
    public int orangesRotting(int[][] grid) {
        boolean [][] vis = new boolean[grid.length][grid[0].length];
        int sol =  bfs(grid, vis);
        for(int i = 0; i<grid.length; i++)
            for(int j = 0; j<grid[0].length; j++)
                if(grid[i][j]==1)
                    sol  = -1;
        return sol;
    }
}
