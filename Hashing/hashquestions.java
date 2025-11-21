import java.util.*;

public class hashquestions {
    public static void lhashset() {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(null);
        set.add(3);

        set.add(1);
        System.out.println(set);
        if (set.contains(2)) {
            System.out.println("Contains 2");
        }
        set.clear();
        System.out.println(set);
        System.out.println(set.size());
        System.out.println("LinkedHashset");
        LinkedHashSet<String> cities = new LinkedHashSet<>();
        cities.add("Delhi");
        cities.add("Bengaluru");
        cities.add("Mumbai");
        cities.add("Patna");
        // iteration by iterator
        Iterator it = cities.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        // iterator by for each loop
        for (String city : cities) {
            System.out.println(city);
        }
        System.out.println(cities);
        System.out.println("TressSet");
        TreeSet<String> c = new TreeSet<>();
        c.add("Delhi");
        c.add("Bengaluru");
        c.add("Mumbai");
        c.add("Patna");
        System.out.println(c);

    }

    // Anagrams
    public static boolean isAnagram(String s, String t) { // O(n)
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map.get(ch) != null) {
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }

    public static void Majorityele() { // O(N)
        int arr[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            // if (map.containsKey(arr[i])) {
            // map.put(arr[i], map.get(arr[i]) + 1);
            // } else {
            // map.put(arr[i], 1);
            // }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
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
        // Majorityele();
        // String s = "tulip", t = "lipid";
        // System.out.println(isAnagram(s, t));
        lhashset();

    }
}