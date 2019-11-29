package schoolRecruitWrittenTest.tx2;

import java.util.Scanner;

/**
 * Created by 杜文丽 on 9/1/2019 7:26 PM
 **/
public class Problem5 {
    public static int count(int len,int beishu,int k){
        if (beishu==0){
            return 1;
        }
        return len-beishu*k+1;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        int k=in.nextInt();
        for (int i = 0; i <t ; i++) {
            int a=in.nextInt();
            int b=in.nextInt();
            int c=0;
            for (int len = a; len <=b ; len++) {
                int beishu=0;
                while (beishu*k<=len){
                    c+=count(len,beishu,k);
                    beishu++;
                }
            }

            System.out.println(c);
        }

    }
}
