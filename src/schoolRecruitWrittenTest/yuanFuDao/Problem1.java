package schoolRecruitWrittenTest.yuanFuDao;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by 杜文丽 on 8/24/2019 3:59 PM
 **/
public class Problem1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int[]index=new int[2100000];
        int num=in.nextInt();
        int rep=in.nextInt();
        int[] nums=new int[num];
        for (int i = 0; i <num ; i++) {
            nums[i]=in.nextInt();
            index[nums[i]+2000000]++;
        }

        for (int i = 0; i <num ; i++) {
            if (index[nums[i]+2000000]<=rep){
                System.out.print(nums[i]+" ");
            }
        }
        System.out.println();
    }
}
