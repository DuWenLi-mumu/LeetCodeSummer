package dp;

/**
 * Created by 杜文丽 on 3/5/2020 4:50 PM
 **/
public class BestTimetoBuyandSellStockwithCooldown309 {
    public int maxProfit(int[] prices) {
        if (prices.length<2){
            return 0;
        }
        int[][] dp=new int[2][prices.length];
        dp[0][0]=0;
        dp[1][0]=-prices[0];
        dp[0][1]=Math.max(dp[0][0],dp[1][0]+prices[1]);
        dp[1][1]=Math.max(-prices[1],dp[1][0]);
        for (int i = 2; i <prices.length ; i++) {
            dp[1][i]=Math.max(dp[1][i-1],dp[0][i-2]-prices[i]);
            dp[0][i]=Math.max(dp[0][i-1],dp[1][i-2]+prices[i]);
        }
        return Math.max(dp[0][prices.length-1],dp[1][prices.length-1]);
    }
}
