package jzOffer;

/**
 * Created by 杜文丽 on 11/14/2020 2:34 PM
 **/
public class PrintTheMaximumNumberOfNBitsFromOne17 {
    public int[] printNumbers(int n) {
        long num = 1;
        while (n > 0){
            n--;
            num *= 10;
        }
        int[] res = new int[(int) (num - 1)];
        for (int i = 1; i < num ; i++) {
            res[i] = i;
        }
        return res;
    }
}
