class Solution {
    private int lowerbound(List<Integer> subset,int tar){
        int ans = subset.size();
        int le = 0,ri = subset.size()-1;
        while(le<=ri){
            int mid = (le+ri)/2;
            if(subset.get(mid)>=tar){
                ans = mid;
                ri = mid-1;
            }else{
                le = mid+1;
            }
        }return ans;
    }
    public int lengthOfLIS(int[] nums) {
        // int[] dp = new int[nums.length];

        // for(int i=0;i<nums.length;i++){
        //     dp[i] = 1;
        //     for(int j=i-1;j>=0;j--){
        //         if(nums[i]>nums[j]){
        //             dp[i] = Math.max(dp[i],dp[j]+1);
        //         }
        //     }
        // }
        // int lis  = 0;
        // for(int i=0;i<nums.length;i++){
        //     lis = Math.max(lis,dp[i]);
        // }       
        // return lis;

        //optimal sol

        List<Integer> subset  = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            int lb = lowerbound(subset,nums[i]);
            if(lb<subset.size()) subset.set(lb,nums[i]);
            else subset.add(nums[i]);
        }
        return subset.size();
    }
}
