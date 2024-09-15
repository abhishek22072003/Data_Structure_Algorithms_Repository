package Array;

public class LargestElement {
    public static int largest(int[] arr) {
        int max  = -1;
        for(int a: arr)
            max = Math.max(max, a);
        return max;
    }
}
