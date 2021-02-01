package weekly.week226;

import java.util.*;

/**
 * Created by 杜文丽 on 1/31/2021 10:19 AM
 **/
public class Solution1 {
    public static int countBalls(int lowLimit, int highLimit) {
        int n = highLimit - lowLimit + 1;
        Map<Integer, Integer> sum = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int val = count(i);
            if (sum.containsKey(val)) {
                sum.put(val, sum.get(val) + 1);
            } else {
                sum.put(val, 1);
            }
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : sum.entrySet()) {
            max =   Math.max(max,entry.getValue());
        }
        return max;
    }

    public static int count(int num){
        int sum = 0;
        while (num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        countBalls(11,104);
    }
}
