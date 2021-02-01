package jzOffer;

/**
 * Created by 杜文丽 on 1/28/2021 10:17 PM
 *
 * BST树的特性 根节点左边的值小于root.val，根节点右边的值大于root.val
 **/
public class BackOrderTraversalSequenceOfBinarySearchTrees33 {
    public static boolean verifyPostorder(int[] postorder) {
        if (postorder.length <= 2){
            return true;
        }
        return verify(postorder,0,postorder.length - 1);
    }
    public static boolean verify(int[] postorder,int left,int right){
        if (left >= right){
            return true;
        }
        int root = postorder[right];
        int l = left;
        while (l < right && postorder[l] < root){
            l++;
        }
        for (int i = l; i < right ; i++) {
            if (postorder[i] < root){
                return false;
            }
        }
        if (!verify(postorder,left,l-1)){
            return false;
        }
        if (!verify(postorder,l,right-1)){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] post = {1,2,5,10,6,9,4,3};
        boolean res = verifyPostorder(post);
    }
}
