package dp;

/**
 * Created by 杜文丽 on 3/14/2020 4:36 PM
 **/
public class RangeSumQuery2DImmutable304 {

}
class NumMatrix {
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix=matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res=0;
        for (int i = row1; i <=row2 ; i++) {
            for (int j = col1; j <=col2 ; j++) {
                res+=matrix[i][j];
            }
        }
        return res;
    }
}
