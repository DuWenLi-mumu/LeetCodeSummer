package dp;

/**
 * Created by 杜文丽 on 9/11/2020 9:23 PM
 **/
public class LongestPalindromicSubstring5 {
    public static void main(String[] args) {
        LongestPalindromicSubstring5 test=new LongestPalindromicSubstring5();
        test.longestPalindrome("cbbd");
    }
    public String longestPalindrome(String s) {
        if (s.length()<2){
            return s;
        }
        int len=s.length();
        boolean[][] dp=new boolean[len+1][len+1];
        for (int i = 0; i <len ; i++) {
            for (int j = 0; j <len ; j++) {
                if (i>=j){
                    dp[i][j]=true;
                }
            }
        }
        int left=0;
        int right=0;
        for (int i = len; i >0 ; i--) {
            for (int j = i+1; j <=len ; j++) {
                if (s.charAt(i-1)==s.charAt(j-1)){
                    dp[i][j]=dp[i+1][j-1];
                    if (dp[i][j]&&right-left<j-i){
                        right=j-1;
                        left=i-1;
                    }
                }else {
                    dp[i][j]=false;
                }
            }
        }

        return s.substring(left,right+1);
    }
}
