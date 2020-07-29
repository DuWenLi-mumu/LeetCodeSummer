package util;


import java.util.List;

/**
 * Created by 杜文丽 on 3/29/2020 4:36 PM
 **/
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
