class Solution {
    public long maxEarnings(int[][] mt) {
        int[][] v= mt;
        int n = v.length;
        Arrays.sort(v,(x,y)->Integer.compare(x[0],y[0]));
        long[] a = new long[n];
        for(int i=0;i<n;i++) a[i] = v[i][1];
        long[] b = a.clone();
        Arrays.sort(b);
        int m = 0;
        for(int i=0;i<n;i++){
            if(i==0 || b[i]!=b[i-1]) b[m++] = b[i];
        }
        HashMap<Long,Integer> c = new HashMap<>();
        for(int i=0;i<m;i++) c.put(b[i],i+1);
        long[] d = new long[m+1];
        Arrays.fill(d,Long.MIN_VALUE/4);
        long e =0;
        for(int i=0;i<n;i++){
            int[] f = v[i];
            long g = f[0] ,h=f[1],k=f[2];
            int l =0,r=m;
            while(l<r){
                int mid = (l+r)>>>1;
                if(b[mid]<=g) l = mid+1;
                else r = mid;
            }
            long p = Long.MIN_VALUE/4;
            int q= l;
            while(q>0){
                if(d[q]>p) p=d[q];
                q-=q&-q;
            }
            long s = k;
            if(p>Long.MIN_VALUE/8){
                long t = k+g+p;
                if(t>s) s = t;
            }
            if(s>e)e = s;
            int u = c.get(h);
            while(u<=m){
                if(s-h>d[u]) d[u] = s-h;
                u+=u&-u;
            }
        }
        return e;
        
    }
}
