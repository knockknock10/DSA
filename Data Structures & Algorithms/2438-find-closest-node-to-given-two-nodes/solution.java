class Solution {
    public void dfs(int node, List<Integer>[] adj, boolean[] vis, int[] dis) {
        vis[node] = true;
        for (int neighbor : adj[node]) {
            if (!vis[neighbor]) {
                dis[neighbor] = dis[node] + 1;
                dfs(neighbor, adj, vis, dis);
            }
        }
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (edges[i] != -1)
                adj[i].add(edges[i]);
        }

        boolean[] vis1 = new boolean[n];
        boolean[] vis2 = new boolean[n];
        int[] dis1 = new int[n];
        int[] dis2 = new int[n];

        dfs(node1, adj, vis1, dis1);
        dfs(node2, adj, vis2, dis2);

        int minDist = Integer.MAX_VALUE;
        int result = -1;

        for (int i = 0; i < n; i++) {
            if (vis1[i] && vis2[i]) {
                int maxDist = Math.max(dis1[i], dis2[i]);
                if (maxDist < minDist) {
                    minDist = maxDist;
                    result = i;
                }
            }
        }

        return result;
    }
}
