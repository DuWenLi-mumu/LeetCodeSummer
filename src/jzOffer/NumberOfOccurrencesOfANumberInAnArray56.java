package jzOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杜文丽 on 10/22/2020 10:59 PM
 **/
public class NumberOfOccurrencesOfANumberInAnArray56 {
    public int[] singleNumbers(int[] nums) {
        int[] res = new int[2];
        int tmp = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp ^= nums[i];
        }
        while ((tmp & 1) == 0) {
            index++;
            tmp = tmp >> 1;
        }
        int r1 = 0;
        int r2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (((nums[i] >> index)&1) == 0) {
                r1 ^= nums[i];
            }else {
                r2 ^= nums[i];
            }
        }
        res[0] = r1;
        res[1] = r2;
        return res;
    }
}
