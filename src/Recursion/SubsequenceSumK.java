package Recursion;

public class SubsequenceSumK {
    static int solve(int ind, int [] arr, int n, int sum, int currsum){
        if(ind==n){
            if(currsum==sum)
                return 1;
            return 0;
        }
        int pick = solve(ind+1, arr, n, sum, currsum+arr[ind]);
        int notpic = solve(ind+1, arr, n, sum, currsum);
        return pick+notpic;
    }
    public int perfectSum(int arr[],int n, int sum)
    {
       return solve(0, arr, n, sum, 0);
    }
}
