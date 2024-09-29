package Array;

public class LinearSearch {
    static int searchInSorted(int arr[], int N, int K) {
        for(int i = 0; i<arr.length; i++)
                if(arr[i]==K)
                    return i;
        return -1;
    }
}
