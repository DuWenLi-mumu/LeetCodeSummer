package jzOffer;


import java.util.Arrays;

public class TheRunesInPlayingCards61 {
    public boolean isStraight(int[] nums) {
        if (nums.length < 2){
            return true;
        }
        Arrays.sort(nums);
        int c0 = 0;
        int i = 0;
        int gap = 0;
        while (i < nums.length){
            if (nums[i] == 0){
                c0++;
                i++;
            }else {
                break;
            }
        }
        for (int j = i; j < nums.length - 1; j++) {
            if (nums[j + 1] == nums[j]){
                return false;
            }
            gap += nums[j + 1] - nums[j] - 1;
        }
        if (gap > c0){
            return false;
        }
        return true;
    }
}
