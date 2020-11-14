package jzOffer;

/**
 * Created by 杜文丽 on 11/10/2020 4:46 PM
 **/
public class TheRangeOfMotionOfTheRobot13 {
    int c = 0;
    public int movingCount(int m, int n, int k) {

        boolean[][] visited = new boolean[m][n];
        dfs(0,0,m,n,k,visited);
        return c;
    }
    public void dfs(int i, int j,int m,int n,int k,boolean[][] visited){
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]){
            return;
        }
        if (count(i,j) > k ){
            return;
        }else {
            visited[i][j] = true;
            c++;
            dfs(i + 1,j,m,n,k,visited);
            dfs(i - 1,j,m,n,k,visited);
            dfs(i,j + 1,m,n,k,visited);
            dfs(i,j - 1,m,n,k,visited);
//            visited[i][j] = false;
        }
    }
    public int count(int i,int j){
        if (i < 0 || j < 0 ){
            return 0;
        }
        int res = 0;
        while (i > 0){
            res += i % 10;
            i /= 10;
        }
        while (j > 0){
            res += j % 10;
            j /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        int k = 1;
        TheRangeOfMotionOfTheRobot13 test = new TheRangeOfMotionOfTheRobot13();
        test.movingCount(m,n,k);
    }
}
