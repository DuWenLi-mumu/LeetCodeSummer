package schoolRecruitWrittenTest.byteDanceExam;

import java.util.Scanner;

/**
 * Created by 杜文丽 on 8/11/2019 6:43 PM
 **/
public class Problem1 {
    public static int trans(int hours,int min){
        return hours*60+min;
    }
    public static void main(String[] args) {
        int n;
        int x;
        int a,b;
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        int[] hours=new int[n];
        int[] mins=new int[n];
        int[] times=new int[n];
        for (int i = 0; i <n ; i++) {
            hours[i]=sc.nextInt();
            mins[i]=sc.nextInt();
            times[i]=trans(hours[i],mins[i]);
        }
        x=sc.nextInt();
        a=sc.nextInt();
        b=sc.nextInt();


        int courseTime=trans(a,b);
        int lastTime=courseTime-x;

        if (lastTime<0){
            lastTime+=24*60;
        }
            int index=0;
            int min=100000;
            for (int i = 0; i <n ; i++) {
                if (times[i]<lastTime&&min>lastTime-times[i]){
                    index=i;
                    min=lastTime-times[i];
                }
            }
            System.out.println(hours[index]+" "+mins[index]);

        }


}
