package jzOffer;

import java.util.Stack;

/**
 * Created by 杜文丽 on 11/7/2020 12:53 PM
 **/
public class QueuesAreImplementedWithTwoStacks9 {

}
class CQueue {
    Stack<Integer> add;
    Stack<Integer> post;
    public CQueue() {
        add = new Stack<>();
        post = new Stack<>();
    }
    public void appendTail(int value) {
        add.add(value);
    }
    public int deleteHead() {
        if (post.empty() && add.empty()){
            return -1;
        }
        if (!post.empty()){
            return post.pop();
        }
        while (!add.empty()){
            post.add(add.pop());
        }
        return post.pop();
    }

}