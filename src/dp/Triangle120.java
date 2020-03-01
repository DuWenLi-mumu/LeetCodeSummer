package dp;

import java.util.List;

/**
 * Created by 杜文丽 on 2/29/2020 7:40 PM
 **/
public class Triangle120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size()<=0){
            return 0;
        }else if (triangle.size()<=1){
            int min=triangle.get(0).get(0);
            for (int i = 1; i <triangle.get(0).size() ; i++) {
                min=Math.min(min,triangle.get(0).get(i));
            }
            return min;
        }
        int m=triangle.size();
        int[][] dp=new int[m][m];
        for (int i = m/2; i <m ; i++) {
            for (int j = m/2; j <m ; j++) {
                dp[i][j]=11111111;
            }
        }


    }
}
