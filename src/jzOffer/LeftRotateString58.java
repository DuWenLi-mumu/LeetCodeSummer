package jzOffer;

/**
 * Created by 杜文丽 on 11/3/2020 9:17 PM
 **/
public class LeftRotateString58 {
    public String reverseLeftWords(String s, int n) {
        String sub1 = s.substring(0, n);
        return s.substring(n) + sub1;
    }
}
