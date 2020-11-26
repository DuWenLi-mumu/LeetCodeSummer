package jzOffer;

import util.ListNode;

/**
 * Created by 杜文丽 on 11/20/2020 5:05 PM
 **/
public class TheKthToTheLastNodeInTheList22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode curr = head;
        int size = 0;
        while (curr != null){
            size++;
            curr = curr.next;
        }
        int len = size - k;
        int currIndex = 0;
        curr = head;
        while (currIndex < len && curr != null){
            curr = curr.next;
            currIndex++;
        }
        return curr;
    }
}
