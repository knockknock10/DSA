class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int[] d = new int[100001];
        long k = (long) k1 + k2, sum = 0;
        int max = 0;

        // Step 1: count the differences
        for (int i = 0; i < nums1.length; i++) {
            int x = Math.abs(nums1[i] - nums2[i]);
            d[x]++;
            sum += x;
            max = Math.max(max, x);
        }

        // Enough budget -> every difference becomes 0
        if (sum <= k) return 0;

        // Step 2: shave the biggest differences, level by level
        for (int i = max; i > 0 && k > 0; i--) {
            long move = Math.min(k, d[i]);
            d[i] -= move;
            d[i - 1] += move;
            k -= move;
        }

        // Step 3: add up the squares
        long ans = 0;
        for (int i = 0; i <= max; i++)
            ans += (long) i * i * d[i];

        return ans;
    }
}
