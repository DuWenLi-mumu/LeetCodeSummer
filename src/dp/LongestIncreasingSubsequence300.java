package dp;

import java.util.Stack;

/**
 * Created by 杜文丽 on 3/9/2020 9:50 AM
 **/
public class LongestIncreasingSubsequence300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length<1){
            return nums.length;
        }
        int[] dp=new int[nums.length+1];
        int index=0;
        for (int i = 0; i <nums.length ; i++) {
            if (index==0||dp[index-1]<nums[i]){
                dp[index++]=nums[i];
            }
            if(dp[index-1]==nums[i]){
                continue;
            }
            int findIndex=find(dp,index-1,nums[i]);
            if (findIndex==0){
                //遇到相等的，什么都不做
                continue;
            }else if (findIndex>0){
                //找到了替换的位置，直接进行替换，index不变
                dp[findIndex]=nums[i];
            }else {
                //没有找到比他小的，他就是最小的，替换掉第一个
                dp[0]=nums[i];
            }
        }
        return index;
    }
    public int find(int[]dp,int index,int num){
        for (int i = index; i >=0 ; i--) {
            if (dp[i]==num){
                return 0;
            }else if (dp[i]<num){
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
    }

//    public int lengthOfLIS(int[] nums) {
//        if (nums.length <= 1) {
//            return nums.length;
//        }
//        int[] dp = new int[nums.length];
//        dp[0] = 1;
//        int res = 1;
//        for (int i = 1; i < nums.length; i++) {
//            dp[i] = 1;
//            int index = i - 1;
//            boolean find = false;
//            while (index >= 0) {
//                if (nums[index] < nums[i]) {
//                    find = true;
//                    dp[i] = Math.max(dp[i], dp[index] + 1);
//                }
//                index--;
//            }
//            if (!find) {
//                dp[i] = 1;
//            }
//            res = Math.max(res, dp[i]);
//        }
//        return res;
//    }
}
