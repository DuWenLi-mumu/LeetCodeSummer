package data_structure;

class Node<T extends Comparable> {
    Node left;
    Node right;
    T val;
    public Node(T val){
        this.val = val;
    }
}

public class BST {
    private Node root = null;

    public BST() {
    }
    public Node getRoot(){
        return root;
    }
    public void add(Node node) {
        if (root == null) {
            this.root = node;
            return;
        } else {
            Node curr = root;
            Node pre = curr;
            while (curr != null) {
                pre = curr;
                if (curr.val.compareTo(node.val) > 0) {
                    curr = curr.left;
                } else {
                    curr = curr.right;
                }
            }
            if (pre.val.compareTo(node.val) > 0) {
                pre.left = node;
            } else {
                pre.right = node;
            }
        }

    }

    public boolean contains(Node node) {
        Node curr = root;
        while (curr != null) {
            if (curr.val == node.val) {
                return true;
            } else if (curr.val.compareTo(node.val) > 0) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return false;
    }

    public boolean delete(Node node) {
        boolean removeSucess = false;
        //首先找到这个节点
        if (!contains(node)) {
            return removeSucess;
        }
        Node curr = root;
        Node pre = root;
        while (curr != null && curr.val != node.val) {
            pre = curr;
            if (curr.val == node.val) {
                removeSucess = true;
                break;
            } else if (curr.val.compareTo(node.val) > 0) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        //要删除的结点为curr
        Node currRight = curr.right;
        if (currRight == null) {

            if (pre.val.compareTo(curr.val) > 0) {
                pre.left = curr.left;
            } else {
                pre.right = curr.left;
            }
        } else {
            if (pre.val.compareTo(curr.val) > 0) {
                pre.left = curr.right;
            } else {
                pre.right = curr.right;
            }
            while (currRight.left != null){
                currRight = currRight.left;
            }
            currRight.left = curr.left;
        }
        return removeSucess;
    }

    public static void main(String[] args) {
        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n4 = new Node<>(4);
        Node<Integer> n5 = new Node<>(5);
        Node<Integer> n6 = new Node<>(6);
        BST test = new BST();
        test.add(n5);
        test.add(n3);
        test.add(n4);
        test.add(n6);
        test.add(n1);
        test.add(n2);
        Node root = test.getRoot();
        test.delete(n3);
        root = test.getRoot();
    }

}
