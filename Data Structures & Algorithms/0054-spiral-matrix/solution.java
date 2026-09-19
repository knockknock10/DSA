class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> an = new ArrayList<>();
        int strow = 0;
        int stcol = 0;
        int endrow = matrix.length - 1;
        int endcol = matrix[0].length - 1;

        while (strow <= endrow && stcol <= endcol) {
            for (int k = stcol; k <= endcol; k++) {
                an.add(matrix[strow][k]);
            }
            strow++;

            for (int i = strow; i <= endrow; i++) {
                an.add(matrix[i][endcol]);
            }
            endcol--;

            if (strow <= endrow) {
                for (int i = endcol; i >= stcol; i--) {
                    an.add(matrix[endrow][i]);
                }
                endrow--;
            }

            if (stcol <= endcol) {
                for (int j = endrow; j >= strow; j--) {
                    an.add(matrix[j][stcol]);
                }
                stcol++;
            }
        }

        return an;
    }
}
