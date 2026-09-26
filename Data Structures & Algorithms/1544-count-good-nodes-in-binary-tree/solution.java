/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root,root.val);
    }
    private int dfs(TreeNode root,int max){
        int count = 0;
        if(root==null) return 0;
        if(root.val>=max) count=1;
        max = Math.max(max,root.val);
        count+=dfs(root.left,max);
        count+=dfs(root.right,max);
        return count;
    }
}
