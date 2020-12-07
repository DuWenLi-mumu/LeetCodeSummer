package jzOffer;

import java.util.Stack;

/**
 * Created by 杜文丽 on 12/7/2020 2:26 PM
 **/
public class TheStackContainingTheMinFunction30 {
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;
    Stack<Integer> minStack = new Stack<>();
    public TheStackContainingTheMinFunction30() {
    }

    public void push(int x) {
        if (min >= x){
            minStack.push(min);
            min = x;
        }
        stack.add(x);
    }

    public void pop() {
        if (stack.peek() == min){
            min = minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min;
    }
}
