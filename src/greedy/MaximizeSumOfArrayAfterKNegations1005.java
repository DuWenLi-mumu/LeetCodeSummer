package greedy;

import java.util.Arrays;

/**
 * Created by 杜文丽 on 2/13/2020 11:03 PM
 **/
public class MaximizeSumOfArrayAfterKNegations1005 {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);


        for (int i = 0; i <A.length ; i++) {
            if (K>0){
                if (A[i]<0){
                    A[i]=-1*A[i];
                    K--;
                }else {
                    Arrays.sort(A);
                    break;
                }
            }
        }

        if (K%2==1){
            A[0]=-1*A[0];
        }

        int res=0;
        for (int i = 0; i <A.length ; i++) {
            res+=A[i];
        }
        return res;
    }
}
