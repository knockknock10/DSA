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
    private  List<List<Integer>> level(TreeNode root){
       
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<Integer> curle = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr==null){
                ans.add(curle);
                curle = new ArrayList<>();
                if(q.isEmpty()){
                    break;
                }else{
                    q.offer(null);
                }
            }else{
                curle.add(curr.val);
                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }
            }
        }
        return ans;

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        return level(root);
    }
}
