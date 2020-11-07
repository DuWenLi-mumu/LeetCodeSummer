package schoolRecruitWrittenTest.byteDanceExam.pddExam;

import java.util.Scanner;

/**
 * Created by 杜文丽 on 8/11/2019 2:48 PM
 * 1000 4
 * 1 4 998 995
 **/
public class Problem2 {
    public static int handle(int currSum,int num,int total){
        int min=currSum;
        for (int i = -1*total/2; i <total/2 ; i++) {
            int res=0;
            for (int j = i; j <i+num ; j++) {
                if (j<0){
                    res+=(-1*j);
                }

            }
            if (min>Math.abs(currSum-res)){
                min=Math.abs(currSum-res);
            }
        }
        System.out.println(min);
        return min;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int pearlNum=sc.nextInt();
        int[] n=new int[pearlNum];
        int currSum1=0;
        int currsum2=0;
        for (int i = 0; i <pearlNum ; i++) {
            n[i]=sc.nextInt();
            if (n[i]>total/2){
                currSum1+=total-n[i];
            }else{
                currSum1+=n[i];
            }
            currsum2+=n[i];
        }

        int res=Math.min(handle(currSum1,pearlNum,total),handle(currsum2,pearlNum,total));
        System.out.println(res);
    }
}
