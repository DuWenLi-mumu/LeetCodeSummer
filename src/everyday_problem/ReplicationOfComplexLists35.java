package everyday_problem;

import util.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 杜文丽 on 1/30/2021 3:48 PM
 **/
public class ReplicationOfComplexLists35 {
    public Node copyRandomList(Node head) {
        Node curr = head;
        Map<Node,Node> map = new HashMap<>();
        while (curr != null){
            map.put(curr,new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        Node res = map.get(curr);
        while (curr != null){
            Node newNode = map.get(curr);
            newNode.next = map.get(curr.next);
            newNode.random = map.get(curr.random);
            curr = curr.next;
        }
        return res;
    }
}
