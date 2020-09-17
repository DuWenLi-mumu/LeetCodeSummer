package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by 杜文丽 on 9/12/2020 4:17 PM
 **/
public class CoinChange322 {
    //可重复多次使用coin 完全背包问题 递归方式实现
    ArrayList<Integer> results;

    /**
     * 递归方式实现，内存消耗高，栈溢出
     *
     * @param coins
     * @param amount
     * @param sum
     * @param nums
     */
    public void solve1_sub(int[] coins, int amount, int sum, int nums) {
        if (sum == amount) {
            results.add(nums);
        } else if (sum > amount) {
            return;
        }
        for (int i = 0; i < coins.length; i++) {
            solve1_sub(coins, amount, sum + coins[i], nums + 1);
        }
    }

    public int solve1(int[] coins, int amount) {
        results = new ArrayList<>();
        solve1_sub(coins, amount, 0, 0);
        if (results.size() < 1) {
            return -1;
        }
        Collections.sort(results, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        return results.get(0);
    }

    public int solve2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        } else if (coins.length == 0 && amount != 0) {
            return -1;
        }
        return sub(coins, amount, new int[amount]);
    }

    public int sub(int[] coins, int amount, int[] count) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (count[amount - 1] != 0) {
            return count[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins
        ) {
            int res = sub(coins, amount - coin, count);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        count[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[amount - 1];
    }

    int[][] dp;//dp[i][j]表示钱i个货币凑成金额为j的最小数目
    int max=11111111;
    public int solve3(int[] coins, int amount) {
        dp = new int[coins.length+1][amount + 1];
        for (int i = 0; i <=coins.length; i++) {
            for (int j = 0; j <=amount ; j++) {
                dp[i][j]=max;
            }
        }
        for (int i = 0; i <=coins.length ; i++) {
            dp[i][0]=0;
        }
        for (int i = 1; i <= coins.length; i++) {
        for (int j = 1; j <= amount; j++) {
                if (j - coins[i-1] >= 0)
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i-1]] + 1);
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        if (dp[coins.length][amount]!=max){
            int num=dp[coins.length][amount];
            return num;
        }else{
            return -1;
        }
    }

    public int solve4(int[] coins,int amount){
        int[]dp=new int[amount+1];
        for (int i = 1; i <=amount ; i++) {
            dp[i]=max;
        }
        for (int i = 0; i <coins.length ; i++) {
            for (int j = coins[i]; j <=amount ; j++) {
                dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
            }
        }
        return dp[coins.length-1]==max?-1:dp[coins.length-1];
    }
    /**
     * 动态规划实现 完全背包
     * 遍历出所有可能的结果 取最小的结果
     *
     * @param coins
     * @param amount
     */
    public int coinChange(int[] coins, int amount) {
        /**
         * 递归方式
         */
        //solve1(coins, amount);
        /**
         * 递归方式优化
         */
        //solve2(coins, amount);
        /**
         * 动态规划方式
         */
       return solve3(coins,amount);
        /**
         * 动态规划优化
         */
        //return solve4(coins,amount);
    }

    public static void main(String[] args) {
        CoinChange322 test=new CoinChange322();
        int[]coins={1,2,5};
        test.coinChange(coins,11);
    }
}
