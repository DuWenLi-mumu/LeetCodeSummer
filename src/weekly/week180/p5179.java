package weekly.week180;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by 杜文丽 on 3/15/2020 11:02 AM
 **/
public class p5179 {
    ArrayList<Integer> nodeList;
    int[] nodes;
    public TreeNode balanceBST(TreeNode root){
        //并没有在原来bst树当中直接进行旋转操作，而是取出所有的数，重新构建ALV树
        nodeList=new ArrayList<>();
        add(root);
        if (nodeList.size()<3){
            return root;
        }
        nodes=new int[nodeList.size()];
        for (int i = 0; i <nodeList.size() ; i++) {
            nodes[i]=nodeList.get(i);
        }
        return build(0,nodes.length-1);
    }
    public TreeNode build(int left,int right){
        if (left>right){
            return null;
        }
        int curr=(left+right)/2;
        TreeNode node=new TreeNode(nodes[curr]);
        node.left=build(left,curr-1);
        node.right=build(curr+1,right);
        return node;
    }
    public void add(TreeNode root){
        if (root==null){
            return;
        }
        add(root.left);
        nodeList.add(root.val);
        add(root.right);
    }
//    public TreeNode balanceBST(TreeNode root) {
//        if (root==null){
//            return null;
//        }
//        TreeNode left=root.left;
//        TreeNode right=root.right;
//        root.left=balanceBST(left);
//        root.right=balanceBST(right);
//        int leftHeight=findHeight(root.left);
//        int rightHeight=findHeight(root.right);
//        if (!isBalanced(root)){
//
//            if (leftHeight > rightHeight) {
//                root = RotateLeft(root);
//                return balanceBST(root);
//            }
//
//            if (leftHeight < rightHeight) {
//                root=RotateRight(root);
//                return balanceBST(root);
//            }
//        }
//        return root;
//    }
//    private TreeNode RotateLeft(TreeNode root) {
//        TreeNode rightTemp = root;
//        TreeNode leftTemp = root.left.right;
//        root = root.left;
//        rightTemp.left=leftTemp;
//        root.right=rightTemp;
//        return root;
//    }
//    private TreeNode RotateRight(TreeNode root) {
//        TreeNode leftTemp = root;
//        TreeNode rightTemp = root.right.left;
//        root = root.right;
//        leftTemp.right=rightTemp;
//        root.left=leftTemp;
//        return root;
//    }
//    public int findHeight(TreeNode root){
//        if( root == null ){
//            return -1;
//        }
//        int leftHeight = findHeight(root.left);
//        int rightHeight = findHeight(root.right);
//        if( leftHeight < rightHeight){
//            return 1 + rightHeight;
//        }else{
//            return 1 + leftHeight;
//        }
//    }
//    public boolean isBalanced(TreeNode root){
//        if (root==null){
//            return true;
//        }
//        int leftHeight = findHeight(root.left);
//        int rightHeight = findHeight(root.right);
//        if (Math.abs(leftHeight - rightHeight) <= 1&&isBalanced(root.left)&&isBalanced(root.right)) {
//            return true;
//        }else {
//            return false;
//        }
//    }

}
