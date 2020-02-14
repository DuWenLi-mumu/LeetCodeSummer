package greedy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 杜文丽 on 2/13/2020 11:14 PM
 *
 * 更好的思路：解为 min（偶数个数，奇数个数）
 **/
public class PlayWithChips1217 {
    public static void main(String[] args) {
        int[] x={1,2,3};
        minCostToMoveChips(x);
    }
    public static int minCostToMoveChips(int[] chips) {
        int odd=0;
        int even=0;
        for (int i = 0; i <chips.length ; i++) {
            if (chips[i]%2==0){
                even++;
            }else {
                odd++;
            }
        }
        return Math.min(even,odd);
    }
}
