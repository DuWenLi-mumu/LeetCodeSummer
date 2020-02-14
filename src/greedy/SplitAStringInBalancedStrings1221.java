package greedy;

import java.util.Stack;

/**
 * Created by 杜文丽 on 2/14/2020 10:52 PM
 **/
public class SplitAStringInBalancedStrings1221 {
    public int balancedStringSplit(String s) {
        Stack<Character> stack=new Stack<>();
        int res=0;
        for (int i = 0; i <s.length() ; i++) {
            if (stack.empty()){
                stack.push(s.charAt(i));
                continue;
            }else if (stack.peek()==s.charAt(i)){
                stack.push(s.charAt(i));
                continue;
            }else {
                stack.pop();
                if (stack.empty()){
                    res++;
                }
            }
        }
        return res;
    }
}
