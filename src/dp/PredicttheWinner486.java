package dp;

/**
 * Created by 杜文丽 on 3/18/2020 9:08 PM
 * dp[i][j]表示1号比2号在区间i,j多出的总数
 **/
public class PredicttheWinner486 {
    public boolean PredictTheWinner(int[] nums) {
        if (nums.length%2==0){
            return true;
        }
        int[][]dp=new int[nums.length][nums.length];
        for (int i = 0; i <nums.length ; i++) {
            dp[i][i]=nums[i];
            for (int j = 0; j <i-1 ; j++) {
                dp[j][i]=Math.max(nums[i]-dp[j][i-1],nums[j]-dp[j+1][i]);
            }
        }
        return dp[0][nums.length-1]>0;
    }
}
