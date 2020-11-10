package jzOffer;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * Created by 杜文丽 on 11/6/2020 11:53 PM
 **/
public class FibonacciSequenceI9 {
    public int fib(int n) {
        if (n < 2){
            return n;
        }
        int n1 = 0;
        int n2 = 1;
        int pre = n2;
        for (int i = 2; i <= n ; i++) {
            pre = n2;
            n2 = (n1 + n2) % 1000000007;
            n1 = pre;
        }
        return n2;

    }
}
