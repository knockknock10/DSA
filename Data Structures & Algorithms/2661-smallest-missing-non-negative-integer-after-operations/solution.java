class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] freq = new int[value];
        
        for (int num : nums) {
            int r = num % value;
            freq[r < 0 ? r + value : r]++;
        }
        
        for (int k = 0; ; k++) {
            int r = k % value;
            if (freq[r]-- == 0) {
                return k;
            }
        }
    }
}
