package Array;

import java.util.HashMap;

public class LongestSubarrayWithSumK {
    public static int lenOfLongSubarr(int A[], int N, int K) {
        HashMap<Integer, Integer> map  = new HashMap<>();
        int pref = 0;
        int max =0;
        for(int i =0; i<A.length; i++){
            pref += A[i];
            if(pref==K){
                max = i+1;
            }
            if(map.containsKey(pref-K)){
                int len = i-map.get(pref-K);
                max = Math.max(max, len);
            }
            if(!map.containsKey(pref))
                map.put(pref, i);
        }
        return max;
    }
}
