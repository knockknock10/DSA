class Solution {
    public int minDeletionSize(String[] s) {
        int n = s.length, m = s[0].length();
        int count = 0;

        for (int row_concrete = 0; row_concrete < m; row_concrete++) {
            for (int row = 1; row < n; row++) {
                if (s[row].charAt(row_concrete) < s[row - 1].charAt(row_concrete)) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}
