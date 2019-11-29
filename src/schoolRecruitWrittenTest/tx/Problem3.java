package schoolRecruitWrittenTest.tx;

import java.util.Scanner;

/**
 * Created by 杜文丽 on 8/17/2019 8:03 PM
 **/
public class Problem3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, l;
        n = sc.nextInt();
        l = sc.nextInt();
        int[][] ns = new int[n][3];
        for (int i = 0; i < n; i++) {
            ns[i][0] = sc.nextInt();
            ns[i][1] = sc.nextInt();
        }
        //将ns按照第一个从小到大排序
        for (int i = 0; i < ns.length; i++) {
            for (int j = i + 1; j < ns.length; j++) {
                int[] tmp = new int[2];
                if (ns[i][0] > ns[j][0]) {
                    tmp[0] = ns[i][0];
                    tmp[1] = ns[i][1];
                    ns[i][0] = ns[j][0];
                    ns[i][1] = ns[j][1];
                    ns[j][0]=tmp[0];
                    ns[j][1]= tmp[1];
                }
            }
        }
        if (ns[0][0] > 0) {
            System.out.println(-1);
        } else {
            int end = ns[0][1];
            int c = 1;
            while (end  < l && c < n) {
                int index = 0;
                int max = end;
                for (int i = 1; i < n; i++) {
                    if (ns[i][2] == 0) {//表示还没有加入过
                        if (ns[i][0] <= end && ns[i][1] > max) {
                            max = ns[i][1];
                            index = i;
                        }
                    }
                }
                c++;
                end = ns[index][1];
                ns[index][2]=1;
            }
            if (end>=l){
                System.out.println(c);
            }else {
                System.out.println(-1);
            }

        }
    }


}








