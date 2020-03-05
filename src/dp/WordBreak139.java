package dp;

import java.util.List;

/**
 * Created by 杜文丽 on 3/5/2020 3:38 PM
 **/
public class WordBreak139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        //dp[i]表示前i个字符串能否拆分成dic
        int[] dp=new int[s.length()+1];
        dp[0]=1;
        for (int i = 1; i <=s.length() ; i++) {
            for (int j = 0; j <i ; j++) {
                if (dp[j]==1&&wordDict.contains(s.substring(j,i))){
                    dp[i]=1;
                    break;
                }
            }
        }
        if (dp[s.length()]==1){
            return true;
        }else {
            return false;
        }
    }
}
