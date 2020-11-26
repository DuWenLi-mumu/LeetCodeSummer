package jzOffer;

import java.text.BreakIterator;

/**
 * Created by 杜文丽 on 11/20/2020 4:48 PM
 **/
public class AdjustTheArrayOrderSoThatOddNumbersPercedeEvenNumbers21 {
    public static int[] exchange(int[] nums) {
        if(nums.length < 1){
            return nums;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            //左边找到一个偶数
            while (left < right && nums[left] % 2 == 1){
                left++;
            }
            //右边找到一个奇数
            while (right > left && nums[right] % 2 == 0){
                right--;
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        exchange(nums);
    }
}
