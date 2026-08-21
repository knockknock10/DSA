class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<Integer>[] ad = new ArrayList[n];
        int[] indeg = new int[n];
        Queue<Integer> qu = new LinkedList<>();
        for(int i=0;i<n;i++){
            ad[i] = new ArrayList<Integer>();
        }
        for(int[] x:prerequisites){
            ad[x[1]].add(x[0]);
            indeg[x[0]]++;
        }
        for(int i=0;i<n;i++){
            if(indeg[i]==0){
                qu.add(i);
            }
        }
        int count = 0;
        while(!qu.isEmpty()){
            int c=qu.poll();
            count++;
            for(int j:ad[c]){
                if(--indeg[j]==0){
                    qu.add(j);
                }
            }
        }
        return count==n;
    }
}
