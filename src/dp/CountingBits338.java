package dp;

/**
 * Created by 杜文丽 on 3/13/2020 3:07 PM
 **/
public class CountingBits338 {
    public int[] countBits(int num) {
        int[] res=new int[num+1];
        if (num <=0){
            return res;
        }
        res[1]=1;
        if (num <=0){
            return res;
        }
        for (int i = 2; i <=num ; i++) {
            if (i%2==0){
                res[i]=res[i/2];
            }else {
                res[i]=res[i-1]+1;
            }
        }
        return res;
    }
}
