package linked_List;

/**
 * Created by 杜文丽 on 8/16/2019 7:01 PM
 **/
public class LinkedListCycleII142 {
    public static void main(String[] args) {

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution142 {
    public ListNode detectCycle(ListNode head) {
        //先走到他们相遇的地方
        ListNode fast=head;
        ListNode slow=head;
        if (head==null||head.next==null){
            return null;
        }
        do {
            fast=fast.next.next;
            slow=slow.next;
        }while (fast!=null&&slow!=null&&fast.next!=null&&slow.next!=null&&fast!=slow);
        if (fast==null||slow==null||fast.next==null||slow.next==null){
            return null;
        }
        fast=head;
        while (fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }
}