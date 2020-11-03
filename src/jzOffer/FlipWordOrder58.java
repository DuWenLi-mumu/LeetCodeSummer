package jzOffer;

/**
 * Created by 杜文丽 on 10/23/2020 3:46 PM
 **/
public class FlipWordOrder58 {
    public String reverseWords(String s) {
        String res = "";
        int begin = 0;
        int end = s.length() - 1;
        //去除首空格
        while (begin < s.length()){
            if (s.charAt(begin)==' '){
                begin++;
            }else {
                break;
            }
        }
        //去除尾空格
        while (end >= 0){
            if (s.charAt(end) == ' ') {
                end--;
            }else {
                break;
            }
        }
        char[] str = new char[s.length()];
        if (begin == end){
            return String.valueOf(s.charAt(begin));
        }
        //在复制的时候直接翻转
        int length = end - begin + 1;
        for (int i = begin;i <= end; i++) {
            str[i] = s.charAt(begin + end - i);
        }
        int left = begin;
        int right = begin-2;
        for (int i = begin; i <= end ;) {
            //遇到空格 就要翻转
            if (str[i] == ' '){
                left = right+2;
                right = i-1;
                res += reverse(str,left,right)+" ";
                if (i < end && str[i+1] == ' '){
                    while (i <= end && str[i] == ' '){
                        i++;
                    }
                    right = i-1;
                }else {
                    i++;
                }

            }else {
                i++;
            }
        }
        int index = end;
        while (str[index] != ' '){
            index--;
        }
        res += reverse(str,index+1,end);

        return res;
    }
    public String reverse(char[] x,int left, int right){
        if (left == right){
            return String.valueOf(x[left]);
        }
        int l = left;
        int r = right;
        while (left < right){
            x[left] ^= x[right];
            x[right] ^= x[left];
            x[left] ^= x[right];
            left++;
            right--;
        }
        String res = "";
        for (int i = l; i <= r ; i++) {
            res += x[i];
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "a good   example";
        FlipWordOrder58 test = new FlipWordOrder58();
        test.reverseWords(s);

    }
}
