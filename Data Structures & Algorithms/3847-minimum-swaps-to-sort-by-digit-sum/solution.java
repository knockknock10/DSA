
import java.util.*;

class Solution {
    private int sum(int n) {
        int su = 0;
        while (n > 0) {
            su += n % 10;
            n /= 10;
        }
        return su;
    }
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = sum(nums[i]);
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < n; i++) {
            index.put(nums[i], i);
        }
        boolean[] visited = new boolean[n];
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] || index.get(arr[i][0]) == i) {
                continue;
            }
            int j = i;
            int cycleSize = 0;
            while (!visited[j]) {
                visited[j] = true;
                int value = arr[j][0];
                j = index.get(value);
                cycleSize++;
            }
            swaps += cycleSize - 1;
        }
        return swaps;
    }
}

