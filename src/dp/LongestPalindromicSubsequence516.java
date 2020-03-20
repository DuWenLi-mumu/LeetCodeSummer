package dp;

/**
 * Created by 杜文丽 on 3/20/2020 1:58 PM
 * dp[i][j]表示 i到j子字符串中 最长回文串的长度
 *
 * 状态转移方程：
 * s[i]=s[j]: dp[i][j]=dp[i+1][j-1]+2
 * s[i]!=s[j]: dp[i][j]=Max(dp[i+1][j],dp[i][j-1]);
 **/
public class LongestPalindromicSubsequence516 {
    public static void main(String[] args) {
        String s="cbbd";
        longestPalindromeSubseq(s);
    }
    public static int longestPalindromeSubseq(String s) {
        int[][] dp=new int[s.length()][s.length()];
        dp[0][0]=1;
        for (int j = 1; j <s.length() ; j++) {
            dp[j][j]=1;
            for (int i = j-1; i >=0 ; i--) {
                if (s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1]+2;
                }else {
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}
