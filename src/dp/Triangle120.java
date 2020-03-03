package dp;

import java.util.List;

/**
 * Created by 杜文丽 on 2/29/2020 7:40 PM
 **/
public class Triangle120 {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int m=triangle.size();
        if (m<=0){
            return 0;
        }
        int[][] dp=new int[m][m];
        for (int i = 0; i <m ; i++) {
            dp[m-1][i]=triangle.get(m-1).get(i);
        }
        for (int i = m-2; i >=0 ; i--) {
            for (int j = 0; j <triangle.get(i).size() ; j++) {
                dp[i][j]=Math.min(dp[i+1][j+1]+triangle.get(i).get(j),dp[i+1][j]+triangle.get(i).get(j));
            }
        }
        return dp[0][0];
    }
}
