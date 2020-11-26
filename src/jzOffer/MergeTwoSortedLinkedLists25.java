package jzOffer;

import util.ListNode;

/**
 * Created by 杜文丽 on 11/26/2020 1:08 PM
 **/
public class MergeTwoSortedLinkedLists25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        if (l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        The substructure of a tree
        return head.next;
    }
}
