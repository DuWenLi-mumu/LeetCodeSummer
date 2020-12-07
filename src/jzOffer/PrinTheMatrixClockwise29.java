package jzOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杜文丽 on 12/7/2020 10:16 AM
 **/
public class PrinTheMatrixClockwise29 {
    List<Integer> res = new ArrayList<>();
    public int[] spiralOrder(int[][] matrix) {
        int n = matrix.length;
        if (n == 0){
            return new int[0];
        }else if (n == 1){
            return matrix[0];
        }
        int m = matrix[0].length;
        int i = 0;
        int j = 0;
        while (m >= 1 && n >= 1){
            print(matrix,n,m,i,j);
            i++;
            j++;
            m -= 2;
            n -= 2;
        }
        int[] result = new int[res.size()];
        for (int k = 0; k < res.size() ; k++) {
            result[k] = res.get(k);
        }
        return result;
    }
    public void print(int[][] matrix,int n,int m,int i,int j){
        if (m == 1 ){
            for (int k = i; k < i + n - 1 ; k++) {
                res.add(matrix[k][i]);
            }
        }else if (n == 1){
            for (int k = i; k < i + m - 1 ; k++) {
                res.add(matrix[i][k]);
            }
        }else {
            for (int k = j; k <= j + m - 1 ; k++) {
                res.add(matrix[i][k]);
            }
            for (int k = i + 1; k <= i + n -1 ; k++) {
                res.add(matrix[k][i + m - 1]);
            }
            for (int k = j + m - 2; k >= j; k--) {
                res.add(matrix[i][k]);
            }
            for (int k = i + n - 2; k >= i + 1 ; k--) {
                res.add(matrix[k][j]);
            }
        }

    }

    public static void main(String[] args) {

    }
}
