
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        // Step 1: Create array of [value, index] pairs
        int[][] valueWithIndex = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            valueWithIndex[i] = new int[]{nums[i], i}; // Store value and its original index
        }
        
        // Step 2: Sort by value in descending order
        Arrays.sort(valueWithIndex, (a, b) -> b[0] - a[0]);
        // This compares values (a[0] and b[0]) and sorts bigger values first
        
        // Step 3: Take first k elements and sort them by original index
        Arrays.sort(valueWithIndex, 0, k, (a, b) -> a[1] - b[1]);
        // This sorts only the first k elements by their original indices (a[1])
        
        // Step 4: Extract the values in order
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = valueWithIndex[i][0]; // Take just the value part
        }
        
        return result;
    }
}
