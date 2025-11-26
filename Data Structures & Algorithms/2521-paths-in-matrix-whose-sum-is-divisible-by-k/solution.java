class Solution {
    private static final int MOD = 1_000_000_007;

    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] prev = new int[n][k];
        int[][] cur  = new int[n][k];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(cur[j], 0);
            }

            for (int j = 0; j < n; j++) {
                int val = grid[i][j] % k;

                if (i == 0 && j == 0) {
                    cur[0][val] = 1;
                    continue;
                }

                if (i > 0) {
                    for (int r = 0; r < k; r++) {
                        if (prev[j][r] == 0) continue;
                        int nr = (r + val) % k;
                        cur[j][nr] = (cur[j][nr] + prev[j][r]) % MOD;
                    }
                }

                if (j > 0) {
                    for (int r = 0; r < k; r++) {
                        if (cur[j - 1][r] == 0) continue;
                        int nr = (r + val) % k;
                        cur[j][nr] = (cur[j][nr] + cur[j - 1][r]) % MOD;
                    }
                }
            }

            int[][] tmp = prev;
            prev = cur;
            cur = tmp;
        }

        return prev[n - 1][0];
    }
}
