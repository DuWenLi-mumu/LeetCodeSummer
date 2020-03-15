package everyday_problem;

/**
 * Created by 杜文丽 on 3/15/2020 6:23 PM
 **/
public class MaxAreaofIsland695 {
    int[][] clone;
    int m;
    int n;
    public int maxAreaOfIsland(int[][] grid) {
        clone=grid.clone();
        m=grid.length;
        n=grid[0].length;
        int res=0;
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if (clone[i][j]==1){

                    res=Math.max(res,find(i,j));
                }
            }
        }
        return res;
    }
    public int find(int i,int j){
        clone[i][j]=0;
        int res=1;
        int[]row={-1,0,1,0};
        int[]col={0,1,0,-1};
        for (int k = 0; k <4 ; k++) {
            int x=i+row[k];
            int y=j+col[k];
            if (x>=0&&x<m&&y>=0&&y<n){
                if (clone[x][y]==1){
                    clone[x][y]=0;
                    res+=find(x,y);
                }
            }
        }
        return res;
    }
}
