package algorithm_implementation;

/**
 * Created by 杜文丽 on 3/20/2020 1:23 PM
 *
 * kmp是著名的字符串匹配算法，在字符串txt中寻找是否有模式子串pat
 * 思想：尽可能用已经匹配过的字符串来最大化模式子串的移动
 *
 * dfa[char i][j]表示 新来的字符char i与模式子串pat第j位匹配或者不匹配的时候，模式子串pat下一步应该移动到哪一位
 * X表示，当不匹配的时候，下一步pat应该移动到第X位的位置
 *当匹配成功时 下一位应该跳转到 j+1
 *
 **/
public class KMP {
    static int[][] dfa;
    public static boolean kmp(String txt,String pat){

        calculateDFA(pat);
        int j=0;
        for (int i = 1; i <txt.length() &&j<pat.length(); i++) {
            j=dfa[txt.charAt(i)][j];
        }
        if (j>=pat.length()){
            return true;
        }else {
            return false;
        }
    }
    public static void calculateDFA(String pat){
        dfa=new int[256][pat.length()+1];
        dfa[pat.charAt(0)][0]=1;//只有和第一个字符相同的串 才可以匹配
        int X=0;//匹配失败时，下一步pat该匹配的位置
        for (int i = 1; i <pat.length() ; i++) {
            //假设全都不匹配
            for (int j = 0; j <256 ; j++) {
                dfa[j][i]=dfa[j][X];
            }
            //只有和pat[i]位字符相同时 才是匹配
            dfa[pat.charAt(i)][i]=i+1;
            //更新X
            X=dfa[pat.charAt(i)][X];
        }

    }

    public static void main(String[] args) {
        String txt="ABAAA";
        String pat="BAAB";
        System.out.println(kmp(txt,pat));
    }
}
