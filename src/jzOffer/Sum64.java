package jzOffer;

/**
 * (n+1)*n/2 = (n2+n)>>1
 */
public class Sum64 {
    public int sumNums(int n) {
        return (int)(Math.pow(n,2) + n) >> 1;
    }
}
