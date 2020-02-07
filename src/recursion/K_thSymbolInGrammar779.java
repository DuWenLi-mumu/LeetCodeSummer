package recursion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by 杜文丽 on 2020/2/7 21:04
 **/
public class K_thSymbolInGrammar779 {
    public  int kthGrammar(int N, int K) {
       if (N==1){
           return 0;
       }
       if (K%2==0){
           if (kthGrammar(N-1,K/2)==0){
               return 1;
           }else {
               return 0;
           }
       }else {
           if (kthGrammar(N-1,(K+1)/2)==0){
               return 0;
           }else {
               return 1;
           }
       }

    }
}
