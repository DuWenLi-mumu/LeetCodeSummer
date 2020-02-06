package recursion;

import java.util.Arrays;

/**
 * Created by 杜文丽 on 2020/2/6 15:32
 * 简化办法：题目描述 nums中的数字全部都是正数
 **/
public class PartitionToKEqualSumSubsets698 {
    public static void main(String[] args) {
        int[] nums={10,10,10,7,7,7,7,7,7,6,6,6};
        boolean k=canPartitionKSubsets(nums,3);
        System.out.println(k);
    }
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int avg=0;
        for (int i = 0; i <nums.length ; i++) {
            avg+=nums[i];
        }
        if (avg%k!=0){
            return false;
        }
        avg=avg/k;
        int[] arr=new int[k];
        Arrays.fill(arr,avg);
        return dfs(nums,arr,k,nums.length-1);
    }
    public static boolean dfs(int[]nums,int[] arr,int k,int curr){
        if (curr<0){
            return true;
        }
        for (int i = 0; i <k ; i++) {
            if (nums[curr]==arr[i]||curr>0&&arr[i]-nums[curr]>=nums[0]){
                //放入
                arr[i]-=nums[curr];
                if (dfs(nums, arr, k, curr-1)){
                    return true;
                }
                arr[i]+=nums[curr];//不放
            }
        }
        return false;
    }
}
