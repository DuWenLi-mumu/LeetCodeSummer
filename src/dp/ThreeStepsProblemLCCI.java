package dp;

/**
 * Created by 杜文丽 on 2/26/2020 5:31 PM
 **/
public class ThreeStepsProblemLCCI {
    public int waysToStep(int n) {
        if (n<=1){
            return 1;
        }else if (n<=2){
            return 2;
        }else if (n<=0){
            return 0;
        }
        int n0=1;
        int n1=1;
        int n2=2;
        int tmp;
        for (int i = 3; i <=n ; i++) {
            tmp=((n0+n1)%1000000007+n2)%1000000007;
            n0=n1;
            n1=n2;
            n2=tmp;
        }
        return n2;
    }
}
