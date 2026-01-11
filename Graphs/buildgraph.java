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
        // MST
        graph[0].add(new Edege(0, 1, 10));
        graph[0].add(new Edege(0, 2, 15));
        graph[0].add(new Edege(0, 3, 30));

        graph[1].add(new Edege(1, 0, 10));
        graph[1].add(new Edege(1, 3, 40));

        graph[2].add(new Edege(2, 0, 15));
        graph[2].add(new Edege(2, 3, 50));

        graph[3].add(new Edege(3, 1, 40));
        graph[3].add(new Edege(3, 2, 50));

        // Bellman ford Algorithm
        // graph[0].add(new Edege(0, 1, 2));
        // graph[0].add(new Edege(0, 2, 4));

        // graph[1].add(new Edege(1, 2, -4));

        // graph[2].add(new Edege(2, 3, 2));

        // graph[3].add(new Edege(3, 4, 4));

        // graph[4].add(new Edege(4, 1, -1));

        // // dijkstra's
        // graph[0].add(new Edege(0, 1, 2));
        // graph[0].add(new Edege(0, 2, 4));

        // graph[1].add(new Edege(1, 3, 7));
        // graph[1].add(new Edege(1, 2, 1));

        // graph[2].add(new Edege(2, 4, 3));

        // graph[3].add(new Edege(3, 5, 1));

        // graph[4].add(new Edege(4, 3, 2));
        // graph[4].add(new Edege(4, 5, 5));

        // all path source to dest
        // graph[0].add(new Edege(0, 3, 1));
        // graph[2].add(new Edege(2, 3, 1));

        // graph[3].add(new Edege(3, 1, 1));

        // graph[4].add(new Edege(4, 0, 1));
        // graph[4].add(new Edege(4, 1, 1));

        // graph[5].add(new Edege(5, 0, 1));
        // graph[5].add(new Edege(5, 2, 1));

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

    // Dijkstra's
    static class Pair implements Comparable<Pair> {
        int n;
        int path;

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path; // path based sorting for my pairs
        }
    }

    public static void dijkstra(ArrayList<Edege> graph[], int src) {
        int dist[] = new int[graph.length]; // dist[i] ->src to i
        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE; // +infinity
            }
        }
        boolean visit[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0)); // src to src tak ka pair
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!visit[curr.n]) {
                visit[curr.n] = true;
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edege e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if (dist[u] + wt < dist[v]) { // update distance src to v
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + "");
        }
        System.out.println();
    }

    public static void creategraph2(ArrayList<Edege> graph) {

        // Bellman ford Algorithm
        graph.add(new Edege(0, 1, 2));
        graph.add(new Edege(0, 2, 4));

        graph.add(new Edege(1, 2, -4));

        graph.add(new Edege(2, 3, 2));

        graph.add(new Edege(3, 4, 4));

        graph.add(new Edege(4, 1, -1));
    }

    // Bellman_ford Algorithm
    public static void BellmanFord2(ArrayList<Edege> graph, int src, int V) { // graph[]
        int dist[] = new int[V];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        // O(V*E)
        // algo O(V)
        for (int i = 0; i < V - 1; i++) {
            // edeges O(E)
            for (int j = 0; j < graph.size(); j++) { // all vertex

                Edege e = graph.get(j);
                // u,v,wt
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                // relaxation
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }

            }
        }
        // print
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }
    static class Pair1 implements Comparable<Pair1>{
        int v;
        int cost;
        
        public Pair1(int v,int cost){
            this.v = v;
            this.cost = cost;
        }
        @Override
        public int compareTo(Pair1 p2){
            return this.cost - p2.cost;
        }
    }
    public static void MST_prims(ArrayList<Edege> graph[]){
        boolean visit[] = new boolean[graph.length];
        PriorityQueue<Pair1> pq = new PriorityQueue<>();
        pq.add(new Pair1(0, 0));
        int finaCost = 0;       //Mst cost/total min weight
        while(!pq.isEmpty()){
            Pair1 curr = pq.remove();
            if(!visit[curr.v]){
                visit[curr.v] = true;
                finaCost+=curr.cost;
                for(int i=0;i<graph[curr.v].size();i++){
                    Edege e = graph[curr.v].get(i);
                    pq.add(new Pair1(e.dest, e.wt));
                }
                
            }
            
        }
        System.out.println("Final cost of Mst : "+finaCost);
    }
    
    // Cheapest Connecting Flight Problem #727
    static class Edege1 {
         int src;
         int dest;
         int wt;
         public Edege1(int src,int dest,int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
         }
    }
    public static void crgraph(int flights[][],ArrayList<Edege1> graph[]){
        for(int i =0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<flights.length;i++){
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];
            Edege1 e = new Edege1(src, dest, wt);
            graph[src].add(e);
        }
    }
    static class Info{
        int v;
        int cost;
        int stops;
        public Info(int v,int cost,int stops){
            this.v = v;
            this.cost = cost;
            this.stops = stops;
        }
    }
    public static int CheapestFlight(int n,int flights[][],int src,int dest,int k){
        @SuppressWarnings("unchecked")
        ArrayList<Edege1>[] graph = new ArrayList[n]; 
        crgraph(flights, graph);
        
        int dist[] = new int[n];
        for(int i=0;i<n;i++){
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));
        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr.stops>k){
                break;
            }
            for(int i=0;i<graph[curr.v].size();i++){
                Edege1 e  = graph[curr.v].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                if(curr.cost+wt < dist[v] && curr.stops<=k){              //dist[u] != Integer.MAX_VALUE && if add in any int in infinity then it goes to negative
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stops+1));
                }
                
            }
        }
        //dist[dest]
        if(dist[dest] == Integer.MAX_VALUE){
            return -1;
        }else{
            return dist[dest];
        }
        
        
    }
    public static void main(String[] args) {
        int v = 5;
        // int arr[] = new arr[v]
        // array of arraylist
       // @SuppressWarnings("unchecked")
        //ArrayList<Edege>[] graph = new ArrayList[v]; // null ->EMPTY arraylist
        //creategraph(graph);
        // bfs(graph);
        // dfs(graph, 0, new boolean[v]);
        // System.out.println();
        // System.out.println(hasPath(graph, 0, 4, new boolean[v]));
        // System.out.println(detectcycle(graph));
        // System.out.println(isCycle(graph));
        // System.out.println("Topological sorting using Dfs");
        // topsort(graph);
        // all path from source to dest
        // int src = 5, dest = 1;
        // allapth(graph, src, dest, path);
        // Dijkstra's
        // int src = 0;
        // dijkstra(graph, src);
        // ArrayList<Edege> graph = new ArrayList<>();
        // creategraph2(graph);
        // BellmanFord(graph, 0);
        // BellmanFord2(graph, 0, v);
        // MST_prims(graph);
        
        //Cheapest flight
        int n =4;
        int flights[][] = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src =0,dst = 3,k =1;
        System.out.println(CheapestFlight(n, flights, src, dst, k));
    }
    
}
