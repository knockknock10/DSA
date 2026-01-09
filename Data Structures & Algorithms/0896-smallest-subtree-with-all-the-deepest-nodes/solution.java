class Solution {

    TreeNode res = null ;

    int maxDepth = 0 ;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {

        recur(root, 1) ;

        return res ;
    }

    int recur(TreeNode root, int currDepth)
    {
        if(root == null) return 0 ;

        int leftDepth = recur(root.left, currDepth + 1) ;
        int rightDepth = recur(root.right, currDepth + 1) ;

        int max = Math.max(leftDepth, rightDepth) ;

        if(leftDepth == rightDepth && max + currDepth >= maxDepth)
        {
            res = root ;
        }

        maxDepth = Math.max(maxDepth, max + currDepth) ;

        return 1 + max ;
    }
}
