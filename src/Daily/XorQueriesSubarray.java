package Daily;

import com.sun.security.jgss.GSSUtil;

import java.util.Arrays;

public class XorQueriesSubarray {
    public static  int[] xorQueries(int[] arr, int[][] queries) {
        int [] pxor = new int[arr.length];
        pxor[0]=arr[0];
        for(int i = 1; i<arr.length; i++)
            pxor[i] = pxor[i-1] ^ arr[i];
        int [] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            if(start == 0)
                ans[i] = pxor[end];
            else
                ans[i] = pxor[end] ^ pxor[start-1];
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] arr = {4,8,2,10};
        int [][] queries = {{2,3},{1,3},{0,0},{0,3}};
        System.out.println(Arrays.toString(xorQueries(arr, queries)));
    }
}
