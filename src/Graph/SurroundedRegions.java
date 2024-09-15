package Graph;

public class SurroundedRegions {
    static void dfs(int sr, int sc, char [][] board, boolean [][] vis, int [] a, int [] b){
        vis[sr][sc] = true;
        for(int i= 0; i<4; i++){
            int nr = sr+a[i];
            int nc = sc+b[i];
            if(nr >=0 && nr < board.length && nc >=0 && nc<board[0].length && !vis[nr][nc] && board[nr][nc]=='0'){
                dfs(nr, nc, board, vis, a, b);
            }
        }
    }
    public void solve(char[][] board) {
        boolean [][] vis = new boolean[board.length][board[0].length];
        int [] a = {1, -1, 0, 0};
        int [] b = {0, 0, 1, -1};
        for(int i = 0; i<board.length; i++)
            for(int j = 0; j<board[0].length; j++)
                if(i==0 || j==0 || i==board.length-1 || j== board[0].length-1)
                    if(board[i][j]=='0' && !vis[i][j])
                        dfs(i, j, board, vis, a, b);

        for(int i = 0; i<board.length; i++)
            for(int j = 0; j<board[0].length; j++)
                if(board[i][j] == 'O' && !vis[i][j])
                    board[i][j] = 'X';
    }
}
