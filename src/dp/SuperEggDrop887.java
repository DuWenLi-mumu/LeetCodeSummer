package dp;

/**
 * Created by 杜文丽 on 9/18/2020 4:36 PM
 **/
public class SuperEggDrop887 {
    public int superEggDrop(int K, int N) {
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
}
