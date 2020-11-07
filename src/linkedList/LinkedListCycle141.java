package linkedList;

import util.ListNode;

/**
 * Created by 杜文丽 on 8/16/2019 6:53 PM
 **/
public class LinkedListCycle141 {
    public boolean hasCycle(ListNode head) {
        if (head==null)
            return false;
        ListNode fast=head.next;
        ListNode slow=head;
        if (slow==null||fast==null){
            return false;
        }
        while (slow!=null&&fast!=null&&slow!=fast&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if (slow==fast&&slow!=null){
            return true;
        }else if (slow==null||fast==null||fast.next==null||slow.next==null){
            return false;
        }
        return false;
    }
}

