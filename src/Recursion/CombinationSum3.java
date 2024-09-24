package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    static void solve(int ind, int size, int target, ArrayList<Integer> path, List<List<Integer>>ans){
        if(size==0 && target==0){
            ans.add(new ArrayList<>(path));
        }
        for(int i = ind; i <10; i++){
            if(i > target) break;
            path.add(i);
            solve(i+1, size-1, target-i, path, ans);
            path.remove(path.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(1, k, n, new ArrayList<>(), ans);
        return ans;
    }
}
