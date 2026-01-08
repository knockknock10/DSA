class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE / 2);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int product = nums1[i - 1] * nums2[j - 1];
                
                int max = product;
                int candidate = product + dp[i - 1][j - 1];
                if (candidate > max) max = candidate;
                if (dp[i - 1][j] > max) max = dp[i - 1][j];
                if (dp[i][j - 1] > max) max = dp[i][j - 1];
                dp[i][j] = max;
            }
        }
        
        return dp[n][m];
    }
}
