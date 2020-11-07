package dp;

import java.util.Stack;

/**
 * Created by 杜文丽 on 8/14/2019 4:06 PM
 **/
public class RegularExpressionMatching10 {
    boolean[][] dp;
    char[] s_c;
    char[] p_c;
    public boolean isMatch(String s, String p) {
        dp=new boolean[s.length()+1][p.length()+1];
        s_c= new char[s.length()+2];
        p_c=new char[p.length()+2];
        dp[0][0]=true;
        s_c[0]=' ';
        p_c[0]=' ';
        for (int i = 0; i <s.length() ; i++) {
            s_c[i+1]=s.charAt(i);
        }
        for (int i = 0; i <p.length() ; i++) {
            p_c[i+1]=p.charAt(i);
        }
        for (int i = 2; i <p.length()+1 ; i++) {
            if (p_c[i]=='*'){
                //可以出现0次
                dp[0][i]=dp[0][i-2];
            }
        }
        for (int i = 1; i <s.length()+1 ; i++) {
            for (int j = 1; j <p.length()+1 ; j++) {
                if (p_c[j]=='.'||p_c[j]==s_c[i]){
                    dp[i][j]=dp[i-1][j-1];
                }
                if (j >= 2 && p_c[j]== '*') {
                    //出现0次
                    dp[i][j]=dp[i][j-2];
                    //出现多次
                    if (p_c[j-1]=='.'||p_c[j-1]==s_c[i]){
                        dp[i][j]|=dp[i-1][j]|dp[i-1][j-1];//再出现一次或者直接就走到最后
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        RegularExpressionMatching10 test=new RegularExpressionMatching10();
        test.isMatch("aaaaa",".*");
    }

}
