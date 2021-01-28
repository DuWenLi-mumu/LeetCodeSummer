package jzOffer;

import java.util.Stack;

/**
 * Created by 杜文丽 on 1/7/2021 2:20 PM
 **/
public class ThePushInAndPopOutSequenceOfTheStack31 {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> in = new Stack<>();
        int currIn = 0;
        int currPop = 0;
        int len = pushed.length;
        while (currPop < len) {
            if (currIn < len) {
                if (!in.empty() && in.peek() == popped[currPop]) {
                    in.pop();
                    currPop++;
                } else if (in.empty() || currPop < len && pushed[currIn] != popped[currPop]) {
                    while (currIn < len && currPop < len && pushed[currIn] != popped[currPop]){
                        in.push(pushed[currIn]);
                        currIn++;
                    }
                    currPop++;
                    currIn++;
                }else {
                    currPop++;
                    currIn++;
                }
            } else {
                while (currPop < len){
                    if (!in.empty() && popped[currPop] == in.peek()){
                        in.pop();
                        currPop++;
                    }else {
                        return false;
                    }
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};

        int[] poped = {4,5,3,2,1};
        validateStackSequences(pushed,poped);
    }
}
