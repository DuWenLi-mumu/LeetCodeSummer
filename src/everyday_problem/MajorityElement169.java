package everyday_problem;

/**
 * Created by 杜文丽 on 3/13/2020 3:03 PM
 **/
public class MajorityElement169 {
    public int majorityElement(int[] nums) {
        int num=nums[0];
        int c=1;
        for (int i = 1; i <nums.length ; i++) {
            if (c<1){
                num=nums[i];
                c=1;
                continue;
            }
            if (num==nums[i]){
                c++;
            }else {
                c--;
            }
        }
        return num;
    }
}
