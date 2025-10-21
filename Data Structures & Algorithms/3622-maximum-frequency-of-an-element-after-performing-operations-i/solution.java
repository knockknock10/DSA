class Solution {

    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);

        int ans = 0;
        Map<Integer, Integer> numCount = new HashMap<>();

        int lastNumIndex = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != nums[lastNumIndex]) {
                numCount.put(nums[lastNumIndex], i - lastNumIndex);
                ans = Math.max(ans, i - lastNumIndex);
                lastNumIndex = i;
            }
        }

        numCount.put(nums[lastNumIndex], nums.length - lastNumIndex);
        ans = Math.max(ans, nums.length - lastNumIndex);

        for (int i = nums[0]; i <= nums[nums.length - 1]; i++) {
            int l = leftBound(nums, i - k);
            int r = rightBound(nums, i + k);
            int tempAns;
            if (numCount.containsKey(i)) {
                tempAns = Math.min(r - l + 1, numCount.get(i) + numOperations);
            } else {
                tempAns = Math.min(r - l + 1, numOperations);
            }
            ans = Math.max(ans, tempAns);
        }

        return ans;
    }

    private int leftBound(int[] nums, int value) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int rightBound(int[] nums, int value) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] > value) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
