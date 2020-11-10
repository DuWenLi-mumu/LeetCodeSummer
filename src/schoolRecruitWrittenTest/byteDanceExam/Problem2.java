package schoolRecruitWrittenTest.byteDanceExam;

import java.util.Scanner;

/**
 * Created by 杜文丽 on 8/11/2019 6:43 PM
 **/
public class Problem2 {
    public static int sub(int res,int before_sum){
        if (res==0){
            if (before_sum%2==0){
                return 0;
            }else{
                return 1;
            }
        }else {
            if (before_sum%2==1){
                return 0;
            }else {
                return 1;
            }
        }

    }
    public static void main(String[] args) {
        int n;
        int k;
        String s;
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        k=sc.nextInt();
        s=sc.next();
        int[] res=new int[n+k];
        int[] ori=new int[n+k];
        int before_sum=0;
        for (int i = 0; i <n+k-1; i++) {
            res[i]=s.charAt(i)-'0';
        }

        //前k个的计算 0_k-1
        for (int i = 0; i <k ; i++) {
            ori[i]=sub(res[i],before_sum);
            before_sum+=ori[i];
        }

        //k_n-1
        for (int i = k; i <=n-1 ; i++) {
            before_sum=0;
            for (int j=i-k+1;j<=i-1;j++)
            {
                before_sum+=ori[j];
            }
            ori[i]=sub(res[i],before_sum);
        }

        //n_n+k-2
        int index=k-2;
        for (int i = n; i <n+k-1; i++) {
            before_sum=0;
            for (int j = i-index+1; j <=i-1 ; j++) {
                before_sum+=ori[j];
            }
            index--;
            ori[i]=sub(res[i],before_sum);
        }

        for (int i = 0; i <n ; i++) {
            System.out.println(ori[i]);
        }


    }
}
