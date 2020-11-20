package jzOffer;

/**
 * Created by 杜文丽 on 11/10/2020 9:56 PM
 **/
public class ToTheIntegerPowerOfAValue16 {
    public static double myPow(double x, int n1) {
        double tmp = x;
        long base = 1;
        long n = n1;
        boolean rebase = false;
        if (n == 0) {
            return 1;
        } else if (n == 1 || n == -1) {
            if (n == 1) {
                return x;
            } else {
                return 1 / x;
            }
        } else if (n < 0) {
            rebase = true;
            n = -n;
        }
        double res = 1;
        while (n >= 2 * base) {
            tmp *= tmp;
            res *= tmp;
            n -= 2 * base;
            base *= 2;
        }
        while (n > 0) {
            res *= x;
            n--;
        }
        if (rebase) {
            res = 1 / res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00000,
                -2147483648));
    }
}
