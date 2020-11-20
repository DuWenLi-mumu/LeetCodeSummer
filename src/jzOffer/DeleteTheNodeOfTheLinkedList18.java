package jzOffer;

import util.ListNode;

/**
 * Created by 杜文丽 on 11/14/2020 3:24 PM
 **/
public class DeleteTheNodeOfTheLinkedList18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode curr = head;
        if (curr == null){
            return null;
        }else if ((curr.next == null && curr.val != val)){
            return curr;
        }else if (curr.val == val){
            return curr.next;
        }
        while (curr.next != null && curr.next.val != val){
            curr = curr.next;
        }
        if (curr.next == null){
            return null;
        }else if (curr.next.val == val){
            curr.next = curr.next.next;
        }
        return head;
    }
}
