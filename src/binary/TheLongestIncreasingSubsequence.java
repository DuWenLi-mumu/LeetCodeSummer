package binary;

import java.util.ArrayList;
import java.util.List;

public class TheLongestIncreasingSubsequence {
    public static int[] LIS (int[] arr) {
        if (arr.length < 2){
            return arr;
        }
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int max = 1;
        int[] nums = new int[arr.length];
        nums[0] = arr[0];
        int index_num = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > nums[index_num - 1]){
                nums[index_num++] = arr[i];
                dp[i] = dp[i - 1] + 1;
            }else if (arr[i] == nums[index_num]){
                dp[i] = dp[i - 1];
            }else {
                dp[i] = dp[i - 1];
                //arr[i] < num最后一个数字，找到一个合适的位置进行替换
                if (arr[i] <= nums[0]){
                    nums[0] = arr[i];
                }else if (arr[i] > nums[index_num - 2]){
                    nums[index_num - 1] = arr[i];
                }else {
                    for (int j = 1; j < index_num; j++) {
                        if (arr[i] > nums[j - 1] && arr[i] < nums[j + 1] && arr[i] < nums[j]){
                            nums[j] = arr[i];
                            break;
                        }
                    }
                }
            }
            max = Math.max(max,dp[i]);
        }

        int[] res = new int[max];
        int res_index = 0;
        int pre = -1;//保留前一个序列选择的值
        for (int i = 0; i < dp.length;) {
            int val = dp[i];//在当前最长子序列个数一样的序列中寻找
            int min = arr[i];//保存递增序列中最小的
            int index = i;
            while (index < dp.length && dp[index] == val){
                if (arr[index] > pre){
                    min = Math.min(min,arr[index]);
                }
                index++;
            }
            pre = min;
            res[res_index++] = min;
            i = index;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {2,1,5,3,6,4,8,9,7};
        int[] res = LIS(test);
        for (int i = 0; i <res.length ; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}
