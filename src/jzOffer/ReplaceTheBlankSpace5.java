package jzOffer;

/**
 * Created by 杜文丽 on 11/9/2020 3:05 PM
 **/
public class ReplaceTheBlankSpace5 {
    public String replaceSpace(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                res = res + "%20";
            }else {
                res = res + s.charAt(i);
            }
        }
        return res;
    }
}
