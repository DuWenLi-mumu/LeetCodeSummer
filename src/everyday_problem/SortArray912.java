package everyday_problem;

/**
 * Created by 杜文丽 on 3/31/2020 4:29 PM
 **/
public class SortArray912 {
    public int[] sortArray(int[] nums) {
        if (nums.length<=1){
            return nums;
        }
        quickSort(nums,0,nums.length-1);
        return nums;
    }
    public void quickSort(int[] nums,int low,int high){
        if (low>=high){
            return;
        }
        int index=partition(nums,low,high);
        quickSort(nums,low,index-1);
        quickSort(nums,index+1,high);
    }
    public int partition(int[] nums,int l,int h){
        int pivot=nums[l];
        while (l<h){
            while (l<h&&nums[h]>=pivot) h--;//右边找到一个小的
            nums[l]=nums[h];

            while (l<h&&nums[l]<=pivot) l++;//左边找到一个大的
            nums[h]=nums[l];
        }
        nums[l]=pivot;
        return l;
    }


}
