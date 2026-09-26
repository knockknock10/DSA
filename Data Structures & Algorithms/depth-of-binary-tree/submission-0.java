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
    private int dep(TreeNode root,int c){
        if(root==null) return 0;
        int left = dep(root.left,c);
        int right = dep(root.right,c);
        return Math.max(left,right)+1;
    }
    public int maxDepth(TreeNode root) {
        int count = 0;
        return dep(root,count);
    }
}
