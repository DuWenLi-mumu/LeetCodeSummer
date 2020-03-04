package dp;

/**
 * Created by 杜文丽 on 3/4/2020 5:59 PM
 **/
public class UglyNumberII264 {
    public static void main(String[] args) {
        nthUglyNumber(10);
    }
    public static int nthUglyNumber(int n) {
        int[] w=new int[3];
        int[] dp=new int[n+1];
        for (int i = 0; i <n ; i++) {
            dp[i]=1;
        }
        for (int i = 1; i <n ; i++) {
            int a=dp[w[0]]*2;
            int b=dp[w[1]]*3;
            int c=dp[w[2]]*5;
            int res=Math.min(a,Math.min(b,c));
            if (res==a){
                w[0]++;
            }
            if (res==b){
                w[1]++;
            }
            if(res==c) {
                w[2]++;
            }
            dp[i]=res;
        }
        return dp[n-1];
    }
}
