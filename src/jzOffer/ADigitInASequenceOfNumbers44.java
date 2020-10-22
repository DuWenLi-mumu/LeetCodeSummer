package jzOffer;

/**
 * Created by 杜文丽 on 10/21/2020 9:51 PM
 **/
public class ADigitInASequenceOfNumbers44 {
    public int findNthDigit(int n) {
        int digit = 1;//位数
        int start = 1;
        int count = 9;
        while (count < n) {
            n -= count;
            digit++;
            start *= 10;
            count = 9 * start * digit;

        }
        int num = start + (n - 1) / digit;
        int res = String.valueOf(num).charAt((n-1) % digit)-'0' ;
        return res;
    }
}
