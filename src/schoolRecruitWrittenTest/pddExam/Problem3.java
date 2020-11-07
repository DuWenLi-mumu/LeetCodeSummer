package schoolRecruitWrittenTest.byteDanceExam.pddExam;

import java.util.Scanner;

/**
 * Created by 杜文丽 on 8/11/2019 2:56 PM
 **/
public class Problem3 {
    static int[][] dp=new int[1000][100000];

    public static int sub(int i,int currSum,int s,int n){
        int resnum=0;
        if (i>s-currSum){
            return -1;
        }
        if (n<0){
            return 0;
        }else if (currSum>=s&&n!=0){
            return 0;
        }else if (currSum==s&&n==0){
            return 1;
        }else if (s!=0&&currSum<s&&n>0){
            if (dp[n][s-currSum]!=-1){
                return dp[n][s-currSum];
            }else{
                if (n==1&&s-currSum>i){
                    return 1;
                }
                for (int j = i+1; j <s ; j++) {
                    int temp=sub(j,currSum+j,s,n-1);
                    if (temp==-1){
                        break;
                    }else {
                        resnum+=temp;
                    }
                }
                dp[n][s-currSum]=resnum;
                return resnum;
            }
        }
        return resnum;
    }
    public static void main(String[] args) {
        int s,n;
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        s=sc.nextInt();
        if (s<(1+n)*n/2){
            System.out.println(0);
        }else if (n>10000||s>100000){
           System.out.println("wrong");
        } else{
            for (int i = 0; i <1000 ; i++) {
                for (int j = 0; j <100000 ; j++) {
                    dp[i][j]=-1;
                }
            }
            int res=0;
            if(n==0){
                System.out.println(0);
            }else if(n==1){
                System.out.println(1);
            }else if (s<=0){
                System.out.println(0);
            }else{
                res=sub(0,0,s,n);
                System.out.println(res);
            }
        }

    }
}
