class Solution {
    public int maximumDifference(int[] nums) {
        int maxVal = nums[nums.length - 1], maxDiff = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < maxVal)
                maxDiff = Math.max(maxDiff, maxVal - nums[i]);
            maxVal = Math.max(maxVal, nums[i]);
        }
        return maxDiff;
    }
}
