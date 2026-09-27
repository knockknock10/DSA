class Solution {
    public int maxSubarray(int[] nums) {
        int [] d = nums;
        int n = nums.length,l=0,ans = 0;
        int[] f = new int[501];
        int[] p = new int[501];
        for(int r = 0;r<n;r++){
            int v = nums[r];
            for(int u=1;u+v<=500;u++){
                if(f[u]>0){
                    p[u+v]+=(u==v?f[v]:f[u]);
                }
            }f[v]++;
            while(true){
                boolean bad= false;
                for(int x=1;x<=500;x++){
                    if(f[x]>0 && p[x]>0){
                        bad = true;
                        break;
                    }
                }
                if(!bad) break;
                int w = nums[l];
                for(int u =1;u+w<=500;u++){
                    if(f[u]>0){
                        p[u+w]-=(u==w?f[w]-1:f[u]);
                    }
                }
                f[w]--;
                l++;
            }
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }
    
}
