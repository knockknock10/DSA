class Solution {
    private int[][] grid;
    private int m, n;

    private boolean closed(int i, int j) {  // flood the island through (i, j); true if it never reaches the border
        if (i < 0 || i >= m || j < 0 || j >= n) return false;  // stepped off the grid: the island touches the border
        if (grid[i][j] == 1) return true;  // water, or land we already flooded
        grid[i][j] = 1;  // visited: turn it into water
        return closed(i + 1, j) & closed(i - 1, j) & closed(i, j + 1) & closed(i, j - 1);  // & (not &&) floods all 4 sides
    }

    public int closedIsland(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 0 && closed(i, j)) count++;
        return count;
    }
}
