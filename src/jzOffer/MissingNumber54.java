package jzOffer;

/**
 * Created by 杜文丽 on 10/22/2020 10:34 PM
 **/
public class MissingNumber54 {
    public int missingNumber(int[] nums) {


        int n = 0;
        for (int i = 0; i <= nums.length; i++) {
            n ^= i;
            if (i < nums.length)
                n ^= nums[i];
        }
        return n;
    }
}
