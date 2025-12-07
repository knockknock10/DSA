package Graphs;

import java.util.*;

public class buildgraph {
    public static class Edege {
        int src;
        int dest;
        int wt;

        public Edege(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void creategraph(ArrayList<Edege> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edege(0, 1, 1));

        graph[1].add(new Edege(1, 0, 1));
        graph[1].add(new Edege(1, 2, 1));
        graph[1].add(new Edege(1, 3, 1));

        graph[2].add(new Edege(2, 1, 1));
        graph[2].add(new Edege(2, 3, 1));
        graph[2].add(new Edege(2, 4, 1));

        graph[3].add(new Edege(3, 1, 1));
        graph[3].add(new Edege(3, 2, 1));

        graph[4].add(new Edege(4, 1, 1));

        // 2's neighbour
        // for (int i = 0; i < graph[2].size(); i++) {
        // Edege e = graph[2].get(i); // src,dest,wt
        // System.out.println(e.dest);
        // }
    }

    public static void bfs(ArrayList<Edege>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean visit[] = new boolean[graph.length];
        // take a src
        q.add(0);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!visit[curr]) {
                System.out.print(curr + " ");
                visit[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edege e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edege>[] graph, int curr, boolean visit[]) {
        // visit
        System.out.print(curr + " ");
        visit[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edege e = graph[curr].get(i);
            if (!visit[e.dest]) {
                dfs(graph, e.dest, visit);
            }
        }
    }

    // O(V+E)
    public static boolean hasPath(ArrayList<Edege>[] graph, int src, int dest, boolean visit[]) {
        if (src == dest) {
            return true;
        }
        visit[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edege e = graph[src].get(i);
            // e.dest = neighbour
            if (!visit[e.dest] && hasPath(graph, e.dest, dest, visit)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 5;
        // int arr[] = new arr[v]
        // array of arraylist
        @SuppressWarnings("unchecked")
        ArrayList<Edege>[] graph = new ArrayList[v]; // null ->EMPTY arraylist
        creategraph(graph);
        bfs(graph);
        dfs(graph, 0, new boolean[v]);
        System.out.println();
        System.out.println(hasPath(graph, 0, 4, new boolean[v]));
    }
}
