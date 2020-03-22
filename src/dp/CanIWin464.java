package dp;

/**
 * Created by 杜文丽 on 3/21/2020 7:20 PM
 **/
public class CanIWin464 {
    int[] dp;
    int m;
    int t;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        this.m=maxChoosableInteger;
        this.t=desiredTotal;
        if ((1+m)*m/2<t){
            return false;
        }
        dp=new int[(int) (1<<m+1)];
        return sub(t,0);
    }
    public boolean sub(int t,int v){
        if (dp[v]!=0){
            return dp[v]==1;//记录是否已经计算过了
        }
        for (int i = 1; i <=m ; i++) {
            int curr=1<<i;//切换到第i个位数
            if ((curr&v)==0//当前的第i位没有使用过；
                    &&((i>=t)//当前的i比目标要大
                    ||!(sub(t-i,v|curr))))//我选了i但是对方没有赢
            {
                dp[v]=1;
                return true;
            }
        }
        dp[v]=-1;
        return false;
    }
}