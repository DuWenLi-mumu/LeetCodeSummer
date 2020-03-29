package array;

/**
 * Created by 杜文丽 on 8/3/2019 11:23 AM
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 **/
public class MaximumProductSubarray152 {
    //日妈 dp这个也太强了吧，直接降到O(n)
    int[] dpmin=new int[100000];
    int[] dpmax=new int[100000];
    int res=0;

    public int maxProduct(int[] nums) {
        for (int i = 0; i <100000 ; i++) {
            dpmin[i]=100000;
            dpmax[i]=-100000;
        }
        dpmax[0]=nums[0];
        dpmin[0]=nums[0];
        res=nums[0];

        for (int i = 1; i <nums.length ; i++) {
            dpmax[i]=Math.max(dpmax[i-1]*nums[i],dpmin[i-1]*nums[i]);
            dpmin[i]=Math.min(dpmax[i-1]*nums[i],dpmin[i-1]*nums[i]);
            res=Math.max(dpmax[i],dpmin[i]);
        }


        return res;
    }
}