package dp;

import java.util.Stack;

/**
 * Created by 杜文丽 on 3/9/2020 9:50 AM
 **/
public class LongestIncreasingSubsequence300 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        lengthOfLIS(nums);
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            int index = i - 1;
            boolean find = false;
            while (index >= 0) {
                if (nums[index] < nums[i]) {
                    find = true;
                    dp[i] = Math.max(dp[i], dp[index] + 1);
                }
                index--;

            }
            if (!find) {
                dp[i] = 1;
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
