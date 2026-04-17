package DP;
import java.util.*;

public class pract {
    //House Robber Problem
    private static int robs(int n,int nums[],int dp[]){
        if(n<=0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int val1 = nums[n-1]+robs(n-2, nums, dp);
        int val2 = robs(n-1, nums, dp);
        dp[n] = Math.max(val1,val2);
        return dp[n];
    }
    public static int rob(int nums[]){
        int n = nums.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return robs(n,nums,dp);
    }
    //House Robber III
    static class Node {
        int val;
        Node left;
        Node right;
        public Node(int val,Node left,Node right){
            val = this.val;
            left = this.left;
            right = this.right;
        }
        
    }
    private static int robIII(Node root,HashMap<Node,Integer> dp){
        if(root == null){
            return 0;
        }
        if(dp.containsKey(root) == true){
            dp.get(root);
        }
        int notTake = robIII(root.left, dp)+ robIII(root.right, dp);
        int take = root.val;
        if(root.left!=null){
            take+= robIII(root.left.left, dp)+robIII(root.left.right, dp);
        }
        if(root.right!=null){
            take+=robIII(root.right.right, dp)+robIII(root.right.left, dp);
        }
        int ans = Math.max(notTake,take);
        dp.put(root, ans);
        return ans;
    }
    
    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (buyPrice > prices[i]) {
                buyPrice = prices[i];
            }

            profit = Math.max(profit, prices[i] - buyPrice);
        }

        return profit;        
    }

    public static int robIIIUtil(Node root){
        HashMap<Node,Integer> dp = new HashMap<>();
        return robIII(root, dp);
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3,1};
        System.out.println(rob(nums));
    }
}
