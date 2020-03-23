package everyday_problem;

/**
 * Created by 杜文丽 on 3/23/2020 2:24 PM
 **/
public class MiddleOfTheLinkedList876 {
    public ListNode middleNode(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode p=head;
        int c=0;
        while (p!=null){
            c++;
            p=p.next;
        }
        if (c%2==0){
            c/=2;
        }else {
            c=c/2+1;
        }
        for (int i = 0; i <c ; i++) {
            head=head.next;
        }
        return head;
    }
}
