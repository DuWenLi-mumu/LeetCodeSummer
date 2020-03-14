package dp;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 杜文丽 on 3/14/2020 5:17 PM
 * f(0)=1
 * f(1)=10
 * f(2)=9*9+f(1)
 * f(3)=9*9*8+f(2)
 * f(4)=9*9*8*7+f(3)
 **/
public class CountNumberswithUniqueDigits357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n==0){
            return 1;
        }else if (n==1){
            return 10;
        }
        int res=10;
        int f=9;
        int base=9;
        for (int i = n; i >1 ; i--) {
            f*=base;
            base--;
            res+=f;
        }
        return res;
    }

}

