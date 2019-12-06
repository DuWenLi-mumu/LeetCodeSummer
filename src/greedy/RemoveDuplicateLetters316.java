package greedy;

import java.util.*;

/**
 * Created by 杜文丽 on 2019/12/5 17:26
 **/
public class RemoveDuplicateLetters316 {
    Set<Character> chars = new HashSet<>();
    Set<String> res = new HashSet<>();
    public void subDeal(char c, Set<Character> tmpChars, String currStr,String s) {
        if (tmpChars.isEmpty()) {
            res.add(currStr);
            return;
        }
        if (tmpChars.contains(c)) {
            currStr += c;
            s=s.replace(c+"","");
            tmpChars.remove(c);
            if (tmpChars.isEmpty()){
                res.add(currStr);
                return;
            }
            for (int i = 0; i <s.length() ; i++) {
                subDeal(s.charAt(i), new HashSet<>(tmpChars), currStr,s.substring(i));
            }
        }

    }

    public String removeDuplicateLetters(String s) {
        if (s.length() <= 1) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            chars.add(s.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            Set<Character> tmpChars = new HashSet<>(chars);
            String currStr = "";
            subDeal(s.charAt(i), tmpChars, currStr,s.substring(i));
        }
        List<String> resList=new ArrayList<>();
        for (String str:res
             ) {
            resList.add(str);
        }
        Collections.sort(resList);
        return resList.get(0);
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters316 test = new RemoveDuplicateLetters316();
        System.out.println(test.removeDuplicateLetters("bbcaac"));
        //System.out.println("bbbcc".substring(1));
    }
}
