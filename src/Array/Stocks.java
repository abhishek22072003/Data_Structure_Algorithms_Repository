package Array;

public class Stocks {
    public int maxProfit(int[] prices) {
        int max  = 0;
        int lsf = prices[0];
        for(int i= 0; i<prices.length; i++){
            int profit = prices[i]-lsf;
            max = Math.max(max, profit);
            lsf = Math.min(lsf, prices[i]);
        }
        return max;
    }
}
