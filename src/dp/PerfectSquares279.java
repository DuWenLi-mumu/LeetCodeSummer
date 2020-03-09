package dp;

import java.util.Arrays;

/**
 * Created by 杜文丽 on 3/9/2020 7:36 PM
 **/
public class PerfectSquares279 {
    public int numSquares(int n) {
        int sqrt= (int) Math.sqrt(n);
        if (n==sqrt*sqrt){
            return 1;
        }
        int[] dp=new int[n+1];
        Arrays.fill(dp,n);
        dp[0]=0;
        dp[1]=1;
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=sqrt ; j++) {
                int square=j*j;
                if (i<square){
                    break;
                }
                else {
                    dp[i]=Math.min(dp[i],dp[i-square]);
                }
            }
        }
        return dp[n];
    }
}
