class Solution {
    public int longestSubarray(int[] nums, int k) {
        int a = 0,n = nums.length;
        int[] m = nums;
        for(int b = 0;b<n;b++){
            int c = 0;
            Set<Integer> d = new HashSet<>();
            for(int e =b;e<n;e++){
                c = (c+nums[e])%k;
                if(c<0) c+=k;
                int f = (2*(nums[e]%k))%k;
                if(f<0) f+=k;
                d.add(f);
                if(c==0 || d.contains(c)){
                    a = Math.max(a,e-b+1);
                }
            }
        }
        return a;
    }
}
