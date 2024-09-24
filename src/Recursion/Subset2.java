package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Subset2 {
    static void solve(int ind, int [] nums, ArrayList<Integer> path, List<List<Integer>> ans){

        ans.add(new ArrayList<>(path));

        for(int i = ind; i<nums.length; i++){
            if(i!=ind && nums[i]==nums[i-1]) continue;
            path.add(nums[i]);
            solve(i+1, nums, path, ans);
            path.remove(path.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        solve(0, nums, new ArrayList<>(), ans);
        return ans;
    }
}