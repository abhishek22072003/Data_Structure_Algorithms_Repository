package Array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        int len = 0;
        Set<Integer> set = new HashSet<>();
        for(int a: nums)
            set.add(a);
        for(int a: nums){
            if(!set.contains(a-1)){
                len = 0;
                int x = a;
                while(set.contains(x)){
                    len++;
                    x++;
                }
                max = Math.max(len, max);
            }
        }
        return max;
    }
}
