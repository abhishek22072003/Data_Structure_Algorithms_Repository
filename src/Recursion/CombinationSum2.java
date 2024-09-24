package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    static void solve(int ind, int [] candidates, int target, List<Integer> path, List<List<Integer>> ans){

        if(target==0){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = ind; i<candidates.length; i++){
            if(i!=ind && candidates[i]==candidates[i-1]) continue;
            if(candidates[i]>target) break;
            path.add(candidates[i]);
            solve(i+1, candidates, target-candidates[i], path, ans);
            path.remove(path.size()-1);
            //solve(i+1, candidates, target, path, ans);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        solve(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }
}