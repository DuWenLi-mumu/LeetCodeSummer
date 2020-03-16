package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 杜文丽 on 3/14/2020 10:26 PM
 * dp[i]表示以i结尾的满足条件的最大子集个数
 **/
public class LargestDivisibleSubset368 {

    public static void main(String[] args) {
        int[] nums={4,8,10,240};
        largestDivisibleSubset(nums);
    }
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res=new ArrayList<>();
        if (nums.length<=0){
            return res;
        }else if (nums.length<=1){
            res.add(nums[0]);
            return res;
        }
        Arrays.sort(nums);
        int[] dp=new int[nums.length+1];
        dp[0]=1;
        int count=1;
        int number=nums[0];
        for (int i = 1; i <nums.length ; i++) {
            boolean find=false;
            for (int j = i-1; j >=0 ; j--) {
                if (nums[i]%nums[j]==0){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    find=true;
                }
            }
            if (!find){
                dp[i]=1;
            }
            if (count<dp[i]){
                count=dp[i];
                number=nums[i];
            }
        }

        for (int i = nums.length-1; i >=0 ; i--) {
            if (dp[i]==count){
                res.add(nums[i]);
                count--;
            }
        }
        return res;
    }
}
