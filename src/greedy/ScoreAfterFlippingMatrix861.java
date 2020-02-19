package greedy;

/**
 * Created by 杜文丽 on 2/19/2020 4:07 PM
 **/
public class ScoreAfterFlippingMatrix861 {
    public static void main(String[] args) {
        int[][]A={{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        int res=matrixScore(A);
    }
    public static int matrixScore(int[][] A) {
        //处理行 使得第一行全部为1
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] != 1) {
                int[] flip = flip(A[i]);
                A[i] = flip;
            }
        }
        int res = 0;
        //处理列 保证列的1比0多
        for (int i = 0; i < A[0].length; i++) {//列
            int count = 0;
            for (int j = 0; j < A.length; j++) {//行
                if (A[j][i] == 1) {
                    count++;
                }
            }
            if (count <= A.length / 2) {
                count = A.length - count;
            }
            res += count * Math.pow(2, A[0].length - i-1);

        }
        return res;
    }

    public static int[] flip(int[] arr) {
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]==1){
                arr[i]=0;
            }else {
                arr[i]=1;
            }
        }
        return arr;
    }

}
