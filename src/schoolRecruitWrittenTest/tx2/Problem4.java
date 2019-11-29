package schoolRecruitWrittenTest.tx2;

import java.util.Scanner;

/**
 * Created by 杜文丽 on 9/1/2019 7:26 PM
 **/
public class Problem4 {
    static int[] days=new int[100000];
    public static int sub(int left,int right){
        if (left==right){
            return days[left]*days[left];
        }else if (left>right){
            return 0;
        }
        int min=days[left];
        int my=days[left];
        for (int i = left+1; i <=right ; i++) {
            my+=days[i];
            if (min>days[i]){
                min=days[i];
            }
        }
        my=my*min;
        int mymax=Math.max(sub(left+1,right),sub(left,right-1));
        return Math.max(mymax,my);
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        for (int i = 0; i < n; i++) {
            days[i]=in.nextInt();
        }
        System.out.println(sub(0,n-1));
    }
}
