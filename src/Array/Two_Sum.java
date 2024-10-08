package Array;

import java.util.Arrays;
import java.util.HashMap;

public class Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int req  = target-nums[i];
            if(map.containsKey(req))
                return new int[]{map.get(req), i};
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
