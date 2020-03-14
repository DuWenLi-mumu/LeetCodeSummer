package everyday_problem;

import java.util.ArrayList;

/**
 * Created by 杜文丽 on 3/14/2020 4:15 PM
 **/
public class LongestIncreasingSubsequence300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length<=1){
            return nums.length;
        }
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(nums[0]);
        for (int i = 1; i <nums.length ; i++) {
            if (nums[i]>arr.get(arr.size()-1)){
                arr.add(nums[i]);
            }else if (nums[i]==arr.get(arr.size()-1)){
                continue;
            }else {
                if (arr.size()==1){
                    arr.set(0,nums[i]);
                    continue;
                }
                for (int j = arr.size()-2; j >=0 ; j--) {
                    if (arr.get(j)==nums[i]){
                        break;
                    }else if (arr.get(j)<nums[i]){
                        arr.set(j+1,nums[i]);
                        break;
                    }
                }
            }
        }
        return arr.size();
    }
}
