package everyday_problem;

import java.util.Arrays;

/**
 * Created by 杜文丽 on 3/22/2020 1:49 PM
 **/
public class MinimumIncrementToMakeArrayUnique945 {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int res=0;
        for (int i = 1; i <A.length ; i++) {
            if (A[i]<=A[i-1]){
                res+=A[i-1]+1-A[i];
                A[i]=A[i-1]+1;
            }
        }
        return res;
    }
}
