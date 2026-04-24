import java.util.*;

class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];

        Map<Integer, List<Integer>> map = new HashMap<>();

        //  Group indices by value
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // Process each group
        for (List<Integer> list : map.values()) {
            int size = list.size();

            long[] prefix = new long[size];
            prefix[0] = list.get(0);

            // Build prefix sum of indices
            for (int i = 1; i < size; i++) {
                prefix[i] = prefix[i - 1] + list.get(i);
            }

            // Calculate distances
            for (int i = 0; i < size; i++) {
                int index = list.get(i);

                long left = (long) i * index - (i > 0 ? prefix[i - 1] : 0);
                long right = (prefix[size - 1] - prefix[i]) - (long)(size - i - 1) * index;

                ans[index] = left + right;
            }
        }

        return ans;
    }
}
