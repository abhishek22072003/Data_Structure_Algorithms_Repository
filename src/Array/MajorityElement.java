package Array;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int ele = nums[0];
        int cnt = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]==ele)
                cnt++;
            else
                cnt--;
            if(cnt<=0){
                cnt = 0;
                ele = nums[i];
            }
        }
        return ele;
    }
}
