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

    public static void main(String[] args) {
        int[] kl = { 3, 2, 1, 5, 6, 4 };
        int k = 2;

        AMq obj = new AMq();
        System.out.println(obj.findlargest(kl, k));
    }
}