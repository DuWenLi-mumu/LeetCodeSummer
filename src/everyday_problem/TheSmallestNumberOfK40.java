package everyday_problem;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by 杜文丽 on 3/20/2020 10:14 AM
 **/
public class TheSmallestNumberOfK40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for (int i = 0; i < arr.length ; i++) {
            queue.add(arr[i]);
        }
        int[] res=new int[k];
        for (int i = 0; i <k ; i++) {
            res[i]=queue.poll();
        }
        return res;
    }
}
