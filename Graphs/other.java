package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class other {
    // static int n = 7;
    // static int par[] = new int[n];
    // static int rank[] = new int[n];
    // public static void init(){
    // for(int i=0;i<n;i++){
    // par[i] = i;
    // }
    // }
    // public static int find(int x){
    // if(x==par[x]){
    // return x;
    // }
    // return par[x] = find(par[x]);
    // }
    // public static void union(int a,int b){
    // int parA = find(a);
    // int parB = find(b);

    // if(rank[parA]==rank[parB]){
    // par[parB] = parA;
    // rank[parA]++;
    // }else if(rank[parA]<rank[parB]){
    // par[parA] = parB;
    // }else{
    // par[parB] = parA;
    // }
    // }
    static class Edge {// implements Comparable<Edge>{
        int src;
        int dest;

        // int wt;
        public Edge(int s, int d) {// ,int w){
            this.src = s;
            this.dest = d;
            // this.wt = w;
        }
        // @Override
        // public int compareTo(Edge e2){
        // return this.wt - e2.wt;
        // }
    }
    // static void createGraph(ArrayList<Edge> edges){
    // // edges
    // edges.add(new Edge( 0, 1, 10));
    // edges.add(new Edge( 0, 2, 15));
    // edges.add(new Edge( 0, 3, 30));
    // edges.add(new Edge( 1, 3, 40));
    // edges.add(new Edge( 2, 3, 50));
    // }
    // static int n = 4; //vertices
    // static int par[] = new int[n];
    // static int rank[] = new int[n];
    // public static void init(){
    // for(int i=0;i<n;i++){
    // par[i] = i;
    // }
    // }

    // public static int find(int x){
    // if(x==par[x]){
    // return x;
    // }
    // return par[x] = find(par[x]);
    // }
    // public static void union(int a,int b){
    // int parA = find(a);
    // int parB = find(b);

    // if(rank[parA]==rank[parB]){
    // par[parB] = parA;
    // rank[parA]++;
    // }else if(rank[parA]<rank[parB]){
    // par[parA] = parB;
    // }else{
    // par[parB] = parA;
    // }
    // }
    // public static void kraushkalsMst(ArrayList<Edge> edges,int V){ //O(V+ElogE)
    // init();
    // Collections.sort(edges);//O(ElogE)
    // int mstCost = 0;
    // int count = 0;

    // for(int i=0;count<V-1;i++){//O(v)
    // Edge e = edges.get(i);
    // //(src,dest,wt)
    // int parA = find(e.src);//src = a
    // int parB = find(e.dest);//src = b
    // if(parA != parB){
    // union(e.src, e.dest);
    // mstCost+=e.wt;
    // count++;
    // }

    // }
    // System.out.println(mstCost);
    // }

    // Strongly Disconnect Componnets TC O(V+E)
    public static void createGraph1(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // graph[0].add(new Edge(0, 2));
        // graph[0].add(new Edge(0, 3));

        // graph[1].add(new Edge(1, 0));

        // graph[2].add(new Edge(2, 1));

        // graph[3].add(new Edge(3, 4));
        // for Bridges in Graphs
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
       // graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        //graph[4].add(new Edge(4, 5));

       // graph[5].add(new Edge(5, 3));
       // graph[5].add(new Edge(5, 4));

    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        vis[curr] = true;
        System.out.print(curr + " ");

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static void topSort(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSort(graph, e.dest, vis, s);
            }
        }

        s.push(curr);
    }
    
    public static void kosaraju(ArrayList<Edge> graph[], int V) {
        // step 1
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topSort(graph, i, vis, s);
            }
        }
        // step 2
        @SuppressWarnings("unchecked")
        ArrayList<Edge> transpose[] = new ArrayList[V];
        for (int i = 0; i < graph.length; i++) {
            vis[i] = false;
            transpose[i] = new ArrayList<Edge>();
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);// e.src->e.dest
                transpose[e.dest].add(new Edge(e.dest, e.src));// reverse Edege
            }
        }

        // step3
        while (!s.isEmpty()) {
            int curr = s.pop();
            if (!vis[curr]) {
                System.out.print("SCC ->");
                dfs(transpose, curr, vis);// scc
                System.out.println();
            }
        }
    }
    
    //Bridegs in Graphs 
    public static void dfss(ArrayList<Edge> graph[] ,int curr,int par,int dt[],int low[],boolean vis[],int time){
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            int neigh = e.dest;
            if(neigh == par){
                continue;
            }else if(!vis[neigh]){
                dfss(graph, neigh, curr, dt, low, vis, time);
                low[curr] = Math.min(low[curr], low[neigh]);
                if(dt[curr]<low[neigh]){
                    System.out.println("Bridge : "+curr+"------"+neigh);
                }
            }else{
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
        }
    }
    public static void Tarjans_bridge(ArrayList<Edge> graph[],int V){
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfss(graph, i, -1, dt, low, vis, time);
            }
        }
    }
    public static void main(String args[]) {
        // init();
        // System.out.println(find(3));
        // union(1, 3);
        // System.out.println(find(3));
        // union(2, 4);
        // union(3, 6);
        // union(1, 4);
        // System.out.println(find(3));
        // System.out.println(find(4));
        // union(1, 5);
        // int V = 4;
        // ArrayList<Edge> edges = new ArrayList<>();
        // createGraph(edges);
        // kraushkalsMst(edges, V);
       // int V = 5;
       int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph1(graph);
        //kosaraju(graph, V);
        Tarjans_bridge(graph,V);
    }
}
