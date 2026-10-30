import java.util.*;

class Solution {

    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(new int[] { e[1], e[2] });
        }

        long[][] dis = new long[n][k + 1];
        for (long[] row : dis) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        // {shortest path length, node index, number of consecutive identical letters at the end}
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) ->
            Long.compare(a[0], b[0])
        );

        dis[0][1] = 0;
        pq.offer(new long[] { 0, 0, 1 });

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int x = (int) cur[1],
                cnt = (int) cur[2];

            if (d > dis[x][cnt]) {
                continue;
            }
            if (x == n - 1) {
                return (int) d;
            }

            for (int[] e : g[x]) {
                int y = e[0],
                    w = e[1];
                int newCnt = labels.charAt(x) == labels.charAt(y) ? cnt + 1 : 1;
                if (newCnt > k) {
                    continue;
                }

                long nd = d + w;
                if (nd < dis[y][newCnt]) {
                    dis[y][newCnt] = nd;
                    pq.offer(new long[] { nd, y, newCnt });
                }
            }
        }

        return -1;
    }
}
