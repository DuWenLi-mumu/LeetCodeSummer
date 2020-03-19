package dp;

/**
 * Created by 杜文丽 on 3/19/2020 3:31 PM
 **/
public class MaximumLengthofRepeatedSubarray718 {
    public int findLength(int[] A, int[] B) {
        int[] big;
        int[] small;
        if (A.length>B.length){
            big=A;
            small=B;
        }else {
            big=B;
            small=A;
        }
        int[][] dp=new int[small.length+1][big.length+1];

        int max=0;
        for (int i = 0; i <small.length ; i++) {
            for (int j = 0; j <big.length ; j++) {
               if (small[i]==big[j]){
                   if (i==0||j==0){
                       dp[i][j]=1;
                   }else {
                       dp[i][j]=dp[i-1][j-1]+1;
                   }

               }
               max=Math.max(dp[i][j],max);
            }
        }
        return max;

    }
}
