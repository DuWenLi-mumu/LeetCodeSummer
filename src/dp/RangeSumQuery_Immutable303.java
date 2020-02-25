package dp;

/**
 * Created by 杜文丽 on 2/25/2020 9:26 PM
 **/
public class RangeSumQuery_Immutable303 {

}
class NumArray {
    public int[] nums;
    public NumArray(int[] nums) {
        this.nums=nums;
    }

    public int sumRange(int i, int j) {
        int res=0;
        for (int k =i; k <=j ; k++) {
            res+=nums[k];
        }
        return res;
    }
}
