package dp;

/**
 * Created by 杜文丽 on 9/18/2020 6:26 PM
 **/
public class BurstBalloons312 {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[][]dp=new int[n+2][n+2];
        int[] points=new int[n+2];
        points[0]=points[1]=1;
        for (int i = 0; i <n ; i++) {
            points[i+1]=nums[i];
        }
        for (int i = n; i >=0 ; i++) {
            for (int j = i+1; j <=n ; j++) {
                for (int k = i; k <=j ; k++) {
                    dp[i][j]=Math.max(dp[i][j],dp[i][k]+dp[k][j]+points[i]*points[j]*points[k]);
                }
            }
        }
        return dp[0][n+1];
    }
}
