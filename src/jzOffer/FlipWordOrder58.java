package jzOffer;

/**
 * Created by 杜文丽 on 10/23/2020 3:46 PM
 **/
public class FlipWordOrder58 {
    String res = "";
    public String reverseWords(String s) {
        if (s.length() < 1){
            return s;
        }
        String reverse = new StringBuffer(s).reverse().toString();
        char[] reverseChars = reverse.toCharArray();
        int begin = 0;
        int end = 0;
        while (begin < reverseChars.length && end < reverseChars.length){
            while (begin < reverseChars.length && reverseChars[begin] == ' '){
                begin++;
            }
            end = begin;
            while (end < reverseChars.length && reverseChars[end] != ' '){
                end++;
            }
            if (res.length() >= 1){
                res += " ";
            }
            reverse(reverseChars,begin,end - 1);
            begin = end;
        }
        int index = res.length()-1;
        while (index >= 0 && res.charAt(index) == ' '){
            index--;
        }
        res = res.substring(0,index +1);
        return res;
    }
    public void reverse(char[] chars,int begin,int end){
        if (begin >= chars.length || end >= chars.length){
            return;
        }
        for (int i = end; i >= begin; i--) {
            res += chars[i];
        }
    }
    public static void main(String[] args) {
        String s = "a good   example";
        FlipWordOrder58 test = new FlipWordOrder58();
        test.reverseWords(s);

    }
}
