package recursion;
class LongestUnivaluePath687{
    int res=0;
    public int longestUnivaluePath(TreeNode root) {
        if (root==null){
            return 0;
        }
        dfs(root,root.val);
        return res;
    }
    public int dfs(TreeNode node,int parent){
        if (node==null){
            return 0;
        }
        int left=0;
        int right=0;
        if (node.left!=null){
            left=dfs(node.left,node.val);
        }
        if (node.right!=null){
            right=dfs(node.right,node.val);
        }
        res=Math.max(res,right+left);
        if (parent==node.val){
            return Math.max(left,right)+1;
        }
        return 0;

    }
}