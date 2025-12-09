class Solution {
    public int specialTriplets(int[] nums) {
        final int MOD = 1_000_000_007;
        Map<Integer, Long> left = new HashMap<>();
        Map<Integer, Long> right = new HashMap<>();
        for (int x : nums) right.put(x, right.getOrDefault(x, 0L) + 1);
        long ans = 0;
        for (int x : nums) {
            right.put(x, right.get(x) - 1);
            int need = x * 2;
            long lc = left.getOrDefault(need, 0L);
            long rc = right.getOrDefault(need, 0L);
            ans = (ans + lc * rc) % MOD;
            left.put(x, left.getOrDefault(x, 0L) + 1);
        }
        return (int) ans;
    }
}
