class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int M = matrix.length;
        int N = matrix[0].length;

        int[][] mat = new int[M][N];

        // convert char to int
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                mat[i][j] = matrix[i][j] - '0';
            }
        }

        // row-wise prefix widths
        for (int i = 0; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] += mat[i][j - 1];
                }
            }
        }

        int Ans = 0;

        // fix each column
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < M; i++) {
                int width = mat[i][j];
                if (width == 0) continue;

                // expand downward
                int currWidth = width;
                for (int k = i; k < M && mat[k][j] > 0; k++) {
                    currWidth = Math.min(currWidth, mat[k][j]);
                    int height = k - i + 1;
                    Ans = Math.max(Ans, currWidth * height);
                }

                // expand upward
                currWidth = width;
                for (int k = i; k >= 0 && mat[k][j] > 0; k--) {
                    currWidth = Math.min(currWidth, mat[k][j]);
                    int height = i - k + 1;
                    Ans = Math.max(Ans, currWidth * height);
                }
            }
        }

        return Ans;
    }
}
