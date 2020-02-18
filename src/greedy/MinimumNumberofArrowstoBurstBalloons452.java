package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by 杜文丽 on 2/16/2020 11:48 PM
 **/
public class MinimumNumberofArrowstoBurstBalloons452 {
    public static void main(String[] args) {
        int[][] points={{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        findMinArrowShots(points);
    }
    public static int findMinArrowShots(int[][] points) {
        if (points.length<=0){
            return 0;
        }
        if (points.length<=1){
            return 1;
        }
        Arrays.sort(points, new Comparator<int[]>() {//x升序排序，x相同的按照y坐标降序排序
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[1]-t1[1];
            }
        });
        //求交集
        int res=1;
        int left=points[0][0];
        int right=points[0][1];
        for (int i = 1; i <points.length ; i++) {
            if (points[i][0]<=right){//出现交集
                left=points[i][0];
            }else {
                res++;
                left=points[i][0];
                right=points[i][1];
            }
        }
        return res;
    }
}
