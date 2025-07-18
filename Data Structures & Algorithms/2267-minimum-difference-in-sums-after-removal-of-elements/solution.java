class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length, k = n / 3;
        long[] leftMins = new long[n];   // Sum of k smallest from left
        long[] rightMaxs = new long[n];  // Sum of k largest from right
        long leftSum = 0, rightSum = 0, minDiff = Long.MAX_VALUE;

        // Max-heap for smallest k from left
        PriorityQueue<Integer> maxLeftHeap = new PriorityQueue<>((a, b) -> b - a);

        // Min-heap for largest k from right
        PriorityQueue<Integer> minRightHeap = new PriorityQueue<>();

        // Compute leftMins
        for (int i = 0; i < k; i++) {
            maxLeftHeap.offer(nums[i]);
            leftSum += nums[i];
        }
        leftMins[k - 1] = leftSum;

        for (int i = k; i < n - k; i++) {
            int x = nums[i];
            if (x < maxLeftHeap.peek()) {
                leftSum += x - maxLeftHeap.poll();
                maxLeftHeap.offer(x);
            }
            leftMins[i] = leftSum;
        }

        // Compute rightMaxs
        for (int i = n - 1; i >= n - k; i--) {
            minRightHeap.offer(nums[i]);
            rightSum += nums[i];
        }
        rightMaxs[n - k] = rightSum;

        for (int i = n - k - 1; i >= k - 1; i--) {
            int x = nums[i];
            if (x > minRightHeap.peek()) {
                rightSum += x - minRightHeap.poll();
                minRightHeap.offer(x);
            }
            rightMaxs[i] = rightSum;
        }

        // Find minimum difference
        for (int i = k - 1; i < n - k; i++) {
            minDiff = Math.min(minDiff, leftMins[i] - rightMaxs[i + 1]);
        }

        return minDiff;
    }
}

