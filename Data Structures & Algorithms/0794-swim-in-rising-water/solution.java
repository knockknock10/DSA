class Solution {
    int dirs[][] = {{0,-1},{0,1},{-1,0},{1,0}};
    
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int ans = Integer.MAX_VALUE;
        int low = 0, high = n * n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            boolean vis[][] = new boolean[n][n];
            if (grid[0][0] <= mid && dfs(0, 0, mid, grid, vis)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    boolean dfs(int x, int y, int t, int[][] grid, boolean[][] vis) {
        int n = grid.length;
        vis[x][y] = true;
        if (x == n - 1 && y == n - 1) return true;

        for (int[] d : dirs) {
            int nx = x + d[0], ny = y + d[1];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n &&
                !vis[nx][ny] && grid[nx][ny] <= t) {
                if (dfs(nx, ny, t, grid, vis)) return true;
            }
        }
        return false;
    }
}
