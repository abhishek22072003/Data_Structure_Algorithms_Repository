package Array;

public class SecondLargest {
    public int print2largest(int[] arr) {
        int largest = -1;
        int secondLargest = -1;
        for(int a: arr){
            if(a > largest){
                largest  = a;
                secondLargest = largest;
            }
            if(a > secondLargest && a != largest){
                secondLargest = a;
            }
        }
        return secondLargest;
    }
}
