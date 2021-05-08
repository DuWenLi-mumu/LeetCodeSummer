package everyday_problem;

public class FindTheMinimumValueInTheRotationSortArray153 {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int mid = (r + l) / 2;
        while (l < r){
            mid = (r + l) / 2;
            if (nums[r] > nums[mid]){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
