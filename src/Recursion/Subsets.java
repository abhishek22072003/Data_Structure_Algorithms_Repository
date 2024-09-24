package Recursion;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Subsets {


    static void solve(int ind, int [] nums, ArrayList<Integer> list, List<List<Integer>> subset){
        if(ind==nums.length){
            subset.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[ind]);
        solve(ind+1, nums, list, subset);
        list.remove(list.size()-1);
        solve(ind+1, nums, list, subset);
    }
    public static List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> subset = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        solve(0, nums, list, subset);
        return subset;
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3};
        System.out.println(subsets(arr));
    }

}
