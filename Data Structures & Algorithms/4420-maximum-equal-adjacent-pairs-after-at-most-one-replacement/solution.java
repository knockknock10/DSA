class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        int a= 0,b,c,d,e,m=0;
        HashMap<Long,Integer> f = new HashMap<>();
        for(int i=1;i<nums.length;i++){
            b = nums[i - 1];
            c = nums[i];
            if (b == c) {
                a++;
            } else {
                d = Math.min(b, c);
                e = Math.max(b, c);
                long k = ((long) d << 32) | e;
                f.put(k, f.getOrDefault(k, 0) + 1);
            }
        }
        int[] s = nums;
        for(int v:f.values()){
            m = Math.max(m,v);
        }
        return a+m;
    }
}
