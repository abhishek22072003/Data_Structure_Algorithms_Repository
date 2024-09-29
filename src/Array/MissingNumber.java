package Array;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        long allsum = (len * (len+1))/2;
        long sum = 0;
        for(int a: nums)
            sum+=a;
        return (int)(allsum-sum);
    }
}
