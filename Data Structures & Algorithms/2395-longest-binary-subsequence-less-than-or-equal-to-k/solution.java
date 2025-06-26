public class Solution {
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int zeros = 0;
        int ones = 0;
        long value = 0;
        long pow = 1;

        // Count all zeros
        for (char c : s.toCharArray()) {
            if (c == '0') zeros++;
        }

        // Process from right to left
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                if (value + pow > k) {
                    continue; // Skip this '1' as it would exceed k
                }
                value += pow;
                ones++;
            }
            pow <<= 1;
            // Prevent pow from overflowing; if pow is beyond k, no more '1's can be added
            if (pow > k) {
                // Once pow exceeds k, further bits can't be added as their value is too large
                break;
            }
        }
        return zeros + ones;
    }
}
