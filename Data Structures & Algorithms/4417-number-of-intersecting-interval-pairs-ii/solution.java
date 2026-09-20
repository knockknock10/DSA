class Solution {
    public long countIntersectingIntervals(int[][] intervals) {
        int[][] t = intervals;
        int n = intervals.length;
        int[] s = new int[n];
        for(int i=0;i<n;i++) s[i] = intervals[i][1];
        Arrays.sort(s);
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        long[] bit = new long[n+1];
        long dis = 0;
        for(int[] iv:intervals){
            int p = l(s,iv[0]);
            for(int j=p;j>0;j-=j & -j) dis+=bit[j];
            int ind = l(s,iv[1])+1;
            for(int i=ind;i<=n;i+=i & -i) bit[i]++;
        }
        return (long) n*(n-1)/2-dis;
    }
    private int l(int[] a,int t){
        int lo = 0,hi = a.length;
        while(lo<hi){
            int m = (lo+hi)>>>1;
            if(a[m]<t)lo= m+1; else hi = m;
            
        }return lo;
    }
}
