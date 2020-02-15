package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by 杜文丽 on 2/14/2020 11:23 PM
 *
 * 假设A团体去A市，B团体去B市，此时费用为a。
 *
 * 假设上述A团体去B市，B团体去A市，此时费用为b。
 *
 * 求a的最小值，相当于求b的最大值，又相当于要使b-a的值是所有组合中最大的。
 *
 * b-a的值等于A团体所有人的cost[1]-cost[0]的和，加上B团体所有人的cost[0]-cost[1]的和。
 *
 * b-a的值又等于A团体所有人的cost[1]-cost[0]的和，减去B团体所有人的cost[1]-cost[0]的和。
 *
 * 那么只要A团体所有人的cost[1]-cost[0]的和最大，B团体所有人的cost[1]-cost[0]的和最小，就可以使得b-a最大。
 *
 * 只要对所有人的cost[1]-cost[0]排个序，前n个人去A市，后n个人去B市，即可使得b-a最大，亦即a最小。
 **/
public class TwoCityScheduling1029 {
    public static int twoCitySchedCost(int[][] costs) {
        int[][] b_aCost=new int[costs.length][2];
        for (int i = 0; i <costs.length ; i++) {
            b_aCost[i][0]=costs[i][1]-costs[i][0];
            b_aCost[i][1]=i;
        }
        Arrays.sort(b_aCost, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0]-t1[0];
            }
        });
        int res=0;
        for (int i = 0; i <costs.length/2 ; i++) {
            res+=costs[b_aCost[i][1]][0];
        }
        for (int i = costs.length/2; i <costs.length ; i++) {
            res+=costs[b_aCost[i][1]][1];
        }
        return res;
    }
}
