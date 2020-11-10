package jzOffer;

import util.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by 杜文丽 on 11/9/2020 3:08 PM
 **/
public class PrintTheListFromTheEnd6 {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        Collections.reverse(list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
