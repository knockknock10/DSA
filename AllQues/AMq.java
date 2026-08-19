import java.util.*;

public class AMq {

    // car pooling
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        for (int[] trip : trips) {
            diff[trip[1]] += trip[0];
            diff[trip[2]] -= trip[0];
        }
        for (int i = 0; i < 1001; i++) {
            capacity -= diff[i];
            if (capacity < 0) {
                return false;
            }
        }
        return true;
    }

    // 215 kth largest element in array
    public int findlargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    // A.M 49 Group Anagrams
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char temp[] = strs[i].toCharArray();
            Arrays.sort(temp);
            String s = String.valueOf(temp);
            if (map.get(s) != null) {
                List<String> a = map.get(s);
                a.add(strs[i]);
                map.put(s, a);
            } else {
                List<String> a = new ArrayList<>();
                a.add(strs[i]);
                map.put(s, a);
            }
        }
        for (Map.Entry<String, List<String>> x : map.entrySet()) {
            ans.add(x.getValue());
        }
        return ans;
    }

    // Rotting oranges
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int r = grid.length;
        int c = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int count_fresh = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] { i, j });
                }
                if (grid[i][j] == 1) {
                    count_fresh++;
                }
            }
        }

        if (count_fresh == 0)
            return 0;

        int countmin = 0, cnt = 0;
        int dx[] = { 0, 0, 1, -1 };
        int dy[] = { 1, -1, 0, 0 };

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] points = q.poll();
                for (int j = 0; j < 4; j++) {
                    int x = points[0] + dx[j];
                    int y = points[1] + dy[j];
                    if (x < 0 || y < 0 || x >= r || y >= c || grid[x][y] == 0 || grid[x][y] == 2)
                        continue;
                    grid[x][y] = 2;
                    cnt++;
                    q.offer(new int[] { x, y });
                }
            }
            if (q.size() != 0)
                countmin++;
        }
        return count_fresh == cnt ? countmin : -1;
    }

    public static void main(String[] args) {
        int[] kl = { 3, 2, 1, 5, 6, 4 };
        int k = 2;

        AMq obj = new AMq();
        System.out.println(obj.findlargest(kl, k));
        int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        System.out.println(obj.orangesRotting(grid));
    }
}