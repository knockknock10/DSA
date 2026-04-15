class Solution {
    private int robs(int[] nums,int[] dp,int n,int end){
        if(n>end){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int val1 = nums[n]+robs(nums,dp,n+2,end);
        int val2 = robs(nums,dp,n+1,end);
        return dp[n] = Math.max(val1,val2);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        int c1 = robs(nums,dp,0,n-2);
        int dp2[] = new int[n];
        Arrays.fill(dp2,-1);
        int c2 = robs(nums,dp2,1,n-1);
        return Math.max(c1,c2);
    }
}
