package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {
    static void solve(int ind, int [] candidates, int target, ArrayList<Integer> list, List<List<Integer>>ans){
        if(target < 0)
            return;
        if(ind==candidates.length)
        {
            if(target==0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        // take that only
        list.add(candidates[ind]);
        solve(ind, candidates, target-candidates[ind], list, ans);
        list.remove(list.size()-1);
        solve(ind+1, candidates, target, list, ans);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans  = new ArrayList<>();
        solve(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }
}
