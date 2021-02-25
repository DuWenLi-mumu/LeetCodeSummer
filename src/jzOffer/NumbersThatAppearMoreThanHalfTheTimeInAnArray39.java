package jzOffer;

public class NumbersThatAppearMoreThanHalfTheTimeInAnArray39 {
    public static int majorityElement(int[] nums) {
        int num = nums[0];
        int c = 1;
        for (int i = 1; i < nums.length; i++) {
            if (c <= 0){
                num = nums[i];
                c = 1;
            }else if (num == nums[i]){
                c++;
            }else {
                c--;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] nums = {6,5,5};
        majorityElement(nums);
    }
}
