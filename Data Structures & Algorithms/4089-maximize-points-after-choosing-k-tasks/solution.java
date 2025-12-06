class Solution {
    public long maxPoints(int[] technique1, int[] technique2, int k) {
        int n = technique1.length;
        int [][] g  = new int[n][2];
        for(int i=0;i<n;i++){
            g[i][0] = technique1[i]-technique2[i];
            g[i][1] = i;
        }
        Arrays.sort(g,(a,b)->b[0]-a[0]);
        long s = 0;
        for(int i=0;i<k;i++){
            int idx = g[i][1];
            s+=technique1[idx];
        }
        for(int i=0;i<n;i++){
            int idx = g[i][1];
            if(i>=k){
                s+=Math.max(technique1[idx],technique2[idx]);
                
            }
        }return s;
    }
}
