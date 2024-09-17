package Array;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int l = 0;
        int r  = 1;
        while(r < nums.length){
            if(nums[l]==nums[r]){
                r++;
            }
            else{
                l++;
                nums[l] = nums[r];
                r++;
            }
        }
        return l;
    }
}
