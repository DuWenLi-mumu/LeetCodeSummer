package dp;

/**
 * Created by 杜文丽 on 2/25/2020 9:30 PM
 **/
public class HouseRobber198 {
    public int rob(int[] nums) {
        if (nums.length<=0){
            return 0;
        }else if (nums.length<=1){
            return nums[0];
        }
        int[][] dp=new int[2][nums.length];
        dp[0][0]=0;
        dp[1][0]=nums[0];
        for (int i = 1; i <nums.length ; i++) {
            dp[1][i]=dp[0][i-1]+nums[i];
            dp[0][i]=Math.max(dp[0][i-1],dp[1][i-1]);
        }
        return Math.max(dp[0][nums.length-1],dp[1][nums.length-1]);
    }
}
