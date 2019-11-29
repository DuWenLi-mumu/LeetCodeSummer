package schoolRecruitWrittenTest.tx;

import java.util.Scanner;

/**
 * Created by 杜文丽 on 8/17/2019 8:03 PM
 **/
public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] ns=new int[n];
        int[] res=new int[n];
        for (int i = 0; i <n ; i++) {
            ns[i]=sc.nextInt();
        }
        for (int i = 0; i <n ; i++) {
            int tmp=ns[i];
            int index=i;
            res[i]=1;
            //从左边看
            while (index>1&&ns[--index]<=tmp){
                tmp=ns[index];
                res[i]++;
            }
            if (i>0)
                res[i]++;

            index=i;
            //从右边看
            while (index+1<n&&ns[++index]<=tmp){
                tmp=ns[index];
                res[i]++;
            }
            if (i<n-1){
                res[i]++;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(res[i]+ " ");
        }
        System.out.println();
        
    }
}
