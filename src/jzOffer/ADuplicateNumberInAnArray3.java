package jzOffer;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 杜文丽 on 11/9/2020 3:03 PM
 **/
public class ADuplicateNumberInAnArray3 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int before = set.size();
            set.add(nums[i]);
            if (before == set.size()){
                return nums[i];
            }
        }
        return 0;
    }
}
