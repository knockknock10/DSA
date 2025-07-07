import java.util.*;

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]); // Sort by start day
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // stores end days
        int day = 0, i = 0, res = 0;
        int n = events.length;
        
        while (!minHeap.isEmpty() || i < n) {
            if (minHeap.isEmpty()) {
                day = events[i][0]; // Jump to next available event start day
            }

            // Add all events starting on this day
            while (i < n && events[i][0] == day) {
                minHeap.offer(events[i][1]); // Add end day to heap
                i++;
            }

            // Remove expired events
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            // Attend event with earliest end day
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                res++;
            }

            day++;
        }

        return res;
    }
}

