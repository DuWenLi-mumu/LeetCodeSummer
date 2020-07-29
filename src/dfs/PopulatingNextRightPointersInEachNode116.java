package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杜文丽 on 7/29/2020 9:32 PM
 **/
public class PopulatingNextRightPointersInEachNode116 {
    public Node connect(Node root) {
        if (root==null){
            return root;
        }
        List<Node> list=new ArrayList<>();
        list.add(root);
        bfs(list);
        return root;
    }
    public void bfs(List<Node> list){
        if (list.size()==0){
            return;
        }
        List<Node> newList=new ArrayList<>();
        for (Node node:list
             ) {
            if (node.left!=null){
                newList.add(node.left);
            }
            if (node.right!=null){
                newList.add(node.right);
            }
        }
        for (int i = 1; i <list.size() ; i++) {
            list.get(i-1).next=list.get(i);
        }
        list.get(list.size()-1).next=null;
        bfs(newList);
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};