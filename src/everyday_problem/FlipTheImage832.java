package everyday_problem;

public class FlipTheImage832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int len = A[0].length;
        if (len < 1){
            return A;
        }
        //水平翻转
        for (int i = 0; i < A.length; i++) {
            int left = 0;
            int right = len - 1;
            while (left < right){
                int tmp = A[i][left] ;
                A[i][left] = A[i][right];
                A[i][right] = tmp;
                left ++;
                right --;
            }
        }
        //反向
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < len; j++) {
                A[i][j] = (A[i][j] + 1) % 2;
            }
        }
        return A;
    }
}
