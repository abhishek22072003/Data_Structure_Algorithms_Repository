package Daily;

public class LongestSubarrayWithAnd {
    public int longestSubarray(int[] nums) {
        // adding the one smaller and one bigger element in AND operation reduces the overall and
        // there in this question just find biggest number and find its maximum continuous length
        int big = -1;
        for(int a: nums)
            big = Math.max(big, a);
        int max = -1;
        int curr = 0;
        for(int a: nums){
            if(a==big)
                curr++;
            else {
                curr  =0;
            }
            max = Math.max(curr, max);
        }
        return max;
    }
}
