package jzOffer;

import java.util.Map;

/**
 * Created by 杜文丽 on 10/19/2020 7:47 PM
 **/
public class TheGreatestValueOfAGift47 {
    public int maxValue(int[][] grid) {
        int m=grid.length;
        //判断边界为0情况
        if (m < 1){
            return 0;
        }
        int n = grid[0].length;
        if (n < 1){
            return 0;
        }
        int[][]dp = new int[m][n];
        //处理边界值
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }
        for (int i = 1; i < n ; i++) {
            dp[0][i] = grid[0][i] + dp[0][i-1];
        }
        for (int i = 1; i < m ; i++) {
            for (int j = 1; j < n ; j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] test={{1,3,1},{1,5,1},{4,2,1}};
        TheGreatestValueOfAGift47 t=new TheGreatestValueOfAGift47();
        t.maxValue(test);
    }
}
