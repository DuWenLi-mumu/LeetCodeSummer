package dp;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by 杜文丽 on 10/3/2020 7:54 PM
 **/
public class MinimumNumberofArrowsToBurstBalloons452 {
    public int findMinArrowShots(int[][] points) {
        return 0;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Integer[] nums={-1,3,-5,3,2,7,1,9,10};
        Arrays.sort(nums,Comparator.reverseOrder());
        for (Integer i:nums
             ) {
            System.out.print(i+" ");
        }
    }
}
