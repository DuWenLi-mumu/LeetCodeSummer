package heap;

import java.util.Arrays;

/**
 * Created by 杜文丽 on 2/9/2020 10:17 PM
 **/
public class LastStoneWeight1046 {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        int res=stones[0];
        for (int i = 0; i <stones.length-1 ; i++) {
            stones[stones.length-1-1]=stones[stones.length-1]-stones[stones.length-1-1];
            res=stones[stones.length-1-1];
            stones[stones.length-1]=-1111111111;
            Arrays.sort(stones);
        }
        return res;
    }
}
