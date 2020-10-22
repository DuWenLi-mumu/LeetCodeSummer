package jzOffer;

/**
 * Created by 杜文丽 on 10/19/2020 7:58 PM
 **/
public class TranslateANumberIntoAString46 {
    public int translateNum(int num) {
        String number=String.valueOf(num);
        int[] dp=new int[number.length()+1];
        dp[1] = 1;
        if (number.length()<2){
            return 1;
        }
        if (number.charAt(0)=='1'){
            dp[2]=2;
        }else if (number.charAt(0)=='2'&&number.charAt(1)<='5'){
            dp[2]=2;
        }else {
            dp[2]=1;
        }
        for (int i = 2; i <= number.length(); i++) {
            if (number.charAt(i-2)=='2'&&number.charAt(i-1)<='5'){
                dp[i]=dp[i-1]+dp[i-2];
            }else if (number.charAt(i-2)=='1'){
                dp[i]=dp[i-1]+dp[i-2];
            }else {
                dp[i]=dp[i-1];
            }
        }
        return dp[number.length()];
    }
}
