package dp;

/**
 * Created by 杜文丽 on 2/27/2020 11:41 PM
 **/
public class ContiguousSequenceLCCI {
    public int maxSubArray(int[] nums) {
        if (nums.length<=0){
            return 0;
        }else if (nums.length<=1){
            return nums[0];
        }
        int res=nums[0];
        int curr=nums[0];
        for (int i = 1; i <nums.length ; i++) {
            if (curr<0){
                curr=nums[i];
            }else {
                curr+=nums[i];
            }
            res=Math.max(res,curr);
        }
        return res;
    }
}
