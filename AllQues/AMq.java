import java.util.*;

public class AMq {
    
    //car pooling
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
    //215 kth largest element in array 
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

    public static void main(String[] args) {
        int[] kl = {3, 2, 1, 5, 6, 4};
        int k = 2;

        AMq obj = new AMq();
        System.out.println(obj.findlargest(kl, k));
    }
}