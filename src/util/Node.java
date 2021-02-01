package util;


import java.util.List;

/**
 * Created by 杜文丽 on 3/29/2020 4:36 PM
 * int val;
 *     Node next;
 *     Node random;
 *
 *     public Node(int val) {
 *         this.val = val;
 *         this.next = null;
 *         this.random = null;
 *     }
 **/
public class Node {
    public int val;
    public List<Node> children;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val) {
        val = _val;
        this.next = null;
        this.random = null;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
        this.next = null;
        this.random = null;
    }
};
