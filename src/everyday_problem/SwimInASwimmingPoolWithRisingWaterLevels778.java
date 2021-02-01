package everyday_problem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by 杜文丽 on 1/30/2021 1:19 PM
 **/
public class SwimInASwimmingPoolWithRisingWaterLevels778 {
    public int swimInWater(int[][] grid) {
        int time = 0;
        int row = grid.length;
        int col = grid[0].length;

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (true) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0});
            boolean[][] reach = new boolean[row][col];
            reach[0][0] = true;
            while (!queue.isEmpty()) {
                int[] node = queue.poll();
                int x = node[0];
                int y = node[1];
                for (int i = 0; i < 4; i++) {
                    int nx = x + dir[i][0];
                    int ny = y + dir[i][1];
                    if (nx >= 0 && nx < row && ny >= 0 && ny < col && !reach[nx][ny] && grid[nx][ny] <= time && grid[x][y] <= time) {
                        reach[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }

            }
            if (reach[row - 1][col - 1]) {
                return time;
            } else {
                time++;
            }
        }
    }
}
