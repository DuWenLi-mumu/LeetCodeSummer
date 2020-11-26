package jzOffer;

import util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杜文丽 on 11/26/2020 1:02 PM
 **/
public class ReverseALinkedList24 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode curr = head;
        ListNode nextNode = curr.next;
        curr.next = null;
        while (nextNode != null){
            ListNode next = nextNode.next;
            nextNode.next = curr;
            curr = nextNode;
            nextNode = next;
        }
        return curr;

    }
}
