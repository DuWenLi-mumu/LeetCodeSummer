package weekly.week180;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by 杜文丽 on 3/15/2020 11:16 AM
 **/
public class p5359 {

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] item = new int[n][2];
        for (int i = 0; i < n; i++) {
            item[i][0] = speed[i];
            item[i][1] = efficiency[i];
        }
        Arrays.sort(item, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int res = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += item[i][0];
            queue.add(item[i][0]);
            if (queue.size() > k) {
                sum -= queue.poll();
            }
            res = Math.max(res, (sum * item[i][1])%((int) 1e9 + 7));
        }
        return (int) (res % ((int) 1e9 + 7));
    }
}
