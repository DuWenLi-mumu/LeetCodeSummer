package schoolRecruitWrittenTest.byteDanceExam;

import java.util.Scanner;

/**
 * Created by 杜文丽 on 8/11/2019 6:43 PM
 **/
public class Problem3 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        int[] age=new int[n];
        int[] money=new int[n];
        for (int i = 0; i <n ; i++) {
            age[i]=sc.nextInt();
            money[i]=100;
        }
        boolean all_satisfaction=false;
        while(!all_satisfaction){
            for (int i = 0; i <n ; i++) {
                if (i-1>=0){
                    if (age[i-1]<age[i]&&money[i-1]>=money[i]){
                        money[i]=money[i-1]+100;
                    }
                }
                if (i+1>=0&&i+1<n){
                    if (age[i+1]<age[i]&&money[i+1]>=money[i]){
                        money[i]=money[i+1]+100;
                    }
                }
            }
            all_satisfaction=true;
            for (int i = 0; i <n ; i++) {
                if (i-1>=0){
                    if (age[i-1]<age[i]&&money[i-1]>=money[i]){
                        all_satisfaction=false;
                    }
                }
                if (i+1>=0&&i+1<n){
                    if (age[i+1]<age[i]&&money[i+1]>=money[i]){
                       all_satisfaction=false;
                    }
                }
            }
        }
        int res=0;
        for (int i = 0; i <n ; i++) {

            res+=money[i];
        }
        System.out.println(res);
    }
}
