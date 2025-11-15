
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

        private int size; // n
        private LinkedList<Node> buckets[]; // N = buckets.length

        @SuppressWarnings("Unchecked") // if not then we have to tell
        public HashMap() {
            this.size = 4;
            this.buckets = new LinkedList[4];// here what kind of ll type we r using
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(k key) {
            int hc = key.hashCode(); // 124354 or -132435 anything
            return Math.abs(hc) % size; // convrt if -ve else let be and return 0 to size-1
        }

        public void put(k key, v value) {
            int bi = hashFunction(key); // should be 0 to size-1
            int di = SearchInLL(key); // valid;-1
        }

        public boolean containsKey(k key) {
            return false;
        }

        public v remove() {
            return null;
        }

        public ArrayList<k> keySet() {
            return null;
        }

    }

    public static void main(String args[]) {

    }
}
