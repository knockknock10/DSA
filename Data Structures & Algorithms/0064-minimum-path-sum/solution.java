class Solution {
    int[][] dp;

    private int minp(int[][] grid, int n, int m, int row, int col) {
        
        if (row >= n || col >= m) return (int)1e9;

        if (row == n - 1 && col == m - 1) {
            return grid[row][col];
        }

        if (dp[row][col] != -1) return dp[row][col];

        int down = minp(grid, n, m, row + 1, col);
        int right = minp(grid, n, m, row, col + 1);

        return dp[row][col] = grid[row][col] + Math.min(down, right);
    }

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        dp = new int[n][m];
        for (int[] r : dp) {
            java.util.Arrays.fill(r, -1);
        }

        return minp(grid, n, m, 0, 0);
    }
}
