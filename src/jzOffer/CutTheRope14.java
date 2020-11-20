package jzOffer;

/**
 * Created by 杜文丽 on 11/10/2020 8:18 PM
 **/
public class CutTheRope14 {
    public int cuttingRope(int n) {
        int res = 1;
        if (n <= 2){
            return 1;
        }else if (n == 3){
            return 2;
        }
        while (n >= 3){
            res *= 3;
            n -= 3;
        }
        if (n == 1){
            res /= 3;
            res *= 4;
        }else if (n == 2){
            res *= 2;
        }
        return res;

    }
}
