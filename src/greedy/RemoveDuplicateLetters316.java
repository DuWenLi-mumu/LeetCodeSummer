package greedy;

import java.util.*;

/**
 * Created by 杜文丽 on 2019/12/5 17:26
 **/
public class RemoveDuplicateLetters316 {
    Set<Character> chars = new HashSet<>();
    Set<String> res = new HashSet<>();
    String s = "";
    public void subDeal(int i, Set<Character> tmpChars, String currStr) {
        if (tmpChars.isEmpty()) {
            res.add(currStr);
            return;
        }
        if (tmpChars.contains(s.charAt(i))) {
            currStr += s.charAt(i);
            tmpChars.remove(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (tmpChars.isEmpty()){
                    res.add(currStr);
                    return;
                }
                if (tmpChars.contains(s.charAt(j))) {
                    subDeal(j, new HashSet<>(tmpChars), currStr);
                }
            }
        }

    }

    public String removeDuplicateLetters(String s) {
        if (s.length() <= 1) {
            return s;
        }
        this.s=s;
        for (int i = 0; i < s.length(); i++) {
            chars.add(s.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            Set<Character> tmpChars = new HashSet<>(chars);
            String currStr = "";
            subDeal(i, tmpChars, currStr);
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
    }
}
