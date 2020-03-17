package dp;

import javax.xml.transform.stax.StAXResult;
import java.util.Arrays;

/**
 * Created by 杜文丽 on 3/17/2020 6:28 PM
 * dp[i]表示nums中的数字是否能够组成和为i
 **/
public class PartitionEqualSubsetSum416 {

    public boolean canPartition(int[] nums) {
        int sum=0;
        for (int i = 0; i <nums.length ; i++) {
            sum+=nums[i];
        }
        if (sum%2!=0){
            return false;
        }
        sum/=2;
        boolean[] dp=new boolean[sum+1];
        boolean[] used=new boolean[sum+1];
        Arrays.fill(dp,false);
        Arrays.fill(used,false);
        dp[0]=true;
        if (nums[0]<=sum){
            dp[nums[0]]=true;
        }
        //如果正序 会出现 前面的数字 重复使用的情况
        for (int i = 1; i <nums.length ; i++) {
            for (int j = sum; j >=nums[i] ; j--) {
                if (dp[sum]){
                    return true;
                }
                dp[j]=dp[j]||dp[j-nums[i]];//只要有一个组合能够组成j，则就可以组成j
            }
        }

        return dp[sum];
    }
}
