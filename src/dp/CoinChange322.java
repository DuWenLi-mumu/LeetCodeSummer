package dp;

import algorithm_implementation.Sort;

import java.util.ArrayList;
import java.util.Arrays;
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

    int[] dp;//计算到达amount所有可能的结果
    int[] dp_mem;//记录计算过后的最小值
    /**
     * 动态规划实现 完全背包
     * 遍历出所有可能的结果 取最小的结果
     *
     * @param coins
     * @param amount
     */
    public int solve2(int[] coins, int amount) {
        if (amount==0){
            return 0;
        }else if (coins.length==0&&amount!=0) {
            return -1;
        }
        return sub(coins,amount,new int[amount]);
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

    public int coinChange(int[] coins, int amount) {
        /**
         * 递归方式
         */
        solve1(coins, amount);
        /**
         * 动态规划方式
         */
        return solve2(coins, amount);
    }
}
