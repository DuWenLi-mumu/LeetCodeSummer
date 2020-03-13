package dp;

/**
 * Created by 杜文丽 on 3/13/2020 11:23 PM
 **/
public class ArithmeticSlices413 {
    public int numberOfArithmeticSlices(int[] A) {
        int res=0;
        int add=0;
        if (A.length<=2){
            return 0;
        }
        for (int i = 2; i <A.length ; i++) {
            if (A[i]-A[i-1]==A[i-1]-A[i-2]){
                res+=++add;
            }else {
                add=0;
            }
        }
        return res;
    }
}
