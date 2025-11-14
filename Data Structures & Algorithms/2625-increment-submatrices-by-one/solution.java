class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int[n + 1][n + 1];
        
        for (int[] q : queries) {
            int r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3];
            diff[r1][c1]++;
            diff[r2 + 1][c1]--;
            diff[r1][c2 + 1]--;
            diff[r2 + 1][c2 + 1]++;
        }
        
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int above = i > 0 ? mat[i - 1][j] : 0;
                int left = j > 0 ? mat[i][j - 1] : 0;
                int diag = i > 0 && j > 0 ? mat[i - 1][j - 1] : 0;
                mat[i][j] = diff[i][j] + above + left - diag;
            }
        }
        
        return mat;
    }
}

