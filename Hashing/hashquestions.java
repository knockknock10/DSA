import java.util.*;

public class hashquestions {
    public static void Majorityele() { // O(n)
        int arr[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            // if (map.containsKey(arr[i])) {
            // map.put(arr[i], map.get(arr[i]) + 1);
            // } else {
            // map.put(arr[i], 1);
            // }
            map.put(arr[i], map.getOrDefault(arr[i], 1) + 1);
        }
        // Set<Integer> keyset = map.keySet();
        // for (Integer key : keyset) {
        for (Integer key : map.keySet()) {
            if (map.get(key) > arr.length / 3) {
                System.out.println(key);
            }
        }

    }

    public static void main(String args[]) {
        Majorityele();
    }
}