package jzOffer;

/**
 * Created by 杜文丽 on 10/22/2020 10:27 PM
 **/
public class LookForANumberInTheSortedArray53 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        int count = 0;
        while (left <= right) {
            if (nums[mid] == target) {
                count++;
                int midL = mid - 1;
                while (midL >= left && nums[midL] == target) {
                    count++;
                    midL--;
                }
                int midR = mid + 1;
                while (midR <= right && nums[midR] == target) {
                    count++;
                    midR++;
                }
                break;
            }else if (nums[mid]>target){
                right = mid - 1;
                mid = (right + left) / 2;
            }else {
                left = mid + 1;
                mid = (right + left) / 2;
            }
        }
        return count;
    }
}
