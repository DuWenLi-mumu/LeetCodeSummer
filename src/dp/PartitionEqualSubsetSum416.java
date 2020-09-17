package dp;

import javax.xml.transform.stax.StAXResult;
import java.util.Arrays;

/**
 * Created by 杜文丽 on 3/17/2020 6:28 PM
 * dp[i]表示nums中的数字是否能够组成和为i
 **/
public class PartitionEqualSubsetSum416 {
    public static void main(String[] args) {
        PartitionEqualSubsetSum416 test=new PartitionEqualSubsetSum416();
        int[] nums={1,2,3,4,5,6,7};
        test.canPartition(nums);
    }
    public boolean canPartition(int[] nums) {
        int len=nums.length;
        int sum=0;
        for (int i = 0; i <nums.length ; i++) {
            sum+=nums[i];
        }
        int[][][] dp=new int[2][len+1][2];
        dp[0][0][0]=0;
        dp[0][0][1]=sum;
        dp[1][0][0]=nums[0];
        dp[1][0][1]=sum-nums[0];
        for (int i = 1; i <len ; i++) {
            //不拿--》上一个也不拿
            dp[0][i][0]=dp[0][i-1][0];
            dp[0][i][1]=sum-dp[0][i][0];
            if (dp[0][i][0]==dp[0][i][1]){
                return true;
            }
            //不拿--》上一个拿
            dp[0][i][0]=dp[1][i-1][0];
            dp[0][i][1]=sum-dp[0][i][0];
            if (dp[0][i][0]==dp[0][i][1]){
                return true;
            }
            //拿--》上一个不拿
            dp[1][i][0]=dp[0][i-1][0]+nums[i];
            dp[1][i][1]=sum-dp[1][i][0];
            if (dp[1][i][0]==dp[1][i][1]){
                return true;
            }
            //拿--》上一个拿
            dp[1][i][0]=dp[1][i-1][0]+nums[i];
            dp[1][i][1]=sum-dp[1][i][0];
            if (dp[1][i][0]==dp[1][i][1]){
                return true;
            }
        }
        for (int i = 0; i <2 ; i++) {
            for (int j = 0; j <len ; j++) {
                System.out.print("dp["+i+"]"+"["+j+"]:"+dp[i][j][0]+" ");
            }
            System.out.println();
        }
        return false;
    }

//    public boolean canPartition(int[] nums) {
//        int sum=0;
//        for (int i = 0; i <nums.length ; i++) {
//            sum+=nums[i];
//        }
//        if (sum%2!=0){
//            return false;
//        }
//        sum/=2;
//        boolean[] dp=new boolean[sum+1];
//        boolean[] used=new boolean[sum+1];
//        Arrays.fill(dp,false);
//        Arrays.fill(used,false);
//        dp[0]=true;
//        if (nums[0]<=sum){
//            dp[nums[0]]=true;
//        }
//        //如果正序 会出现 前面的数字 重复使用的情况
//        for (int i = 1; i <nums.length ; i++) {
//            for (int j = sum; j >=nums[i] ; j--) {
//                if (dp[sum]){
//                    return true;
//                }
//                dp[j]=dp[j]||dp[j-nums[i]];//只要有一个组合能够组成j，则就可以组成j
//            }
//        }
//
//        return dp[sum];
//    }
}
