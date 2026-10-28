class Solution {
    static final int LIM = 1 << 10;
    public int minCost(int[][] A) {
        int m = A.length, n = A[0].length;
        Set<Integer>[] dp = new HashSet[n];
        
        dp[0] = new HashSet<>();
        dp[0].add(A[0][0]);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                Set<Integer> prev = new HashSet<>();
                if (i > 0) prev.addAll(dp[j]);
                if (j > 0) prev.addAll(dp[j - 1]);

                Set<Integer> curr = new HashSet<>();
                for (int k : prev)
                    curr.add(k ^ A[i][j]);

                dp[j] = curr;
            }
        }

        for (int k = 0; k < LIM; k++)
            if (dp[n - 1].contains(k)) return k;

        return 0;
    }
}
