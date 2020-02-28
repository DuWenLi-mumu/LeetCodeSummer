package dp;

/**
 * Created by 杜文丽 on 2/28/2020 8:46 PM
 **/
public class UniquePathsII63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int MIN=-11111111;
        int[][] dp=new int[m][n];
        boolean obstacle=false;
        for (int i = 0; i <m ; i++) {
            if (obstacle){
                dp[i][0]=MIN;
            }else if (obstacleGrid[i][0]==1){
                obstacle=true;
                dp[i][0]=MIN;
            }else {
                dp[i][0]=1;
            }
        }
        obstacle=false;
        for (int i = 0; i <n ; i++) {
            if (obstacle){
                dp[0][i]=MIN;
            }else if (obstacleGrid[0][i]==1){
                obstacle=true;
                dp[0][i]=MIN;
            }else {
                dp[0][i]=1;
            }
        }
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                if (obstacleGrid[i][j]==1){
                    dp[i][j]=MIN;
                }else {
                    dp[i][j]=Math.max(Math.max(dp[i-1][j],dp[i][j-1]),dp[i-1][j]+dp[i][j-1]);
                }
            }
        }
        if (dp[m-1][n-1]<0){
            return 0;
        }
        return dp[m-1][n-1];
    }
}
