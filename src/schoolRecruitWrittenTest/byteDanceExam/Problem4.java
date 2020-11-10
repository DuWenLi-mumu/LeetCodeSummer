package schoolRecruitWrittenTest.byteDanceExam;

import java.util.Scanner;

/**
 * Created by 杜文丽 on 8/11/2019 6:43 PM
 **/
public class Problem4 {
    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        int[] yu = new int[3];
        int[][] n = new int[num + 1][num + 1];
        for (int i = 0; i <=num ; i++) {
            for (int j = 0; j <=num; j++) {
                n[i][j]=100000;
            }
        }
        for (int i = 0; i < num - 1; i++) {
            int u, v;
            u = sc.nextInt();
            v = sc.nextInt();
            n[u][v] = 1;
        }


        for (int k = 1; k <= num; k++)
            for (int i = 1; i <= num; i++)
                for (int j = 1; j <= num; j++)
                    if (n[i][j] > n[i][k] + n[k][j]){
                        n[i][j] = n[i][k] + n[k][j];
                    }
        for (int i = 1; i <=num ; i++) {
            for (int j = i+1; j <=num ; j++) {
                if (n[i][j]%3==0){
                    yu[0]+=n[i][j];
                }else if (n[i][j]%3==1){
                    yu[1]+=n[i][j];
                }else if(n[i][j]%3==2){
                    yu[2]+=n[i][j];
                }
            }
        }

        for (int i =0; i < 3; i++) {
            System.out.print(yu[i]+" ");
        }
    }
}
