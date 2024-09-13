package Graph;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    static class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    static void bfs(int i, int j, boolean [][] vis, char [][] grid){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        vis[i][j]= true;
        int m  = grid.length;
        int n = grid[0].length;
        int [] a = {1, -1, 0, 0};
        int [] b = {0, 0, -1, 1};
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.poll();
            for(int d = 0; d<a.length; d++){
                int r = row+a[d];
                int c = col + b[d];
                if(r >=0 && r < m && c >=0 && c<n && !vis[r][c] && grid[r][c]=='1'){
                    q.add(new Pair(r, c));
                    vis[r][c]= true;
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean [][] vis = new boolean[m][n];
        int cnt = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    cnt++;
                    bfs(i, j, vis, grid);
                }
            }
        }
        return cnt;
    }
}
