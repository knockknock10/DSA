class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long ans = 0;
        for(int i=0;i<n;i++){
            int minv = nums[i];
            int maxv = nums[i];
            for(int j=i;j<n;j++){
                minv = Math.min(minv,nums[j]);
                maxv = Math.max(maxv,nums[j]);
                ans+=maxv-minv;
            }
        }
        return ans;
    }
}
