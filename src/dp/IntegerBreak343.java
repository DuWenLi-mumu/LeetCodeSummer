package dp;

/**
 * Created by 杜文丽 on 3/10/2020 9:30 PM
 * 原则就是 能拆成3绝对不拆成2
 * 6=2+2+2=2*2*2=8
 * 6=3+3=3*3=9
 **/
public class IntegerBreak343 {
    public int integerBreak(int n) {
        if (n==2){
            return 1;
        }
        if (n==3){
            return 2;
        }
        int res=1;
        while (n>4){
            res*=3;
            n-=3;
        }
        return n*res;
    }
}
