package Daily;
import java.util.*;

public class Solution {
    static boolean find(int [][] matrix, int row, int col, int health, int cost, boolean [][] vis){
        if(row == matrix.length-1 && col == matrix[0].length-1){
            if(health - cost > 0) {
                return true;
            }
            return false;
        }
        boolean ansFound = false;
        if(row + 1 < matrix.length && !vis[row+1][col]){
            vis[row+1][col] = true;
            if(find(matrix, row+1, col, health, cost+matrix[row+1][col], vis)){
                ansFound =  true;
            }
            vis[row+1][col] = false;
        }
        if(!ansFound && row - 1 >= 0 && !vis[row-1][col]){
            vis[row-1][col] = true;
            if(find(matrix, row-1, col, health, cost+matrix[row-1][col], vis)){
                ansFound =  true;
            }
            vis[row-1][col] = false;
        }
        if(!ansFound &&col - 1 >= 0 && !vis[row][col-1]){
            vis[row][col-1] = true;
            if(find(matrix, row, col-1, health, cost+matrix[row][col-1], vis)){
                ansFound =  true;
            }
            vis[row][col-1] = false;
        }
        if(!ansFound &&col + 1  < matrix[0].length && !vis[row][col+1]){
            vis[row][col+1] = true;
            if(find(matrix, row, col+1, health, cost+matrix[row][col+1], vis)){
                ansFound =  true;
            }
            vis[row][col+1] = false;
        }
        return false;

    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int [][] matrix = new int[grid.size()][grid.get(0).size()];
        boolean [][] vis = new boolean[matrix.length][matrix[0].length];
        for(int i = 0; i<grid.size(); i++){
            for(int j = 0; j<grid.get(i).size(); j++){
                matrix[i][j] = grid.get(i).get(j);
            }
        }
        vis[0][0] = true;
        boolean ans = find(matrix, 0, 0, health, matrix[0][0], vis);
        return ans;
    }
}