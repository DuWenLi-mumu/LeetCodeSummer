package dp;

import java.util.Arrays;

/**
 * Created by 杜文丽 on 9/15/2020 10:14 AM
 **/
public class TargetSum494 {
    int res=0;
    public void solve(int sum,int index,int[]nums,int s){
        if (index>=nums.length){
            if (sum==s) {
                res++;
                return;
            }
            return;
        }
        solve(sum+nums[index],index+1,nums,s);
        solve(sum-nums[index],index+1,nums,s);
    }

    //dp算法
    /**
     * 转换成背包问题
     * 2*Sa=Sb+Sa+tar
     * Sa=[tar+S(nums)]/2;
     * 背包容量为Sa，有n个物品，求恰好装满这个背包
     *
     * 二维的超出内存限制
     */
    int[][]dp;
    public int solve2(int[] nums,int S){
        int sum=0;
        for (int i = 0; i <nums.length ; i++) {
            sum+=nums[i];
        }
        int sa=(S+sum+1)/2;
        dp=new int[nums.length+1][sa+1];//dp[i][j] 前i个物品刚好装满j的不同装法
        for (int i = 0; i <=nums.length ; i++) {
            dp[i][0]=1;//什么都不装
        }
        for (int i = 1; i <=nums.length ; i++) {
            for (int j = 1; j <=sa ; j++) {
                if (j-nums[i-1]>=0){
                    dp[i][j]=dp[i-1][j-nums[i-1]]+dp[i-1][j];
                }else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[nums.length][sa];
    }
    //dp优化

    /**
     * 将二维问题转换成一维问题
     * @param nums
     * @param S
     * @return
     */
    int[]dp2;
    public int solve3(int[] nums,int S){
        int sum=0;
        for (int i = 0; i <nums.length ; i++) {
            sum+=nums[i];
        }
        int sa=(S+sum+1)/2;
        dp2=new int[sa+1];
        dp2[0]=1;
        for (int i = 1; i <=nums.length ; i++) {
            for (int j = sa; j >=0 ; j--) {
                if (j-nums[i-1]>=0){
                    dp2[j]=dp2[j-nums[i-1]]+dp2[j];
                }else {
                    dp2[j]=dp2[j];
                }
            }
        }
        return dp2[sa];
    }
    public int findTargetSumWays(int[] nums, int S) {
        return solve2(nums,S);
    }
    public static void main(String[] args) {
        TargetSum494 test=new TargetSum494();
        int[] nums={1,1,1,1,1};
        test.findTargetSumWays(nums,3);
    }

    /**
     * [1] 2
     * sa=(2+1)/2=1.5=1;
     *
     */
}
