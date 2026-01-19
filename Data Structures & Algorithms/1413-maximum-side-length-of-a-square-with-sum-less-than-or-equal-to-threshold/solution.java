class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        int maxSide = Math.min(m,n);

        int[][] pref = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pref[i][j] =
                    mat[i-1][j-1]
                  + pref[i-1][j]
                  + pref[i][j-1]
                  - pref[i-1][j-1];
            }
        }

        while (maxSide > 0) {
            for (int i = 0; i + maxSide <= m; i++) {
                for (int j = 0; j + maxSide <= n; j++) {
                    if (helper(pref, threshold, i, j, maxSide))
                        return maxSide;
                }
            }
            maxSide--;
        }

        return 0;
    }

    private boolean helper(int[][] pref, int t, int x, int y, int side) {
        int x2 = x + side;
        int y2 = y + side;

        int sum =
            pref[x2][y2]
        - pref[x][y2]
        - pref[x2][y]
        + pref[x][y];

        return sum <= t;
    }

}
