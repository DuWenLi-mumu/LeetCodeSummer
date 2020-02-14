package greedy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 杜文丽 on 2/13/2020 11:14 PM
 **/
public class PlayWithChips1217 {
    public static void main(String[] args) {
        int[] x={1,2,3};
        minCostToMoveChips(x);
    }
    public static int minCostToMoveChips(int[] chips) {
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i <chips.length ; i++) {
            set.add(chips[i]);
        }
        int res=10000000;
        int count=0;
        for (Integer i:set
             ) {
            for (int j = 0; j <chips.length ; j++) {
                count+=(Math.abs(chips[j]-i))%2;
            }
            res=Math.min(res,count);
            count=0;
        }
        return res;
    }
}
