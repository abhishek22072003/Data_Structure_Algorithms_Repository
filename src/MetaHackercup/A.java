package MetaHackercup;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    static Scanner in;
    static String  solve(Scanner in){
        int N = in.nextInt(), K = in.nextInt();
        long [] arr = new long[N];
        Arrays.sort(arr);
        for(int i = 0; i<N; i++)
            arr[i] = in.nextLong();
        long minRequired = 0;
        for(int i = arr.length-1; i>=0; i--){
            if(i==arr.length-1 && i!=0) continue;
            if(i==0) minRequired+=arr[i];
            else minRequired+=arr[i]*2;
        }
        if(minRequired <= K)
            return "YES";
        else
            return "NO";

    }
    public static void main(String[] args) {
        in = new Scanner(System.in);
        int T = in.nextInt();
        for(int tt = 0; tt<T; tt++){
            System.out.println("Case #"+(tt+1)+": "+solve(in));
        }
    }
}
