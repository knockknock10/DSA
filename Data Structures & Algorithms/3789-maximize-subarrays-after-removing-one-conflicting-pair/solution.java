class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        for (int[] pair : conflictingPairs) {
            if (pair[1] < pair[0]) {
                int temp = pair[0];
                pair[0] = pair[1];
                pair[1] = temp;
            }
        }

        Arrays.sort(conflictingPairs, Comparator.comparingInt(a -> a[1]));

        int m = conflictingPairs.length;
        int max1 = 0;
        int max2 = 0;
        long gain = 0;
        long maxGain = 0;
        long totalOccupied = 0;

        for (int i = 0; i < m; i++) {
            int start = conflictingPairs[i][0];
            int base = n + 1 - conflictingPairs[i][1];
            if (i < m - 1) {
                base = conflictingPairs[i + 1][1] - conflictingPairs[i][1];
            }

            if (start > max1) {
                max2 = max1;
                max1 = start;
                gain = 0;
            } else if (start > max2) {
                max2 = start;
            }

            gain += (long)(max1 - max2) * base;
            totalOccupied += (long)max1 * base;

            if (gain > maxGain) {
                maxGain = gain;
            }
        }

        long total = (long) n * (n + 1) / 2;
        return total - totalOccupied + maxGain;
    }
}
