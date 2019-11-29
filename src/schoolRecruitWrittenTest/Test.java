package schoolRecruitWrittenTest;

import java.util.Scanner;

/**
 * Created by 杜文丽 on 8/25/2019 4:09 PM
 **/
public class Test {
    public static int sub(char[] stra,char[] strb,int curra,int currb,int currChange,int alen,int blen){
        if (curra>=alen||currb>=blen){
            return currChange;
        }
        if (stra[curra]==strb[currb]){
            return sub(stra,strb,curra+1,currb+1,currChange,alen,blen);
        }else {
            for (int i = blen-1; i >=currb ; i++) {
                strb[i]=strb[i-1];
            }
            strb[currb]=stra[curra];
            blen++;
            int add=sub(stra,strb,curra+1,currb+1,currChange+1,alen,blen);
            for (int i = currb; i <blen ; i++) {
                strb[i]=strb[i+2];
            }
            blen-=2;
            int remove=sub(stra,strb,curra+1,currb,currChange+1,alen,blen);
            for (int i = blen; i >=currb ; i++) {
                strb[i+1]=strb[i];
            }
            strb[currb]=stra[curra];
            blen++;
            int change=sub(stra,strb,curra+1,currb+1,currChange++,alen,blen);

            return Math.min(Math.min(add,remove),change);
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String stra=in.next();
        String strb=in.next();
        char[] a=new char[100000];
        char[]b=new char[100000];
        for (int i = 0; i <stra.length() ; i++) {
            a[i]=stra.charAt(i);
        }
        for (int i = 0; i <strb.length() ; i++) {
            b[i]=strb.charAt(i);
        }
        System.out.println(sub(a,b,0,0,0,stra.length(),strb.length()));


    }
}
