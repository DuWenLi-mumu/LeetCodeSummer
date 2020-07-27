package everyday_problem;

/**
 * Created by 杜文丽 on 7/27/2020 5:18 PM
 **/
public class IsSubsequence392 {
    public static void main(String[] args) {
        IsSubsequence392 test=new IsSubsequence392();
        test.isSubsequence("aaaa", "abbaa");
    }
    public boolean isSubsequence(String s, String t) {
        int index=-1;
        for (int i = 0; i <s.length() ; i++) {
            index=find(String.valueOf(s.charAt(i)),t,index+1);
            if (index<0){
                return false;
            }else if (index>=t.length()-1){
                if (s.length()-1<=i){
                    return true;
                }
                return false;
            }
        }
        return true;
    }
    public int find(String c,String t,int curr){
        String subStr=t.substring(curr);
        boolean contain=subStr.contains(c);
        if (contain){
            return subStr.indexOf(c)+curr;
        }else {
            return -1;
        }
    }
}
