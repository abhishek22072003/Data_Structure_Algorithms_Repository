package Graph;

import java.util.LinkedList;
import java.util.Queue;

// '.' as empty cell
// '+' as wall
public class NearestExitFromMaze {
    static int bfs(int sr, int sc, char [][] maze, boolean [][] vis){
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        vis[sr][sc] = true;
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
                for(int d  = 0; d<4; d++){
                    int r = row + deltai[d];
                    int c = col + deltaj[d];
                    if(r >= 0 && r < maze.length && c >=0 && c < maze[0].length && !vis[r][c] && maze[r][c]=='.'){
                        if(r == 0 || r == maze.length-1 || c == 0 || c == maze[0].length-1)
                                return cnt;
                        else{
                            q.add(new int[]{r, c});
                            vis[r][c]  = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        boolean [][] vis = new boolean[maze.length][maze[0].length];
        return bfs(entrance[0], entrance[1], maze, vis);
    }
}
