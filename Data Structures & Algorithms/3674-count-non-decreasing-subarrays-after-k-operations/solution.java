class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] val = new int[n];
        int[] cnt = new int[n];
        int head = 0, tail = -1;
        int j = n - 1;
        long cost = 0, ans = 0;

        for (int i = n - 1; i >= 0; i--) {
            int c = 1;
            while (tail >= head && val[tail] < nums[i]) {
                cost += (long) (nums[i] - val[tail]) * cnt[tail];
                c += cnt[tail];
                tail--;
            }
            tail++;
            val[tail] = nums[i];
            cnt[tail] = c;

            while (cost > k) {
                cost -= val[head] - nums[j];
                if (--cnt[head] == 0) head++;
                j--;
            }
            ans += j - i + 1;
        }
        return ans;
    }
}
