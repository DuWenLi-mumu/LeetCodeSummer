package heap;

import java.util.Arrays;

/**
 * Created by 杜文丽 on 2/11/2020 8:01 PM
 * 只是查找第k大的数字，所以没有必要全部排序，只需要建立大顶堆，然后取出的第k个就是结果，不需要全部有序。
 * 但是我不知道堆应该怎么建立和维持，所以就暂时调用 库函数排序吧
 **/
public class KthLargestElementInAnArray215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
