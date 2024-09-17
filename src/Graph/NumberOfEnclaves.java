package Graph;

public class NumberOfEnclaves {
    static void dfs(int sr, int sc, int [][] grid, boolean [][] vis, int [] deltai, int [] deltaj){
        vis[sr][sc] = true;
        grid[sr][sc] = 0;
        for(int i = 0; i<4; i++){
            int nr = sr + deltai[i];
            int nc = sc + deltaj[i];
            if(nr >=0 && nr< grid.length && nc >= 0 && nc<grid[0].length && !vis[nr][nc] && grid[nr][nc]==1){
                dfs(nr, nc, grid, vis, deltai, deltaj);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        boolean [][] vis = new boolean[grid.length][grid[0].length];
        int [] deltai = {1, -1, 0, 0};
        int [] deltaj = {0, 0, 1, -1};
        for(int i = 0; i<grid.length; i++)
            for(int j = 0; j<grid[0].length; j++)
                if(i==0 || j == 0 || i == grid.length-1 || j == grid[0].length-1){
                    if(grid[i][j]==1 && !vis[i][j])
                        dfs(i, j, grid, vis, deltai, deltaj);
                }
        int cnt = 0;
        for(int i = 0; i<grid.length; i++)
            for(int j = 0; j<grid[0].length; j++)
                if(grid[i][j]==1)
                    cnt++;
        return cnt;
    }
}
