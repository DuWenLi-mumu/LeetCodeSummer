package dp;

/**
 * Created by 杜文丽 on 3/13/2020 10:37 PM
 **/
public class HouseRobberII213 {
    public int rob(int[] nums) {
        if (nums.length<=0){
            return 0;
        }else if(nums.length<=1){
            return nums[0];
        }
        int[][] dp1=new int[2][nums.length];
        int[][] dp2=new int[2][nums.length];
        dp1[0][0]=0;
        dp1[1][0]=nums[0];
        dp2[0][1]=0;
        dp2[1][1]=nums[1];
        for (int i = 1; i <nums.length-1 ; i++) {
            dp1[0][i]=Math.max(dp1[1][i-1],dp1[0][i-1]);
            dp1[1][i]=dp1[0][i-1]+nums[i];
        }
        for (int i = 2; i <nums.length ; i++) {
            dp2[0][i]=Math.max(dp2[1][i-1],dp2[0][i-1]);
            dp2[1][i]=dp2[0][i-1]+nums[i];
        }
        int res1=Math.max(dp1[0][nums.length-2],dp1[1][nums.length-2]);
        int res2=Math.max(dp2[0][nums.length-1],dp2[1][nums.length-1]);
        return Math.max(res1,res2);

    }
}
