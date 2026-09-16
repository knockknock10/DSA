class Solution {
    public int numberOfSets(int n, int k) {
        final int MOD = 1_000_000_007;
        long[][] dp = new long[n][k + 1];
        for (int i = 0; i < n; i++) dp[i][0] = 1;

        for (int j = 1; j <= k; j++) {
            long sum = 0;
            for (int i = 1; i < n; i++) {
                sum = (sum + dp[i - 1][j - 1]) % MOD;
                dp[i][j] = (dp[i - 1][j] + sum) % MOD;
            }
        }

        return (int) dp[n - 1][k];
    }
}
