package everyday_problem;

import java.util.List;
import java.util.Scanner;

public class SortLinkedLists148 {
    public static ListNode sortList(ListNode head) {
        return sort(head);
    }
    public static ListNode sort(ListNode node){
        ListNode head = new ListNode(-1);
        head.next = node;
        ListNode curr = node;//node已经在链表里面了，作为第一个元素是不需要排序的 需要排序的元素永远是curr.next
        node = node.next.next;
        while (curr.next != null){

            node = node.next;
            ListNode tmp = head;

            //如果要在第一个插入
            if (curr.next.val <= head.next.val){
                ListNode tmp_node = head.next;
                head.next = curr.next;
                ListNode tmp_node2 = curr.next.next;
                curr.next.next = tmp_node;
                tmp_node.next = tmp_node2;
                continue;
            }
            //在其他位置上插入
            while ((tmp.next != curr.next) && curr.next.val >= tmp.next.val){
                tmp = tmp.next;
            }
            if (tmp.next == curr.next){
                //直接放在最后面，不需要任何操作
            }else{
                //tmp.next.val >= curr.next.val 插入在tmp之后
                ListNode tmp_next = tmp.next;
                tmp.next = curr.next;
                curr.next = tmp_next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        //[4,2,1,3]
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        sort(n1);
    }
}
