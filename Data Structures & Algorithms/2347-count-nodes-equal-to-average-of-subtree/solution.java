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
    int ans = 0;
    int[] helper(TreeNode root){
        if(root==null) return new int[]{0,0};
        int[] l = helper(root.left);
        int[] r = helper(root.right);
        int sum = root.val+l[0]+r[0];
        int c = 1+r[1]+l[1];
        if(root.val==sum/c) ans++;
        return new int[]{sum,c};
    }
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return ans;
    }
}
