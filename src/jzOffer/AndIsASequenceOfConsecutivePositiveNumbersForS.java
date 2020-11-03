package jzOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by 杜文丽 on 10/23/2020 11:20 AM
 **/
public class AndIsASequenceOfConsecutivePositiveNumbersForS {
    public int[][] findContinuousSequence(int target) {
        List<Queue<Integer>> res = new ArrayList<>();
        Queue<Integer> list = new PriorityQueue<>();
        int sum = 0;
        for (int i = 1; i < target; i++) {
            list.add(i);
            sum += i;
            if (sum == target) {
                res.add(new PriorityQueue(list));
                continue;
            } else {
                while (sum > target) {
                    sum -= list.poll();
                }
                if (sum == target) {
                    res.add(new PriorityQueue(list));
                }
            }
        }
        int[][] r = new int[res.size()][];
        for (int i = 0; i < res.size() ; i++) {
            r[i] = new int[res.get(i).size()];
            int index = 0;
            while (!res.get(i).isEmpty()){
                r[i][index++] = res.get(i).poll();
            }
        }
        return r;
    }

    public static void main(String[] args) {
        AndIsASequenceOfConsecutivePositiveNumbersForS test = new AndIsASequenceOfConsecutivePositiveNumbersForS();
        test.findContinuousSequence(9);
    }
}
