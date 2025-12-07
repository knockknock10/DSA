class Solution {
    public long totalScore(int hp, int[] damage, int[] requirement) {
        int n = damage.length;
        int[] t = new int[n];
        for(int i=0;i<n;i++){
            t[i] = damage[i]+requirement[i];
        }
        long[] p = new long[n+1];
        p[0] = 0;
        for(int i=0;i<n;i++){
            p[i+1] = p[i] +damage[i];
        }
        long ts = 0;
        for(int k =1;k<=n;k++){
            int kdx = k-1;
            long ck = p[kdx]-hp+t[kdx];
            int low = 0;
            int high = k;
            while(low<high){
                int mid = low+(high-low)/2;
                if(p[mid]<ck){
                    low = mid+1;
                }else{
                    high = mid;
                }
            }
            int im = low;
            int count = 0;
            if(im<k){
                count = k-im;
            }
            ts+=count;
        }
        return ts;
    }
}
