class Solution {

    public long minimumCost(int[] nums, int k, int dist) {

        int n = nums.length;
        long result = Long.MAX_VALUE;
        long windowSum = 0L;

        java.util.TreeSet<Integer> using = new java.util.TreeSet<>(
                (a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]
        );

        java.util.TreeSet<Integer> waiting = new java.util.TreeSet<>(
                (a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]
        );

        for (int i = 1; i <= dist + 1; i++) {
            using.add(i);
            windowSum += nums[i];
        }

        while (using.size() > k - 1) {
            int idx = using.pollLast();
            windowSum -= nums[idx];
            waiting.add(idx);
        }

        result = Math.min(result, windowSum);

        for (int i = 1; i + dist + 1 < n; i++) {

            waiting.add(i + dist + 1);

            if (using.contains(i)) {
                using.remove(i);
                windowSum -= nums[i];

                int idx = waiting.pollFirst();
                using.add(idx);
                windowSum += nums[idx];

            } else {
                waiting.remove(i);

                int wMin = waiting.first();
                int uMax = using.last();

                if (nums[wMin] < nums[uMax]) {
                    using.remove(uMax);
                    waiting.add(uMax);
                    windowSum -= nums[uMax];

                    waiting.remove(wMin);
                    using.add(wMin);
                    windowSum += nums[wMin];
                }
            }

            result = Math.min(result, windowSum);
        }

        return result + nums[0];
    }
}
