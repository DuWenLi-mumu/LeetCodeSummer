package weekly.week212;

/**
 * Created by 杜文丽 on 10/25/2020 10:29 AM
 **/
public class Solution3 {
//    public int minimumEffortPath(int[][] heights) {
//        int[][] dp = new int[heights.length][heights[0].length];
//
//    }

    public boolean dfs(int[][] heights, int k, int[][] done, int i, int j) {
        if (i < 0 || i > heights.length - 1 || j < 0 || j > heights[0].length - 1) {
            return false;
        }
        if (done[i][j] == 1) {
            return false;
        }
        if (i == heights.length - 1 && j == heights[0].length - 1) {
            return true;
        }
        done[i][j] = 1;
        boolean up;
        boolean down;
        boolean left;
        boolean right;
        //上 i-1,j
        if (i - 1 >= 0 && i - 1 < heights.length - 1) {
            if (k < Math.abs(heights[i - 1][j] - heights[i][j])) {
                up = false;
            } else {
                if (dfs(heights, k, done, i - 1 ,j)){
                    up = true;
                }else{
                    up = false;
                }
            }
        } else {
            up = false;
        }
        //下 i+1,j
        if (i + 1 >= 0 && i + 1 < heights.length - 1){
            if (k < Math.abs(heights[i + 1][j] - heights[i][j])){
                down = false;
            }else {
                if (dfs(heights, k, done, i + 1 ,j)){
                    down = true;
                }else{
                    down = false;
                }
            }
        }else {
            down = false;
        }
        return false;
    }
}
