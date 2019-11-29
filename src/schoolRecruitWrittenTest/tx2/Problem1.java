package schoolRecruitWrittenTest.tx2;

import java.util.Scanner;

/**
 * Created by 杜文丽 on 9/1/2019 7:26 PM
 **/
public class Problem1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int[] a=new int[n];
        int aoddcount=0;
        int aevencount=0;
        int[] b=new int[m];
        int boddccount=0;
        int bevencount=0;
        for (int i = 0; i <n ; i++) {
            a[i]=in.nextInt();
            if (a[i]%2==1){
                aoddcount++;
            }
        }
        for (int i = 0; i <m ; i++) {
            b[i]=in.nextInt();
            if (b[i]%2==1){
                boddccount++;
            }
        }
        aevencount=n-aoddcount;
        bevencount=m-boddccount;
        System.out.println(Math.min(aevencount,boddccount)+Math.min(aoddcount,bevencount));



    }
}
