package jzOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杜文丽 on 12/4/2020 12:29 PM
 **/
public class ALookupInATwodimensionalArray4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
        if (n < 1){
            return false;
        }
        int m = matrix[0].length;
        if (m < 1){
            return false;
        }
        return BFS(matrix,target,m,n,0,m-1);
    }
    public boolean BFS(int[][] matrix,int target,int m,int n,int i,int j){
        if (i < 0 || i >= n || j < 0 && j >= m){
            return false;
        }
        if (matrix[i][j] == target){
            return true;
        }else if (matrix[i][j] > target){
            return BFS(matrix,target,m,n,i,j-1);
        }else {
            return BFS(matrix,target,m,n,i+1,j);
        }
    }
}
