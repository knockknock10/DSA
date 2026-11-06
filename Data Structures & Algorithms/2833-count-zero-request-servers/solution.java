import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        // Step 1: Sort logs by timestamp
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        // Step 2: Store queries with their original indices
        int q = queries.length;
        int[][] sortedQueries = new int[q][2];

        for (int i = 0; i < q; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        // Step 3: Sort queries by timestamp
        Arrays.sort(sortedQueries, (a, b) ->
            Integer.compare(a[0], b[0])
        );

        // Step 4: Initialize our data structures
        int[] answer = new int[q];
        int[] freq = new int[n + 1];

        int left = 0;
        int right = 0;
        int active = 0;

        // Step 5: Process queries in sorted order
        for (int i = 0; i < q; i++) {

            int time = sortedQueries[i][0];
            int originalIndex = sortedQueries[i][1];

            int start = time - x;

            // Add logs that have entered the window
            while (right < logs.length &&
                   logs[right][1] <= time) {

                int server = logs[right][0];

                if (freq[server] == 0) {
                    active++;
                }

                freq[server]++;
                right++;
            }
            // Remove logs that have left the window
            while (left < right &&
                   logs[left][1] < start) {
                int server = logs[left][0];

                freq[server]--;

                if (freq[server] == 0) {
                    active--;
                }

                left++;
            }
            // Count servers with zero requests
            answer[originalIndex] = n - active;
        }

        return answer;
    }
}
