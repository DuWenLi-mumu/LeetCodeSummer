package greedy;

/**
 * Created by 杜文丽 on 2/22/2020 10:22 PM
 * X只能*2或者-1
 * 等价于
 * y只能/2或者+1
 *
 *
 **/
public class BrokenCalculator991 {
    public int brokenCalc(int X, int Y) {
        if (X>=Y){
            return X-Y;
        }
        int res=0;
        while (X<Y){
            if (Y%2==0){
                res++;
                Y/=2;
            }else {
                res+=2;
                Y=(Y+1)/2;
            }
        }
        return res+X-Y;
    }
}
