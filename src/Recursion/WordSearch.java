package Recursion;

public class WordSearch {
    static boolean solve(int row, int col, char[][] board, boolean [][] vis, int ind, String word){
        if(ind==word.length()){
            return true;
        }
        vis[row][col]=true;
        // up
        if(row-1 >=0 && board[row-1][col] == word.charAt(ind) && !vis[row-1][col]){
            boolean solution = solve(row-1, col, board, vis, ind+1, word);
            if(solution) return true;
        }
        // down
        if(row+1 < board.length && board[row+1][col] == word.charAt(ind) && !vis[row+1][col]){
            boolean solution = solve(row+1, col, board, vis, ind+1, word);
            if(solution) return true;
        }
        // left
        if(col-1 >=0 && board[row][col-1] == word.charAt(ind) && !vis[row][col-1]){
            boolean solution = solve(row, col-1, board, vis, ind+1, word);
            if(solution) return true;
        }
        // right
        if(col+1 < board[0].length && board[row][col+1] == word.charAt(ind) && !vis[row][col+1]){
            boolean solution = solve(row, col+1, board, vis, ind+1, word);
            if(solution) return true;
        }
        vis[row][col]=false;
        return false;
    }
    public static boolean exist(char[][] board, String word) {
        boolean [][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j]==word.charAt(0)){
                    boolean ans = solve(i, j, board, visited, 1, word);
                    if(ans) return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] ch = {{'a', 'a'}};
        System.out.println(exist(ch, "aaa"));
    }
}
