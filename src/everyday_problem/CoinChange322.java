package everyday_problem;

import java.util.Arrays;

/**
 * Created by 杜文丽 on 3/8/2020 9:26 AM
 * 这道题 是背包问题 不是贪心问题
 **/
public class CoinChange322 {

    public int coinChange(int[] coins, int amount) {
        if (amount==0){
            return 0;
        }else if (coins.length==0&&amount!=0) {
            return -1;
        }
        return sub(coins,amount,new int[amount]);
    }
    public int sub(int[] coins,int amount,int[] count){
        if (amount<0){
            return -1;
        }
        if (amount==0){
            return 0;
        }
        if (count[amount-1]!=0){
            return count[amount-1];
        }
        int min=Integer.MAX_VALUE;
        for (int coin:coins
             ) {
            int res=sub(coins,amount-coin,count);
            if (res>=0&&res<min){
                min=res+1;
            }
        }
        count[amount-1]=(min==Integer.MAX_VALUE)?-1:min;
        return count[amount-1];
    }

}
