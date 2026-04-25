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
    //62. Unique Paths
    public static int utilUniquepaths(int row,int col,int dp[][],int m,int n){
        if(row==m-1 && col == n-1) return 1;
        if(row<0 || col<0 || row>=m || col>=n) return 0;
        
        if(dp[row][col]!=-1) return dp[row][col];
        int down = utilUniquepaths(row+1, col, dp, m, n);
        int right = utilUniquepaths(row, col+1, dp, m, n);
        int res = down+right;
        return dp[row][col] = res;        
    }
    public static int Uniquepaths(int m,int n){
        int[][] dp = new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        return utilUniquepaths(0, 0, dp, m, n);
    }
    //63. Unique Paths II  here both the tc and Sc is (M*N)
    private static int utiluniquePathsWithObstacles(int row,int col,int[][] dp,int m,int n,int[][] obstacleGrid){
        if(row<0 || row>=m || col<0 || col>=n) return 0;
        if(obstacleGrid[row][col] == 1) return 0;
        
        if(row==m-1 && col==n-1) return 1;
        if(dp[row][col]!=-1) return dp[row][col];
        
        int down = utiluniquePathsWithObstacles(row+1,col,dp,m,n,obstacleGrid);
        int right = utiluniquePathsWithObstacles(row,col+1,dp,m,n,obstacleGrid);
        int res = down + right;
        return dp[row][col] = res;
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] dp = new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        return utiluniquePathsWithObstacles(0,0,dp,m,n,obstacleGrid);
    }
    // Count Square Submatrices with All Ones
    public static int countSquare(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        
        int count[][] = new int[n][m];
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0){
                    count[i][j] = matrix[i][j];
                }else if(matrix[i][j]==1){
                    count[i][j] = 1+Math.min(count[i-1][j],
                            Math.min(count[i-1][j-1], count[i][j-1])
                    );
                }
                ans+= count[i][j];
            }
        }
        return ans;
    } 
    //Longest Increasing Subsequence 1st approach
    public int LIS(int[] nums){
        int[] dp = new int[nums.length];
        
        for(int i=0;i<nums.length;i++){
            dp[i] = 1;
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int lis = 0;
        for(int i=0;i<nums.length;i++){
            lis = Math.max(lis,dp[i]);
        }
        
        return lis;
        
    }
    public static void main(String[] args) {
        // int nums[] = {1,2,3,1};
        // System.out.println(rob(nums));
        // int m = 3, n = 7;
        // System.out.println(Uniquepaths(m, n));
        // int obstacleGrid[][] = {{0,1},{0,0}};//{{0,0,0},{0,1,0},{0,0,0}};
        // System.out.println(uniquePathsWithObstacles(obstacleGrid));  
        int matrix[][] ={{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        System.out.println(countSquare(matrix));      
    }
}
