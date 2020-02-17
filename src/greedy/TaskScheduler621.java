package greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by 杜文丽 on 2/17/2020 4:36 PM
 * 这道题，牛逼，我要画星星！！
 **/
public class TaskScheduler621 {
    public static void main(String[] args) {
        char[] tasks={'A','A','A','B','B','B'};
        leastInterval(tasks,2);
    }
    public static int leastInterval(char[] tasks, int n) {
        if (tasks.length<=0){
            return 0;
        }
        int[] nums= new int[26];
        for (int i = 0; i <tasks.length ; i++) {
            nums[tasks[i]-'A']++;
        }
        Arrays.sort(nums);
        int max=0;
        for (int i = nums.length-1; i >=0 ; i--) {
            if (nums[i]==nums[25]){
                max++;
            }
        }
        return Math.max((nums[25]-1)*(n+1)+max,tasks.length);
    }
}
