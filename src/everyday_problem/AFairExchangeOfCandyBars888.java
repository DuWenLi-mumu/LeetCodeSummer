package everyday_problem;

import java.util.Map;

/**
 * Created by 杜文丽 on 2/1/2021 11:12 PM
 **/
public class AFairExchangeOfCandyBars888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
        }
        for (int i = 0; i < B.length; i++) {
            sumB += B[i];
        }
        int[] res = new int[2];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (sumA - A[i] + B[j] == sumB - B[j] + A[i]){
                    res[0] = A[i];
                    res[1] = B[j];
                    return res;
                }
            }
        }
        return res;
    }
}
