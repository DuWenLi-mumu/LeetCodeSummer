package jzOffer;

import java.text.BreakIterator;

/**
 * Created by 杜文丽 on 10/23/2020 11:13 AM
 **/
public class AndAreTwoNumbersForS57 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            if (nums[left] + nums[right] > target){
                right--;
            }else if (nums[right] + nums[left] < target){
                left++;
            }else {
                int[] res = new int[2];
                res[0] = nums[left];
                res[1] = nums[right];
                return res;
            }
        }
        return null;
    }
}
