package everyday_problem;

/**
 * Created by 杜文丽 on 3/12/2020 1:03 PM
 * 我丢 这道题我是真不会
 * 我丢 这道题真是巧妙
 **/
public class GreatestCommonDivisorofStrings1071 {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2 ).equals( str2 + str1)) return "";
        return str1.substring(0, gcd(str1.length(), str2.length()));

    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
