package everyday_problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ConsolidationInterval56 {
    public static void main(String[] args) {
        int[][] arr = {{1,4},{2,3}};
        int[][] tmp = arr.clone();
        merge(tmp);
        print(tmp);

    }
    public static void print(int[][] arr){
        System.out.println("**************************************");
        int row = arr.length;
        int col = arr[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0){
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else {
                    return o1[0] - o2[0];
                }
            }
        });
        int left = intervals[0][0];
        int right = intervals[0][1];
        int index = 1;
        List<int[]> res = new ArrayList<>();
        while (index < intervals.length){
            if (right >= intervals[index][0]){
                right = Math.max(right,intervals[index][1]);
            }else {
                int[] curr = {left,right};
                res.add(curr);
                left = intervals[index][0];
                right = intervals[index][1];
            }
            index++;
        }
        res.add(new int[]{left,right});
        int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
