package DP;

import java.util.*;

import org.w3c.dom.ranges.Range;

public class pract {
    // House Robber Problem
    private static int robs(int n, int nums[], int dp[]) {
        if (n <= 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int val1 = nums[n - 1] + robs(n - 2, nums, dp);
        int val2 = robs(n - 1, nums, dp);
        dp[n] = Math.max(val1, val2);
        return dp[n];
    }

    public static int rob(int nums[]) {
        int n = nums.length;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return robs(n, nums, dp);
    }

    // House Robber III
    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val, Node left, Node right) {
            val = this.val;
            left = this.left;
            right = this.right;
        }

    }

    private static int robIII(Node root, HashMap<Node, Integer> dp) {
        if (root == null) {
            return 0;
        }
        if (dp.containsKey(root) == true) {
            dp.get(root);
        }
        int notTake = robIII(root.left, dp) + robIII(root.right, dp);
        int take = root.val;
        if (root.left != null) {
            take += robIII(root.left.left, dp) + robIII(root.left.right, dp);
        }
        if (root.right != null) {
            take += robIII(root.right.right, dp) + robIII(root.right.left, dp);
        }
        int ans = Math.max(notTake, take);
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

    public static int robIIIUtil(Node root) {
        HashMap<Node, Integer> dp = new HashMap<>();
        return robIII(root, dp);
    }

    // 62. Unique Paths
    public static int utilUniquepaths(int row, int col, int dp[][], int m, int n) {
        if (row == m - 1 && col == n - 1)
            return 1;
        if (row < 0 || col < 0 || row >= m || col >= n)
            return 0;

        if (dp[row][col] != -1)
            return dp[row][col];
        int down = utilUniquepaths(row + 1, col, dp, m, n);
        int right = utilUniquepaths(row, col + 1, dp, m, n);
        int res = down + right;
        return dp[row][col] = res;
    }

    public static int Uniquepaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return utilUniquepaths(0, 0, dp, m, n);
    }

    // 63. Unique Paths II here both the tc and Sc is (M*N)
    private static int utiluniquePathsWithObstacles(int row, int col, int[][] dp, int m, int n, int[][] obstacleGrid) {
        if (row < 0 || row >= m || col < 0 || col >= n)
            return 0;
        if (obstacleGrid[row][col] == 1)
            return 0;

        if (row == m - 1 && col == n - 1)
            return 1;
        if (dp[row][col] != -1)
            return dp[row][col];

        int down = utiluniquePathsWithObstacles(row + 1, col, dp, m, n, obstacleGrid);
        int right = utiluniquePathsWithObstacles(row, col + 1, dp, m, n, obstacleGrid);
        int res = down + right;
        return dp[row][col] = res;
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return utiluniquePathsWithObstacles(0, 0, dp, m, n, obstacleGrid);
    }

    // Count Square Submatrices with All Ones
    public static int countSquare(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int count[][] = new int[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    count[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 1) {
                    count[i][j] = 1 + Math.min(count[i - 1][j],
                            Math.min(count[i - 1][j - 1], count[i][j - 1]));
                }
                ans += count[i][j];
            }
        }
        return ans;
    }

    // Longest Increasing Subsequence 1st approach
    public int LIS(int[] nums) {
        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int lis = 0;
        for (int i = 0; i < nums.length; i++) {
            lis = Math.max(lis, dp[i]);
        }

        return lis;

    }

    // LIS optimal approach
    public static int lowerbound(List<Integer> subset, int tar) {
        int ans = subset.size();
        int le = 0, ri = subset.size() - 1;
        while (le <= ri) {
            int mid = (le + ri) / 2;
            if (subset.get(mid) >= tar) {
                ans = mid;
                ri = mid - 1;
            } else {
                le = mid + 1;
            }
        }
        return ans;
    }

    public static int licopt(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int lb = lowerbound(subset, nums[i]);
            if (lb < subset.size())
                subset.set(lb, nums[i]);
            else
                subset.add(nums[i]);
        }
        return subset.size();
    }

    // 303 Range Sum Query - Immutable
    class NumArray {
        int pre[];

        public NumArray(int[] nums) {
            pre = nums;
            pre[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                pre[i] = pre[i - 1] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            if (left == 0)
                return pre[right];
            return pre[right] - pre[left - 1];
        }
    }

    // 307. Range Sum Query - Mutable
    // class Node {
    //     int start, end, sum;
    //     Node left, right;

    //     public Node(int start, int end) {
    //         this.start = start;
    //         this.end = end;
    //     }
    // }

    // class SegmentTree {
    //     Node root;

    //     SegmentTree(int[] nums) {
    //         root = build(nums, 0, nums.length - 1);
    //     }

    //     // O(N)
    //     Node build(int[] nums, int start, int end) {
    //         if (start > end)
    //             return null;
    //         Node root = new Node(start, end);
    //         if (start == end) {
    //             // left
    //             root.sum = nums[start];
    //             return root;
    //         }
    //         int mid = start + (end - start) / 2;
    //         root.left = build(nums, start, mid);
    //         root.right = build(nums, mid + 1, end);
    //         root.sum = root.left.sum + root.right.sum;
    //         return root;
    //     }

    //     // O(2*logn)
    //     int Query(Node root, int ql, int qr) {
    //         // no overlap
    //         if (root.end < ql || root.start > qr) {
    //             return 0;
    //         }
    //         if (root.start >= ql && root.end <= qr) {
    //             // comlpletly overlap
    //             return root.sum;
    //         }
    //         return Query(root.left, ql, qr) + Query(root.right, ql, qr);
    //     }

    //     // O(logn)
    //     int update(Node root, int idx, int val) {
    //         if (root == null)
    //             return 0;
    //         if (idx < root.start || idx > root.end) {
    //             return root.sum;// no overlap
    //         }
    //         if (root.start == root.end) {
    //             root.sum = val;
    //             return root.sum;
    //         }
    //         root.sum = update(root.left, idx, val) + update(root.right, idx, val);
    //         return root.sum;
    //     }
    // }

    // class NumArray {
    //     SegmentTree tree;

    //     public NumArray(int[] nums) {
    //         tree = new SegmentTree(nums);
    //     }

    //     public void update(int index, int val) {
    //         tree.update(tree.root, index, val);
    //     }

    //     public int sumRange(int left, int right) {
    //         return tree.Query(tree.root, left, right);
    //     }
    // }

    public static void main(String[] args) {
        // int nums[] = {1,2,3,1};
        // System.out.println(rob(nums));
        // int m = 3, n = 7;
        // System.out.println(Uniquepaths(m, n));
        // int obstacleGrid[][] = {{0,1},{0,0}};//{{0,0,0},{0,1,0},{0,0,0}};
        // System.out.println(uniquePathsWithObstacles(obstacleGrid));
        int matrix[][] = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } };
        System.out.println(countSquare(matrix));
    }
}
