class Solution {
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        
        // Sort events by start day
        Arrays.sort(events, Comparator.comparingInt(e -> e[0]));

        // Precompute start times and next non-overlapping index
        int[] starts = new int[n];
        int[] nextIdx = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = events[i][0];
        }

        for (int i = 0; i < n; i++) {
            int nextStartDay = events[i][1] + 1;
            int idx = Arrays.binarySearch(starts, nextStartDay);
            nextIdx[i] = idx < 0 ? -idx - 1 : upperBound(starts, events[i][1]);
        }

        // Initialize DP arrays
        long[] prev = new long[n + 1];
        long[] curr;

        // Base case: max value attending one event
        for (int i = n - 1; i >= 0; i--) {
            prev[i] = Math.max(prev[i + 1], events[i][2]);
        }

        long result = prev[0];

        // Fill DP for 2 to k events
        for (int round = 2; round <= k; round++) {
            curr = new long[n + 1];
            for (int i = n - 1; i >= 0; i--) {
                long take = events[i][2] + prev[nextIdx[i]];
                curr[i] = Math.max(curr[i + 1], take);
            }
            result = Math.max(result, curr[0]);
            prev = curr;
        }

        return (int) result;
    }

    // Custom upper bound function
    private int upperBound(int[] arr, int key) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] <= key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}

