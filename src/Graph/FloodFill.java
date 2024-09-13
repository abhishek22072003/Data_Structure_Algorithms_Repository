package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    // solution using dfs (low lines of code)
    static void dfs(int [][] image, int row, int col, int initial, int color, int [] deltai, int [] deltaj){
        image[row][col] = color;
        for(int i = 0; i<4; i++){
            int nrow = row+deltai[i];
            int ncol = col+deltaj[i];
            if(nrow >=0 && nrow < image.length && ncol >=0 && ncol < image[0].length && image[nrow][ncol]==initial && image[nrow][ncol]!=color){
                dfs(image, nrow, ncol, initial, color, deltai, deltaj);
            }
        }
    }
    // solution using bfs (better for stack space)
    static void bfs(int [][] image, int sr, int sc, int color, boolean [][] vis){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        vis[sr][sc] = true;
        int [] a = {1, -1, 0, 0};
        int [] b = {0, 0, -1, 1};
        int initial = image[sr][sc];
        while(!q.isEmpty()){
            int row = q.peek()[0];
            int col = q.peek()[1];
            q.poll();
            image[row][col] = color;
            for(int i = 0; i<4; i++){
                int r = row+a[i];
                int c = col+b[i];
                if(r >= 0 && r < image.length && c>=0 && c<image[0].length && !vis[r][c] && image[r][c]==initial){
                    vis[r][c]=true;
                    q.add(new int[]{r, c});
                }
            }
        }
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // don't alter real input in interview
        boolean [][] vis = new boolean[image.length][image[0].length];
        //bfs(image, sr, sc, color, vis);
        int [] deltai = {1, -1, 0, 0};
        int [] deltaj = {0, 0, -1, 1};
        dfs(image, sr, sc, image[sr][sc], color, deltai, deltaj);
        return image;
    }

    public static void main(String[] args) {
        int [][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int [][] solution   = floodFill(image, 1, 1, 2);
        for(int [] s: solution)
            System.out.println(Arrays.toString(s));
    }
}
