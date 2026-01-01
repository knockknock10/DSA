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
        graph[0].add(new Edege(0, 3, 1));
        graph[2].add(new Edege(2, 3, 1));

        graph[3].add(new Edege(3, 1, 1));

        graph[4].add(new Edege(4, 0, 1));
        graph[4].add(new Edege(4, 1, 1));

        graph[5].add(new Edege(5, 0, 1));
        graph[5].add(new Edege(5, 2, 1));

        // graph[0].add(new Edege(0, 1, 1));

        // graph[1].add(new Edege(1, 0, 1));
        // graph[1].add(new Edege(1, 2, 1));
        // graph[1].add(new Edege(1, 3, 1));

        // graph[2].add(new Edege(2, 1, 1));
        // graph[2].add(new Edege(2, 3, 1));
        // graph[2].add(new Edege(2, 4, 1));

        // graph[3].add(new Edege(3, 1, 1));
        // graph[3].add(new Edege(3, 2, 1));

        // graph[4].add(new Edege(4, 1, 1));

        // graph[0].add(new Edege(0, 1, 1));
        // graph[0].add(new Edege(0, 2, 1));
        // graph[0].add(new Edege(0, 3, 1));

        // graph[1].add(new Edege(1, 0, 1));
        // graph[1].add(new Edege(1, 2, 1));

        // graph[2].add(new Edege(2, 0, 1));
        // graph[2].add(new Edege(2, 1, 1));

        // graph[3].add(new Edege(3, 0, 1));
        // graph[3].add(new Edege(3, 4, 1));

        // graph[4].add(new Edege(4, 3, 1));

        // 2's neighbour
        // for (int i = 0; i < graph[2].size(); i++) {
        // Edege e = graph[2].get(i); // src,dest,wt
        // System.out.println(e.dest);
        // }
    }

    // public static void bfs(ArrayList<Edege>[] graph) {
    // Queue<Integer> q = new LinkedList<>();
    // boolean visit[] = new boolean[graph.length];
    // // take a src
    // q.add(0);
    // while (!q.isEmpty()) {
    // int curr = q.remove();
    // if (!visit[curr]) {
    // System.out.print(curr + " ");
    // visit[curr] = true;
    // for (int i = 0; i < graph[curr].size(); i++) {
    // Edege e = graph[curr].get(i);
    // q.add(e.dest);
    // }
    // }
    // }
    // }

    // For disconnected components
    public static void bfsUtil(ArrayList<Edege>[] graph, boolean visit[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!visit[curr]) {
                System.out.print(curr + " ");
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

    public static void bfs(ArrayList<Edege>[] graph) {
        boolean visit[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                bfsUtil(graph, visit);
            }
        }
    }

    // for disconnected components
    public static void DfsUtil(ArrayList<Edege>[] graph, int curr, boolean visit[]) {
        System.out.print(curr + " ");
        visit[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edege e = graph[curr].get(i);
            if (!visit[e.dest]) {
                DfsUtil(graph, e.dest, visit);
            }
        }
    }

    public static void Dfs(ArrayList<Edege>[] graph) {
        boolean visit[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                DfsUtil(graph, i, visit);
            }
        }
    }

    // For connected components
    // public static void dfs(ArrayList<Edege>[] graph, int curr, boolean visit[]) {
    // // visit
    // System.out.print(curr + " ");
    // visit[curr] = true;
    // for (int i = 0; i < graph[curr].size(); i++) {
    // Edege e = graph[curr].get(i);
    // if (!visit[e.dest]) {
    // dfs(graph, e.dest, visit);
    // }
    // }
    // }

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

    public static boolean detectcycle(ArrayList<Edege>[] graph) {
        boolean visit[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                if (detectcycleUtil(graph, visit, i, -1)) {
                    return true;
                    // cycle exists in one loop of parts
                }
            }
        }
        return false;
    }

    public static boolean detectcycleUtil(ArrayList<Edege>[] graph, boolean visit[], int curr, int par) {
        visit[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edege e = graph[curr].get(i);
            // Case-3
            if (!visit[e.dest]) {
                if (detectcycleUtil(graph, visit, e.dest, curr)) {
                    return true;
                }
            }
            // Case-1
            else if (visit[e.dest] && e.dest != par) {
                return true;
            } // Case-2 do nothing continue
        }
        return false;
    }

    // Check for Directed graph if cycle exits
    public static boolean isCycle(ArrayList<Edege>[] graph) {
        boolean visit[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                if (isCycleUtil(graph, i, visit, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edege>[] graph, int curr, boolean visit[], boolean stack[]) {
        visit[curr] = true;
        stack[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edege e = graph[curr].get(i);
            if (stack[e.dest]) { // cycle neigh
                return true;
            }
            if (!visit[e.dest] && isCycleUtil(graph, e.dest, visit, stack)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void topsort(ArrayList<Edege>[] graph) {
        boolean visit[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
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

    public static void calcindeg(ArrayList<Edege>[] graph, int indeg[]) {
        for (int i = 0; i < graph.length; i++) {
            int v = i;
            for (int j = 0; j < graph[v].size(); j++) {
                Edege e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void topsortbfs(ArrayList<Edege>[] graph) {
        int indeg[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        calcindeg(graph, indeg);
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.println(curr + " ");
            for (int i = 0; i < graph[curr].size(); i++) {
                Edege e = graph[curr].get(i);
                indeg[e.dest]--;
                if (indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
    }

    public static String path = "";

    public static void allapth(ArrayList<Edege>[] graph, int src, int dest, String path) {
        if (src == dest) {
            System.out.println(path + dest);
            return;
        }
        for (int i = 0; i < graph[src].size(); i++) {
            Edege e = graph[src].get(i);
            allapth(graph, e.dest, dest, path + src);
        }

    }

    public static void main(String[] args) {
        int v = 6;
        // int arr[] = new arr[v]
        // array of arraylist
        @SuppressWarnings("unchecked")
        ArrayList<Edege>[] graph = new ArrayList[v]; // null ->EMPTY arraylist
        creategraph(graph);
        // bfs(graph);
        // dfs(graph, 0, new boolean[v]);
        // System.out.println();
        // System.out.println(hasPath(graph, 0, 4, new boolean[v]));
        // System.out.println(detectcycle(graph));
        // System.out.println(isCycle(graph));
        // System.out.println("Topological sorting using Dfs");
        // topsort(graph);

        int src = 5, dest = 1;
        allapth(graph, src, dest, path);
    }
}
