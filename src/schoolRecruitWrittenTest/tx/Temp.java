package schoolRecruitWrittenTest.tx;


public class Temp {
    public static void main(String[] args) {

    }
}

//class TreeConvert {
//
//    TreeNode tail = null;
//    TreeNode head = null;
//
//    //head 保存链表的头节点，tail 保存当前节点的前一个节点。
//    public TreeNode Convert(TreeNode pRootOfTree) {
//        if (pRootOfTree == null) {
//            return null;
//        }
//        Convert(pRootOfTree.left);
//        if (head == null) {
//            head = pRootOfTree;
//            tail = pRootOfTree;
//
//        } else {
//            pRootOfTree.left = tail;
//            tail.right = pRootOfTree;
//            tail = pRootOfTree;
//        }
//        Convert(pRootOfTree.right);
//        return head;
//    }
//}