class Solution {
    private boolean isbp(int x){
        if(x<0) return false;
        String s = Integer.toBinaryString(x);
        int i=0,j= s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    private int fmin(int x){
        int d =0;
        while(true){
            if(isbp(x-d)) return d;
            if(isbp(x+d)) return d;
            d++;
        }
    }
    public int[] minOperations(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            int x  = nums[i];
            ans[i] = fmin(x);
        }
        return ans;
    }
}
