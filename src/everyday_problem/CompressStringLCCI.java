package everyday_problem;

/**
 * Created by 杜文丽 on 3/16/2020 7:55 PM
 **/
public class CompressStringLCCI {
    public String compressString(String S) {
        if (S.length()<2){
            return S;
        }
        int oldLen=S.length();
        String newStr="";
        char currChar=S.charAt(0);
        int count=1;
        for (int i = 1; i <oldLen ; i++) {
            if (currChar==S.charAt(i)){
                count++;
            }else {
                newStr=newStr+currChar+String.valueOf(count);
                count=1;
                currChar=S.charAt(i);
            }
        }
        newStr+=currChar+String.valueOf(count);
        if (newStr.length()>=S.length()){
            return S;
        }else {
            return newStr;
        }
    }
}
