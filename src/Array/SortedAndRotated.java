package Array;

public class SortedAndRotated {
    public boolean check(int[] nums) {
        int flag = 0;
        for(int i = 1; i<nums.length; i++)
            if(nums[i-1] > nums[i])
                flag++;
        if(nums[0] < nums[nums.length-1])
            flag++;
        return flag <= 1;
    }
}
