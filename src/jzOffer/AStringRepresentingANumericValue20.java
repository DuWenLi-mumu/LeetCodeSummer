package jzOffer;

import com.sun.org.apache.regexp.internal.RE;
import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * Created by 杜文丽 on 11/16/2020 8:55 PM
 **/
public class AStringRepresentingANumericValue20 {
    public boolean isNumber(String s) {
        boolean point = false;
        boolean e = false;
        boolean numFlag = false;
        s = s.trim();
        if (s == null || s.length() < 1){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                //判断为数字
                numFlag = true;
            }else if(s.charAt(i) == '.' && !e && !point){
                point = true;
            }else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E' )&& !e && numFlag){
                e = true;
                numFlag = false;
            }else if(((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i-1) == 'e' || s.charAt(i-1) == 'E'))){

            }
            else {
                return false;
            }
        }
        return numFlag;
    }


}
