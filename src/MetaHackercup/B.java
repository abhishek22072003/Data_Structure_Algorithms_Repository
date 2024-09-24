package MetaHackercup;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

class B {    
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int T  = in.nextInt();
        for(int tt = 0; tt < T; tt++){         
            int n = in.nextInt(), a = in.nextInt();
            double  first = (double)a/100;
            //System.out.println(first);
            float  second = (float)(n-1)/n;
            //System.out.println(second);
            System.out.print("Case #"+(tt+1)+": ");
            System.out.println((Math.pow(first, second) * 100 )-a);
        }
    }
}
