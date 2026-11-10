class Solution {
    public int climbStairs(int n, int[] costs) {
        costs = IntStream.concat(IntStream.of(0), Arrays.stream(costs)).toArray();  // step 0 is free, step i costs costs[i]
        int[] dp = new int[n + 3];  // dp[i] = climb(i)
        Arrays.fill(dp, Integer.MAX_VALUE / 2);  // the two steps past the top stay inf
        dp[n] = costs[n];
        for (int i = n - 1; i >= 0; i--)  // from the top step down
            dp[i] = costs[i] + Math.min(dp[i + 1] + 1, Math.min(dp[i + 2] + 4, dp[i + 3] + 9));
        return dp[0];
    }
}
