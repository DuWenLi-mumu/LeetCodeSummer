package dp;

/**
 * Created by 杜文丽 on 2/28/2020 9:33 PM
 **/
public class DecodeWays91 {
    public int numDecodings(String s) {
        if (s.length()<=0){
            return 0;
        }
        if (s.charAt(0)=='0'){
            return 0;
        }
        if (s.length()<=1&&s.charAt(0)!='0'){
            return 1;
        }
        int[] dp=new int[s.length()];
        dp[0]=1;
        if (s.charAt(0)>='1'&&s.charAt(0)<'2'&&s.charAt(1)!='0'){
            dp[1]=2;
        }else if (s.charAt(0)=='2'&&s.charAt(1)<='6'&&s.charAt(1)>'0'){
            dp[1]=2;
        }else if (s.charAt(0)>'2'&&s.charAt(1)=='0'){
            return 0;
        }else {
            dp[1]=1;
        }
        for (int i = 2; i <s.length() ; i++) {
            if (s.charAt(i)=='0'){
                if (s.charAt(i-1)<='2'&&s.charAt(i-1)>='1'){
                    dp[i]=dp[i-2];
                }else {
                    return 0;
                }
            }else if (s.charAt(i-1)<'2'&&s.charAt(i-1)>='1'){
                dp[i]=dp[i-1]+dp[i-2];
            }else if (s.charAt(i-1)=='2'&&s.charAt(i)<='6'&&s.charAt(i)>'0'){
                dp[i]=dp[i-1]+dp[i-2];
            }else {
                dp[i]=dp[i-1];
            }
        }
        return dp[s.length()-1];

    }
}
