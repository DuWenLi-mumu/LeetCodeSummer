package everyday_problem;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by 杜文丽 on 3/29/2020 4:20 PM
 **/
public class AsFarFromLandAsPossible1162 {
    public int maxDistance(int[][] grid) {
        Queue<int[]> queue=new ArrayDeque<>();
        int m=grid.length;
        int n=grid[0].length;
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if (grid[i][j]==1){
                    queue.add(new int[]{i,j});
                }
            }
        }
        int[] x={-1,0,1,0};
        int[] y={0,1,0,-1};
        boolean ocean=false;
        int[] lastPoint = new int[0];
        //将所有的点一次取出来，判断后加进去
        while (!queue.isEmpty()){
            int[] index=queue.poll();
            for (int i = 0; i <4 ; i++) {
                lastPoint=index;
                int newx=index[0]+x[i];
                int newy=index[1]+y[i];
                if (newx<0||newx>=m||newy<0||newy>=n||grid[newx][newy]!=0){
                    continue;
                }
                grid[newx][newy]=grid[index[0]][index[1]]+1;
                queue.add(new int[]{newx,newy});
                ocean=true;
            }
        }
        if (ocean){
            return grid[lastPoint[0]][lastPoint[1]]-1;
        }else {
            return -1;
        }

    }
}
