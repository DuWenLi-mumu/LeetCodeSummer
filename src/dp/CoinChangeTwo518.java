package dp;

/**
 * Created by 杜文丽 on 9/18/2020 10:52 AM
 **/
public class CoinChangeTwo518 {
    public int change(int amount, int[] coins) {
        //完全背包问题
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];
        for (int i = 0; i <=n ; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i <=coins.length ; i++) {
            for (int j = amount; j >0 ; j--) {
                if (j-coins[i-1]>=0){
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-coins[i-1]];
                }else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }
}
