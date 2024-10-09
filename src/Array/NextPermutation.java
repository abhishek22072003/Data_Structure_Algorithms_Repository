package Array;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        for(int i = nums.length-1; i>0; i--){
            if(nums[i-1] < nums[i]){
                pivot = i-1;
                break;
            }
        }
        // array in descending order
        if(pivot==-1){
            Arrays.sort(nums);
            return;
        }
        int ele = nums[pivot];
        int maxIndex = pivot;
        for(int i = pivot+1; i<nums.length; i++){
            if(nums[i] > nums[pivot]){
               maxIndex = i;
            }
        }
        System.out.println(pivot+" "+maxIndex);
        // swap this two
        ele = nums[pivot];
        nums[pivot]= nums[maxIndex];
        nums[maxIndex] = ele;

        // sort further array
        for(int i = pivot+1; i<nums.length; i++){
            for(int j = pivot+1; j<nums.length-1; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                     nums[j] = nums[j+1];
                     nums[j+1]= temp;
                }
            }
        }
    }
}
