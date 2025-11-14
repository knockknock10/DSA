package Hashing;

import java.util.HashMap;
import java.util.Set;

public class hash {

    public static void main(String[] args) {
        // Create
        HashMap<String, Integer> hm = new HashMap<>();
        // Insert O(1)
        hm.put("India", 100);
        hm.put("China", 30);
        hm.put("Us", 300);

        // System.out.println(hm);
        // // Get O(1)
        // int population = hm.get("India");
        // System.out.println(population);
        // System.out.println(hm.get("Nepal"));
        // // ContainsKey O(1)
        // System.out.println(hm.containsKey("India"));// true
        // System.out.println(hm.containsKey("Nepal"));// false

        // Remove O(1)
        // System.out.println(hm.remove("China")); // 30
        // key value pair gets delted and return the value of that key
        // and return null if that key doesnt exist
        // System.out.println(hm.remove("Nepal")); // null
        // System.out.println(hm);

        // Size of hashmap
        // System.out.println(hm.size()); // 3

        // Is empty
        // System.out.println(hm.isEmpty()); // not empty so return false

        // clear removes all the data from hasmap
        // hm.clear();
        // System.out.println(hm.isEmpty()); // true

        // Iterate
        Set<String> keys = hm.keySet();
        System.out.println(keys);
        for (String k : keys) {
            System.out.println("Key= " + k + ", value= " + hm.get(k));
        }
        // or also hm.entrySet();
        System.out.println(hm.entrySet());

    }
}
