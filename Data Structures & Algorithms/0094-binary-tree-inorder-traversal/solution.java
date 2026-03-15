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
    private List<Integer> list  = new ArrayList<>();
    private void inorderTraverse(TreeNode root) {
        if(root==null){
            return;
        }
        inorderTraverse(root.left);
        list.add(root.val);
        inorderTraverse(root.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        inorderTraverse(root);
        return list;
    }
}
