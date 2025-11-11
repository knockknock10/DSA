import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class heaps {
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distsq;
        int idx;

        public Point(int x, int y, int distsq, int idx) {
            this.x = x;
            this.y = y;
            this.distsq = distsq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2) {
            return this.distsq - p2.distsq;
        }
    }

    // Heap sort
    public static void heapify(int arr[], int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;
        if (left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }
        if (right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }
        if (maxIdx != i) {
            // sawp
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
            heapify(arr, maxIdx, size);
        }
    }

    public static void heapsort(int arr[]) {
        // 1st to build maxheap
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n); // O(n/2*log n) i.e O(n log n)
        }
        // 2nd push largest at end
        for (int i = n - 1; i > 0; i--) { // O(n)
            // swap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i); // O(log n) i.e O(n log n)
        }
    } // n logn + n logn i.e O(n log n)

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

    // Connect N ropes with minimum Cost
    public static void minRope() {
        int ropes[] = { 2, 3, 3, 4, 6 };
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }
        int cost = 0;
        while (pq.size() > 1) {
            int min = pq.remove();
            int min2 = pq.remove();
            cost += min + min2;
            pq.add(min + min2);
        }
        System.out.println("Cost of Connecting ropes : " + cost);
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

        // Heap h = new Heap();
        // h.add(3);
        // h.add(4);
        // h.add(1);
        // h.add(5);
        // while (!h.isEmpty()) {
        // System.out.println(h.peek());
        // h.remove();
        // }

        // int arr[] = { 1, 2, 4, 5, 3 };
        // heapsort(arr);
        // for (int i = 0; i < arr.length; i++) {
        // System.out.print(arr[i] + " ");
        // }
        // System.out.println();

        int pts[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k = 2;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < pts.length; i++) {
            int distsq = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
            pq.add(new Point(pts[i][0], pts[i][1], distsq, i));
        }
        // nearest k cars
        for (int i = 0; i < k; i++) {
            System.out.println("C" + pq.remove().idx);
        }
        minRope();
    }
}