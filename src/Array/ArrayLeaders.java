package Array;

import java.util.ArrayList;

public class ArrayLeaders {
    static ArrayList<Integer> leaders(int n, int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int greatest   = 0;
        for(int i = arr.length-1; i>=0; i--){
            if(arr[i] >= greatest){
                greatest = arr[i];
                ans.add(0,greatest);
            }
        }
        return ans;
    }
}
