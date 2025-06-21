class Solution {
    public int minimumDeletions(String word, int k) {
        // 1. Count character frequencies
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        // 2. Extract non-zero freqs into updated[], track size
        int[] updated = new int[26];
        int size = 0;
        for (int f : freq) {
            if (f > 0) updated[size++] = f;
        }

        // 3. Sort only the used portion
        Arrays.sort(updated, 0, size);

        int min = Integer.MAX_VALUE;          // best answer so far
        int totalSum = word.length();         // sum of all frequencies
        int deletedLeftSum = 0;               // sum of freqs fully deleted on left
        int sumInWindow = 0;                  // sum of freqs inside [i..j)
        int j = 0;                            // right pointer for window

        // 4. Slide the window start i across all frequencies
        for (int i = 0; i < size; i++) {
            int from = updated[i];
            int to = from + k;

            // Expand right pointer while freq ≤ to
            while (j < size && updated[j] <= to) {
                sumInWindow += updated[j++];
            }

            // Elements to the right of window: [j..size-1]
            int countRight = size - j;
            int sumRight = totalSum - sumInWindow;
            // If we want them all to be at most `to`, we must delete:
            // sumRight - (countRight * to)
            int deletionsRight = sumRight - countRight * to;

            // Total deletions = left deletions + right deletions
            int totalDel = deletedLeftSum + deletionsRight;
            min = Math.min(min, totalDel);

            // Move window start forward by “deleting” updated[i] from window/total
            totalSum -= updated[i];
            deletedLeftSum += updated[i];
            sumInWindow -= updated[i];
        }

        return min;
    }
}
