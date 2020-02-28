package dp;

/**
 * Created by 杜文丽 on 2/28/2020 8:40 PM
 **/
public class UniquePaths62 {
    public int uniquePaths(int m, int n) {
        if (m<=1||n<=1){
            return 1;
        }
        int[][] dp=new int[m][n];
        for (int i = 0; i <m ; i++) {
            dp[m][0]=1;
        }
        for (int i = 0; i <n ; i++) {
            dp[0][n]=1;
        }
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                dp[i][j]=dp[i][j-1]+dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}
