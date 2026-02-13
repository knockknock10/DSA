
import java.util.*;

public class hashimp {
    static class HashMap<k, v> { // k,v are generics in java generics are parametarized types
        // key val data types are not fixed so we make it generic
        private class Node {
            k key;
            v value;

            public Node(k key, v value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // size
        private int N;
        private LinkedList<Node> buckets[]; // N = buckets.length

        @SuppressWarnings("unchecked") // if not then we have to tell
        public HashMap() {

            this.N = 4;
            this.buckets = new LinkedList[4];// here what kind of ll type we r using
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(k key) {
            int hc = key.hashCode(); // 124354 or -132435 anything
            return Math.abs(hc) % N; // convrt if -ve else let be and return 0 to size-1
        }

        private int SearchInLL(k key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0;
            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key.equals(key)) { // node.key==key
                    return di;
                }
                di++;
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node> oldbuck[] = buckets;
            buckets = new LinkedList[N * 2];
            N = N * 2;
            for (int i = 0; i < N; i++) { // intialize with empty linked list
                buckets[i] = new LinkedList<>();
            }
            // nodes-> add in bucket
            for (int i = 0; i < oldbuck.length; i++) {
                LinkedList<Node> ll = oldbuck[i];
                for (Node node : ll) {
                    // Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        public void put(k key, v value) { // O(lambda)->O(1)
            int bi = hashFunction(key); // should be 0 to size-1
            int di = SearchInLL(key, bi); // valid;-1

            if (di != -1) {
                Node node = buckets[bi].get(di); // bucket indx then in that ll indx
                node.value = value;
            } else { // if that key doesnot exits
                buckets[bi].add(new Node(key, value));
                n++;
            }
            double lambda = (double) n / N;
            if (lambda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(k key) { // O(1)
            int bi = hashFunction(key); // should be 0 to size-1
            int di = SearchInLL(key, bi); // valid;-1

            if (di != -1) {
                return true;
            } else {
                return false;
            }
        }

        public v remove(k key) { // O(1)
            int bi = hashFunction(key); // should be 0 to size-1
            int di = SearchInLL(key, bi); // valid;-1

            if (di != -1) {
                Node node = buckets[bi].remove(di); // bucket indx then in that ll indx
                n--;
                return node.value;
            } else { // if that key doesnot exits
                return null;
            }
        }

        public v get(k key) { // O(1)
            int bi = hashFunction(key); // should be 0 to size-1
            int di = SearchInLL(key, bi); // valid;-1

            if (di != -1) {
                Node node = buckets[bi].get(di); // bucket indx then in that ll indx
                return node.value;
            } else { // if that key doesnot exits
                return null;
            }

        }

        public ArrayList<k> keySet() {
            ArrayList<k> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }

    }

    public static void main(String args[]) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 40);
        hm.put("China", 1230);
        hm.put("Nepal", 243);
        hm.put("us", 234);

        ArrayList<String> keys = hm.keySet();
        for (String key : keys) {
            System.out.println(key);
        }
        System.out.println(hm.get("India"));
        System.out.println(hm.remove("India"));
        System.out.println(hm.get("India"));
    }
}
