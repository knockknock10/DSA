class Solution {
    private static int MOD = 1_000_000_007;

    public int possibleStringCount(String word, int k) {
        if (word.isEmpty()) return 0;

        List<Integer> groups = new ArrayList<>();

        // Count consecutive character groups
        int count = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) count++;
            else {
                groups.add(count);
                count = 1;
            }
        }
        groups.add(count); // Add the last group

        // Total combinations = product of each group count
        long total = 1;
        for (int num : groups) {
            total = (total * num) % MOD;
        }

        // If all strings must be at least of length k or smaller, return early
        if (k <= groups.size()) return (int) total;

        // DP to count number of combinations with length < k
        int[] dp = new int[k];
        dp[0] = 1;

        for (int num : groups) {
            int[] newDp = new int[k];
            long sum = 0;
            for (int s = 0; s < k; s++) {
                if (s > 0) sum = (sum + dp[s - 1]) % MOD;
                if (s > num) sum = (sum - dp[s - num - 1] + MOD) % MOD;
                newDp[s] = (int) sum;
            }
            dp = newDp;
        }

        // Subtract invalid combinations (length < k)
        long invalid = 0;
        for (int s = groups.size(); s < k; s++) {
            invalid = (invalid + dp[s]) % MOD;
        }

        return (int) ((total - invalid + MOD) % MOD);
    }
}
