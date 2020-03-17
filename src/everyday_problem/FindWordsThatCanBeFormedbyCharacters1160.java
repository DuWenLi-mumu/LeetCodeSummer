package everyday_problem;

/**
 * Created by 杜文丽 on 3/17/2020 4:27 PM
 **/
public class FindWordsThatCanBeFormedbyCharacters1160 {
    public static void main(String[] args) {

    }
    public int countCharacters(String[] words, String chars) {
        char[] remainChars=new char[26];
        int res=0;
        for (int i = 0; i <chars.length() ; i++) {
            remainChars[chars.charAt(i)-'a']++;
        }
        for (int i = 0; i <words.length ; i++) {
            char[] tmp=remainChars.clone();
            boolean success=true;
            for (int j = 0; j <words[i].length()&&success ; j++) {
                if (tmp[words[i].charAt(j)-'a']>0){
                    tmp[words[i].charAt(j)-'a']--;
                }else {
                    success=false;
                }
            }
            if (success){
                res+=words[i].length();
            }
        }
        return res;
    }
}
