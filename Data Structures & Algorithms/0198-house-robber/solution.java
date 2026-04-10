class Solution {
    private int robs(int n,int nums[],int dp[]){
        if(n<=0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int val1 = nums[n-1]+robs(n-2,nums,dp);
        int val2 = robs(n-1,nums,dp);
         dp[n] =  Math.max(val1,val2);
        return dp[n];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[101];
        Arrays.fill(dp,-1);
        return robs(n,nums,dp);
        
    }
}
