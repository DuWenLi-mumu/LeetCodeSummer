package dp;

import java.util.Arrays;

/**
 * Created by 杜文丽 on 3/16/2020 8:38 PM
 **/
public class GuessNumberHigherorLowerII375 {
    public int getMoneyAmount(int n) {
        return sub(1,n);
    }
    public int sub(int l,int h){
        if (h<=l){
            return 0;
        }
        int res= Integer.MAX_VALUE;
        for (int i = l; i <=h ; i++) {
            res=Math.min(res,i+Math.max(sub(l,i-1),sub(i+1,h)));
        }
        return res;

    }
}
