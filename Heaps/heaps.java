import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class heaps {
    // Insert in heap
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) { // O(log n)
            // add at last
            arr.add(data);

            int x = arr.size() - 1;// child index;
            int par = (x - 1) / 2; // parent index;
            // no of comparisions with upper of its parent i.e level of tree
            // so here while loop is O(log n)
            while (arr.get(x) < arr.get(par)) { // for max heap just change < to >
                // swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
                // update them
                x = par;
                par = (x - 1) / 2;
            }

        }

        // Min in heap
        public int minh() {
            return arr.get(0);
        }

        // peek
        public int peek() {
            return arr.get(0);
        }

        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i; // for max heap just chnage the name of to maxIdx
            // for max heap just change > to <
            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            } // for max heap just change > to <
            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }
            if (minIdx != i) {
                // swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);
                heapify(minIdx);
            }

        }

        // remove from heap
        public int remove() {
            int data = arr.get(0);
            // step 1 swap first and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);
            // step 2 delete last

            arr.remove(arr.size() - 1);

            // step-3 heapify
            heapify(0);
            return data;
        }

        // check for empty
        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    // PriorityQueue for objects
    public static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }

    public static void main(String[] args) {
        // PriorityQueue<Student> pq = new PriorityQueue<>();//
        // Comparator.reverseOrder() for reverse
        // pq.add(new Student("A", 4));// O(log n)
        // pq.add(new Student("B", 2));
        // pq.add(new Student("C", 5));
        // pq.add(new Student("D", 2));
        // while (!pq.isEmpty()) {
        // System.out.println(pq.peek().name + " --->>" + pq.peek().rank);// O(1)
        // pq.remove();// O(log n)
        // }

        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);
        while (!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }
    }
}