import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        int[] count = new int[n];

        PriorityQueue<Integer> freeRoom = new PriorityQueue<>();
        PriorityQueue<long[]> used = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return Long.compare(a[1], b[1]);
            return Long.compare(a[0], b[0]);
        });

        for (int i = 0; i < n; i++) {
            freeRoom.offer(i);
        }

        for (int[] meet : meetings) {
            int start = meet[0], end = meet[1];
            long duration = end - start;

            // Free up rooms that are done before current meeting starts
            while (!used.isEmpty() && used.peek()[0] <= start) {
                int room = (int) used.poll()[1];
                freeRoom.offer(room);
            }

            int room;
            long actualStart;

            if (freeRoom.isEmpty()) {
                long[] next = used.poll();
                actualStart = next[0];
                room = (int) next[1];
            } else {
                room = freeRoom.poll();
                actualStart = start;
            }

            count[room]++;
            used.offer(new long[]{actualStart + duration, room});
        }

        int maxRoom = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[maxRoom]) {
                maxRoom = i;
            }
        }

        return maxRoom;
    }
}

