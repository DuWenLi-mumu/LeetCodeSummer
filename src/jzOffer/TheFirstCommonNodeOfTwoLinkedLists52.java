package jzOffer;

import util.ListNode;

/**
 * Created by 杜文丽 on 10/22/2020 10:17 PM
 **/
public class TheFirstCommonNodeOfTwoLinkedLists52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA;
        ListNode h2 = headB;
        while (h1 != null){
            while (h2 != null && h1 != h2){
                h2 = h2.next;
            }
            if (h2 == null){
                h1 = h1.next;
                h2 = headB;
            }else {
                return h1;
            }
        }
        return null;
    }
}
