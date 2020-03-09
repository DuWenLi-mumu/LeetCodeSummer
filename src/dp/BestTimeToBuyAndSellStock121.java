package dp;

/**
 * Created by 杜文丽 on 3/9/2020 9:32 AM
 **/
public class BestTimeToBuyAndSellStock121 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int[][][] dp = new int[2][2][prices.length];
        dp[0][0][0] = Integer.MIN_VALUE;
        dp[0][1][0] = -prices[0];
        dp[1][0][0] = 0;
        dp[1][1][0] = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length; i++) {
            dp[0][1][i] = Math.max(dp[0][1][i - 1], dp[1][0][i - 1] - prices[i]);
            dp[0][0][i] = dp[0][0][i - 1];
            dp[1][0][i] = dp[1][0][i - 1];
            dp[0][0][i] = Math.max(dp[0][0][i - 1], dp[0][1][i - 1] + prices[i]);
        }
        if (dp[0][0][prices.length-1]<0){
            return 0;
        }
        return dp[0][0][prices.length - 1];
    }
}
