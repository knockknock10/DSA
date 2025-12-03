import java.util.*;

class Solution {

    static class Pair {
        int a, b;
        Pair(int a, int b) { this.a = a; this.b = b; }
        public int hashCode() { return Objects.hash(a, b); }
        public boolean equals(Object o) {
            Pair p = (Pair)o;
            return a == p.a && b == p.b;
        }
    }

    public int countTrapezoids(int[][] points) {
        int n = points.length;

        Map<Pair, Map<Long, Integer>> slopes = new HashMap<>();
        Map<String, Map<Pair, Integer>> mids = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0], y2 = points[j][1];

                int dx = x2 - x1, dy = y2 - y1;
                int g = gcd(Math.abs(dx), Math.abs(dy));
                dx /= g;
                dy /= g;

                if (dx < 0 || (dx == 0 && dy < 0)) {
                    dx = -dx;
                    dy = -dy;
                }

                Pair slope = new Pair(dy, dx);

                long c = (long)dx * y1 - (long)dy * x1;

                slopes.putIfAbsent(slope, new HashMap<>());
                Map<Long, Integer> lineMap = slopes.get(slope);
                lineMap.put(c, lineMap.getOrDefault(c, 0) + 1);

                int mx = x1 + x2, my = y1 + y2;
                String midKey = mx + "," + my;

                mids.putIfAbsent(midKey, new HashMap<>());
                Map<Pair, Integer> midMap = mids.get(midKey);
                midMap.put(slope, midMap.getOrDefault(slope, 0) + 1);
            }
        }

        long tot = 0;

        for (Map<Long, Integer> lineCounts : slopes.values()) {
            long total = 0;
            long sumSq = 0;
            for (int v : lineCounts.values()) {
                total += v;
                sumSq += (long)v * v;
            }
            tot += (total * total - sumSq) / 2;
        }

        long para = 0;

        for (Map<Pair, Integer> sCnt : mids.values()) {
            long v = 0;
            long sumComb = 0;

            for (int c : sCnt.values()) {
                v += c;
                sumComb += (long)c * (c - 1) / 2;
            }
            if (v > 1) {
                para += v * (v - 1) / 2 - sumComb;
            }
        }

        return (int)(tot - para);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
