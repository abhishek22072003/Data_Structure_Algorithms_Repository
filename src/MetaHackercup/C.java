package MetaHackercup;

import java.util.Arrays;
import java.util.Scanner;

class C {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int T  = in.nextInt();
        for(int tt = 0; tt < T; tt++){
            int n  = in.nextInt(), goal = in.nextInt();
            boolean [] present = new boolean[1000001];
            for(int i = 0; i<n; i++){
                int val = in.nextInt();
                present[val] = true;
            }
            int min = Integer.MAX_VALUE;
            int ind = -1;
            int ele =  n;
            for(int i =1; i<present.length; i++){   
                if(present[i]){                     
                    int curr_dis = Math.abs(goal-i);                    
                    if(curr_dis <= min){
                        min = curr_dis; 
                        ind = ele;                        
                    }
                    ele--;
                }
            }
            System.out.print("Case #"+(tt+1)+": ");
            System.out.println(ind+" "+min);

            
        }
    }
}
