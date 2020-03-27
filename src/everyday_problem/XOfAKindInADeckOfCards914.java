package everyday_problem;

import java.util.*;

/**
 * Created by 杜文丽 on 3/27/2020 7:26 PM
 **/
public class XOfAKindInADeckOfCards914 {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] count=new int[1111111];
        for (int num:deck
             ) {
            count[num]++;
        }
        int x=0;
        for (int c:count
             ) {
            if (c>0){
                x=gcd(x,c);
                if (x==1){
                    return false;
                }
            }
        }
        return x>=2;
    }
    public int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
}
