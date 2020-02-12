package heap;

/**
 * Created by 杜文丽 on 2/11/2020 8:06 PM
 **/
public class MergeKSortedLists23 {
    public static void main(String[] args) {
        boolean able=false;
        int res=3;
        while (!able){
            if (res%2==1&&res%3==0&&res%4==1&&res%5==4&&res%6==3&&res%7==0&&res%8==1&&res%9==0){
                able=true;
                System.out.println(res);
            }
            res++;
        }
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length<=0){
            return null;
        }else if (lists.length<=1){
            return lists[0];
        }
        ListNode head=lists[0];
        for (int i = 1; i <lists.length ; i++) {
            head=merge(head,lists[i]);
        }
        return head;
    }
    public static ListNode merge(ListNode l1,ListNode l2){
        //大于等于为大
        if (l1==null){
            return l2;
        }else if (l2==null){
            return l1;
        }
        ListNode head=l1.val>=l2.val?l2:l1;
        ListNode pre=null;
        while (l1!=null&&l2!=null){
            if (l1.val>=l2.val){
                if (pre==null){
                    pre=head;
                }else {
                    //l2指着l1
                    pre.next=l2;
                    pre=l2;
                }
                ListNode tmp=l2.next;
                l2.next=l1;
                l2=tmp;
            }else {
                if (pre==null){
                    pre=head;
                }else {
                    pre.next=l1;
                    pre=l1;
                }
                ListNode tmp=l1.next;
                l1.next=l2;
                l1=tmp;
            }
        }
        return head;
    }
}
