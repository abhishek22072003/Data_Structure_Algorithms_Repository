package Array;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int [] solution = new int[nums.length];
        for(int i = nums.length - k; i<nums.length; i++)
            solution[i-nums.length-k] = nums[i];
        for(int i = 0; i<nums.length - k; i++){
            solution[i+k] = nums[i];
        }
        for(int i = 0; i<nums.length; i++)
            nums[i] = solution[i];
    }
}
