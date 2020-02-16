package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by 杜文丽 on 2/16/2020 11:28 PM
 **/
public class NonOverlappingIntervals435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length<=1){
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o->o[0]));
        Arrays.sort(intervals,Comparator.comparingInt(o->o[1]));
        int res=0;
        int left=intervals[0][0];
        int right=intervals[0][1];
        for (int i = 1; i <intervals.length ; i++) {
            if (intervals[i][0]>=right){
                left=intervals[i][0];
                right=intervals[i][1];
            }else {
                res++;
            }
        }
        return res;

    }
}
