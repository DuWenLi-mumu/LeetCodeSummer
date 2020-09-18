package dp;

import org.omg.CORBA.MARSHAL;

/**
 * Created by 杜文丽 on 9/18/2020 4:36 PM
 **/
public class SuperEggDrop887 {
    public int solve1(int K,int N){
        //1.dp[k][m] 鸡蛋有k个，可以扔m次，dp[k][m]所达到的楼层高度
        int[][]dp=new int[K+1][N+1];
        int m=0;
        while (dp[K][m]<N){
            m++;
            for (int k = 0; k <=K ; k++) {
                dp[k][m]=dp[k][m-1]+dp[k-1][m-1]+1;
            }
        }
        return m;
    }
    public int solve2(int K,int N){
        //dp[k][n] k个鸡蛋，n层楼，dp[k][n]在最坏情况下最少扔的次数
        //目前来说我没有办法处理最小这个操作，所以我写不出来这种假定下的动态规划解法
        int[][]dp=new int[K+1][N+1];
        for (int i = 0; i <=N ; i++) {
            dp[0][i] = Integer.MAX_VALUE;
            dp[1][i] = i;
        }
        for (int i = 1; i <=K ; i++) {
            for (int j = 1; j <=N ; j++) {
                dp[i][j]= Math.max(dp[i-1][j-1]+1,dp[i][N-j]+1);
            }
        }
        return dp[K][N];
    }
    public int superEggDrop(int K, int N) {
        return 0;
    }
}
