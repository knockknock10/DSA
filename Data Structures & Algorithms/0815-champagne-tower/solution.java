class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] dp = new double[query_row + 2];
        dp[0] = poured;

        for (int row = 0; row < query_row; row++) {
            double[] next_row = new double[query_row + 2];
            
            for (int glass = 0; glass <= row; glass++) {
                double amount = dp[glass];
                
                if (amount > 1.0) {
                    double excess = (amount - 1.0) / 2.0;
                    next_row[glass] += excess;
                    next_row[glass + 1] += excess;
                }
            }
            
            dp = next_row;
        }

        return Math.min(dp[query_glass], 1.0);
    }
}

