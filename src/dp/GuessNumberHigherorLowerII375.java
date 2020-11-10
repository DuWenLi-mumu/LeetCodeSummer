package dp;

public class GuessNumberHigherorLowerII375 {
    public int getMoneyAmount(int n) {
        if (n < 1) {
            return 0;
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        //初始化操作 只有一个数 不用猜 只有两个数 猜最小的cost最小
        for (int i = 0; i <= n; i++) {
            dp[i][i] = 0;
            if (i + 1 <= n) {
                dp[i][i + 1] = i;
            }
        }

        for (int j = 2; j <= n; j++) {
            for (int i = j-1; i >=0; i--) {
                int min = i + dp[i + 1][j];//算右端
                for (int k = i + 1; k <= j - 1; k++) {
                    min = Math.min(min, Math.max(dp[i][k - 1], dp[k + 1][j]) + k);
                }
                min = Math.min(min, j + dp[i][j - 1]);//算左端
                dp[i][j] = min;
            }
        }
        return dp[0][n];
    }
}
