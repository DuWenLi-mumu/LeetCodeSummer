package dp;

/**
 * Created by 杜文丽 on 2/28/2020 8:33 PM
 **/
public class TheMasseuseLCCI {
    public int massage(int[] nums) {
        if (nums.length<=0){
            return 0;
        }else if (nums.length<=1){
            return nums[0];
        }
        int[][] dp=new int[2][nums.length+1];
        dp[0][0]=0;
        dp[1][0]=nums[0];

        for (int i = 1; i <nums.length ; i++) {
            dp[0][i]=Math.max(dp[0][i-1],dp[1][i-1]);
            dp[1][i]=dp[0][i-1]+nums[i];
        }
        return Math.max(dp[0][nums.length-1],dp[1][nums.length-1]);
    }
}
