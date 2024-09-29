package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen{
    static void solve(int col, char [][] board, int n, List<List<String>> solution){
        if(col==n){
            solution.add(buildString(board));
            return;
        }
        for(int row = 0; row < n; row++){
            if(isSafe(row, col, board)){
                board[row][col]='Q';
                solve(col+1, board, n, solution);
                board[row][col]='.';
            }
        }
    }

    private static List<String> buildString(char[][] board) {
        List<String> ans = new ArrayList<>();
        for(char [] c: board){
            String s = new String(c);
            ans.add(s);
        }
        return ans;
    }

    private static boolean isSafe(int row, int col, char[][] board) {
        int drow = row;
        int dcol = col;
        // row
        while(col>=0){
            if(board[row][col]=='Q') return false;
            col--;
        }
        row = drow;
        col = dcol;
        while(row>=0 && col >= 0){
            if(board[row][col]=='Q') return false;
            row--;
            col--;
        }
        row = drow;
        col = dcol;
        while(row<board.length && col>=0){
            if(board[row][col]=='Q') return false;
            row++;
            col--;
        }
        return true;
    }

    static public List<List<String>> solveNQueens(int n) {
        char [][] board = new char[n][n];
        for(char [] c: board){
            Arrays.fill(c, '.');
        }
        List<List<String>> solution = new ArrayList<>();

        solve(0, board, n, solution);

        return solution;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
