package greedy;

/**
 * Created by 杜文丽 on 2019/12/9 16:26
 **/
public class BestTimeToBuyAndSellStockII122 {
    public int maxProfit(int[] prices) {
        if (prices.length<=1){
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        //第0天不允许操作 什么都没有
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][0] = Integer.MIN_VALUE;
        dp[1][0] = 0;
        dp[1][1] = -prices[0];
        for (int i = 2; i <= n ; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i-1],dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i-1],dp[i - 1][1]);
        }
        return dp[n][0];
    }


}
