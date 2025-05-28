class Solution {
    /*
       1. From second tree we will choose a node(maxTar), who will have max no of nodes at within k-1 edges bcz
          1 edge will get utilized in joining tree1 and tree2
       2. We will connect every node of tree1 to maxTar node of tree2
       3. For every Node of tree1 we will count the no of nodes within k edges in tree1 and add the value of maxTar node 
          of tree2 in it to get answer for node i of tree1
    */
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n=edges1.length+1, m=edges2.length+1;

        ArrayList<Integer>[] tree1 = formTree(edges1, n);
        ArrayList<Integer>[] tree2 = formTree(edges2, m);
        int[] answer = new int[n];

        int maxTar = 0;
        for(int i=0;i<m;i++){
          maxTar=Math.max(maxTar, maxTargetNodesHelper(i, tree2, k-1));
        }

        for(int i=0;i<n;i++){
            answer[i]=maxTargetNodesHelper(i, tree1, k)+maxTar;
        }

        return answer;
    }
    public ArrayList<Integer>[] formTree(int[][] edges, int n){
      ArrayList<Integer>[] tree = new ArrayList[n];
      for(int i=0;i<n;i++) tree[i]=new ArrayList<>();

      for(int i=0;i<edges.length;i++){
        int u=edges[i][0];
        int v=edges[i][1];
        tree[u].add(v);
        tree[v].add(u);
      }
      return tree;
    }
    public int maxTargetNodesHelper(int src, ArrayList<Integer>[] tree, int k){
      int n=tree.length;
      LinkedList<Pair> queue=new LinkedList<>();
      queue.add(new Pair(src, 0));
      int cnt=0;
      boolean[] visited=new boolean[n];
      while(queue.size()>0){
        Pair rem = queue.removeFirst();
        if(visited[rem.src] || rem.k>k)continue;
        visited[rem.src]=true;
        cnt++;
        for(int child:tree[rem.src]){
            queue.addLast(new Pair(child, rem.k+1));
        }
      }
      return cnt;
    }
}
class Pair{
    int src, k;
    Pair(int src, int k){
        this.src=src;
        this.k=k;
    }
}
