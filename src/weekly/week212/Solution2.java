package weekly.week212;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 杜文丽 on 10/25/2020 10:29 AM
 **/
public class Solution2 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length ; i++) {
            int[] ns = new int[r[i] - l[i]+1];
            for (int j = l[i]; j <= r[i] ; j++) {
                ns[j-l[i]] = nums[j];
            }
            res.add(check(ns));
        }
        return res;
    }
    public boolean check(int[] nums){
        if (nums.length<1){
            return true;
        }
        Arrays.sort(nums);
        int dis = nums[1] - nums[0];
        for (int i = 2; i <nums.length ; i++) {
            if (dis != nums[i]-nums[i-1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {4,6,5,9,3,7};
        int[] l = {0,0,2};
        int[] r = {2,3,5};
        Solution2 test = new Solution2();
        List list = test.checkArithmeticSubarrays(nums,l,r);
    }
}
