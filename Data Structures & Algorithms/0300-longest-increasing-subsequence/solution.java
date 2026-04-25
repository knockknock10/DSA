class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            dp[i] = 1;
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int lis  = 0;
        for(int i=0;i<nums.length;i++){
            lis = Math.max(lis,dp[i]);
        }       
        return lis;
    }
}
