package dp;

/**
 * Created by 杜文丽 on 3/7/2020 6:20 PM
 **/
public class MaximumProductSubarray152 {
    public int maxProduct(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        if (nums.length <= 1) {
            return nums[0];
        }
        int res=nums[0];
        int max=nums[0];
        int min=nums[0];

        for (int i = 1; i <nums.length ; i++) {
            if (nums[i]<0){
                //交换max，min
                int tmp=min;
                min=max;
                max=tmp;
            }
            min=Math.min(nums[i],min*nums[i]);
            max=Math.max(nums[i],max*nums[i]);
            res=Math.max(res,max);
        }
        return res;
    }
}
