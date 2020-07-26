package point;

/**
 * Created by 杜文丽 on 7/26/2020 2:14 PM
 **/
public class SortColors75 {
    public void sortColors(int[] nums) {
        quickSort(nums,0,nums.length-1);
    }

    /**
     * 快速排序，找到一个pivot,l、h两个指针分别指向头尾，
     * 从后往前扫描，发现当前值比pivot小，l，h值交换
     * 再从前往后扫描，发现当前值比pivot大，l，h交换
     *
     */
    public void quickSort(int[] nums,int left,int right){
        if (left>=right){
            return;
        }
        //默认第一个为pivot
        int oldleft=left;
        int oldright=right;
        int pivot=nums[left];
        while (left<right){
            while (right>left&&nums[right]>=pivot)
                right--;
            nums[left]=nums[right];
            while (left<right&&nums[left]<pivot)
                left++;
            nums[right]=nums[left];
        }
        nums[left]=pivot;
        quickSort(nums,oldleft,left-1);
        quickSort(nums,left+1,oldright);
    }
}
