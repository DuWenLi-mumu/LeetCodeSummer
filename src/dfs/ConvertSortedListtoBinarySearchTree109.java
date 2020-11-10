package dfs;

import util.ListNode;
import util.TreeNode;

import java.util.ArrayList;

/**
 * Created by 杜文丽 on 8/14/2019 3:11 PM
 **/
public class ConvertSortedListtoBinarySearchTree109 {
    public TreeNode sub(ArrayList<Integer> arr, int begin, int end){
        if (begin>end){
            return null;
        }else if (begin==end){
            return new TreeNode(arr.get(begin));
        }
        int mid=(begin+end+1)/2;
        TreeNode root=new TreeNode(arr.get(mid));
        root.left=sub(arr,begin,mid-1);
        root.right=sub(arr,mid+1,end);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        while (head!=null){
            arrayList.add(head.val);
            head=head.next;
        }
        return sub(arrayList,0,arrayList.size()-1);
    }
}
