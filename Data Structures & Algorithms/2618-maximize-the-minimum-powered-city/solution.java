class Solution {
    public long maxPower(int[] stations, int r, long k) {
        int n = stations.length;
        long[] power = new long[n];
        long window = 0;
        int windowSize = 2 * r + 1;
        for (int j = 0; j <= Math.min(n - 1, r); j++) window += stations[j];
        for (int i = 0; i < n; i++) {
            power[i] = window;
            int removeIdx = i - r;
            if (removeIdx >= 0) window -= stations[removeIdx];
            int addIdx = i + r + 1;
            if (addIdx < n) window += stations[addIdx];
        }
        long low = 0;
        long high = Arrays.stream(power).max().orElse(0L) + k;
        long best = 0;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (canReach(power, r, k, mid)) {
                best = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return best;
    }
    private boolean canReach(long[] power, int r, long k, long target) {
        int n = power.length;
        long used = 0L;
        long[] diff = new long[n + 1];
        long curAdd = 0L;

        for (int i = 0; i < n; i++) {
            curAdd += diff[i];
            long total = power[i] + curAdd;
            if (total < target) {
                long need = target - total;
                used += need;
                if (used > k) return false;
                curAdd += need;
                int end = Math.min(n, i + 2 * r + 1);
                diff[end] -= need;
            }
        }
        return true;
    }
}
