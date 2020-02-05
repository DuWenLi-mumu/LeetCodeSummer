package recursion;

/**
 * Created by 杜文丽 on 2020/2/5 13:13
 **/
public class NthTribonacciNumber1137 {
    int res=0;
    public int tribonacci(int n) {
        if (n<=0){
            return 0;
        }
        if (n<=2){
            return 1;
        }
        dfs(0,1,1,2,n);
        return res;

    }
    public void dfs(int n1,int n2,int n3,int index,int n){
        if (index>=n){
            return;
        }else {
            res=n1+n2+n3;
            n1=n2;n2=n3;n3=res;
            dfs(n1,n2,n3,index+1,n);
        }
    }
}
