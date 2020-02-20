package greedy;

import java.util.ArrayList;

/**
 * Created by 杜文丽 on 2/20/2020 7:39 PM
 **/
public class ZigZagConversion6 {
    public static void main(String[] args) {

        String str="PAYPALISHIRING";
        convert(str,3);

    }
    public static String convert(String s, int numRows) {
        if (numRows<=1){
            return s;
        }
        if (s.length()<=1){
            return s;
        }
        String[] arr=new String[numRows];
        for (int i = 0; i <numRows ; i++) {
            arr[i]="";
        }
        for (int i = 0; i <s.length() ; i+=(numRows*2-2)) {
            int index=i;
            for (int j = 0; j <numRows ; j++) {
                if (index<s.length()){
                    arr[j]=arr[j]+s.charAt(index++);
                }
            }
            for (int j = numRows-2; j >0 ; j--) {
                if (index<s.length()){
                    arr[j]=arr[j]+s.charAt(index++);
                }
            }
        }
        String res="";
        for (int i = 0; i <numRows ; i++) {
            res+=arr[i];
        }
        return res;
    }
}
