class Solution {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length; long MIN_VAL = Long.MIN_VALUE;
        long max_result = MIN_VAL;

        for (int i = 0; i < n; i++) {
            int left_idx = i, right_idx = i;
            long center_sum = nums[left_idx];

            while (right_idx + 1 < n && nums[right_idx + 1] < nums[right_idx]) {
                center_sum += (long)nums[right_idx + 1];
                right_idx++;
            }
            if (right_idx == left_idx) continue;

            int center_end = right_idx;

            long left_part_sum = 0, right_part_sum = 0;
            long max_left = MIN_VAL, max_right = MIN_VAL;

            while (left_idx - 1 >= 0 && nums[left_idx - 1] < nums[left_idx]) {
                left_part_sum += (long)nums[left_idx - 1];
                max_left = Math.max(max_left, left_part_sum);
                left_idx--;
            }
            if (left_idx == i) continue;

            while (right_idx + 1 < n && nums[right_idx + 1] > nums[right_idx]) {
                right_part_sum += (long)nums[right_idx + 1];
                max_right = Math.max(max_right, right_part_sum);
                right_idx++;
            }
            if (right_idx == center_end) continue;
            
            i = right_idx - 1;
            max_result = Math.max(max_result, max_left + max_right + center_sum);
        }
        
        return max_result;
    }
}
