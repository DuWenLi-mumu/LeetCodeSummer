package greedy;

import java.util.Stack;

/**
 * Created by 杜文丽 on 2/20/2020 7:56 PM
 **/
public class MinimumAddtoMakeParenthesesValid921 {
    public int minAddToMakeValid(String S) {
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i <S.length() ; i++) {
            if (stack.empty()){
                stack.push(S.charAt(i));
            }else if (stack.peek()=='('&&S.charAt(i)==')'){
                stack.pop();

            }else {
                stack.add(S.charAt(i));
            }

        }
        return stack.size();

    }
}
