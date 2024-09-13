package Daily;

import java.util.Arrays;

public class SpiralMatrixIV {
    public static int[][] spiralMatrix(int m, int n) {
        int [][] matrix = new int[m][n];
        for(int [] a: matrix)
                Arrays.fill(a, -1);
        int rstart =0;
        int rend = m-1;
        int cstart = 0;
        int cend = n-1;
        int counter = 1;
        while(rstart <= rend && cstart <= cend){
            // left to right
            for(int i = rstart; i<=cend; i++){
                if(matrix[rstart][i]==-1)
                    matrix[rstart][i] = counter++;
            }
            // up to down
            for(int i = rstart+1; i<= rend; i++) {
                if(matrix[i][cend]==-1)
                    matrix[i][cend] = counter++;
            }

            // right to left
            for(int i = cend-1; i>=cstart; i--){
                if(cstart == cend)
                    break;
                if(matrix[rend][i]==-1)
                    matrix[rend][i] = counter++;
            }

            // down to up
            for(int i = rend-1; i>=rstart+1; i--){
                if(rstart==rend)
                    break;
                if(matrix[i][cstart]==-1)
                    matrix[i][cstart] = counter++;
            }
           rstart++;
            cstart++;
            rend--;
            cend--;
        }
        return matrix;
    }
    public static void main(String[] args) {
        int [][] solution = spiralMatrix(5, 7);
        for(int [] arr : solution)
            System.out.println(Arrays.toString(arr));
    }
}