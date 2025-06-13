class Solution {
    public int minimizeMax(int[] nums, int p) {
        if (p == 0) return 0;
        Arrays.sort(nums);
        int n = nums.length, left = 0, right = nums[n-1] - nums[0];
        while (left < right) {
            int mid = left + (right - left) / 2, pairs = 0;
            for (int i = 1; i < n; i++) {
                if (nums[i] - nums[i-1] <= mid) {
                    pairs++;
                    i++;
                }
            }
            if (pairs >= p) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
