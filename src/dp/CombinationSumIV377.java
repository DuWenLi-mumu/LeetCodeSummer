package dp;

import java.util.Arrays;

/**
 * Created by 杜文丽 on 3/17/2020 4:53 PM
 * dp[i]表示和为i的组成总个数
 **/
public class CombinationSumIV377 {

    public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[target+1];
        dp[0]=0;
        for (int i = 1; i <=target ; i++) {
            for (int j = 0; j <nums.length ; j++) {
                if (i-nums[j]>=0){
                    dp[i]+=dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }

}
