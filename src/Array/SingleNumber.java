package Array;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for(int a: nums)
            xor  = xor ^ a;
        return xor;
    }
}
