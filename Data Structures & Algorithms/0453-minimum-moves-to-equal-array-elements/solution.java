class Solution {
    public int minMoves(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for(int i:nums){
            if(i<ans) ans = i;
        }
        long m = 0;
        for(int i:nums){
            m+=i-ans;
        }
        return (int) m;
    }
}
