package Graphs;

import java.util.*;
import Tries.trie;
public class practiselab {
    static class Edege {
        int src;
        int dest;
        int wt;

        Edege(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void creategraph(ArrayList<Edege>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edege(0, 0, 0));
    }

    public static void dfs(ArrayList<Edege>[] graph) {
        boolean visit[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                dfsutil(graph, i, visit);
            }
        }
    }

    public static void dfsutil(ArrayList<Edege>[] graph, int curr, boolean visit[]) {
        System.out.println(curr + " ");
        visit[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edege e = graph[curr].get(i);
            if (!visit[e.dest]) {
                dfsutil(graph, e.dest, visit);
            }
        }
    }

    public static void bfs(ArrayList<Edege>[] graph) {
        boolean visit[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                bfsUtil(graph, visit);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edege>[] graph, boolean visit[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!visit[curr]) {
                System.out.println(curr + " ");
                visit[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edege e = graph[curr].get(i);
                    if (!visit[e.dest]) {
                        q.add(e.dest);
                    }
                }
            }
        }
    }

    // Tower of Hanoi
    public static void hanoi(int n, char from, char aux, char to) {
        if (n == 0) {
            return;
        }
        hanoi(n - 1, from, to, aux);
        System.out.println("N" + n + "from" + from + "to" + to);
        hanoi(n - 1, aux, from, to);
    }

    // Linear search
    public static int linear(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    // Binary search
    public static int binary(int arr[], int key) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] == key) {
                return m;
            } else if (arr[m] < key) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    public static void maxsub_Kadane() {
        int arr[] = { 10, 12, 34, 5, 68, 2 };
        int max = arr[0];
        int curr = arr[0];
        for (int i = 0; i < arr.length; i++) {
            curr = Math.max(arr[i], curr + arr[i]);
            max = Math.max(max, curr);
        }
        System.out.println(max);
    }

    // Task Scheduling
    static class Task {
        int start;
        int finish;

        Task(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }

    public static void task_schedule() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Task[] tasks = new Task[n];
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int f = sc.nextInt();
            tasks[i] = new Task(s, f);
        }
        Arrays.sort(tasks, (a, b) -> a.finish - b.finish);
        List<Task> res = new ArrayList<>();
        int lastfinish = -1;
        for (Task t : tasks) {
            if (t.start >= lastfinish) {
                res.add(t);
                lastfinish = t.finish;
            }
        }
        System.out.println(res.size());
        for (Task t : res) {
            System.out.println(t.start + " " + t.finish);
        }
    }

    public static void topsort(ArrayList<Edege>[] graph) {
        Stack<Integer> s = new Stack<>();
        boolean visit[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                topsortUtil(graph, i, visit, s);
            }
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void topsortUtil(ArrayList<Edege>[] graph, int curr, boolean visit[], Stack<Integer> s) {

        visit[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edege e = graph[curr].get(i);
            if (!visit[e.dest]) {
                topsortUtil(graph, e.dest, visit, s);
            }
        }
        s.push(curr);
    }

    public static void main(String[] args) {

        int v = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edege>[] graph = new ArrayList[v];
        creategraph(graph);
    }
}
