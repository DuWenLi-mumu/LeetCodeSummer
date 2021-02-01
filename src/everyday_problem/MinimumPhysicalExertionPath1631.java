package everyday_problem;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by 杜文丽 on 1/29/2021 9:28 PM
 **/
public class MinimumPhysicalExertionPath1631 {
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        int left = 0;
        int right = 999999;
        int ans = 0;

        while (left <= right){
            int mid = (left + right) / 2;
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] seen = new boolean[row][col];
            seen[0][0] = true;
            queue.add(new int[]{0,0});
            //四个方向分别检查
            while (!queue.isEmpty()){
                int[] node = queue.poll();
                int x = node[0];
                int y = node[1];
                for (int i = 0; i < 4; i++) {
                    int nx = x + dir[i][0];
                    int ny = y + dir[i][1];
                    if (nx >= 0 && nx < row && ny >=0 && ny < col && !seen[nx][ny] && Math.abs(heights[x][y] - heights[nx][ny]) <= mid){
                        seen[nx][ny] = true;
                        queue.offer(new int[]{nx,ny});
                    }
                }
            }
            if (seen[row - 1][col - 1] == true){
                ans = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }

        }
        return ans;
    }
}
