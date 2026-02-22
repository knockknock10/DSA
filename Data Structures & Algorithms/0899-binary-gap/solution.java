class Solution {
    public int binaryGap(int n) {
        n >>= Integer.numberOfTrailingZeros(n);
        if (n == 1) return 0;

        int maxGap = 0, gap = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                maxGap = Math.max(maxGap, gap);
                gap = 0;
            } else
                gap++;
            n >>= 1;
        }

        return maxGap + 1;
    }
}
