class Solution {
    private boolean rec(int idx,int target,int nums[],Boolean dp[][]){
        if(target==0) return true;
        if(idx<0)  return false;

        if(dp[idx][target]!=null){
            return dp[idx][target];
        }
        boolean yes = (nums[idx]>target) ?
         false :rec(idx-1,target-nums[idx],nums,dp);
        boolean no = rec(idx-1,target,nums,dp);
        return dp[idx][target] = yes || no;
    } 
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums) sum+=num;
        if(sum %2 == 1) return false;
        Boolean dp[][] = new Boolean[nums.length+1][sum/2 + 1];
        return rec(nums.length-1,sum/2,nums,dp);
    }
}
