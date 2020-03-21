package everyday_problem;

/**
 * Created by 杜文丽 on 3/21/2020 7:09 PM
 **/
public class WaterAndJugProblem365 {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x+y<z){
            return false;
        }
        if (z==0){
            return true;
        }
        int gcd=gcd(x,y);
        if (gcd==0){
            if (x==0&&y!=0){
                return z%y==0?true:false;
            }else if (y==0&&x!=0){
                return z%x==0?true:false;
            }else {
                return false;
            }
        }
        return z%gcd==0?true:false;
    }
    public int gcd(int a,int b){
        if (b==0){
            return 0;
        }
        if (a%b==0){
            return b;
        }
        int tmp=a%b;
        a=b;
        b=tmp;
        return gcd(a,b);
    }
}
