package Recursion;

import java.util.ArrayList;

public class SubsetSum1 {
    static void solve(int ind, ArrayList<Integer> arr, int curr, ArrayList<Integer> ans){
        if(ind==arr.size()){
            ans.add(curr);
            return;
        }
        solve(ind+1, arr, curr+arr.get(ind), ans);
        solve(ind+1, arr, curr, ans);
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        solve(0, arr, 0, ans);
        return ans;
    }
}
