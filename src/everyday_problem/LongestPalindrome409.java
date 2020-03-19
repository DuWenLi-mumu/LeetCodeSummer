package everyday_problem;

/**
 * Created by 杜文丽 on 3/19/2020 3:00 PM
 **/
public class LongestPalindrome409 {
    public int longestPalindrome(String s) {
        int[] chars=new int[60];
        int res=0;
        for (int i = 0; i < s.length(); i++) {
            int index=s.charAt(i)-'A';
            chars[index]++;
            if (chars[index]%2==0){
                res+=chars[index];
                chars[index]=0;
            }
        }
        boolean single=false;
        for (int i = 0; i <60 ; i++) {
            if (chars[i]%2==0){
                continue;
            }else {
                single=true;
            }
        }
        if (single){
            res++;
        }
        return res;
    }
}
