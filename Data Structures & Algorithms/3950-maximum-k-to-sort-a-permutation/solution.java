class Solution {
    public int sortPermutation(int[] nums) {
        int n= nums.length;
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i]==i){
                continue;
            }ans&=nums[i];
        }
        return ans == Integer.MAX_VALUE ? 0: ans;
    }
}
