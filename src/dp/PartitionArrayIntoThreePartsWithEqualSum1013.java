package dp;

/**
 * Created by 杜文丽 on 3/11/2020 11:08 PM
 *
 * 这个办法 实属暴力了emmm
 **/
public class PartitionArrayIntoThreePartsWithEqualSum1013 {
    public boolean canThreePartsEqualSum(int[] A) {
        int len=A.length;
        int sum1=0;
        for (int i = 0; i <len-2 ; i++) {
            sum1+=A[i];
            int sum2=0;
            for (int j = i+1; j <len-1 ; j++) {
                sum2+=A[j];
                if (sum1!=sum2){
                    continue;
                }
                int sum3=0;
                for (int k = j+1; k <len ; k++) {
                    sum3+=A[k];

                }
                if (sum2==sum3){
                    return true;
                }
            }
        }
        return false;
    }
}
