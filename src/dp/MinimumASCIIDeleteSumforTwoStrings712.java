package dp;

/**
 * Created by 杜文丽 on 3/12/2020 1:28 PM
 * dp[i][j] str1前i个字符与str2前j个字符构成相等所需要删除的最小ASCII和
 **/
public class MinimumASCIIDeleteSumforTwoStrings712 {
    public int minimumDeleteSum(String s1, String s2) {
        int [][] dp = new int[s2.length()+1][s1.length()+1];
        for(int i = 1; i< s1.length()+1; i++){
            dp[0][i] = s1.charAt(i-1)+ dp[0][i-1];
        }
        for(int i = 1; i< s2.length()+1; i++){
            dp[i][0] = s2.charAt(i-1) + dp[i-1][0];
        }
        for(int j = 1; j< s2.length()+1 ; ++j){
            for (int i = 1; i<s1.length()+1;++i){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[j][i] = dp[j-1][i-1];
                }else{
                    dp[j][i] = Math.min(dp[j-1][i]+(s2.charAt(j-1)),
                            dp[j][i-1]+(s1.charAt(i-1)));
                }
            }
        }
        return dp[s2.length()][s1.length()];

    }
}
