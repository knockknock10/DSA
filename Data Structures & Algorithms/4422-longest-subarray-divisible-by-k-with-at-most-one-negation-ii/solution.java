class Solution {
    public int longestSubarray(int[] nums, int k) {
        int[] ca = nums;
        int a = ca.length;
        int[] b = new int[a+1];
        for(int i=0;i<a;i++){
            int h = ca[i]%k;
            if(h<0) h+=k;
            b[i+1] = (b[i]+h)%k;
        }
        int[] c = new int[k];
        Arrays.fill(c,-1);
        c[0] = 0;
        int[] d = new int[k];
        Arrays.fill(d,-1);
        int g = 0;
        int[] e = new int[k];
        int f = 0;
        for(int i=1;i<=a;i++){
            int h = ca[i-1];
            int m = (2*(h%k))%k;
            if(m<0) m+=k;
            if(d[m]==-1){
                e[f++] = m;
            }
            d[m] = i-1;
            int p = b[i];
            if(c[p]!=-1){
                int len = i-c[p];
                if(len>g) g = len;
            }
            for(int j = 0;j<f;j++){
                int pr = e[j];
                int q = p-pr;
                if(q<0) q+=k;
                int r = c[q];
                if(r!=-1 && r<=d[pr]){
                    int len = i-r;
                    if(len>g) g = len;
                }
            }
            if(c[p]==-1){
                c[p] = i;
            }
        }
        return g;
    }
}
